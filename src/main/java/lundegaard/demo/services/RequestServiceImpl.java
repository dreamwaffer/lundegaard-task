package lundegaard.demo.services;

import lundegaard.demo.models.Request;
import lundegaard.demo.repositories.RequestRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RequestServiceImpl implements RequestService {

    public final int REQUEST_TEXT_LENGTH = 5;

    private RequestRepository requestRepository;
    private InputCheckService inputCheckService;

    public RequestServiceImpl(RequestRepository requestRepository, InputCheckService inputCheckService) {
        this.requestRepository = requestRepository;
        this.inputCheckService = inputCheckService;
    }

    @Override
    public List<String> processRequest(Request request) {
        List<String> errors = new ArrayList<>();
        List<String> values = new ArrayList<>();

        values.add(request.getType());
        values.add(request.getPolicyNumber());
        values.add(request.getFirstName());
        values.add(request.getSurname());
        values.add(request.getText());

        for(String value : values){
            if (value == null || value.length() == 0){
                errors.add("All fields are required!");
                break;
            }
        }

        if (!inputCheckService.isAlphaNumeric(request.getPolicyNumber())) {
            errors.add("Policy number should contain alpha-numeric characters only!");
        }
        if (!inputCheckService.isAlphabetic(request.getFirstName()) || !inputCheckService.isAlphabetic(request.getSurname())) {
            errors.add("Name and surname should contain alphabetic characters only!");
        }
        if (request.getText().length() > REQUEST_TEXT_LENGTH) {
            errors.add("Your request should not be longer than " + REQUEST_TEXT_LENGTH + " characters!");
        }
        if (errors.isEmpty()){
            this.requestRepository.save(request);
        }
        return errors;
    }
}