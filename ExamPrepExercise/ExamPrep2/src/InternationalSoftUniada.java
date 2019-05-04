import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InternationalSoftUniada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap <String, Map<String,Integer>>record = new LinkedHashMap<>();

        String input = "";
        while(!"END".equals(input = scanner.nextLine())){
            String [] data = input.split(" -> ");
            String countryName = data[0];
            String contestantName = data[1];
            int contestantPoints = Integer.parseInt(data[2]);

            if(!record.containsKey(countryName)){
                record.put(countryName,new LinkedHashMap<>());
                record.get(countryName).put(contestantName,contestantPoints);
            }else{
                if(record.get(countryName).containsKey(contestantName)){
                    record.get(countryName).put(contestantName,contestantPoints+record.get(countryName).get(contestantName));
                }else{
                    record.get(countryName).put(contestantName,contestantPoints);
                }

            }
        }

        LinkedHashMap<String,Integer>totalPoints = new LinkedHashMap<>();

        record.entrySet().stream()
                .forEach(e->{
                    int sum = e.getValue().values().stream().mapToInt(i->i).sum();
                    totalPoints.put(e.getKey(),sum);
                });
        Map<String,Integer>sorted = totalPoints.entrySet().stream()
                .sorted((e1,e2)->Integer.compare(e2.getValue(),e1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1,LinkedHashMap::new));

        sorted.entrySet().stream()
                .forEach(elem->{
                    System.out.println(String.format("%s: %d",elem.getKey(),elem.getValue()));
                    record.get(elem.getKey()).entrySet().forEach(pair->{
                        System.out.println(String.format("-- %s -> %d",pair.getKey(),pair.getValue()));
                    });
                });

    }
}
