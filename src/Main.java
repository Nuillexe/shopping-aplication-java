import java.util.*;



public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        System.out.println("Enter the card Limit to begin your shopping");
        double cardLimit=scanner.nextDouble();
        scanner.nextLine();
        CreditCard card= new CreditCard(cardLimit);

        String purchaseDescription;
        double purchaseValue;
        boolean stopShopping=false;

        System.out.println("Now, you can buy. Let's go!");
        do{

            System.out.printf("\nYour balance:"+ card.getBalance() +"\n");
            System.out.println("Enter description of your new purchase:");
            purchaseDescription= scanner.nextLine();
            System.out.println("Enter value of your new purchase:");
            purchaseValue= scanner.nextDouble();
            scanner.nextLine();
            Purchase newPurchase=new Purchase(purchaseDescription,purchaseValue);

            if(card.approvedPurchase(newPurchase)){
                card.addPurchase(newPurchase);
                System.out.println("Purchase approved");
                System.out.println("Do you wish keep shopping?(Type yes to keep shopping)");
                stopShopping=stopShopping(scanner.nextLine());

            }else{
                System.out.println("Insufficient balance");
                stopShopping=true;
            }

        }while(!stopShopping);

        System.out.println(card.showShopping());
        System.out.println("Thanks for shopping in our store");
    }

    static boolean stopShopping(String answer){
        return !answer.equalsIgnoreCase("yes");
    }
}