import java.io.*;
import java.util.*;

public class Стек {
    public void Выполнение_операций_со_стеком() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(br.readLine().trim());
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < q; i++) {
            String[] command = br.readLine().split(" ");
            if (command[0].equals("1")) {
                stack.push(Integer.parseInt(command[1]));
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
            bw.write(stack.isEmpty() ? "-1\n" : stack.peek() + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
    //

    public void Сумма_минимумов_на_отрезках() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(sumOfMinElements(arr, n, k));
    }

    private static long sumOfMinElements(int[] arr, int n, int k) {
        Deque<Integer> deque = new LinkedList<>();
        long sum = 0;

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && arr[deque.peekLast()] >= arr[i]) {
                deque.pollLast();
            }
            deque.addLast(i);

            if (i >= k - 1) {
                if (deque.peekFirst() < i - k + 1) {
                    deque.pollFirst();
                }
                sum += arr[deque.peekFirst()];
            }
        }
        return sum;
    }
}
