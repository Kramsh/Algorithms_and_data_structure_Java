import java.io.*;
import java.util.*;

public class Подсчёт_инверсий {
    public void Количество_инверсий() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long inversions = mergeSortAndCount_Количество_инверсий(arr, 0, n - 1);
        System.out.println(inversions);
    }

    private static long mergeSortAndCount_Количество_инверсий(int[] arr, int left, int right) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;
        long count = 0;
        count += mergeSortAndCount_Количество_инверсий(arr, left, mid);
        count += mergeSortAndCount_Количество_инверсий(arr, mid + 1, right);
        count += mergeAndCount_Количество_инверсий(arr, left, mid, right);
        return count;
    }

    private static long mergeAndCount_Количество_инверсий(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        long count = 0;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                count += (mid + 1) - (left + i);
            }
        }

        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];

        return count;
    }
    //

    public void Количество_полуинверсий() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long semiInversions = mergeSortAndCount(arr, 0, n - 1);
        System.out.println(semiInversions);
    }

    private static long mergeSortAndCount(int[] arr, int left, int right) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;
        long count = 0;
        count += mergeSortAndCount(arr, left, mid);
        count += mergeSortAndCount(arr, mid + 1, right);
        count += mergeAndCount(arr, left, mid, right);
        return count;
    }

    private static long mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        long count = 0;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] >= rightArr[j]) {
                count += (mid - left + 1) - i;
                arr[k++] = rightArr[j++];
            } else {
                arr[k++] = leftArr[i++];
            }
        }

        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];

        return count;
    }
}
