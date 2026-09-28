import java.util.List;
import java.util.stream.Collectors;

public class Utility {

    List<Integer> numeri = List.of(10, 20, 30, 40);



    public <T> void stampa(T elemento){
        System.out.println(elemento);

        numeri.stream()
                .reduce(0, (totale, numero) -> totale + numero);
    }
}
