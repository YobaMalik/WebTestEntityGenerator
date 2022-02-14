package MyProject.WebTestEntityGenerator.util.tension;

import java.util.Collection;

public interface IElement<K,V> {

    V get(K key);

    void setValue(K key,V value);

    void remove(K key);

    Collection<V> getValues();

}
