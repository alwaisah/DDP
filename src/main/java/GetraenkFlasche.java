public class GetraenkFlasche {
    private String name;
    private double preis;
    public GetraenkFlasche(String name, double preis){
        this.name  = name;
        this.preis = preis;
    }
    public GetraenkFlasche(){
    }
    public String getName() {
        return name + "X";
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPreis() {
        return preis;
    }
    public void setPreis(double preis) {
        this.preis = preis;
    }
}
