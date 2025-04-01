import java.util.Scanner;

public class Динамическое_программирование {
    public void Камни() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        boolean[][] dp = new boolean[11][11];

        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if (i > 0 && !dp[i - 1][j]) {
                    dp[i][j] = true;
                } else if (j > 0 && !dp[i][j - 1]) {
                    dp[i][j] = true;
                } else if (i > 0 && j > 0 && !dp[i - 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        System.out.println(dp[n][m] ? "Win" : "Lose");
    }
    //
    public void Камни_2() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        boolean[][] dp = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i > 0 && !dp[i - 1][j]) {
                    dp[i][j] = true;
                } else if (j > 0 && !dp[i][j - 1]) {
                    dp[i][j] = true;
                } else if (i > 1 && !dp[i - 2][j]) {
                    dp[i][j] = true;
                } else if (j > 1 && !dp[i][j - 2]) {
                    dp[i][j] = true;
                } else if (i > 1 && j > 0 && !dp[i - 2][j - 1]) {
                    dp[i][j] = true;
                } else if (i > 0 && j > 1 && !dp[i - 1][j - 2]) {
                    dp[i][j] = true;
                }
            }
        }

        System.out.println(dp[n][m] ? "Win" : "Lose");
    }
}
