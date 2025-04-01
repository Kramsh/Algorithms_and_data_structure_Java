import java.util.Scanner;

public class Задача_Сувениры {
    public void Распределение_сувениров() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] values = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            sum += values[i];
        }
        scanner.close();

        if (sum % 3 != 0) {
            System.out.println(0);
            return;
        }

        int target = sum / 3;
        boolean[][] dp = new boolean[target + 1][target + 1];
        dp[0][0] = true;

        for (int value : values) {
            for (int i = target; i >= 0; i--) {
                for (int j = target; j >= 0; j--) {
                    if (dp[i][j]) {
                        if (i + value <= target) dp[i + value][j] = true;
                        if (j + value <= target) dp[i][j + value] = true;
                    }
                }
            }
        }

        System.out.println(dp[target][target] ? 1 : 0);
    }
}
