import java.io.*;
import java.util.*;

public class Задача_Рекламная_кампания {
    public void Рекламная_кампания() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int[] prices = new int[n];
        int[] clicks = new int[n];

        String line = br.readLine();
        if (line != null && !line.isEmpty()) {
            StringTokenizer st = new StringTokenizer(line);
            for (int i = 0; i < n; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }
        }

        line = br.readLine();
        if (line != null && !line.isEmpty()) {
            StringTokenizer st = new StringTokenizer(line);
            for (int i = 0; i < n; i++) {
                clicks[i] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(prices);
        Arrays.sort(clicks);

        long maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit += (long) prices[i] * clicks[i];
        }

        System.out.println(maxProfit);
    }
    //

    static class Advertiser implements Comparable<Advertiser> {
        int profitPerWeek;
        int maxWeeks;

        Advertiser(int profitPerWeek, int maxWeeks) {
            this.profitPerWeek = profitPerWeek;
            this.maxWeeks = maxWeeks;
        }

        @Override
        public int compareTo(Advertiser other) {
            return Integer.compare(other.profitPerWeek, this.profitPerWeek);
        }
    }

    public void Реклама_на_билбордах() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // количество билбордов
        int k = Integer.parseInt(st.nextToken()); // количество рекламодателей
        int w = Integer.parseInt(st.nextToken()); // максимум недель на каждый билборд

        Advertiser[] advertisers = new Advertiser[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int maxWeeks = Integer.parseInt(st.nextToken());
            advertisers[i] = new Advertiser(c, maxWeeks);
        }

        Arrays.sort(advertisers); // сортируем по убыванию прибыли

        PriorityQueue<Integer> billboardWeeks = new PriorityQueue<>(Collections.nCopies(n * w, 0));

        long maxProfit = 0;
        for (Advertiser advertiser : advertisers) {
            for (int i = 0; i < advertiser.maxWeeks; i++) {
                if (!billboardWeeks.isEmpty() && billboardWeeks.peek() < advertiser.profitPerWeek) {
                    maxProfit += advertiser.profitPerWeek - billboardWeeks.poll();
                    billboardWeeks.add(advertiser.profitPerWeek);
                } else {
                    break;
                }
            }
        }
    }
}
