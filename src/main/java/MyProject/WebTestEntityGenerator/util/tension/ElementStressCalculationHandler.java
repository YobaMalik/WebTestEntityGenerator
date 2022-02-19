package MyProject.WebTestEntityGenerator.util.tension;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ElementStressCalculationHandler<K, V> implements IElement<K, V> {
    public static final String BRANCH = "branch";
    public static final String MAIN = "main";

    private final Map<K, V> elements = new HashMap<>(8);

    public ElementStressCalculationHandler() {

    }

    public ElementStressCalculationHandler(Map<K, V> elements) {
        this.elements.putAll(elements);
    }

    public ElementStressCalculationHandler(K key, V value) {
        this.elements.putIfAbsent(key, value);
    }

    @Override
    public V get(K key) {
        return elements.get(key);
    }

    @Override
    public void setValue(K key, V value) {
        elements.putIfAbsent(key, value);
    }


    @Override
    public void remove(K key) {
        elements.remove(key);
    }

    @Override
    public Collection<V> getValues() {
        return elements.values();
    }

    @Override
    public double getResultThickness(String element) {
        return 0;
    }

    @Override
    public double getResultPressure(String element) {
        return 0;
    }

    public double interpolation(double t1, double t2, double ft1, double ft2, double tn) {
        double value = 0;
        double b = (t1 * ft2 - t2 * ft1) / (t1 - t2);
        double a = (ft1 - b) / t1;
        value = tn * a + b;
        return value;
    }
}
