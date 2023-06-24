package daily;

public class _5_MinimumFlipsToMake {

    // https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/

    public int minFlips(int a, int b, int c) {
        int ans = 0;
        while (a != 0 | b != 0 | c != 0) {
            if ((c & 1) == 1) {

                // We need either a & 1 = 1 or b & 1 = 1
                if ((a & 1) == 0 && (b & 1) == 0) {
                    ans++;
                }

            } else {
                ans += (a & 1) + (b & 1);
            }

            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
