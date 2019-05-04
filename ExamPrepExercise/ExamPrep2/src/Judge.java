import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Judge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                  new InputStreamReader(System.in));

        String input = "";

        LinkedHashMap<String, Map<String,Integer>>recordContests = new LinkedHashMap<>();

        LinkedHashMap<String,Integer>totalPointsPerPerson=new LinkedHashMap<>();

        while(!"no more time".equals(input=reader.readLine())){
            String [] data = input.split(" -> ");
            String username = data[0];
            String contest = data[1];
            int points = Integer.parseInt(data[2]);

            if(!recordContests.containsKey(contest)){
                recordContests.put(contest,new LinkedHashMap<>());
                recordContests.get(contest).put(username,points);
                if(!totalPointsPerPerson.containsKey(username)) {
                    totalPointsPerPerson.put(username, points);
                }
            }else{
                if(!recordContests.get(contest).containsKey(username)){
                    recordContests.get(contest).put(username,points);
                    if(!totalPointsPerPerson.containsKey(username)) {
                        totalPointsPerPerson.put(username, points);
                    }else {
                        totalPointsPerPerson.put(username,points+totalPointsPerPerson.get(username));
                    }
                }else {
                    if(points>recordContests.get(contest).get(username)){
                        recordContests.get(contest).put(username,points);
                       totalPointsPerPerson.put(username,points);
                    }else {
                        recordContests.get(contest).put(username,recordContests.get(contest).get(username));
                        if(totalPointsPerPerson.containsKey(username)) {
                            totalPointsPerPerson.put(username, recordContests.get(contest).get(username) + points);
                        }else{
                            totalPointsPerPerson.put(username,points);
                        }
                    }
                }
            }
        }





        recordContests.entrySet().stream()
                .forEach(e->{
                    System.out.println(String.format("%s: %d participants",e.getKey(),e.getValue().size()));

                    LinkedHashMap<String, Integer> collect = e.getValue().entrySet().stream().sorted((e1, e2) -> {
                        return Integer.compare(e2.getValue(), e1.getValue());
                    }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

                    int counter =0;
                    for (Map.Entry<String,Integer>set: collect.entrySet()) {
                        counter++;
                        System.out.println(String.format("%d. %s <::> %d",counter,set.getKey(),set.getValue()));
                    }
                });
        System.out.println("Individual standings:");

        LinkedHashMap<String, Integer> sorted = totalPointsPerPerson.entrySet().stream().sorted((e1, e2) -> {
            return Integer.compare(e2.getValue(), e1.getValue());
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e2, e1) -> e2, LinkedHashMap::new));

        int counter = 0;
        for (Map.Entry<String, Integer> set :sorted.entrySet()) {
            counter++;
            System.out.println(String.format("%d. %s -> %d",counter,set.getKey(),set.getValue()));
        }
    }
}
