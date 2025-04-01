import java.util.Scanner;

public class Полный_перебор_и_оптимизация_перебора {
    public void Перестановки() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.close();

        int result = factorial_Перестановки(n);
        System.out.println(result);
    }

    public static int factorial_Перестановки(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    public void Сочетания() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.close();

        int result = combination(n, k);

        System.out.println(result);
    }

    public static int combination(int n, int k) {
        return factorial_Сочетания(n) / (factorial_Сочетания(k) * factorial_Сочетания(n - k));
    }

    public static int factorial_Сочетания(int x) {
        int fact = 1;
        for (int i = 1; i <= x; i++) {
            fact *= i;
        }
        return fact;
    }
    //
    public void Сочетания_с_повторениями(){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.close();

        int result = combinationWithRepetition(n, k);

        System.out.println(result);
    }

    public static int combinationWithRepetition(int n, int k) {
        return factorial_Сочетания_с_повторениями(n + k - 1) / (factorial_Сочетания_с_повторениями(k) * factorial_Сочетания_с_повторениями(n - 1));
    }

    public static int factorial_Сочетания_с_повторениями(int x) {
        int fact = 1;
        for (int i = 1; i <= x; i++) {
            fact *= i;
        }
        return fact;
    }
}

