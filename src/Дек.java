import java.io.*;
import java.util.*;

public class Дек {
    public void Выполнение_операций_с_очередью() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int q = Integer.parseInt(br.readLine().trim());

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < q; i++) {
            String[] command = br.readLine().split(" ");
            if (command[0].equals("1")) {
                queue.addLast(Integer.parseInt(command[1]));
            } else {
                queue.pollFirst();
            }

            output.append(queue.isEmpty() ? "-1" : queue.peekFirst()).append("\n");
        }

        System.out.print(output);
    }
}
