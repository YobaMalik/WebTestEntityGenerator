package MyProject.WebTestEntityGenerator;

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

        System.out.println(pipe.getResultPressure() == 13.410526315789474);
        System.out.println(pipe.getResultThickness() == 1.9256708620280218);
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

        System.out.println(elbow.getResultPressure() == 11.591697469434177);
        System.out.println(elbow.getResultThickness() == 2.214521491332225);
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
        tee.setValue("main",mainPart);
        tee.setValue("branch",mainPart.clone());

        System.out.println(tee.getResultPressure());
        System.out.println(tee.getResultThickness());

        /*
        * 17.471999999999998  branch pressure
        * 1.9256708620280218 branch thickness
         */
    }

    @Test
    public void testReduceTeeCalculation() {

    }
}
