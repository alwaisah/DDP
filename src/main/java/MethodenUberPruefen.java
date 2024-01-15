import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class MethodenUberPruefen {
    public static void main(String[] args) {
        String eisWuerfelBestaetigung = "jA";
        int eisWuerfelMenge = eisWuerfelStueckEinlesen(eisWuerfelBestaetigung);

        System.out.println(eisWuerfelMenge);
    }
    private static int eisWuerfelStueckEinlesen(String eisWuerfelBestaetigung) {
        Scanner scanner = new Scanner(System.in);
        int eisWuerfelStueckEingabe = 0;
        List<String> bestaetigungsListe = List.of("JA", "BITTE", "JA BITTE", "JA BITTE MIT EIS", "JA MIT EIS", "MIT EIS");
        String eisWuerfel = eisWuerfelBestaetigung;
        while (true) {
            try {
//                AtomicInteger loopZeahle = new AtomicInteger();
//                bestaetigungsListe.forEach((s) -> {
//                    if (eisWuerfel.equalsIgnoreCase(bestaetigungsListe.get(loopZeahle.get()))) {
//                        System.out.println("DONEEEEEEEE");
//                    }
//                    loopZeahle.getAndIncrement();
//                });
                for (int i = 0; i < bestaetigungsListe.size(); i++){
                    if (eisWuerfel.equalsIgnoreCase(bestaetigungsListe.get(i))) {
                        System.out.println("DONEEEEEEEE");
                    }
//                    loopZeahle.getAndIncrement();
                }
                break;
            } catch (InputMismatchException | IllegalArgumentException error) {
                System.out.println("Achtung: Ungültige Eingabe.");
            }
        }
        return eisWuerfelStueckEingabe;
    }

}
