package lundegaard.demo;

import lundegaard.demo.models.RequestType;
import lundegaard.demo.services.RequestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private RequestTypeService requestTypeService;

    @Autowired
    public DataLoader(RequestTypeService requestTypeService) {
        this.requestTypeService = requestTypeService;
    }

    public void run(ApplicationArguments args) {
        requestTypeService.add(new RequestType("Contract Adjustment"));
        requestTypeService.add(new RequestType("Damage Case"));
        requestTypeService.add(new RequestType("Complaint"));
    }
}
