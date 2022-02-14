package MyProject.WebTestEntityGenerator.util.tension.elements.pipeline;

import MyProject.WebTestEntityGenerator.util.tension.ElementStressCalculationHandler;
import MyProject.WebTestEntityGenerator.util.tension.IElement;
import MyProject.WebTestEntityGenerator.util.tension.ITension;
import MyProject.WebTestEntityGenerator.util.tension.elements.StrengthCalculationArea;

public class Tee extends ElementStressCalculationHandler<String, StrengthCalculationArea>
        implements ITension<String, StrengthCalculationArea> {


    @Override
    public double getResultThickness() {
        StrengthCalculationArea branch = get("branch");
        double branchThickness = (branch.getDesignPressure() * branch.getDiameter()) /
                (2 * branch.getWeldRate() * branch.getTension() +
                        branch.getDesignPressure());

        StrengthCalculationArea mainArea = get("main");
        return (mainArea.getDesignPressure() * mainArea.getDiameter()) /
                (2 * Math.min(mainArea.getWeldRate(), mainArea.getAdditionalThickness()) * mainArea.getTension() +
                        mainArea.getDesignPressure());
    }

    @Override
    public double getResultPressure() {
        StrengthCalculationArea mainPart = get("main");
        double mainPartPressure = 2 * mainPart.getTension() * Math.min(mainPart.getWeldRate(), mainPart.getWeldRate()) *
                (mainPart.getDesignThickness() - mainPart.getAdditionalThickness()) /
                (mainPart.getDiameter() - (mainPart.getDesignThickness() - mainPart.getAdditionalThickness()));

        StrengthCalculationArea branchPart = get("branch");
        double branchPress = 2 * branchPart.getWeldRate() * branchPart.getTension() *
                (branchPart.getDesignThickness() - branchPart.getAdditionalThickness()) /
                (branchPart.getDiameter() - (branchPart.getDesignThickness() - branchPart.getAdditionalThickness()));
        //   TODO press1 or Math.min(press1,press2)!?
        return mainPartPressure;
    }

    @Override
    public StrengthCalculationArea getElement(String key) {
        return get(key);
    }
}
