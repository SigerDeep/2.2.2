package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarsDAO;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarsDAO carsDAO;

    @GetMapping()
    public String printCars(ModelMap model, @RequestParam Optional<Integer> count) {
        List<String> messages = new ArrayList<>();
        messages.add("Cars");
        carsDAO.getCars(this.getCount(count)).stream()
                .map(Car::toString)
                .forEach(messages::add);
        model.addAttribute("messages", messages);
        return "cars";
    }

    public int getCount(Optional<Integer> count) {
        int res = 5;
        if (count.isPresent()) {
            if (count.get() < carsDAO.getSize() & count.get() > -1) {
                res = count.get();
            }
        }
        return res;
    }
}