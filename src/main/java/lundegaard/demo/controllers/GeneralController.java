package lundegaard.demo.controllers;

import lundegaard.demo.models.Request;
import lundegaard.demo.services.RequestService;
import lundegaard.demo.services.RequestTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GeneralController {

    private RequestService requestService;
    private RequestTypeService requestTypeService;

    public GeneralController(RequestService requestService, RequestTypeService requestTypeService) {
        this.requestService = requestService;
        this.requestTypeService = requestTypeService;
    }

    @GetMapping(value = {"", "/", "/index"})
    public String getIndex(Model model) {
        model.addAttribute("requestTypes", this.requestTypeService.getAll());
        return "index";
    }

    @PostMapping(value = {"request"})
    public String sendRequest(@ModelAttribute("formData") Request request, Model model) {
        List<String> errorMessages = this.requestService.processRequest(request);
        if (errorMessages.isEmpty()) {
            return "redirect:/index";
        } else {
            model.addAttribute("requestTypes", this.requestTypeService.getAll());
            model.addAttribute("errorMessages", errorMessages);
            model.addAttribute("request", request);
            return "index";
        }
    }
}