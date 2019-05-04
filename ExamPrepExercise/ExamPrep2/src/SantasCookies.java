import java.util.Scanner;

public class SantasCookies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int boxCounter =0;

        for (int i = 0; i <n ; i++) {
            int flour = Integer.parseInt(scanner.nextLine());
            int sugar = Integer.parseInt(scanner.nextLine());
            int cocoa = Integer.parseInt(scanner.nextLine());
            int flourCups = flour/140;
            int sugarSpoons = sugar/20;
            int cocoaSpoons = cocoa/10;

            if(flourCups<=0 || sugarSpoons<=0 || cocoaSpoons<=0){
                System.out.println("Ingredients are not enough for a box of cookies.");
            }else {

               int totalCookiesPerBake = (140+10+20)*Math.min(flourCups,Math.min(sugarSpoons,cocoaSpoons))/25;
                System.out.println("Boxes of cookies: "+totalCookiesPerBake/5);
                boxCounter+=totalCookiesPerBake/5;
            }
        }
        System.out.println("Total boxes: "+ boxCounter);
    }
}
