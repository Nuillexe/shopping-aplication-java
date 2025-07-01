public class Products {
    private String description;
    private double value;

    public Products(String name, double value) {
        this.description = name;
        this.value = value;
    }

    public String toString(){
        return description +" - "+value+"\n";
    }
    public String getName() {
        return description;
    }

    public double getValue() {
        return value;
    }
}
