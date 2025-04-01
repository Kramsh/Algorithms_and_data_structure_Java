import java.util.*;

public class Односвязный_список {
    public void Выполнение_операций_со_списком() {
        Scanner scanner = new Scanner(System.in);

        int q = scanner.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            int queryType = scanner.nextInt();

            if (queryType == 1) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                if (x == 0) {
                    list.add(0, y);
                } else {
                    list.add(x, y);
                }
            } else if (queryType == 2) {
                int x = scanner.nextInt();
                System.out.println(list.get(x - 1));
            } else if (queryType == 3) {
                int x = scanner.nextInt();
                list.remove(x - 1);
            }
        }

        scanner.close();
    }
    //

    public void Перепад_цен() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        scanner.close();

        int[] maxRightValues = new int[n];
        int[] maxRightIndices = new int[n];
        maxRightValues[n - 1] = a[n - 1];
        maxRightIndices[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] >= maxRightValues[i + 1]) {
                maxRightValues[i] = a[i];
                maxRightIndices[i] = i;
            } else {
                maxRightValues[i] = maxRightValues[i + 1];
                maxRightIndices[i] = maxRightIndices[i + 1];
            }
        }

        int minDiff = Integer.MAX_VALUE;
        int iMin = -1;
        int jMin = -1;
        for (int i = 0; i < n - 1; i++) {
            int j = maxRightIndices[i + 1];
            int diff = a[i] - a[j];
            if (diff < minDiff || (diff == minDiff && (i < iMin || (i == iMin && j < jMin)))) {
                minDiff = diff;
                iMin = i;
                jMin = j;
            }
        }

        int currentMaxValue = a[0];
        int currentMaxIndex = 0;
        int maxDiff = Integer.MIN_VALUE;
        int iMax = -1;
        int jMax = -1;

        for (int j = 1; j < n; j++) {
            int diff = currentMaxValue - a[j];
            if (diff > maxDiff || (diff == maxDiff && (currentMaxIndex < iMax || (currentMaxIndex == iMax && j < jMax)))) {
                maxDiff = diff;
                iMax = currentMaxIndex;
                jMax = j;
            }
            if (a[j] > currentMaxValue) {
                currentMaxValue = a[j];
                currentMaxIndex = j;
            }
        }

        System.out.println((iMin + 1) + " " + (jMin + 1));
        System.out.println((iMax + 1) + " " + (jMax + 1));
    }
}
