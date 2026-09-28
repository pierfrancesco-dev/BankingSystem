import java.util.HashMap;
import java.util.Map;

public class Repository<K, V> {
    private Map<K, V> elementi;

    public Repository(){
        elementi = new HashMap<>();
    }

    public void aggiungi(K chiave, V elemento){ elementi.put(chiave, elemento); }

    public V get(K chiave){ return elementi.get(chiave); }

    public void rimuovi(K chiave){ elementi.remove(chiave); }
}
