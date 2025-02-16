package web.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {
    private String model;
    private String series;
    private String number;

    @Override
    public String toString() {
        return this.getModel() + " " + this.getSeries() + ", number " + this.getNumber();
    }
}
