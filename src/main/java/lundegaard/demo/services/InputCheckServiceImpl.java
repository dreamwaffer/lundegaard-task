package lundegaard.demo.services;

import org.springframework.stereotype.Service;

@Service
public class InputCheckServiceImpl implements InputCheckService{
    @Override
    public boolean isAlphaNumeric(String text) {
        return text != null && text.matches("^[a-zA-Z0-9]*$");
    }

    @Override
    public boolean isAlphabetic(String text) {
        return text != null && text.matches("^[a-zA-Z]*$");
    }
}