import java.util.Scanner;

public class Задача_о_рюкзаке {
    public void Наибольшее_количество_золота() {
        Scanner scanner = new Scanner(System.in);

        int W = scanner.nextInt();
        int n = scanner.nextInt();
        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        scanner.close();

        boolean[] dp = new boolean[W + 1];
        dp[0] = true;

        for (int weight : weights) {
            for (int j = W; j >= weight; j--) {
                if (dp[j - weight]) {
                    dp[j] = true;
                }
            }
        }

        for (int i = W; i >= 0; i--) {
            if (dp[i]) {
                System.out.println(i);
                break;
            }
        }
    }
}
