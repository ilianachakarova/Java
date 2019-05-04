import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);


        String [] demons = scanner.nextLine().split(",\\s*");
        TreeMap<String, LinkedHashMap<Integer,Double>>demonsRecord= new TreeMap<>();

        for (int i = 0; i <demons.length ; i++) {

            String demonName = demons[i].replaceAll("\\s+","");
            int totalHealth = 0;
            double totalDamage = 0.0;
            String health ="";

            String healthRegex = "[^\\s\\d.+\\/*,-]*";
            Pattern pattern1 = Pattern.compile(healthRegex);
            Matcher healthMatcher = pattern1.matcher(demonName);

            while (healthMatcher.find()){
                health+=healthMatcher.group();
            }

            for (int j = 0; j <health.length() ; j++) {
                totalHealth+=(int)health.charAt(j);
            }

            String damageRegex = "([-]?[\\d]+[.]?[\\d]*)";
            Pattern pattern2 = Pattern.compile(damageRegex);
            Matcher damageMatcher = pattern2.matcher(demonName);

            while (damageMatcher.find()){
                totalDamage+=Double.parseDouble(damageMatcher.group());
            }

            for (int j = 0; j <demonName.length() ; j++) {
                if(demonName.charAt(j)=='/'){
                    totalDamage/=2;
                }else if(demonName.charAt(j)=='*'){
                    totalDamage*=2;
                }
            }

            demonsRecord.putIfAbsent(demonName,new LinkedHashMap<>());
            demonsRecord.get(demonName).put(totalHealth,totalDamage);

        }

        demonsRecord.entrySet().stream()
                .forEach(element->{
                    element.getValue().entrySet().stream()
                            .forEach(entry->{
                                System.out.println(String.format("%s - %d health, %.2f damage",
                                        element.getKey(),entry.getKey(),entry.getValue()));
                            });
                });

        }

    }



