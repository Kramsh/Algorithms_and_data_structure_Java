import java.io.*;
import java.util.*;

public class Модификация_быстрой_сортировки {
    public void Модификация_быстрой_сортировки() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] aStr = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(aStr[i]);
        }

        threeWayQuickSort(a, 0, n - 1);

        StringBuilder result = new StringBuilder();
        for (int num : a) {
            result.append(num).append(" ");
        }
        System.out.println(result.toString().trim());
    }

    private static void threeWayQuickSort(int[] arr, int low, int high) {
        if (low >= high) return;

        Random random = new Random();
        int pivotIndex = low + random.nextInt(high - low + 1);
        int pivot = arr[pivotIndex];

        int lt = low, gt = high, i = low;
        while (i <= gt) {
            if (arr[i] < pivot) {
                swap(arr, lt++, i++);
            } else if (arr[i] > pivot) {
                swap(arr, i, gt--);
            } else {
                i++;
            }
        }

        threeWayQuickSort(arr, low, lt - 1);
        threeWayQuickSort(arr, gt + 1, high);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
