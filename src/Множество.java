import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Множество {
    public void Выполнение_операций_с_множеством() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            String[] parts = br.readLine().split(" ");
            int type = Integer.parseInt(parts[0]);
            int x = Integer.parseInt(parts[1]);

            if (type == 1) {
                set.add(x);
            } else if (type == 2) {
                sb.append(set.contains(x) ? "1\n" : "0\n");
            }
        }
        System.out.print(sb);
    }
}
