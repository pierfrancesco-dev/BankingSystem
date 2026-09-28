import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Banca {
    private UUID idBanca;
    private String nome;
    private Map<UUID, Utente> utenti;

    public Banca(String nome){
        this.nome = nome;
        idBanca = UUID.randomUUID();
        utenti = new HashMap<>();
    }

    public void aggiungiUtente(Utente utente){ utenti.put(utente.getId(), utente); }

    public Utente cercaUtente(UUID id) throws UtenteNonTrovatoException{
        if(utenti.containsKey(id)) return utenti.get(id);
        throw new UtenteNonTrovatoException("Utente non trovato.");
    }

    public void rimuoviUtente(UUID id){ utenti.remove(id); }
}
