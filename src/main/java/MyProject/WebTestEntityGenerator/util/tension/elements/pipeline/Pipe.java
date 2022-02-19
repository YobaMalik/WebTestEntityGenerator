package MyProject.WebTestEntityGenerator.util.tension.elements.pipeline;

import MyProject.WebTestEntityGenerator.util.tension.ElementStressCalculationHandler;
import MyProject.WebTestEntityGenerator.util.tension.elements.StrengthCalculationArea;

public class Pipe extends ElementStressCalculationHandler<String, StrengthCalculationArea> {

    @Override
    public double getResultThickness(String element) {

        StrengthCalculationArea area = get(element);

        return (area.getDesignPressure() * area.getDiameter()) /
                (2 * area.getWeldRate() * area.getTension() + area.getDesignPressure());
    }

    @Override
    public double getResultPressure(String element) {

        StrengthCalculationArea area = get(element);

        return (2 * area.getTension() * area.getWeldRate() *
                (area.getDesignThickness() - area.getAdditionalThickness()) /
                (area.getDiameter() - (area.getDesignThickness() - area.getAdditionalThickness())));
    }

}
