import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrivingInKathmandu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = "";

        String regex = "^([A-Za-z@#\\!\\?\\$]+)=([0-9]+)<<(.+)$";


        while(!"Last note".equals(inputLine=scanner.nextLine())){
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(inputLine);
            if(matcher.find()){
                String name = matcher.group(1);
                String geoCode = matcher.group(3);
                int length = Integer.parseInt(matcher.group(2));
                String resultName = "";
                if(geoCode.length()==length){
                    for (int i = 0; i <name.length() ; i++) {
                        if(Character.isLetter(name.charAt(i))){
                            resultName+=name.charAt(i);
                        }

                    }
                    System.out.println(String.format("Coordinates found! %s -> %s",resultName,geoCode));
                }else {
                    System.out.println("Nothing found!");
                }
            }else {
                System.out.println("Nothing found!");
            }
        }
    }
}
