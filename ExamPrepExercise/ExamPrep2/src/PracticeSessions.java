import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class PracticeSessions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = "";

        LinkedHashMap<String, List<String>> roadsAndRacers = new LinkedHashMap<>();

        while (!"END".equals(line = scanner.nextLine())){
            String [] commands = line.split("->");

            if(commands[0].equals("Add")){
                roadsAndRacers.putIfAbsent(commands[1],new ArrayList<>());
                roadsAndRacers.get(commands[1]).add(commands[2]);
            }else if(commands[0].equals("Move")){
                String currentRoad = commands[1];
                String racer = commands[2];
                String nextRoad = commands[3];

                if(roadsAndRacers.get(currentRoad).contains(racer)){
                    roadsAndRacers.get(currentRoad).remove(racer);
                    roadsAndRacers.get(nextRoad).add(racer);
                }

            }else if(commands[0].equals("Close")){
                roadsAndRacers.remove(commands[1]);
            }
        }

        System.out.println("Practice sessions:");

        roadsAndRacers.entrySet().stream()
                .sorted((e1,e2)->{
                    int sort = Integer.compare(e2.getValue().size(),e1.getValue().size());
                    if(sort == 0){
                        sort = e1.getKey().compareTo(e2.getKey());
                    }
                    return sort;
                }).forEach(entry->{
            System.out.println(String.format("%s",entry.getKey()));
            for (int i = 0; i <entry.getValue().size(); i++) {
                System.out.println(String.format("++%s",entry.getValue().get(i)));
            }
        });
    }
}
