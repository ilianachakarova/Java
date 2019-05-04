import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class OnTheWayToAnnapurna {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>>diary = new LinkedHashMap<>();

        String inputLine ="";

        while(!"END".equals(inputLine=scanner.nextLine())){
            String [] input = inputLine.split("->");
            String command = input[0];
            String store = input[1];

            if(command.equals("Add")){
                if(!input[2].contains(",")){
                    String item = input[2];
                    if(!diary.containsKey(store)){
                        diary.put(store,new ArrayList<>());
                        diary.get(store).add(item);
                    }else {
                        diary.get(store).add(item);
                    }
                }else {
                    String [] items = input[2].split(",");
                    if(!diary.containsKey(store)){
                        diary.put(store,new ArrayList<>());
                        for (int i = 0; i <items.length ; i++) {
                            diary.get(store).add(items[i]);
                        }
                    }else {
                        for (int i = 0; i <items.length ; i++) {
                            diary.get(store).add(items[i]);
                        }
                    }
                }

            }else if(command.equals("Remove")){
                    diary.remove(store);
            }
        }

        System.out.println("Stores list:");

        diary.entrySet().stream()
                .sorted((e1,e2)->{
                    int sort = Integer.compare(e2.getValue().size(),e1.getValue().size());
                    if(sort==0){
                        sort = e2.getKey().compareTo(e1.getKey());
                    }

                    return sort;
                }).forEach(store->{
            System.out.println(String.format("%s",store.getKey()));
            store.getValue().forEach(e->{
                System.out.println(String.format("<<%s>>",e));
            });
        });
    }
}
