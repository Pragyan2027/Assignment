import java.util.*;

public class ArrayTransformationCostMinimization {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter value of K: ");
        int k = sc.nextInt();

        for (int i = 1; i < n; i++) {
            if ((arr[i] - arr[0]) % k != 0) {
                System.out.println("Transformation is not possible.");
                System.out.println(-1);
                return;
            }
        }
        Arrays.sort(arr);
        int median = arr[n / 2];

        long operations = 0;
        for (int num : arr) {

            operations += Math.abs(num - median) / k;
        }

        System.out.println("Minimum operations required: " + operations);
    }
}
