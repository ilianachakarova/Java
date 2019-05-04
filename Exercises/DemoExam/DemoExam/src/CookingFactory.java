import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CookingFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String>bestList = new ArrayList<>();
        int bestSum =0;
        double bestAverage = 0;
        int smallerSize = 0;
        while (!"Bake It!".equals(input)){

            List<String> batch = Arrays.stream(input.split("#"))
                    .collect(Collectors.toList());
            int sum = 0;
            int average = 0;
            for (int i = 0; i <batch.size() ; i++) {
                int num = Integer.parseInt(batch.get(i));
                sum+= num;
            }
            if (sum>bestSum){
                bestSum = sum;
                bestList = batch;
            }else if(sum == bestSum){
                if(average>bestAverage){
                    bestAverage = average;
                    bestList= batch;
                }
                if(batch.size()< bestList.size()){
                    bestList = batch;
                }
            }

            input = scanner.nextLine();
            }

        System.out.println("Best Batch quality: "+ bestSum);
        System.out.println(bestList.toString().replaceAll("[\\[\\],]",""));
    }
}
