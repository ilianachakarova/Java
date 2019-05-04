import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Concert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> members = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> bandsOnStage = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!"start of concert".equals(input)) {

            String[] data = input.split("; ");
            if (data[0].equals("Add")) {
                String[] names = data[2].split(",\\s+");
                if (!members.containsKey(data[1])) {
                    members.put(data[1], new ArrayList<>());
                    for (int i = 0; i < names.length; i++) {
                        members.get(data[1]).add(names[i]);
                    }
                } else {
                    for (int i = 0; i < names.length; i++) {
                        if (!members.get(data[1]).contains(names[i])) {
                            members.get(data[1]).add(names[i]);
                        }
                    }
                }
            } else if (data[0].equals("Play")) {
                String groupName = data[1];
                String time = (data[2]);

                if (bandsOnStage.containsKey(groupName)) {
                    bandsOnStage.put(groupName, bandsOnStage.get(groupName) + Integer.parseInt(time));
                }
                bandsOnStage.putIfAbsent(groupName, Integer.parseInt(time));
            }
            input = scanner.nextLine();
        }
        String bandToPrint = scanner.nextLine();

        if (bandsOnStage.containsKey(bandToPrint)) {
            System.out.println(String.format("Total time: %d", bandsOnStage.values().stream().mapToInt(Integer::intValue).sum()));
            bandsOnStage.entrySet().stream()
                    .sorted((e1, e2) -> {
                        int sorted = Integer.compare(e2.getValue(), e1.getValue());
                        if (sorted == 0) {
                            sorted = e1.getKey().compareTo(e2.getKey());
                        }
                        return sorted;
                    }).forEach(e -> {
                System.out.println(String.format("%s -> %d", e.getKey(), e.getValue()));
            });
            System.out.println(bandToPrint);

            members.get(bandToPrint).stream().forEach(el -> {
                System.out.println(String.format("=> %s", el));
            });


        }
    }
}
