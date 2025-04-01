import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Задача_Размен {
    public void Размен_все_варианты() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine().trim());

        StringBuilder output = new StringBuilder();
        int count = 0;

        for (int tens = 0; tens <= money / 10; tens++) {
            for (int fives = 0; fives <= (money - tens * 10) / 5; fives++) {
                int ones = money - tens * 10 - fives * 5;
                count++;
                output.append((tens + fives + ones)).append(" ");
                for (int i = 0; i < tens; i++) output.append("10 ");
                for (int i = 0; i < fives; i++) output.append("5 ");
                for (int i = 0; i < ones; i++) output.append("1 ");
                output.setLength(output.length() - 1);
                output.append("\n");
            }
        }

        System.out.println(count);
        System.out.print(output);
    }
    //

    public void Размен_1_5_10_20_50() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine().trim());

        int[] coins = {50, 20, 10, 5, 1};
        List<Integer> result = new ArrayList<>();

        for (int coin : coins) {
            while (money >= coin) {
                money -= coin;
                result.add(coin);
            }
        }

        System.out.println(result.size());
        System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
