import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        LinkedHashMap<String, String> contestAndPassword = new LinkedHashMap<>();

        while (!"end of contests".equals(input = scanner.nextLine())) {
            String[] data = input.split(":");
            String nameContest = data[0];
            String password = data[1];

            contestAndPassword.putIfAbsent(nameContest, password);
            contestAndPassword.put(nameContest, password);

        }

        String input2 = "";

        TreeMap<String, Map<String, Integer>> contestAndPoints = new TreeMap<>();

        while (!"end of submissions".equals(input2 = scanner.nextLine())) {

            String[] data = input2.split("=>");

            String contest = data[0];
            String password = data[1];
            String contestant = data[2];
            Integer points = Integer.parseInt(data[3]);

            if (contestAndPassword.containsKey(contest)) {
                if (password.equals(contestAndPassword.get(contest))) {
                    if (!contestAndPoints.containsKey(contestant)) {
                        contestAndPoints.put(contestant, new LinkedHashMap<>());
                        contestAndPoints.get(contestant).put(contest, points);
                    } else {
                        if (contestAndPoints.get(contestant).containsKey(contest)) {
                            if (points > contestAndPoints.get(contestant).get(contest)) {
                                contestAndPoints.get(contestant).put(contest, points);
                            }
                        } else {
                            contestAndPoints.get(contestant).put(contest, points);
                        }
                    }
                }
            }
        }
        LinkedHashMap<String, Integer> nameAndSum = new LinkedHashMap<>();
        contestAndPoints.entrySet().stream()
                .forEach(e -> {
                    int sum = e.getValue().values().stream().mapToInt(i -> i).sum();
                    nameAndSum.put(e.getKey(), sum);
                });

        nameAndSum.entrySet().stream()
                .sorted((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue()))
                .limit(1).forEach(el ->
                System.out.println(String.format("Best candidate is %s with total %d points.",
                        el.getKey(), el.getValue())));

        System.out.println("Ranking: ");

        contestAndPoints.entrySet().stream()
                .forEach(e -> {
                    System.out.println(e.getKey());
                    e.getValue().entrySet().stream()
                            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                            .forEach(element -> {
                                System.out.println(String.format("#  %s -> %d", element.getKey(), element.getValue()));
                            });
                });


    }
}
