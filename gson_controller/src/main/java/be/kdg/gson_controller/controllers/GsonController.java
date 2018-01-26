package be.kdg.gson_controller.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GsonController {
    @GetMapping(value = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getAccountInformation() {
        return "{}";
    }

    @GetMapping(value = "/client", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getClientJson() {
        return "JSON";
    }

    @GetMapping(value = "/client", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String getClientText() {
        return "TEST";
    }

    @GetMapping(value = "/", produces = {MediaType.TEXT_PLAIN_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<String> dynamic(HttpServletRequest request) {
        ResponseEntity<String> response;
        HttpHeaders headers = new HttpHeaders();
        if (MediaType.parseMediaType(request.getHeader("Accept")).equals(MediaType.APPLICATION_JSON)) {
            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            response = ResponseEntity
                    .ok()
                    .headers(headers)
                    .body("{ \"smile\": \"yes\" }");
        } else if (MediaType.parseMediaType(request.getHeader("Accept")).equals(MediaType.TEXT_PLAIN)) {
            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
            response = ResponseEntity
                    .ok()
                    .headers(headers)
                    .body(":)");
        } else {
            response = ResponseEntity.badRequest().build();
        }
        return response;
    }
}
