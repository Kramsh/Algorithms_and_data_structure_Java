import java.util.Scanner;

public class Задача_Сумма_двух_чисел {
    public void A_plus_B () {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(a + b);
    }

    //
    public void Ax_plus_Bx () {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] aInput = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            aInput[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] bInput = new int[m + 1];
        for (int i = 0; i <= m; i++) {
            bInput[i] = scanner.nextInt();
        }

        int maxDegree = Math.max(n, m);
        int[] aCoeff = new int[maxDegree + 1];
        int[] bCoeff = new int[maxDegree + 1];

        for (int i = 0; i <= n; i++) {
            int degree = n - i;
            aCoeff[degree] = aInput[i];
        }

        for (int i = 0; i <= m; i++) {
            int degree = m - i;
            bCoeff[degree] = bInput[i];
        }

        int[] cCoeff = new int[maxDegree + 1];
        for (int i = 0; i <= maxDegree; i++) {
            cCoeff[i] = aCoeff[i] + bCoeff[i];
        }

        System.out.println(maxDegree);
        StringBuilder sb = new StringBuilder();
        for (int i = maxDegree; i >= 0; i--) {
            sb.append(cCoeff[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    //
    public void A_plus_B_строки() {
            Scanner scanner = new Scanner(System.in);
            int n = Integer.parseInt(scanner.nextLine());
            String a = scanner.nextLine();
            String b = scanner.nextLine();

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < n; i++) {
                result.append(a.charAt(i));
                result.append(b.charAt(i));
            }

            System.out.println(result.toString());
        }

    //
    public void A_plus_B_матрицы() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        int[][] a = new int[n][m];
        int[][] b = new int[n][m];
        int[][] c = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(parts[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                b[i][j] = Integer.parseInt(parts[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < m; j++) {
                sb.append(c[i][j]).append(" ");
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            System.out.println(sb);
        }
    }
}


