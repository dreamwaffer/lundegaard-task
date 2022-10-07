package lundegaard.demo.services;

import lundegaard.demo.models.RequestType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequestTypeService {

    void add(RequestType requestType);

    List<RequestType> getAll();
}