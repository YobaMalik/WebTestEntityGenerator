package MyProject.WebTestEntityGenerator.util.tension.elements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StrengthCalculationArea implements Cloneable {

    private double designThickness;
    private double designPressure;
    private double diameter;
    private double temperature;
    private double tension;

    private double weldRate;
    private double additionalThickness;
    private double degree;
    private double radius;

    private String material;
    private String elementType;

    @Override
    public StrengthCalculationArea clone() {
        try {
            return (StrengthCalculationArea) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
