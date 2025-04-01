import java.util.*;

public class Выход_из_лабиринта {

    static class Position {
        int x, y;
        String path;

        Position(int x, int y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }

    public void найтиПуть() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine(); // Считываем перевод строки

        char[][] maze = new char[n][m];
        Position start = null;

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j);
                if (maze[i][j] == 'S') {
                    start = new Position(i, j, "");
                }
            }
        }

        if (start == null) {
            System.out.println("-1");
            return;
        }

        Queue<Position> queue = new LinkedList<>();
        queue.offer(start);
        boolean[][] visited = new boolean[n][m];
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            if (maze[current.x][current.y] == 'F') {
                System.out.println(current.path.length());
                System.out.println(current.path);
                return;
            }

            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            char[] moves = {'U', 'D', 'L', 'R'};

            for (int d = 0; d < directions.length; d++) {
                int nx = current.x + directions[d][0];
                int ny = current.y + directions[d][1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && maze[nx][ny] != '#') {
                    visited[nx][ny] = true;
                    queue.offer(new Position(nx, ny, current.path + moves[d]));
                }
            }
        }

        System.out.println("-1");
    }
}
