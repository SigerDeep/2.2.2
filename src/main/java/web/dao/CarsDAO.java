package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarsDAO {
    private List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car("BMW", "X1", "a123ec 32"));
        cars.add(new Car("Audi", "100", "c456xp 32"));
        cars.add(new Car("UAZ", "Patriot", "a789op 32"));
        cars.add(new Car("Scoda", "Yeti", "x741co 32"));
        cars.add(new Car("Lada", "2101", "e852op 32"));
    }

    public List<Car> getCars(int request) {
            return cars.stream().limit(request).toList();
    }

    public int getSize() { return cars.size(); }
}
