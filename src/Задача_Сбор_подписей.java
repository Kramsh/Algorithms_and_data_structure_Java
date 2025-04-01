import java.io.*;
import java.util.*;

public class Задача_Сбор_подписей {

    static class Segment implements Comparable<Segment> {
        int left, right;

        Segment(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Segment other) {
            return Integer.compare(this.right, other.right);
        }
    }

    public void Сбор_подписей() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            segments[i] = new Segment(left, right);
        }

        Arrays.sort(segments);

        List<Integer> points = new ArrayList<>();
        int currentPoint = -1;

        for (Segment segment : segments) {
            if (currentPoint < segment.left) {
                currentPoint = segment.right;
                points.add(currentPoint);
            }
        }

        System.out.println(points.size());
        for (int i = 0; i < points.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(points.get(i));
        }
        System.out.println();
    }
    //

    public void Покрытие_точек_отрезками_одинаковой_длины() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long L = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] points = new long[n];
        for (int i = 0; i < n; i++) {
            points[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(points);

        int count = 0;
        int i = 0;
        while (i < n) {
            long start = points[i];
            long end = start + L;
            count++;

            while (i < n && points[i] <= end) {
                i++;
            }
        }

        System.out.println(count);
    }
    //

    public void Минимальная_суммарная_длина_отрезков() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] points = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(points);

        if (k >= n) {
            System.out.println(0);
            return;
        }

        int[] gaps = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            gaps[i] = points[i + 1] - points[i];
        }

        Arrays.sort(gaps);

        int minLength = 0;
        for (int i = 0; i < n - k; i++) {
            minLength += gaps[i];
        }

        System.out.println(minLength);
    }

}
