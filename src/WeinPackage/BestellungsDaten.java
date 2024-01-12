package WeinPackage;

class BestellungsDaten {

    private GetraenkFlasche einGetreankFlasche;
    private Wein einWein;
    private Saft einSaft;
    private int menge;
    private double nettoPreis;
    private double bruttoPreis;
    private double steuer;
    private int kartonsAnzahl;
    private int verbleibendeFlaschen;
    private int flaschenProKarton;
    private int verschiedeneEinkaufsDaten;
    private int eisWuerfelMenge;
    private double eisKostenNetto;

    // Start Konstraktor
    public BestellungsDaten(Wein einWein, Saft einSaft, int menge, double nettoPreis, double bruttoPreis, double steuer, int kartonsAnzahl,
                            int verbleibendeFlaschen, int flaschenProKarton, int verschiedeneEinkaufsDaten){
        this.einWein                    = einWein;
        this.einSaft                    = einSaft;
        this.menge                      = menge;
        this.nettoPreis                 = nettoPreis;
        this.bruttoPreis                = bruttoPreis;
        this.steuer                     = steuer;
        this.kartonsAnzahl              = kartonsAnzahl;
        this.verbleibendeFlaschen       = verbleibendeFlaschen;
        this.flaschenProKarton          = flaschenProKarton;
        this.verschiedeneEinkaufsDaten  = verschiedeneEinkaufsDaten;
    }
    public BestellungsDaten(GetraenkFlasche einGetreankFlasche, int menge, int flaschenProKarton, int eisWuerfelMenge){
        this.einGetreankFlasche = einGetreankFlasche;
        this.menge              = menge;
        this.flaschenProKarton  = flaschenProKarton;
        this.eisWuerfelMenge    = eisWuerfelMenge;
    }
    private BestellungsDaten(){
    }
    // Start Getter und Setter Methods
    public GetraenkFlasche getEinGetreankFlasche() {
        return einGetreankFlasche;
    }
    public void setEinGetreankFlasche(GetraenkFlasche einGetreankFlasche) {
        this.einGetreankFlasche = einGetreankFlasche;
    }
    public Wein getEinWeinFlasche() {
        return einWein;
    }
    public void setEinWeinFlasche(Wein einWein) {
        this.einWein = einWein;
    }
    public int getMenge() {
        return menge;
    }
    public void setMenge(int menge) {
        this.menge = menge;
    }
    public double getNettoPreis() {
        return nettoPreis;
    }
    public void setNettoPreis(double nettoPreis) {
        this.nettoPreis = nettoPreis;
    }
    public double getBruttoPreis() {
        return bruttoPreis;
    }
    public void setBruttoPreis(double bruttoPreis) {
        this.bruttoPreis = bruttoPreis;
    }
    public double getSteuer() {
        return steuer;
    }
    public void setSteuer(double steuer) {
        this.steuer = steuer;
    }
    public int getKartonsAnzahl() {
        return kartonsAnzahl;
    }
    public void setKartonsAnzahl(int kartonsAnzahl) {
        this.kartonsAnzahl = kartonsAnzahl;
    }
    public int getVerbleibendeFlaschen() {
        return verbleibendeFlaschen;
    }
    public void setVerbleibendeFlaschen(int verbleibendeFlaschen) {
        this.verbleibendeFlaschen = verbleibendeFlaschen;
    }
    public int getFlaschenProKarton() {
        return flaschenProKarton;
    }
    public void setFlaschenProKarton(int flaschenProKarton) {
        this.flaschenProKarton = flaschenProKarton;
    }
    public int getVerschiedeneEinkaufsDaten() {
        return verschiedeneEinkaufsDaten;
    }
    public void setVerschiedeneEinkaufsDaten(int verschiedeneEinkaufsDaten) {
        this.verschiedeneEinkaufsDaten = verschiedeneEinkaufsDaten;
    }
    public Wein getEinWein() {
        return einWein;
    }
    public void setEinWein(Wein einWein) {
        this.einWein = einWein;
    }
    public Saft getEinSaft() {
        return einSaft;
    }
    public void setEinSaft(Saft einSaft) {
        this.einSaft = einSaft;
    }
    public int getEisWuerfelMenge() {
        return eisWuerfelMenge;
    }
    public void setEisWuerfelMenge(int eisWuerfelMenge) {
        this.eisWuerfelMenge = eisWuerfelMenge;
    }
    public double getEisKostenNetto() {
        return eisKostenNetto;
    }
    public void setEisKostenNetto(double eisKostenNetto) {
        this.eisKostenNetto = eisKostenNetto;
    }
}