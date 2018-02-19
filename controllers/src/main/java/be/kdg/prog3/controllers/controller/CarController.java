package be.kdg.prog3.controllers.controller;

import be.kdg.prog3.controllers.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class CarController {
    @GetMapping("/cars")
    public String showNewCarPage(Map<String, Object> modelMap) {
        modelMap.put("car", new Car());
        return "cars/new_car";
    }

    @PostMapping("/cars")
    public ModelAndView addCar(@Valid @ModelAttribute Car car, BindingResult errors) {
        final ModelAndView modelAndView = new ModelAndView();
        if (errors.hasErrors()) {
            for (ObjectError e : errors.getAllErrors()) {
                System.err.println(e.getDefaultMessage());
            }
            modelAndView.setViewName("cars/new_car");
        } else {
            // Store the car in the DB...

            // No update of the Spring Model needed!

            modelAndView.setViewName("cars/car_added");
        }
        return modelAndView;
    }

    /*@PostMapping("/books")
    public String addBook(@ModelAttribute Book book) {
        this.books.add(book);
        return "bookAdded";
    }*/
}
