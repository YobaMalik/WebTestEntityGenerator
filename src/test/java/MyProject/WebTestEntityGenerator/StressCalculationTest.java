package MyProject.WebTestEntityGenerator;

import MyProject.WebTestEntityGenerator.util.tension.ElementStressCalculationHandler;
import MyProject.WebTestEntityGenerator.util.tension.elements.pipeline.Elbow;
import MyProject.WebTestEntityGenerator.util.tension.elements.pipeline.Pipe;
import MyProject.WebTestEntityGenerator.util.tension.elements.StrengthCalculationArea;
import MyProject.WebTestEntityGenerator.util.tension.elements.pipeline.Tee;
import org.junit.jupiter.api.Test;

public class StressCalculationTest {

    @Test
    public void testPipeCalculation() {
        StrengthCalculationArea area = new StrengthCalculationArea();

        area.setDesignPressure(3.57);
        area.setMaterial("Сталь 20");
        area.setTension(145.6);

        area.setDiameter(159);
        area.setDesignThickness(8);

        area.setAdditionalThickness(1);
        area.setWeldRate(1);

        Pipe pipe = new Pipe();
        pipe.setValue("pipe", area);

        System.out.println(pipe.getResultPressure("pipe") == 13.410526315789474);
        System.out.println(pipe.getResultThickness("pipe") == 1.9256708620280218);
        /*
        * Pressure("pipe")  13.410526315789474
        * Thickness("pipe") 1.9256708620280218
         */
    }

    @Test
    public void testElbowCalculation() {
        StrengthCalculationArea area = new StrengthCalculationArea();

        area.setDesignPressure(3.57);
        area.setMaterial("Сталь 20");
        area.setTension(145.6);

        area.setDiameter(159);
        area.setDesignThickness(8);

        area.setAdditionalThickness(1);
        area.setWeldRate(1);

        area.setElementType("гнутый");
        Elbow elbow = new Elbow("elbow", area);

        System.out.println(elbow.getResultPressure("elbow") == 11.591697469434177);
        System.out.println(elbow.getResultThickness("elbow") == 2.214521491332225);
        /*
        * Pressure("elbow") 11.591697469434177
        * Thickness("elbow") 2.214521491332225
        *
         */
    }

    @Test
    public void testStraightTeeCalculation() {

        StrengthCalculationArea mainPart = new StrengthCalculationArea();
        mainPart.setDesignPressure(3.57);
        mainPart.setMaterial("Сталь 20");
        mainPart.setTension(145.6);

        mainPart.setDiameter(159);
        mainPart.setDesignThickness(10);

        mainPart.setAdditionalThickness(1);
        mainPart.setWeldRate(1);

        Tee tee = new Tee();
        tee.setValue(ElementStressCalculationHandler.BRANCH,mainPart);
        tee.setValue(ElementStressCalculationHandler.MAIN,mainPart.clone());

        System.out.println(tee.getResultPressure(ElementStressCalculationHandler.BRANCH));
        System.out.println(tee.getResultThickness(ElementStressCalculationHandler.BRANCH));

        System.out.println(tee.getResultPressure(ElementStressCalculationHandler.MAIN));
        System.out.println(tee.getResultThickness(ElementStressCalculationHandler.MAIN));
        /*
        * 17.471999999999998  branch/main pressure
        * 1.9256708620280218 branch/main thickness
         */
    }

    @Test
    public void testReduceTeeCalculation() {

    }
}
