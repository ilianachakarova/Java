import java.util.LinkedHashMap;
import java.util.Scanner;

public class MeTubeStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> views = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> likes = new LinkedHashMap<>();

        String input = "";
        while (!"stats time".equals(input = scanner.nextLine())) {

            String[] array = input.split("-|:");
            if (input.contains("-")){


                String name = array[0];
                int like = Integer.parseInt(array[1]);

                views.putIfAbsent(name, 0);
                views.put(name, views.get(name) + like);
                likes.putIfAbsent(name, 0);

            }else if (input.contains(":")) {

                String command = array[0];
                String name = array[1];

                switch (command) {
                    case "like":
                        if (views.containsKey(name)) {
                            likes.put(name, likes.get(name) + 1);
                        }
                        break;
                    case "dislike":
                        if (views.containsKey(name)) {
                            likes.put(name, likes.get(name) - 1);
                        }
                        break;
                }
            }

        }
        String input2 = scanner.nextLine();

        if (input2.equals("by likes")) {
            views.entrySet().stream().sorted((pair1, pair2) -> {
                return Integer.compare(likes.get(pair2.getKey()), likes.get(pair1.getKey()));
            }).forEach(pair -> {
                System.out.println(String.format("%s - %d views - %d likes"
                        , pair.getKey(), pair.getValue(), likes.get(pair.getKey())));
            });


        }else if (input2.equals("by views")){
            views.entrySet().stream().sorted((pair1, pair2) -> {
                return Integer.compare(pair2.getValue(), pair1.getValue());
            }).forEach(pair ->
                    System.out.println(String.format("%s - %d views - %d likes"
                            , pair.getKey(), pair.getValue(), likes.get(pair.getKey()))));
        }
    }
}
