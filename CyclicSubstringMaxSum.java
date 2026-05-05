import java.util.Scanner;

 class MaxSum{

    public static int maxcyclicsum(String s) {
        if (s == null || s.isEmpty()) return 0;
        s = s.toLowerCase(); 
        
        int n = s.length();
        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[26];
            int currSum = 0;

            for (int j = i; j < i + n; j++) {
                char ch = s.charAt(j % n);
                if (ch < 'a' || ch > 'z') {
                    continue; 
                }
                if (seen[ch - 'a']) {
                    break;
                }

                seen[ch - 'a'] = true;
                currSum += (ch - 'a' + 1);

                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = sc.nextLine();
        System.out.println("Max Sum = " + maxcyclicsum(s));
        
    }
}