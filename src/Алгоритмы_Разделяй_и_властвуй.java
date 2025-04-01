import java.util.Scanner;
import java.util.*;

public class Алгоритмы_Разделяй_и_властвуй {
    public void Сортировка_выбором() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        selectionSort(array);

        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    private static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    public void Слияние_сортированных_последовательностей() {
        mergeSortedLists();
    }

    // 👇 Вспомогательный метод (вызывается из метода выше)
    private void mergeSortedLists() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                list.add(scanner.nextInt());
            }
            lists.add(list);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).isEmpty()) {
                pq.add(new Node(lists.get(i).get(0), i, 0));
            }
        }

        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            result.append(node.value).append(" ");

            int nextIndex = node.elementIndex + 1;
            if (nextIndex < lists.get(node.listIndex).size()) {
                pq.add(new Node(lists.get(node.listIndex).get(nextIndex), node.listIndex, nextIndex));
            }
        }

        System.out.println(result.toString().trim());
    }

    static class Node implements Comparable<Node> {
        int value;
        int listIndex;
        int elementIndex;

        public Node(int value, int listIndex, int elementIndex) {
            this.value = value;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.value, other.value);
        }
    }
    //
    public void Сортировка_слиянием() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        mergeSort(arr);

        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    private void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        System.arraycopy(arr, left, temp, left, right - left + 1);

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            arr[k] = temp[i];
            k++;
            i++;
        }

        while (j <= right) {
            arr[k] = temp[j];
            k++;
            j++;
        }
    }
}

