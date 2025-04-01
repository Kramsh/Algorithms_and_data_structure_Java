import java.io.*;
import java.util.*;

public class Задача_Специи {

    static class Spice implements Comparable<Spice> {
        double costPerWeight;
        int weight;
        int cost;

        Spice(int cost, int weight) {
            this.cost = cost;
            this.weight = weight;
            this.costPerWeight = (double) cost / weight;
        }

        @Override
        public int compareTo(Spice other) {
            return Double.compare(other.costPerWeight, this.costPerWeight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        Spice[] spices = new Spice[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            spices[i] = new Spice(cost, weight);
        }

        Arrays.sort(spices);

        double maxValue = 0.0;
        for (Spice spice : spices) {
            if (W == 0) break;

            int amountToTake = Math.min(W, spice.weight);
            maxValue += amountToTake * spice.costPerWeight;
            W -= amountToTake;
        }

        System.out.printf("%.3f\n", maxValue);
    }
    //

    public void Сувениры() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            if (line != null) {
                prices[i] = Integer.parseInt(line.trim());
            } else {
                throw new IOException("Insufficient input data");
            }
        }

        Arrays.sort(prices);

        int count = 0;
        for (int price : prices) {
            if (S >= price) {
                S -= price;
                count++;
            } else {
                break;
            }
        }

        System.out.println(count);
    }
}
