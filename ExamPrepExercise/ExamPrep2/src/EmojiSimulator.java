import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String  regex ="(\\s:)\\b([a-z]{4,300})\\b(:)(\\s|\\.|\\?|\\!|\\,)";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);

        List<String> emoji = new ArrayList<>();

        while (matcher.find()){
            emoji.add(matcher.group(2));
        }

         String [] numbers = scanner.nextLine().split(":");
        String bonus = "";
        for (int i = 0; i <numbers.length ; i++) {
               bonus+=(char)(Integer.parseInt(numbers[i]));

        }

        int emojiPower = 0;

        for (int i = 0; i <emoji.size() ; i++) {
            for (int j = 0; j <emoji.get(i).length() ; j++) {
                emojiPower+=(int)(emoji.get(i).charAt(j));
            }
        }

        if(emoji.contains(bonus)){
            emojiPower*=2;
        }
        List<String>result = new ArrayList<>();
        if(!emoji.isEmpty()) {
            System.out.print("Emojis found: ");
            for (String el : emoji) {
                el = ":" + el + ":";
                result.add(el);
            }

            System.out.println(emoji.toString().join(", ", result));
        }

        System.out.println("Total Emoji Power: "+emojiPower);

    }
}
