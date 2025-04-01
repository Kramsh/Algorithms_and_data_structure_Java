import java.util.Scanner;
import java.io.*;

public class Вычисление_НОК_и_НОД {
    public void Наибольший_общий_делитель() {
        Scanner scanner = new Scanner(System.in);

        long a = scanner.nextLong();
        long b = scanner.nextLong();

        System.out.println(euclideanGCD_Наибольший_общий_делитель(a, b));
    }

    private static long euclideanGCD_Наибольший_общий_делитель(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    //

    public void Наименьшее_общее_кратное() {
        Scanner scanner = new Scanner(System.in);

        long a = scanner.nextLong();
        long b = scanner.nextLong();

        long gcd = euclideanGCD_Наименьшее_общее_кратное(a, b);
        long lcm = (a / gcd) * b;

        System.out.println(lcm);
    }

    private static long euclideanGCD_Наименьшее_общее_кратное(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    //

    public void Наибольшее_число_шагов_алгоритма_Евклида() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int a = 1, b = 1;
        while (b + a <= n) {
            int temp = a + b;
            a = b;
            b = temp;
        }

        System.out.println(a + " " + b);
    }
}
