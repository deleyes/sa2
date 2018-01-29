package be.kdg.gson_controller.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ParameterController {
    @GetMapping("/test")
    @ResponseBody
    public String requestParam(@RequestParam int id, @RequestParam("naam") String name) {
        return "ID: " + id + "\n" + "Naam: " + name;
    }

    @GetMapping("/test/{id}/{naam}")
    @ResponseBody
    public String pathVariable(@PathVariable int id, @PathVariable("naam") String name) {
        return "ID: " + id + "\n" + "Naam: " + name;
    }
}
