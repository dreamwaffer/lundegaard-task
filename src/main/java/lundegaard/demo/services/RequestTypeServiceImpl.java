package lundegaard.demo.services;

import lundegaard.demo.models.RequestType;
import lundegaard.demo.repositories.RequestTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestTypeServiceImpl implements RequestTypeService {

    private RequestTypeRepository requestTypeRepository;

    public RequestTypeServiceImpl(RequestTypeRepository requestTypeRepository) {
        this.requestTypeRepository = requestTypeRepository;
    }

    @Override
    public void add(RequestType requestType) {
        this.requestTypeRepository.save(requestType);
    }

    @Override
    public List<RequestType> getAll() {
        return this.requestTypeRepository.findAll();
    }
}