package daily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _18_TallestBillboard {

    static class Pair<L, R> {
        private L left;
        private R right;

        public Pair(L left, R right) {
            this.left = left;
            this.right = right;
        }

        public L getLeft() {
            return left;
        }

        public R getRight() {
            return right;
        }

        @Override
        public String toString() {
            return "P{" +
                "left=" + left +
                ", right=" + right +
                '}';
        }
    }

    Map<Integer, Integer> genMap(int[] rods, int leftIndex, int rightIndex) {
        Set<Pair<Integer, Integer>> states = new HashSet<>();
        states.add(new Pair<>(0, 0));
        for (int i = leftIndex; i < rightIndex; ++i) {
            int r = rods[i];
            Set<Pair<Integer, Integer>> newStates = new HashSet<>();
            for (Pair<Integer, Integer> p : states) {
                newStates.add(new Pair<>(p.getLeft() + r, p.getRight()));
                newStates.add(new Pair<>(p.getLeft(), p.getRight() + r));
            }
            states.addAll(newStates);
        }

        System.out.println("State: " + states);

        Map<Integer, Integer> map = new HashMap<>();
        for (Pair<Integer, Integer> p : states) {
            int left = p.getLeft(), right = p.getRight();
            int diff = left - right;
            map.put(diff, Math.max(map.getOrDefault(diff, 0), left));
            // Why left is here
            // Answer: look at this pic: https://leetcode.com/problems/tallest-billboard/Figures/956/9.png
        }

        System.out.println("Map: " + map);
        System.out.println();
        return map;
    }

    public int tallestBillboard(int[] rods) {
        int n = rods.length;
        Map<Integer, Integer> firstHalf = genMap(rods, 0, n / 2);
        Map<Integer, Integer> secondHalf = genMap(rods, n / 2, n);

        int result = Integer.MIN_VALUE;

        for (int diff : firstHalf.keySet()) {
            if (secondHalf.containsKey(-diff)) {
                result = Math.max(result, firstHalf.get(diff) + secondHalf.get(-diff));
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
