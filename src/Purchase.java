public class Purchase implements Comparable<Purchase> {
    private String description;
    private double value;

    public Purchase(String name, double value) {
        this.description = name;
        this.value = value;
    }

    @Override
    public int compareTo(Purchase otherProduct){
        return Double.valueOf(otherProduct.value).compareTo(Double.valueOf(this.value));
    }

    @Override
    public String toString(){
        return description + String.format(" - R$%.2f \n",value);
    }

    public String getDescription() {
        return description;
    }

    public double getValue() {
        return value;
    }
}
