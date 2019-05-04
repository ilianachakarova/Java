import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BakingFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());
        int currentEnergy = 100;
        int currentCoins =100;

        for (int i = 0; i <input.size() ; i++) {

            String [] parts = input.get(i).split("-");
            if("rest".equals(parts[0])){
                int number = Integer.parseInt(parts[1]);
                if(currentEnergy+number<=100){
                    System.out.println(String.format("You gained %d energy.", number));
                    System.out.println(String.format("Current energy: %d.",number+currentEnergy));
                    currentEnergy += number;
                }else {
                    System.out.println(String.format("You gained %d energy.", 100-currentEnergy));
                    System.out.println(String.format("Current energy: %d.",100));
                    currentEnergy = 100;
                }

            }else if("order".equals(parts[0])){

                int coinsToAdd = Integer.parseInt(parts[1]);
                if(currentEnergy-30>=0){
                    currentCoins += coinsToAdd;
                    System.out.printf("You earned %d coins.%n",coinsToAdd);
                    currentEnergy-=30;
                }else {
                    System.out.println("You had to rest!");
                    currentEnergy +=50;
                }
            }else{
                int price = Integer.parseInt(parts[1]);
                if(currentCoins-price>0){
                    System.out.printf("You bought %s.%n",parts[0]);
                    currentCoins-=price;
                }else {
                    System.out.printf("Closed! Cannot afford %s.%n",parts[0]);
                    return;
                }
            }

        }

        System.out.println("Day completed!");
        System.out.printf("Coins: %d%n",currentCoins);
        System.out.printf("Energy: %d%n",currentEnergy);
    }
}
