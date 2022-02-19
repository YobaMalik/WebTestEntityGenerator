package MyProject.WebTestEntityGenerator.util.tension.elements.pipeline;

import MyProject.WebTestEntityGenerator.util.tension.ElementStressCalculationHandler;
import MyProject.WebTestEntityGenerator.util.tension.elements.StrengthCalculationArea;

public class Elbow extends ElementStressCalculationHandler<String, StrengthCalculationArea> {

    private double ki = 1;

    public Elbow(String elbow, StrengthCalculationArea area) {
        super(elbow, area);
        ki = getKI(area);
    }

    @Override
    public double getResultThickness(String element) {
        StrengthCalculationArea area = get(element);

        return ki * (area.getDesignPressure() * area.getDiameter()) /
                (2 * area.getWeldRate() * area.getTension() + area.getDesignPressure());
    }

    @Override
    public double getResultPressure(String element) {
        StrengthCalculationArea area = get(element);
        return 2 * area.getWeldRate() * area.getTension() * (area.getDesignThickness() -
                area.getAdditionalThickness()) /
                (area.getDiameter() * ki - (area.getDesignThickness() - area.getAdditionalThickness()));

    }

    private double getKI(StrengthCalculationArea area) {
        String type = area.getElementType().toLowerCase();

        double diameter = area.getDiameter();
        double weldRate = area.getWeldRate();
        double radius = area.getRadius() == 0 ? area.getDiameter() * 1.5 : area.getRadius();
        double thickness = area.getAdditionalThickness();

        double ki = 1;
        switch (type) {
            case "гнутый" -> {
                if (radius / diameter <= 1.0) ki = 1.3;
                if (radius / diameter < 2.0 && radius / diameter > 1.0) ki = interpolation(2.0, 1.0,
                        1.0, 1.3, radius / diameter);
            }
            case "штампосварной" -> ki = (1 / weldRate) * (4 * radius / (diameter - thickness) - 1) /
                    (4 * radius / (diameter - thickness) - 2);

            case "cекторный" ->
                //bevel angle less than 22,5 degree
                    ki = (4 * radius / (diameter - thickness) - 1) /
                            (4 * radius / (diameter - thickness) - 2);
        }
        return ki;
    }
}
