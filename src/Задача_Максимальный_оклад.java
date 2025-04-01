import java.io.*;
import java.util.*;

public class Задача_Максимальный_оклад {
    public void Максимальный_оклад() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        String[] numbers = br.readLine().trim().split(" ");

        Arrays.sort(numbers, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder result = new StringBuilder();
        for (String number : numbers) {
            result.append(number);
        }

        System.out.println(result.toString());
    }
}
