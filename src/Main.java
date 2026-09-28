public class Main {
    public static void main(String[] args) {
        Utente utente = new Utente("Pier Francesco", "Di Luccio");
        utente.aggiungiContoCorrente(1000, "Intesa San Paolo");

        try{
            new Transazione(10000, TipoTransazione.PRELIEVO, utente.getConto(0));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Operazione terminata.");
        }
    }
}