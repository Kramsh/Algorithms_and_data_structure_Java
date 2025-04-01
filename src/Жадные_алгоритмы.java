import java.util.*;

public class Жадные_алгоритмы {
    public void Бронирование_переговорки() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int count = 0;
        int lastEnd = -1;

        for (int i = 0; i < n; i++) {
            if (intervals[i][0] > lastEnd) {
                count++;
                lastEnd = intervals[i][1];
            }
        }

        System.out.println(count);
    }
}
