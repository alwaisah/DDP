import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {
        System.out.println("\n-- BestellungsDaten Lieferungsprogramm --!\n");

        EinkaufsKorb einkaufsKorb = new EinkaufsKorb();


        List<BestellungsDaten> weinBestellungsList = new ArrayList<>();
        int zaehler = 0;

        //#######################################################################################
        // Eingabeaufforderungen
        String bestaetigungsEinkaufsDaten = bestaetigungsEinkaufsDatenEinlesen();
        bestaetigungsEinkaufsDaten        = bestaetigungsEinkaufsDaten.substring(0, 1).toUpperCase() + bestaetigungsEinkaufsDaten.substring(1).toLowerCase();
        int    mengeEinkaufsDaten         = mengeEinkaufsDatenEinlesen(bestaetigungsEinkaufsDaten);

        for ( zaehler = 0; zaehler < mengeEinkaufsDaten ; zaehler++) {
            System.out.print((zaehler + 1) + ". Bestellung \n");
            String  name                    = nameEinlesen(bestaetigungsEinkaufsDaten);
            BigDecimal  preis                   = BigDecimal.valueOf(preisEinlesen(name));
            BigDecimal  menge                   = BigDecimal.valueOf(mengeEinlesen());
            String  eisWuerfelBestaetigung  = eisWuerfelBestaetigungsEinlesen();
            int     eisWuerfelMenge         = eisWuerfelMengeEinlesen(eisWuerfelBestaetigung);
            int     flaschenProKarton       = flaschenProKartonEinlesen();

            GetraenkFlasche einGetraenkFlasche  = new GetraenkFlasche(name, preis);
            BestellungsDaten bestellungsDaten   = new BestellungsDaten(einGetraenkFlasche, menge, flaschenProKarton, eisWuerfelMenge);

            einkaufsKorb.berechneGesamteNettoPreis(bestellungsDaten, einGetraenkFlasche);
            einkaufsKorb.berechneGesamteSteuer(bestellungsDaten);
            einkaufsKorb.berechneGesamteEisKostenNetto(bestellungsDaten);
            einkaufsKorb.berechneGesamteBruttoPreis(bestellungsDaten);

            weinBestellungsList.add(bestellungsDaten);
            System.out.println("\n----------------------------------------------------\n");
        }
        System.out.println("\nVielen Dank für Ihre Bestellung!\n");
        System.out.println("Ihre Quittung \n");
        //#######################################################################################
        // Ausgabe
        zaehler = 0;
        for (BestellungsDaten bestellungsDatenLoop : weinBestellungsList){
            String  name                = bestellungsDatenLoop.getEinGetreankFlasche().getName();
            BigDecimal preis               = bestellungsDatenLoop.getEinGetreankFlasche().getPreis();
            BigDecimal menge               = bestellungsDatenLoop.getMenge();
            BigDecimal nettoPreis          = bestellungsDatenLoop.getNettoPreis();
            BigDecimal steuer              = bestellungsDatenLoop.getSteuer();
            BigDecimal bruttoPreis         = bestellungsDatenLoop.getBruttoPreis();
            int     flaschenProKarton   = bestellungsDatenLoop.getFlaschenProKarton();
            double  eisKostenNetto      = bestellungsDatenLoop.getEisKostenNetto();

            System.out.print((zaehler + 1) + ". Bestellung \n");
            System.out.printf("Wein Name                        : %s   \n", name);
            System.out.printf("Preis pro GetraenkFlasche (netto): %s €.\n", preis);
            System.out.printf("Menge die Flaschen               : %s Falschen.\n", menge);
            //#######################################################################################
            // Gesamtpreis berechnen
            System.out.printf("Gesamtpreis (netto)              : %s €.\n", nettoPreis);
            System.out.printf("Steuer                           : %s €.\n", steuer);
            if (eisKostenNetto != 0){
                System.out.printf("Gesamt EisKosten (netto)         : %s €.\n", eisKostenNetto);
            }
            System.out.printf("Gesamtpreis (brutto)             : %s €.\n", bruttoPreis);
            //#######################################################################################
            // Katron Anzahl berechnen
            String kartonsMeldung = kartonsMeldung(menge, flaschenProKarton);
            System.out.println(kartonsMeldung);
            zaehler++;
        }
    }
    // Method, um der Kunde Fragen ob Er verschiedene Sorten kaufen möchte und die Eingabe für die Anzahl der Menge Einkaufsdaten, Überprüfen
    private static int mengeEinkaufsDatenEinlesen(String bestaetigungsEinkaufsDaten) {
        Scanner scanner = new Scanner(System.in);
        int mengeEinkaufsDaten = 0;
        while (true) {
            try {
                 if (bestaetigungsEinkaufsDaten.equalsIgnoreCase("BEIDE") || bestaetigungsEinkaufsDaten.equalsIgnoreCase("BEIDE BITTE")){
                     System.out.print("Bitte geben Sie an, in welcher Menge Sie verschiedene Wein- und Saftsorten kaufen möchten: ");
                     mengeEinkaufsDaten = scanner.nextInt();
                     if (mengeEinkaufsDaten <= 0) {
                         throw new IllegalArgumentException("IllegalArgumentException ERROR!");
                     }
                } else {
                    System.out.printf("Bitte geben Sie an, in welcher Menge Sie verschiedene %ssorten kaufen möchten: ", bestaetigungsEinkaufsDaten);
                    mengeEinkaufsDaten = scanner.nextInt();
                    if (mengeEinkaufsDaten <= 0) {
                        throw new IllegalArgumentException("IllegalArgumentException ERROR!");
                    }
                }
                break;
            } catch (InputMismatchException | IllegalArgumentException error) {
                System.out.println("Achtung: Ungültige Eingabe.");
                scanner.nextLine();
            }
        }
        return mengeEinkaufsDaten;
    }
    private static String bestaetigungsEinkaufsDatenEinlesen() {
        Scanner scanner = new Scanner(System.in);
        String einkaufsDatenEingabe;
        List<String> bestaetigungsListe = List.of("WEIN", "WEIN BITTE", "SAFT", "SAFT BITTE", "BEIDE", "BEIDE BITTE");
        while (true) {
            try {
                System.out.print("Möchten Sie Weins, Saft oder beide Bestellen? ");
                einkaufsDatenEingabe = scanner.nextLine();

                for (String getBestaetigungsListe : bestaetigungsListe) {
                    if (einkaufsDatenEingabe.equalsIgnoreCase(getBestaetigungsListe)){
                        return einkaufsDatenEingabe;
                    }
                }
                for (String getBestaetigungsListe : bestaetigungsListe) {
                    if (!einkaufsDatenEingabe.equalsIgnoreCase(getBestaetigungsListe)){
                        throw new IllegalArgumentException("IllegalArgumentException ERROR!");
                    }
                }
                break;
            } catch (InputMismatchException | IllegalArgumentException error) {
                System.out.println("Achtung: Ungültige Eingabe.");
            }
        }
        return einkaufsDatenEingabe;
    }
    // Methode, um die Eingabe für den Namen des Weins Überprüfen
    private static String nameEinlesen(String bestaetigungsEinkaufsDaten) {
        Scanner scanner = new Scanner(System.in);
        String weinName = "";
        List<String> bestaetigungsListe = List.of("WEIN", "WEIN BITTE", "SAFT", "SAFT BITTE", "BEIDE", "BEIDE BITTE");
        while (true) {
            try {
                if (bestaetigungsEinkaufsDaten.equalsIgnoreCase(bestaetigungsListe.get(0)) || bestaetigungsEinkaufsDaten.equalsIgnoreCase(bestaetigungsListe.get(1))){
                    System.out.print("Bitte geben Sie den Namen des Weins ein: ");
                    weinName = scanner.nextLine();
                    if (weinName.isEmpty() || !Character.isLetter(weinName.charAt(0))) {
                        throw new IllegalArgumentException("IllegalArgumentException ERROR!");
                    }
                }else if (bestaetigungsEinkaufsDaten.equalsIgnoreCase(bestaetigungsListe.get(2)) || bestaetigungsEinkaufsDaten.equalsIgnoreCase(bestaetigungsListe.get(3))){
                    System.out.print("Bitte geben Sie den Namen des Safts ein: ");
                    weinName = scanner.nextLine();
                    if (weinName.isEmpty() || !Character.isLetter(weinName.charAt(0))) {
                        throw new IllegalArgumentException("IllegalArgumentException ERROR!");
                    }
                } else {
                    System.out.print("Bitte geben Sie den Namen des Weins oder Safts ein: ");
                    weinName = scanner.nextLine();
                    if (weinName.isEmpty() || !Character.isLetter(weinName.charAt(0))) {
                        throw new IllegalArgumentException("IllegalArgumentException ERROR!");
                    }
                }
                break;
            } catch (InputMismatchException | IllegalArgumentException error) {
                System.out.println("Achtung: Ungültige Eingabe.");
            }
        }
        return weinName;
    }
    // Methode, um die Eingabe zu überprüfen, ob der Kunde Eis haben möchte oder nicht
    private static String eisWuerfelBestaetigungsEinlesen() {
        Scanner scanner = new Scanner(System.in);
        String eisWuerfelBestaetigung;
        List<String> bestaetigungsListe = List.of("JA", "BITTE", "JA BITTE", "JA BITTE MIT EIS", "OHNE EIS", "NEIN BITTE OHNE EIS", "NEIN", "OHNE", "JA MIT EIS", "MIT EIS", "NEIN OHNE EIS");
        while (true) {
            try {
                System.out.print("Möchten Sie Ihr Gericht mit Eis Würfel serviert bekommen? ");
                eisWuerfelBestaetigung = scanner.nextLine();
                for (int i = 0; i < bestaetigungsListe.size(); i++) {
                    if (eisWuerfelBestaetigung.equalsIgnoreCase(bestaetigungsListe.get(i))){
                        return eisWuerfelBestaetigung;
                    }
                }
                for (int i = 0; i < bestaetigungsListe.size(); i++) {
                    if (!eisWuerfelBestaetigung.equalsIgnoreCase(bestaetigungsListe.get(i))){
                        throw new IllegalArgumentException("IllegalArgumentException ERROR!");
                    }
                }
                break;
            } catch (InputMismatchException | IllegalArgumentException error) {
                System.out.println("Achtung: Ungültige Eingabe.");
            }
        }
        return eisWuerfelBestaetigung;
    }
    // Methode, um die Eingabe zu überprüfen, wie viel Kg möchte der Kunde Eis haben
    private static int eisWuerfelMengeEinlesen(String eisWuerfelBestaetigung) {
        Scanner scanner = new Scanner(System.in);
        int eisWuerfelMengeEingabe = 0;
        List<String> bestaetigungsListe = List.of("JA", "BITTE", "JA BITTE", "JA BITTE MIT EIS", "JA MIT EIS", "MIT EIS");
        boolean bestaeten = false;
        while (true) {
            try {
                for (int i = 0; i < bestaetigungsListe.size(); i++) {
                    if (eisWuerfelBestaetigung.equalsIgnoreCase(bestaetigungsListe.get(i))) {
                        System.out.print("Geben Sie bitte an, in welcher Menge Sie Eiswürfel bestellen möchten (Stuck kostet 1.30€ netto): ");
                        eisWuerfelMengeEingabe = scanner.nextInt();
                    }
                }
                break;
            } catch (InputMismatchException | NumberFormatException error) {
                System.out.println("Achtung: Ungültige Eingabe.");
            }
        }
        return eisWuerfelMengeEingabe;
    }
    // Methode, um die Eingabe für den Preis pro GetraenkFlasche (netto) Überprüfen
    private static double preisEinlesen(String nameDesSortes) {
        Scanner scanner = new Scanner(System.in);

        double preisProFlasche;
        while (true) {
            try {
                System.out.print("Bitte geben Sie den Preis pro GetraenkFlasche ein: ");
                preisProFlasche = scanner.nextDouble();
                if (preisProFlasche > 588000 ){
                    System.out.print("Es tut uns leid, aber der eingegebene Preis überschreitet unser Limit. " +
                                     "Der teuerste "+ nameDesSortes +" in unserem Sortiment kostet 558.000 Euro. " +
                                     "\nBitte geben Sie einen Betrag innerhalb dieses Limits ein: ");
                    preisProFlasche = scanner.nextDouble();
                }else if (preisProFlasche < 4.99){
                    System.out.print("Entschuldigung, aber der eingegebene Preis muss mindestens 5.00 Euro " +
                                     "betragen, da die günstigste "+ nameDesSortes +" in unserem Sortiment 4.99 Euro kostet. " +
                                     "\nBitte geben Sie einen gültigen Betrag ein: ");
                    preisProFlasche = scanner.nextDouble();
                }
                break;
            } catch (InputMismatchException | IllegalArgumentException error) {
                System.out.println("Achtung: Ungültige Eingabe.");
                scanner.nextLine();
            }
        }
        return preisProFlasche;
    }
    // Method, um die Eingabe für die Anzahl der Flaschen Überprüfen
    private static int mengeEinlesen() {
        Scanner scanner = new Scanner(System.in);
        int mengeFlachen;
        while (true) {
            try {
                System.out.print("Bitte geben Sie die Anzahl der Flaschen ein, die Sie kaufen möchten: ");
                mengeFlachen = scanner.nextInt();
                if (mengeFlachen <= 0) {
                    throw new IllegalArgumentException("IllegalArgumentException ERROR!");
                }
                break;
            } catch (InputMismatchException | IllegalArgumentException error) {
                System.out.println("Achtung: Ungültige Eingabe.");
                scanner.nextLine();
            }
        }
        return mengeFlachen;
    }
    // Method, um die Eingabe für die Anzahl der Flaschen Pro Karton Überprüfen
    private static int flaschenProKartonEinlesen() {
        Scanner scanner = new Scanner(System.in);
        int flaschenProKarton;
        while (true) {
            try {
                System.out.print("Bitte geben Sie ein, wie viele Flaschen Sie pro Karton aufteilen möchten: 6er, 12er oder 18er Aufteilung? ");
                flaschenProKarton = scanner.nextInt();
                if (flaschenProKarton != 6 && flaschenProKarton != 12 && flaschenProKarton != 18) {
                    throw new IllegalArgumentException("IllegalArgumentException ERROR!");
                }
                break;
            } catch (InputMismatchException | IllegalArgumentException error) {
                System.out.println("Achtung: Ungültige Eingabe.");
                scanner.nextLine();
            }
        }
        return flaschenProKarton;
    }
    private static String kartonsMeldung(BigDecimal menge, int flaschenProKarton) {
        BigDecimal kartonsAnzahl        = BigDecimal.valueOf(menge.intValue() /flaschenProKarton);
        BigDecimal verbleibendeFlaschen = BigDecimal.valueOf(menge.intValue() % flaschenProKarton);

        if (verbleibendeFlaschen.intValue() > 0) {
            return "Hinweis: Ihre Bestellung wird in " + kartonsAnzahl + " Kartons und " + verbleibendeFlaschen + " einzelnen Flaschen versandt.\n Jeder Karton enthält " + flaschenProKarton + " Flaschen.\n\n";
        } else {
            return "Hinweis: Ihre Bestellung wird in "  + kartonsAnzahl + " Kartons versandt.\n Jeder Karton enthält " + flaschenProKarton + " Flaschen.\n\n";
        }
    }
}
