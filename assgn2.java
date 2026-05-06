import java.util.Scanner;
import java.io.*;

class ArrTrans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter K: ");
        int k = sc.nextInt();
        boolean possible = true;

        for (int i = 1; i < n; i++) {
            if ((arr[i] - arr[0]) % k != 0) {
                possible = false;
                break;
            }
        }

        if (!possible) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {

                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }

            int operations = 0;
            for (int i = 0; i < n; i++) {
                operations += Math.abs(arr[i] - arr[n / 2]) / k;
            }
            System.out.println("Minimum operations = " + operations);
        }
    }
}