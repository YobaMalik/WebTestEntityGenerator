package MyProject.WebTestEntityGenerator.util.tension;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ElementStressCalculationHandler<K, V> implements IElement<K, V> {

    Map<K, V> elements = new HashMap<>(4);

    public ElementStressCalculationHandler() {

    }

    public ElementStressCalculationHandler( Map<K, V> elements) {
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

}
