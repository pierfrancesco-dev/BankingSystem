public class ContoCorrente extends Conto implements Trasferibile{

    public ContoCorrente(double saldo, String nomeBanca){
        super(saldo, nomeBanca);
    }

    @Override
    public double calcolaCosto(){ return 5; }

    @Override
    public void trasferisci(Conto contoDestinazione, double importo){
        if(importo <= 0) System.out.println("Importo non valido.");
        else if(importo > getSaldo()) System.out.println("Saldo insufficiente.");
        else{
            contoDestinazione.aggiungiSaldo(importo);
            try{
                rimuoviSaldo(importo);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
