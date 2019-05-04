import java.util.Scanner;

public class CookingMasterclass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceFlourPerPackage = Double.parseDouble(scanner.nextLine());
        double pricePerEgg = Double.parseDouble(scanner.nextLine());
        double pricePerApron = Double.parseDouble(scanner.nextLine());

        double apronsNeeded = Math.ceil(students + 0.2* students);
        double freeFlour = students/5.0;
        freeFlour = Math.floor(freeFlour);

        double moneySpent = pricePerApron*apronsNeeded + pricePerEgg*students*10 + priceFlourPerPackage*(students-freeFlour);

        if(moneySpent<=budget){
            System.out.printf("Items purchased for %.2f$.",moneySpent);
        }else{
            System.out.printf("%.2f$ more needed.",moneySpent-budget);
        }

    }
}
