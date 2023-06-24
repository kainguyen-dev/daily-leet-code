package daily;

import java.util.Arrays;

public class _3_CheckIfItIsAStraightLine {

    public static boolean checkStraightLine(int[][] coordinates) {
        int[] first = coordinates[0];
        int[] second = coordinates[1];
        double[] coefficient = findInterceptor(first, second);

        System.out.println(Arrays.toString(coefficient));
        if (Double.isInfinite(coefficient[0])) {
            for (int i = 2; i < coordinates.length; i++) {
                if (coordinates[i][0] != coordinates[0][0]) return false;
            }
            return true;
        }

        for (int i = 2; i < coordinates.length; i++) {
            double expectY = coordinates[i][0] * coefficient[0] + coefficient[1];
            if (expectY != coordinates[i][1]) return false;
        }
        return true;
    }

    public static double[] findInterceptor(int[] first, int[] second) {
        int x1 = first[0];
        int y1 = first[1];
        int x2 = second[0];
        int y2 = second[1];
        double a = (double) (y1 - y2) / (x1 - x2);
        double b = (double) (x2 * y1 - x1 * y2) / (x2 - x1);
        return new double[]{a, b};
    }

    public static void main(String[] args) {
//        int[][] coordinates = new int[][]{
//            {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}
//        };
//        assert checkStraightLine(coordinates);
//
//        coordinates = new int[][]{
//            {1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}
//        };
//        assert !checkStraightLine(coordinates);

        int[][] coordinate1 = new int[][]{
            {2, 4}, {2, 5}, {2, 8}
        };
        System.out.println(checkStraightLine(coordinate1));
    }

}
