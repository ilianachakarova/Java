import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongEncryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^([A-Z][a-z'\\s]+):([A-Z\\s]+)$";
        String input = "";
        String result = "";

        while (!"end".equals(input = scanner.nextLine())) {
            result = "";
            String[] data = input.split(":");
            String name = data[0];
            int num = name.length();
            Pattern pattern = Pattern.compile(regex);
            Matcher inputMatcher = pattern.matcher(input);


            if (inputMatcher.find()) {
                for (int i = 0; i < inputMatcher.group().length(); i++) {
                    if (inputMatcher.group().charAt(i) == ':') {
                        result += '@';
                    } else if (inputMatcher.group().charAt(i) == 32) {
                        result += (char) (32);

                    } else if (inputMatcher.group().charAt(i) == 39) {
                        result += (char) (39);
                    } else if (inputMatcher.group().charAt(i) > 65 && inputMatcher.group().charAt(i) < 90) {
                        if (inputMatcher.group().charAt(i) + num > 90) {
                            result += (char) (inputMatcher.group().charAt(i) + num - 26);
                        } else {
                            result += (char) (inputMatcher.group().charAt(i) + num);
                        }

                    } else if (inputMatcher.group().charAt(i) > 97 && inputMatcher.group().charAt(i) < 122) {

                        if (inputMatcher.group().charAt(i) + num > 122) {
                            result += (char) (inputMatcher.group().charAt(i) + num - 26);
                        } else {
                            result += (char) (inputMatcher.group().charAt(i) + num);
                        }

                    } else {
                        char current = (char) (inputMatcher.group().charAt(i) + num);
                        result += current;
                    }
                }
                System.out.println("Successful encryption: "+result);
            } else {
                System.out.println("Invalid input!");
            }


        }


    }
}
