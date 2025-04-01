import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Задача_Максимальное_произведение {
    public void Максимальное_произведение() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > firstMax) {
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax) {
                secondMax = num;
            }
        }

        long maxProduct = (long) firstMax * secondMax;
        System.out.println(maxProduct);
    }
    //

    public void Максимальное_произведение_контрпример() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        if (n <= 6) {
            System.out.println("No");
            return;
        }
        System.out.println("Yes");
        StringBuilder sb = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            sb.append(i).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
    //

    public void Максимальное_произведение_трех_чисел() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String[] input = br.readLine().trim().split(" ");

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(a);

        long max1 = a[n - 1];
        long max2 = a[n - 2];
        long max3 = a[n - 3];

        long min1 = a[0];
        long min2 = a[1];

        long product1 = max1 * max2 * max3;
        long product2 = min1 * min2 * max1;

        long result = Math.max(product1, product2);
        System.out.println(result);
    }
    public void Максимальное_произведение_четырех_чисел() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long[] numbers = new long[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextLong();
        }

        Arrays.sort(numbers);

        long maxProduct1 = numbers[n - 1] * numbers[n - 2] * numbers[n - 3] * numbers[n - 4];

        long maxProduct2 = numbers[0] * numbers[1] * numbers[n - 1] * numbers[n - 2];

        long maxProduct3 = Long.MIN_VALUE;
        if (n >= 4) {
            maxProduct3 = numbers[0] * numbers[1] * numbers[2] * numbers[3];
        }

        System.out.println(Math.max(Math.max(maxProduct1, maxProduct2), maxProduct3));
    }
}

