import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        List<Products> shoppingList= new LinkedList<>();
        int cardLimit;
        String productDescription;
        double productValue;
        double totalShopping;
        boolean stopShopping=false;

        System.out.println("Enter the card Limit to begin your shopping");
        cardLimit=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Now, you can buy");
        do{
            System.out.println("Enter description of your new purchase:");
            productDescription= scanner.nextLine();
            System.out.println("Enter value of your new purchase:");
            productValue= scanner.nextDouble();
            scanner.nextLine();
            totalShopping=calculateTotalShopping(shoppingList)+productValue;

            if(totalShopping>cardLimit){
                System.out.println("Insufficient balance");
                stopShopping=true;
            }else{
                shoppingList.add(new Products(productDescription,productValue));
                System.out.println("Do you wish keep shopping?(Type yes to keep shopping)");
                stopShopping=stopShopping(scanner.nextLine());
            }

        }while(!stopShopping);

        Collections.sort(shoppingList);

        System.out.println(showShopping(shoppingList));
        System.out.println("Thanks for shopping in our store");
    }

    static double calculateTotalShopping(List<Products> productsList){
        double totalShopping=0;
        for(Products item:productsList)
            totalShopping+=item.getValue();

        return totalShopping;
    }

    static boolean stopShopping(String answer){
        return !answer.equalsIgnoreCase("yes");
    }

    static String showShopping(List<Products> productsList){
        return printMargin()+
                "Purchases Made:\n\n" +
                printingEachProduct(productsList)+
                printShoppingTotal(productsList)+
                printMargin();
    }

    static String printingEachProduct(List<Products> productsList){
        String shoppingList="";
        for(Products purchase: productsList)
            shoppingList+=purchase.toString();
        return shoppingList;
    }

    static String printShoppingTotal(List<Products> productsList){
        double totalShopping=calculateTotalShopping(productsList);
        return "Total: "+totalShopping+"\n";
    }

    static String printMargin(){
        return "\n********************\n";
    }


}