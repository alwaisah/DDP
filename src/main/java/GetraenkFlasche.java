import java.math.BigDecimal;

class GetraenkFlasche {
    private String name;
    private BigDecimal preis;
    public GetraenkFlasche(String name, BigDecimal preis){
        this.name  = name;
        this.preis = preis;
    }
    public GetraenkFlasche(){
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getPreis() {
        return preis;
    }
    public void setPreis(BigDecimal preis) {
        this.preis = preis;
    }
}
