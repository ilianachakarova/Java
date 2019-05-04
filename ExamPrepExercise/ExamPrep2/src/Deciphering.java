import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deciphering {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                  new InputStreamReader(System.in));

        String message = reader.readLine();
        String [] subst = reader.readLine().split("\\s+");
        String wordToFind = subst[0];
        String wordToReplace = subst[1];

        String regex ="^[d-z\\{\\}\\|#]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(message);

        String result = "";
        if(!matcher.find()){
            System.out.println("This is not the book you are looking for.");
            return;
        }else {
            for (int i = 0; i <message.length() ; i++) {
                result+=(char)(message.charAt(i)-3);
            }

            result = result.replace(wordToFind,wordToReplace);
            System.out.println(result);
        }



    }
}
