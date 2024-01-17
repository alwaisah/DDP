import java.math.BigDecimal;

class EinkaufsKorb {
    // Methode zur Berechnung des Gesamtpreises (netto)
    public BigDecimal berechneGesamteNettoPreis(BestellungsDaten bestellungsDaten, GetraenkFlasche einGetraenkFlasche){
        BigDecimal nettoPreis =  einGetraenkFlasche.getPreis().multiply(bestellungsDaten.getMenge());
         bestellungsDaten.setNettoPreis(nettoPreis);
        return nettoPreis;
    }
    // Methode zur Berechnung der Steuer
    public BigDecimal berechneGesamteSteuer(BestellungsDaten bestellungsDaten) {
        BigDecimal steuer = bestellungsDaten.getNettoPreis().multiply(BigDecimal.valueOf(0.19));
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
    public BigDecimal berechneGesamteBruttoPreis(BestellungsDaten bestellungsDaten) {
        double steuer = Math.round(100 * (bestellungsDaten.getEisKostenNetto() * 0.19)) / 100.0;
        double eisKosten = Math.round(100 * (bestellungsDaten.getEisKostenNetto() + steuer)) / 100.0;
        BigDecimal bruttoPreis = bestellungsDaten.getNettoPreis()
                .add(bestellungsDaten.getSteuer())
                .add(BigDecimal.valueOf(eisKosten));
        bestellungsDaten.setBruttoPreis(bruttoPreis);
        return bestellungsDaten.getBruttoPreis();
    }

}
