import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Utente {
    private UUID idUtente;
    private String nome;
    private String cognome;
    private List<Conto> conti;

    public Utente(String nome, String cognome){
        idUtente = UUID.randomUUID();
        this.nome = nome;
        this.cognome = cognome;
        conti = new ArrayList<>();
    }

    public void aggiungiContoCorrente(int saldo, String nomeBanca){
        conti.add(new ContoCorrente(saldo,nomeBanca));
    }

    public void aggiungiContoRisparmio(int saldo, String nomeBanca){
        conti.add(new ContoRisparmio(saldo,nomeBanca));
    }

    public int numeroConti(){ return conti.size(); }

    public void rimuoviConto(int indice){ conti.remove(indice); }

    public void stampaSaldi(){

        for(int i = 0; i < conti.size(); i++){
            System.out.println("Conto " + (i+1) + ": " + conti.get(i).getSaldo());
        }
    }

    public void stampaNomeCompleto(){
        System.out.println(nome + " " + cognome);
    }

    public Conto getConto(int indice) throws ContoNonTrovatoException{
        if(indice < conti.size()) return conti.get(indice);
        throw new ContoNonTrovatoException("Conto non trovato.");
    }

    public UUID getId(){ return idUtente;}

    public String getNome(){ return nome;}

    public String getCognome(){ return cognome;}

    @Override
    public String toString(){
        return nome + " " + cognome;
    }
}
