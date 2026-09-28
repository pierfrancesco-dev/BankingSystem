import java.time.LocalDateTime;
import java.util.UUID;

public class Transazione {
    private UUID idTransazione;
    private int importo;
    private TipoTransazione tipo;
    private LocalDateTime dateTime;
    private Conto conto;

    public Transazione(int importo, TipoTransazione tipo, Conto conto){
        idTransazione = UUID.randomUUID();
        this.importo = importo;
        this.tipo = tipo;
        this.conto = conto;
        dateTime = LocalDateTime.now();

        eseguiTransazione();
    }

    private void eseguiTransazione(){
        switch(tipo){
            case DEPOSITO -> conto.aggiungiSaldo(importo);
            case PRELIEVO -> {
                try {
                    conto.rimuoviSaldo(importo);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
            default -> System.out.println("Tipo transazione non valida");
        }
    }
}
