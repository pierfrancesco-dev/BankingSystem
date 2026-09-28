import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class FileTest {
    private static Path path = Path.of("utenti.csv");
    private static final Logger logger = Logger.getLogger(FileTest.class.getName());

    public static void main(String[] args) {
        Utente u1 = new Utente("Pier Francesco","Di Luccio");
        Utente u2 = new Utente("Mario","Rossi");
        Utente u3 = new Utente("Luca","Bianchi");

        try {
            if (Files.exists(path)) {
                logger.warning("Il file esiste già.");
            } else {
                Files.createFile(path);
                logger.info("File creato.");
            }

            salvaUtente(u1);
            salvaUtente(u2);
            salvaUtente(u3);
        }catch(IOException e){
            logger.severe(e.getMessage());
        }

        List<Utente> utenti = caricaUtenti();

        utenti.forEach(System.out::println);
    }

    public static void salvaUtente(Utente utente){
        try(BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)){
            writer.write(utente.getNome() + "," + utente.getCognome());
            writer.newLine();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static List<Utente> caricaUtenti(){
        List<Utente> utenti = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(path)){
            String riga;
            while((riga = reader.readLine()) != null){
                String[] dati = riga.split(",");
                utenti.add(new Utente(dati[0], dati[1]));
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return utenti;
    }
}
