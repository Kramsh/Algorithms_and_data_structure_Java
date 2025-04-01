import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.*;
import java.util.Stack;

public class Рандомизированные_алгоритмы {
    public void Разбиение_Ломуто() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (n <= 1) {
            System.out.println(arr[0]);
            return;
        }

        int pivot = arr[0];
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap_Разбиение_Ломуто(arr, i, j);
            }
        }
        swap_Разбиение_Ломуто(arr, 0, i);

        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append(' ');
        }
        System.out.println(sb.toString().trim());
    }

    private static void swap_Разбиение_Ломуто(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //
    public void Быстрая_сортировка() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] parts = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        quickSort(arr);

        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(arr.length - 1);

        while (!stack.isEmpty()) {
            int right = stack.pop();
            int left = stack.pop();

            if (left >= right) continue;

            int pivotIndex = partition(arr, left, right);

            stack.push(left);
            stack.push(pivotIndex - 1);

            stack.push(pivotIndex + 1);
            stack.push(right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivotIndex = choosePivot(arr, left, right);
        int pivotValue = arr[pivotIndex];
        swap_Быстрая_сортировка(arr, pivotIndex, right);

        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (arr[i] <= pivotValue) {
                swap_Быстрая_сортировка(arr, storeIndex, i);
                storeIndex++;
            }
        }
        swap_Быстрая_сортировка(arr, storeIndex, right);
        return storeIndex;
    }

    private static int choosePivot(int[] arr, int left, int right) {
        int mid = left + (right - left) / 2;
        int a = arr[left];
        int b = arr[mid];
        int c = arr[right];

        if ((a <= b && b <= c) || (c <= b && b <= a)) return mid;
        else if ((b <= a && a <= c) || (c <= a && a <= b)) return left;
        else return right;
    }

    private static void swap_Быстрая_сортировка(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


