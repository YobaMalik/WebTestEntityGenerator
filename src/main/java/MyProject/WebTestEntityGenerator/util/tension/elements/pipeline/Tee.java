package MyProject.WebTestEntityGenerator.util.tension.elements.pipeline;

import MyProject.WebTestEntityGenerator.util.tension.ElementStressCalculationHandler;
import MyProject.WebTestEntityGenerator.util.tension.elements.StrengthCalculationArea;

public class Tee extends ElementStressCalculationHandler<String, StrengthCalculationArea> {

    @Override
    public double getResultThickness(String element) {

        calculateThickness(element);
        return get(element).getResultThickness();

    }

    @Override
    public double getResultPressure(String element) {

        calculatePressure(element);
        return get(element).getResultPressure();

    }

    private void calculateThickness(String element) {
        StrengthCalculationArea area = get(element);

        assert area != null;

        if (ElementStressCalculationHandler.BRANCH.equals(element)) {
            double branchThickness = (area.getDesignPressure() * area.getDiameter()) /
                    (2 * area.getWeldRate() * area.getTension() +
                            area.getDesignPressure());
            area.setResultThickness(branchThickness);
        }
        if (ElementStressCalculationHandler.MAIN.equals(element)) {
            double mainThickness = (area.getDesignPressure() * area.getDiameter()) /
                    (2 * Math.min(area.getWeldRate(), area.getAdditionalThickness()) * area.getTension() +
                            area.getDesignPressure());
            area.setResultThickness(mainThickness);
        }

    }

    private void calculatePressure(String element) {
        StrengthCalculationArea area = get(element);

        if (ElementStressCalculationHandler.BRANCH.equals(element)) {
            double mainPartPressure = 2 * area.getTension() * Math.min(area.getWeldRate(), area.getWeldRate()) *
                    (area.getDesignThickness() - area.getAdditionalThickness()) /
                    (area.getDiameter() - (area.getDesignThickness() - area.getAdditionalThickness()));
            area.setResultPressure(mainPartPressure);
        }

        if (ElementStressCalculationHandler.MAIN.equals(element)) {
            double branchPressure = 2 * area.getWeldRate() * area.getTension() *
                    (area.getDesignThickness() - area.getAdditionalThickness()) /
                    (area.getDiameter() - (area.getDesignThickness() - area.getAdditionalThickness()));
            area.setResultPressure(branchPressure);
        }
    }

}
