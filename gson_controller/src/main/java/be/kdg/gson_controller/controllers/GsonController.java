package be.kdg.gson_controller.controllers;

import be.kdg.gson_controller.model.BankAccount;
import be.kdg.gson_controller.model.Customer;
import com.google.gson.Gson;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GsonController {
    @GetMapping(value = "/customer", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String getClientText() {
        Customer jos = new Customer("Jos", "Vermeulen");
        return jos.getFirstName() + "\n" + jos.getLastName();
    }

    @GetMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getClientJson() {
        Customer jos = new Customer("Jos", "Vermeulen");
        return new Gson().toJson(jos);
    }

    @GetMapping(value = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getAccountInformation() {
        Customer jos = new Customer("Jos", "Vermeulen");
        BankAccount account = new BankAccount("BE12 3456 7891 2345", jos);
        return new Gson().toJson(account);
    }

    @GetMapping(value = "/", produces = {MediaType.TEXT_PLAIN_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<String> dynamic(HttpServletRequest request) {
        ResponseEntity<String> response = null;
        HttpHeaders headers = new HttpHeaders();
        if (MediaType.parseMediaType(request.getHeader("Accept")).equals(MediaType.APPLICATION_JSON)) {
            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            response = ResponseEntity
                    .ok()
                    .headers(headers)
                    .body("{ \"content\": \":)\" }");
        } else if (MediaType.parseMediaType(request.getHeader("Accept")).equals(MediaType.TEXT_PLAIN)) {
            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
            response = ResponseEntity
                    .ok()
                    .headers(headers)
                    .body(":)");
        }
        return response;
    }
}
