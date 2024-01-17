import java.math.BigDecimal;

class BestellungsDaten {

    private GetraenkFlasche einGetreankFlasche;
    private Wein einWein;
    private Saft einSaft;
    private BigDecimal menge;
    private BigDecimal nettoPreis;
    private BigDecimal bruttoPreis;
    private BigDecimal steuer;
    private int kartonsAnzahl;
    private int verbleibendeFlaschen;
    private int flaschenProKarton;
    private int verschiedeneEinkaufsDaten;
    private int eisWuerfelMenge;
    private double eisKostenNetto;

    // Start Konstraktor
    public BestellungsDaten(Wein einWein, Saft einSaft, BigDecimal menge, BigDecimal nettoPreis, BigDecimal bruttoPreis, BigDecimal steuer, int kartonsAnzahl,
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
    public BestellungsDaten(GetraenkFlasche einGetreankFlasche, BigDecimal menge, int flaschenProKarton, int eisWuerfelMenge){
        this.einGetreankFlasche = einGetreankFlasche;
        this.menge              = menge;
        this.flaschenProKarton  = flaschenProKarton;
        this.eisWuerfelMenge    = eisWuerfelMenge;
    }
    public BestellungsDaten(){
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
    public BigDecimal getMenge() {
        return menge;
    }
    public void setMenge(BigDecimal menge) {
        this.menge = menge;
    }
    public BigDecimal getNettoPreis() {
        return nettoPreis;
    }
    public void setNettoPreis(BigDecimal nettoPreis) {
        this.nettoPreis = nettoPreis;
    }
    public BigDecimal getBruttoPreis() {
        return bruttoPreis;
    }
    public void setBruttoPreis(BigDecimal bruttoPreis) {
        this.bruttoPreis = bruttoPreis;
    }
    public BigDecimal getSteuer() {
        return steuer;
    }
    public void setSteuer(BigDecimal steuer) {
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