public class Products implements Comparable<Products> {
    private String description;
    private double value;

    public Products(String name, double value) {
        this.description = name;
        this.value = value;
    }

    public int compareTo(Products otherProduct){
        if(this.value<otherProduct.value)
            return -1;
        else if (this.value> otherProduct.value)
            return +1;
        else
            return 0;

    }

    public String toString(){
        return description +String.format(" - R$%.2f \n",value);
    }
    public String getName() {
        return description;
    }

    public double getValue() {
        return value;
    }
}
