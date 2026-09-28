public class ContoRisparmio extends Conto{

    public ContoRisparmio(double saldo, String nomeBanca){
        super(saldo, nomeBanca);
    }

    @Override
    public double calcolaCosto(){ return 2; }
}
