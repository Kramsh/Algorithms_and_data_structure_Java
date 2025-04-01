import java.util.*;

public class Задача_Пара_ближайших_точек {

    static class Point {
        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static double distanceSquared(Point p1, Point p2) {
        return Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2);
    }

    public static double bruteForce(List<Point> points, int start, int end) {
        double minDist = Double.MAX_VALUE;
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                double dist = distanceSquared(points.get(i), points.get(j));
                if (dist < minDist) {
                    minDist = dist;
                }
            }
        }
        return Math.sqrt(minDist);
    }

    public static double closestPointsRecursive(List<Point> pointsX, List<Point> pointsY, int startX, int endX) {
        if (endX - startX <= 3) {
            return bruteForce(pointsX, startX, endX);
        }

        int mid = (startX + endX) / 2;
        Point midPoint = pointsX.get(mid);

        List<Point> leftY = new ArrayList<>();
        List<Point> rightY = new ArrayList<>();
        for (Point point : pointsY) {
            if (point.x <= midPoint.x) {
                leftY.add(point);
            } else {
                rightY.add(point);
            }
        }

        double dl = closestPointsRecursive(pointsX, leftY, startX, mid);
        double dr = closestPointsRecursive(pointsX, rightY, mid, endX);
        double d = Math.min(dl, dr);

        List<Point> sy = new ArrayList<>();
        for (Point point : pointsY) {
            if (Math.abs(point.x - midPoint.x) < d) {
                sy.add(point);
            }
        }

        double best = d;
        for (int i = 0; i < sy.size(); i++) {
            Point p = sy.get(i);
            for (int j = i + 1; j < sy.size(); j++) {
                Point q = sy.get(j);
                if (q.y - p.y >= d) {
                    break;
                }
                double distSquared = distanceSquared(p, q);
                if (distSquared < best * best) {
                    best = Math.sqrt(distSquared);
                }
            }
        }

        return best;
    }

    public void Ближайшие_точки() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            points.add(new Point(scanner.nextInt(), scanner.nextInt()));
        }

        points.sort(Comparator.comparingDouble(p -> p.x));
        List<Point> pointsY = new ArrayList<>(points);
        pointsY.sort(Comparator.comparingDouble(p -> p.y));

        double result = closestPointsRecursive(points, pointsY, 0, points.size());
        System.out.printf("%.6f%n", result);
    }

}
