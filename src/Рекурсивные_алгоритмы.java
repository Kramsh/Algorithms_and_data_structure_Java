import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Рекурсивные_алгоритмы {
        public void Ханойские_башни() {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            List<String> moves = new ArrayList<>();
            hanoi(n, 1, 3, 2, moves);
            System.out.println(moves.size());
            for (String move : moves) {
                System.out.println(move);
            }
        }

        private static void hanoi(int n, int from, int to, int aux, List<String> moves) {
            if (n == 1) {
                moves.add(from + " " + to);
                return;
            }
            hanoi(n - 1, from, aux, to, moves);
            moves.add(from + " " + to);
            hanoi(n - 1, aux, to, from, moves);
        }
        //
        public void Ханойские_башни_2() {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int[] dp = new int[n + 1];
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = Integer.MAX_VALUE;
                for (int k = 1; k < i; k++) {
                    int current = 2 * dp[k] + (1 << (i - k)) - 1;
                    if (current < dp[i]) {
                        dp[i] = current;
                    }
                }
            }
            System.out.println(dp[n]);
        }
    }
