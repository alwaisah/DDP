package WeinPackage;

public class EinkaufsKorb {
    // Methode zur Berechnung des Gesamtpreises (netto)
    public double berechneGesamteNettoPreis(BestellungsDaten bestellungsDaten, GetraenkFlasche einGetraenkFlasche){
        double nettoPreis = Math.round(100 * (bestellungsDaten.getMenge() * einGetraenkFlasche.getPreis())) / 100.0;
        bestellungsDaten.setNettoPreis(nettoPreis);
        return nettoPreis;
    }
    // Methode zur Berechnung der Steuer
    public double berechneGesamteSteuer(BestellungsDaten bestellungsDaten) {
        double steuer = Math.round(100 * (bestellungsDaten.getNettoPreis() * 0.19)) / 100.0;
        bestellungsDaten.setSteuer(steuer);
        return bestellungsDaten.getSteuer();
    }
    // Methode zur Berechnung des Eiskosten (netto)
    public double berechneGesamteEisKostenNetto(BestellungsDaten bestellungsDaten) {
        double eisKosten = Math.round(100 * (bestellungsDaten.getEisWuerfelMenge() * 1.3 )) / 100.0;
        bestellungsDaten.setEisKostenNetto(eisKosten);
        return bestellungsDaten.getEisKostenNetto();
    }
    // Methode zur Berechnung des Gesamtpreises (brutto)
    public double berechneGesamteBruttoPreis(BestellungsDaten bestellungsDaten) {
        double steuer = Math.round(100 * (bestellungsDaten.getEisKostenNetto() * 0.19)) / 100.0;
        double eisKosten = Math.round(100 * (bestellungsDaten.getEisKostenNetto() + steuer)) / 100.0;
        double bruttoPreis = Math.round(100 * ( bestellungsDaten.getNettoPreis() + bestellungsDaten.getSteuer() + eisKosten)) / 100.0;
        bestellungsDaten.setBruttoPreis(bruttoPreis);
        return bestellungsDaten.getBruttoPreis();
    }

}
