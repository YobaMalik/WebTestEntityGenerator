package MyProject.WebTestEntityGenerator.util.tension.elements;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StrengthCalculationArea implements Cloneable, Serializable {

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

    private double resultThickness;
    private double resultPressure;

    @Override
    public StrengthCalculationArea clone() {
        try {
            return (StrengthCalculationArea) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
