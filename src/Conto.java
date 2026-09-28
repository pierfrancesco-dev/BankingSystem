import java.util.UUID;

public abstract class Conto {
    private UUID idConto;
    private double saldo;
    private Banca banca;

    public Conto(double saldo, String nomeBanca){
        idConto = UUID.randomUUID();
        this.saldo = saldo;
        banca = new Banca(nomeBanca);
    }

    public void aggiungiSaldo(double importo){
        saldo += importo;
    }

    public void aggiungiSaldo(double importo, String causale){
        saldo += importo;
        System.out.print("Deposito: " + causale);
    }

    public void rimuoviSaldo(double importo) throws SaldoInsufficienteException, ImportoNonValidoException{
        if(importo <= 0) throw new ImportoNonValidoException("Importo non valido.");
        else if(importo > saldo) throw new SaldoInsufficienteException("Saldo insufficiente.");
        else saldo -= importo;
    }

    public double getSaldo(){ return saldo; }

    public abstract double calcolaCosto();
}
