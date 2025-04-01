import java.util.Scanner;

public class Задачи_о_числах_Фибоначчи {
    public void Числа_Фибоначчи() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if (n == 0) {
            System.out.println(0);
            return;
        }
        if (n == 1) {
            System.out.println(1);
            return;
        }

        long a = 0;
        long b = 1;
        long c = 0;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        System.out.println(b);
    }
    //

    public void Последняя_цифра_числа_Фибоначчи() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if (n == 0) {
            System.out.println(0);
            return;
        }
        if (n == 1) {
            System.out.println(1);
            return;
        }

        int a = 0;
        int b = 1;
        int c = 0;

        for (int i = 2; i <= n; i++) {
            c = (a + b) % 10;
            a = b;
            b = c;
        }

        System.out.println(b);
    }
    //

    public void Огромное_число_Фибоначчи() {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong();
        int m = scanner.nextInt();

        int pisanoPeriod = findPisanoPeriod_Огромное_число_Фибоначчи(m);

        long reducedN = n % pisanoPeriod;

        System.out.println(fibonacciMod_Огромное_число_Фибоначчи(reducedN, m));
    }

    private static int findPisanoPeriod_Огромное_число_Фибоначчи(int m) {
        if (m == 0) return 0;
        if (m == 1) return 1;

        int previous = 0;
        int current = 1;

        for (int i = 0; i < m * m; i++) {
            int temp = (previous + current) % m;
            previous = current;
            current = temp;

            if (previous == 0 && current == 1) {
                return i + 1;
            }
        }

        return m * m;
    }

    private static long fibonacciMod_Огромное_число_Фибоначчи(long n, int m) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long previous = 0;
        long current = 1;

        for (long i = 2; i <= n; i++) {
            long temp = (previous + current) % m;
            previous = current;
            current = temp;
        }

        return current % m;
    }
    //

    public void Последняя_цифра_суммы_чисел_Фибоначчи() {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong();

        int pisanoPeriod = findPisanoPeriod_Последняя_цифра_суммы_чисел_Фибоначчи(10);

        long reducedN = (n + 2) % pisanoPeriod;

        long lastDigit = fibonacciMod_Последняя_цифра_суммы_чисел_Фибоначчи(reducedN, 10);

        if (lastDigit == 0) {
            System.out.println(9);
        } else {
            System.out.println((lastDigit - 1) % 10);
        }
    }

    private static int findPisanoPeriod_Последняя_цифра_суммы_чисел_Фибоначчи(int m) {
        if (m == 0) return 0;
        if (m == 1) return 1;

        int previous = 0;
        int current = 1;

        for (int i = 0; i < m * m; i++) {
            int temp = (previous + current) % m;
            previous = current;
            current = temp;

            if (previous == 0 && current == 1) {
                return i + 1;
            }
        }

        return m * m;
    }

    private static long fibonacciMod_Последняя_цифра_суммы_чисел_Фибоначчи(long n, int m) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long previous = 0;
        long current = 1;

        for (long i = 2; i <= n; i++) {
            long temp = (previous + current) % m;
            previous = current;
            current = temp;
        }

        return current % m;
    }
    //

    public void Последняя_цифра_частичной_суммы_чисел_Фибоначчи() {
        Scanner scanner = new Scanner(System.in);

        long m = scanner.nextLong();
        long n = scanner.nextLong();

        int pisanoPeriod = findPisanoPeriod(10);
        long lastDigitM = fibonacciMod((m + 1) % pisanoPeriod, 10);
        long lastDigitN = fibonacciMod((n + 2) % pisanoPeriod, 10);

        long result = (lastDigitN - lastDigitM + 10) % 10;

        System.out.println(result);
    }

    private static int findPisanoPeriod(int m) {
        if (m == 0) return 0;
        if (m == 1) return 1;

        int previous = 0;
        int current = 1;

        for (int i = 0; i < m * m; i++) {
            int temp = (previous + current) % m;
            previous = current;
            current = temp;

            if (previous == 0 && current == 1) {
                return i + 1;
            }
        }

        return m * m;
    }

    private static long fibonacciMod(long n, int m) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long previous = 0;
        long current = 1;

        for (long i = 2; i <= n; i++) {
            long temp = (previous + current) % m;
            previous = current;
            current = temp;
        }

        return current % m;
    }
}
