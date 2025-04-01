import java.io.*;
import java.util.*;

public class Словарь {
    public void Выполнение_операций_со_словарем() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int q = Integer.parseInt(br.readLine().trim());

        Map<Integer, Integer> dictionary = new HashMap<>();

        for (int i = 0; i < q; i++) {
            String[] command = br.readLine().split(" ");
            if (command[0].equals("1")) {
                int key = Integer.parseInt(command[1]);
                int value = Integer.parseInt(command[2]);
                dictionary.put(key, value);
            } else {
                int key = Integer.parseInt(command[1]);
                output.append(dictionary.getOrDefault(key, -1)).append("\n");
            }
        }

        System.out.print(output);
    }
}
