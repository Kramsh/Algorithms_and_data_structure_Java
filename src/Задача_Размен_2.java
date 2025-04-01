import java.util.Scanner;
import java.util.Arrays;

public class Задача_Размен_2 {
    public void Оптимальный_размен() {
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        scanner.close();

        int[] dp = new int[money + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int[] coins = {1, 3, 4};

        for (int i = 1; i <= money; i++) {
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        System.out.println(dp[money]);
    }
}
