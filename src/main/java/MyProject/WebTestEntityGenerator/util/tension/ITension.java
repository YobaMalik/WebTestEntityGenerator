package MyProject.WebTestEntityGenerator.util.tension;

import MyProject.WebTestEntityGenerator.util.tension.elements.StrengthCalculationArea;

public interface ITension<K, V> {

    double getResultThickness();

    double getResultPressure();

    StrengthCalculationArea getElement(K key);

    default double interpolation(double t1, double t2, double ft1, double ft2, double tn) {
        double value = 0;
        double b = (t1 * ft2 - t2 * ft1) / (t1 - t2);
        double a = (ft1 - b) / t1;
        value = tn * a + b;
        return value;
    }
}
