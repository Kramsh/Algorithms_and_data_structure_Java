import java.io.*;
import java.util.*;

public class Поиск_доминирующего_элемента {
    public void Поиск_доминирующего_элемента() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] aStr = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(aStr[i]);
        }

        int candidate = findCandidate(a);
        if (candidate != -1 && countOccurrences(a, candidate) > n / 2) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static int findCandidate(int[] nums) {
        int candidate = -1;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    private static int countOccurrences(int[] nums, int candidate) {
        int count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        return count;
    }
    //

    public void Поиск_трех_доминирующих_элементов() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int threshold = n / 4;

        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        for (int freq : freqMap.values()) {
            if (freq > threshold) {
                count++;
            }
            if (count >= 3) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }
}
