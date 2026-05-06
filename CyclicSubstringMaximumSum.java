import java.util.*;
public class CyclicSubstringMaximumSum {
    static int value(char c) {
        return c - 'a' + 1;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int n = s.length();

        String t = s + s;

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int sum = 0;
        int maxSum = 0;

        for (int right = 0; right < 2 * n; right++) {

            char ch = t.charAt(right);
            while (set.contains(ch)) {
                char remove = t.charAt(left);
                set.remove(remove);
                sum -= value(remove);
                left++;
            }

            while ((right - left + 1) > n) {
                char remove = t.charAt(left);
                set.remove(remove);
                sum -= value(remove);
                left++;
            }

            set.add(ch);
            sum += value(ch);

            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
}