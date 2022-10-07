package lundegaard.demo.services;

import org.springframework.stereotype.Service;

@Service
public interface InputCheckService {

    boolean isAlphaNumeric(String text);

    boolean isAlphabetic(String text);
}