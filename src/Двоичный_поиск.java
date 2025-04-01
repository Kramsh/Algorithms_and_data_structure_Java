import java.io.*;
import java.util.*;

public class Двоичный_поиск {
    public void Двоичный_поиск() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] kStr = br.readLine().split(" ");
        int[] k = new int[n];
        for (int i = 0; i < n; i++) {
            k[i] = Integer.parseInt(kStr[i]);
        }

        int q = Integer.parseInt(br.readLine());

        int result = binarySearch_Двоичный_поиск(k, q);
        System.out.println(result);
    }

    private static int binarySearch_Двоичный_поиск(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
    //

    public void Множественный_поиск_ключей_в_отсортированной_последовательности() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] kArray = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            kArray[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine().trim());
        int[] qArray = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            qArray[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder result = new StringBuilder();
        for (int q : qArray) {
            result.append(binarySearch_Множественный_поиск_ключей_в_отсортированной_последовательности(kArray, q)).append("\n");
        }
        System.out.print(result);
    }

    private static int binarySearch_Множественный_поиск_ключей_в_отсортированной_последовательности(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    //

    public void Подсчет_количества_вхождений_элементов() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] kStr = br.readLine().split(" ");
        int[] K = new int[n];
        for (int i = 0; i < n; i++) {
            K[i] = Integer.parseInt(kStr[i]);
        }

        int m = Integer.parseInt(br.readLine());
        String[] qStr = br.readLine().split(" ");
        int[] Q = new int[m];
        for (int i = 0; i < m; i++) {
            Q[i] = Integer.parseInt(qStr[i]);
        }

        StringBuilder result = new StringBuilder();
        for (int q : Q) {
            int count = countOccurrences(K, q);
            result.append(count).append(" ");
        }

        System.out.println(result.toString().trim());
    }

    private static int countOccurrences(int[] arr, int target) {
        int leftIndex = findLeftIndex(arr, target);
        if (leftIndex == -1) {
            return 0;
        }
        int rightIndex = findRightIndex(arr, target);
        return rightIndex - leftIndex + 1;
    }

    private static int findLeftIndex(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            if (arr[mid] == target) {
                index = mid;
            }
        }

        return index != -1 ? index : -1;
    }

    private static int findRightIndex(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            if (arr[mid] == target) {
                index = mid;
            }
        }

        return index != -1 ? index : -1;
    }
    //

    public void Минимальная_длина_покрывающих_отрезков() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] points = new long[n];
        for (int i = 0; i < n; i++) {
            points[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(points);

        long left = 0;
        long right = points[n - 1] - points[0];

        while (left < right) {
            long mid = (left + right) / 2;
            if (canCover(points, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }

    private static boolean canCover(long[] points, int k, long length) {
        int count = 1;
        long currentEnd = points[0] + length;

        for (long point : points) {
            if (point > currentEnd) {
                count++;
                if (count > k) return false;
                currentEnd = point + length;
            }
        }

        return true;
    }
}
