package lundegaard.demo.services;

import lundegaard.demo.models.Request;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequestService {

    List<String> processRequest(Request request);
}