import java.io.*;
import java.util.*;

public class Представление_графа_в_памяти_компьютера {
    public void Граф_из_списка_маршрутов() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        boolean[][] adjacencyMatrix1 = new boolean[n][n];
        boolean[][] adjacencyMatrix2 = new boolean[n][n];

        for (int i = 0; i < m; i++) {
            String[] route = br.readLine().split(" ");
            int k = Integer.parseInt(route[0]);

            int[] stops = new int[k];
            for (int j = 0; j < k; j++) {
                stops[j] = Integer.parseInt(route[j + 1]) - 1;
            }

            for (int j = 0; j < k; j++) {
                for (int l = j + 1; l < k; l++) {
                    int u = stops[j];
                    int v = stops[l];
                    adjacencyMatrix2[u][v] = true;
                    adjacencyMatrix2[v][u] = true;
                }

                if (j < k - 1) {
                    int u = stops[j];
                    int v = stops[j + 1];
                    adjacencyMatrix1[u][v] = true;
                    adjacencyMatrix1[v][u] = true;
                }
            }
        }

        printMatrix(adjacencyMatrix1, n);
        printMatrix(adjacencyMatrix2, n);
    }

    private static void printMatrix(boolean[][] matrix, int n) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(matrix[i][j] ? 1 : 0);
                if (j < n - 1) sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    //

    public void Робот_пылесос() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] dimensions = br.readLine().split(" ");
            int n = Integer.parseInt(dimensions[0]);
            int m = Integer.parseInt(dimensions[1]);

            char[][] room = new char[n][m];
            for (int i = 0; i < n; i++) {
                room[i] = br.readLine().toCharArray();
            }

            String[] startPos = br.readLine().split(" ");
            int r = Integer.parseInt(startPos[0]) - 1;
            int c = Integer.parseInt(startPos[1]) - 1;

            int q = Integer.parseInt(br.readLine().trim());
            char[] actions = br.readLine().toCharArray();

            int[] dr = {-1, 0, 1, 0};
            int[] dc = {0, 1, 0, -1};
            int direction = 0;

            Set<String> visited = new HashSet<>();
            visited.add(r + "," + c);

            for (char action : actions) {
                if (action == 'L') {
                    direction = (direction + 3) % 4;
                } else if (action == 'R') {
                    direction = (direction + 1) % 4;
                } else if (action == 'M') {
                    int newR = r + dr[direction];
                    int newC = c + dc[direction];

                    if (newR >= 0 && newR < n && newC >= 0 && newC < m && room[newR][newC] == '.') {
                        r = newR;
                        c = newC;
                        visited.add(r + "," + c);
                    }
                }
            }

            System.out.println(visited.size());
    }
}
