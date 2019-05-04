import java.util.*;

public class IronGrinder {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

       LinkedHashMap<String,Integer>record = new LinkedHashMap<>();
        LinkedHashMap<String,Integer>times = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while(!input.equals("Slide rule")) {
            if (!input.contains("ambush")) {
                String[] data = input.split(":");
                String townName = data[0];
                String[] moreData = data[1].split("->");
                int time = Integer.parseInt(moreData[0]);
                int passengers = Integer.parseInt(moreData[1]);
                if (!record.containsKey(townName)) {
                    record.put(townName, passengers);
                    times.put(townName, time);
                }else {
                    if(time<=times.get(townName)){
                        times.put(townName,time);
                    }else if(times.get(townName)==0){
                        times.put(townName,time);
                    }else {
                        times.put(townName,times.get(townName));
                    }
//                    times.put(townName,time);
                    record.put(townName,passengers+record.get(townName));
                }
            } else {
                String[] data = input.split(":");
                String townName = data[0];
                String[] moreData = data[1].split("->");
                String ambush = moreData[0];
                int passangerCount = Integer.parseInt(moreData[1]);

                if(record.containsKey(townName)){
                    times.put(townName,0);
                    record.put(townName,record.get(townName)-passangerCount);
                }
                }

            input = scanner.nextLine();
        }
       record.entrySet().stream()
               .sorted((e1,e2)->{
                   int sort = Integer.compare(times.get(e1.getKey()),times.get(e2.getKey()));
                   if(sort==0){
                       sort = e1.getKey().compareTo(e2.getKey());
                   }
                   return sort;
               })
               .forEach(pair->{
                   System.out.println(String.format("%s -> Time: %d -> Passengers: %d"
                           ,pair.getKey(),times.get(pair.getKey()),pair.getValue()));
               });
    }
}
