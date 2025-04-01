import java.io.*;

public class Задача_Количество_призов {
    public void Количество_призов() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());

        long k = 0;
        long sum = 0;

        while (sum + (k + 1) <= n) {
            k++;
            sum += k;
        }

        System.out.println(k);
    }
}
