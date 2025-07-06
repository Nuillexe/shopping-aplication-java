import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CreditCard {
    private double limit;
    private double balance;
    double totalShopping = 0;

    List<Purchase> shoppingList= new LinkedList<>();


    public CreditCard(double limit) {
        this.limit = limit;
        this.balance = limit;
    }

    public boolean approvedPurchase(Purchase newPurchase) {
        if(balance - newPurchase.getValue() >- 1){
            balance -= newPurchase.getValue();
            return true;
        }else
            return false;
    }

    public void addPurchase(Purchase newPurchase){
        shoppingList.add(newPurchase);
        sortThePurchases();
    }

    private void sortThePurchases(){
        Collections.sort(shoppingList);
    }

    public double getBalance() {
        return balance;
    }

    public String showShopping(){
        return printMargin()+
                "Purchases Made:\n\n" +
                printEachProduct()+
                printShoppingTotal()+
                printMargin();
    }

    private String printEachProduct(){
        String shoppingList="";
        for(Purchase purchase: this.shoppingList)
            shoppingList+=purchase.toString();
        return shoppingList;
    }

    private String printShoppingTotal(){
        this.totalShopping=calculateTotalShopping();
        return "Total: "+this.totalShopping+"\n";
    }

    public double calculateTotalShopping(){
        double totalShopping=0;
        for(Purchase item:shoppingList)
            totalShopping+=item.getValue();

        return totalShopping;
    }

    private String printMargin(){
        return "\n********************\n";
    }

}
