import java.util.*;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Обходы_графа {
    public void Рейтинг_в_шахматном_турнире() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int winner = scanner.nextInt();

            if (winner == 1) {
                graph.get(u).add(v);
                inDegree[v]++;
            } else {
                graph.get(v).add(u);
                inDegree[u]++;
            }
        }
        scanner.close();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                System.out.println("NO");
                return;
            }
            int player = queue.poll();
            count++;
            for (int opponent : graph.get(player)) {
                if (--inDegree[opponent] == 0) {
                    queue.add(opponent);
                }
            }
        }

        System.out.println(count == n ? "YES" : "NO");
    }
    //

    public void Минимальное_количество_арифметических_операций() {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        System.out.println(minOperations(X, Y));
    }

    private static int minOperations(int X, int Y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{X, 0});
        boolean[] visited = new boolean[100001];
        visited[X] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int steps = current[1];

            if (currentX == Y) {
                return steps;
            }

            for (int c = 0; c <= 9; c++) {
                int nextX = currentX + c;
                if (nextX >= 0 && nextX <= 100000 && !visited[nextX]) {
                    visited[nextX] = true;
                    queue.offer(new int[]{nextX, steps + 1});
                }

                nextX = currentX - c;
                if (nextX >= 0 && nextX <= 100000 && !visited[nextX]) {
                    visited[nextX] = true;
                    queue.offer(new int[]{nextX, steps + 1});
                }

                nextX = currentX * c;
                if (nextX >= 0 && nextX <= 100000 && !visited[nextX]) {
                    visited[nextX] = true;
                    queue.offer(new int[]{nextX, steps + 1});
                }
            }
        }
        return -1;
    }
}