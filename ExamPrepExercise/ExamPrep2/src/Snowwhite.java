import java.util.LinkedHashMap;
import java.util.Scanner;

public class Snowwhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> dwarf = new LinkedHashMap<>();
        LinkedHashMap<String,Integer> countByColor = new LinkedHashMap<>();

        String line = "";
        while(!"Once upon a time".equals(line = scanner.nextLine())) {
            String[] input = line.split(" <:> ");

            String name = input[0];
            String color = input[1];
            int physics = Integer.parseInt(input[2]);

            String key = name + " "+ color;

            if(!countByColor.containsKey(color)){
                countByColor.putIfAbsent(color,1);
            }else {
                countByColor.put(color,countByColor.get(color)+1);
            }

            if(!dwarf.containsKey(key)){
                dwarf.put(key,physics);
            }else {
                if(physics>dwarf.get(key)){
                    dwarf.put(key,physics);
                    countByColor.put(color,countByColor.get(color)-1);
                }else {
                    dwarf.put(key,dwarf.get(key));
                }
            }

        }

        dwarf.entrySet().stream()
                .sorted((d1,d2)->{
                    int sort = Integer.compare(d2.getValue(),d1.getValue());
                    if(sort==0){
                        String color1 = d1.getKey().split(" ")[1];
                        String color2 = d2.getKey().split(" ")[1];

                        int size1 = countByColor.get(color1);
                        int size2 = countByColor.get(color2);
                        sort = Integer.compare(size2,size1);

                    }
                    return sort;
                }).forEach(element->{
            String [] data = element.getKey().split(" ");
            String name = data[0];
            String color = data[1];
            System.out.println(String.format("(%s) %s <-> %d",color,name,element.getValue()));
        });
    }
}
