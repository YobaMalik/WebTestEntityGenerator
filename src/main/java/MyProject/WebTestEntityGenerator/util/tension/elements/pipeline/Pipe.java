package MyProject.WebTestEntityGenerator.util.tension.elements.pipeline;

import MyProject.WebTestEntityGenerator.util.tension.ElementStressCalculationHandler;
import MyProject.WebTestEntityGenerator.util.tension.IElement;
import MyProject.WebTestEntityGenerator.util.tension.ITension;
import MyProject.WebTestEntityGenerator.util.tension.elements.StrengthCalculationArea;

public class Pipe extends ElementStressCalculationHandler<String, StrengthCalculationArea>
        implements ITension<String, StrengthCalculationArea> {


    @Override
    public double getResultThickness() {
        StrengthCalculationArea area = get("pipe");

        return (area.getDesignPressure() * area.getDiameter()) /
                (2 * area.getWeldRate() * area.getTension() + area.getDesignPressure());
    }

    @Override
    public double getResultPressure() {
        StrengthCalculationArea area = get("pipe");

        return (2 * area.getTension() * area.getWeldRate() *
                (area.getDesignThickness() - area.getAdditionalThickness()) /
                (area.getDiameter() - (area.getDesignThickness() - area.getAdditionalThickness())));
    }

    @Override
    public StrengthCalculationArea getElement(String key) {
        return get(key);
    }

}
