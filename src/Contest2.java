import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class Contest2 {

    public static void main(String[] args) {

//        System.out.println(lengthOnesZeros(new int[]{0, 1, 0, 1, 0, 0, 1, 0}));
//        findMissingAndRepeating(new int[]{1, 2, 2, 4});

//        System.out.println(Arrays.toString(sortByFrequency(new int[]{1, 1, 2, 2, 2, 3, 3, 3, 3})));

//        System.out.println(duplicate(new int[]{1,3,4,2,2}));
//        printNto1(5);
//        System.out.println();
        System.out.println(addDigits(45));
        System.out.println(addDigits(12345));
//        System.out.println(NthFibonacciNumber(5));
//        System.out.println(generateSubsequences("abc"));
        String str = "racecar";
        System.out.println(isPalindrome(str,0, str.length()-1));

    }


    //TC = O(N)
    //SC = O(N)
    public static int lengthOnesZeros(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
            if (Objects.equals(map.get(1), map.get(0))) {
                count = map.get(0) + map.get(1);
            }
        }
        return count;
    }


    // TC = O(N)
    // SC = O(1)
    public static void findMissingAndRepeating(int[] A) {
        int n = A.length;

        int i = 0;

        while (i < A.length) {

            int correct = A[i] - 1;

            if (A[i] != A[correct]) {

                int temp = A[i];
                A[i] = A[correct];
                A[correct] = temp;
            } else {
                i++;
            }
        }

        for (i = 0; i < n; i++) {
            if (A[i] != i + 1) {
                System.out.println("Repeating :" + A[i]);
                System.out.println("Missing :" + (i + 1));
                break;
            }
        }
    }


    // TC = O(N)
    // SC = O(N)
    public static Integer[] sortByFrequency(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int a : A) map.put(a, map.getOrDefault(a, 0) + 1);


        Integer[] arr = Arrays.stream(A).boxed().toArray(Integer[]::new);

        Arrays.sort(arr, (a, b) -> {
            int fa = map.get(a);
            int fb = map.get(b);

            if (fa == fb) {
                return a - b;
            }

            return fb - fa;
        });

        return arr;
    }

    // TC = O(N)
    // SC = O(1)
    public static int maxProduct(int[] nums) {

        int maxProd = nums[0];
        int minProd = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int curr = nums[i];

            if (curr < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            maxProd = Math.max(curr, maxProd * curr);
            minProd = Math.min(curr, minProd * curr);

            ans = Math.max(ans, maxProd);
        }

        return ans;
    }





    public static int duplicate(int[] A){
        int slow = A[0];
        int fast = A[0];


        // Here we detected the cycle
        do {
            slow = A[slow];
            fast = A[A[slow]];
        }while (slow != fast);

        slow = A[0];

        while (slow != fast){
            slow = A[slow];
            fast = A[fast];
        }

        return slow;
    }


    public static void printNto1(int n){
        if(n==0) return;

        System.out.print(n+" ");
        printNto1(n-1);
    }

    static int sum = 0;

    public static int addDigits(int n){
        if(n < 1) return 0;
        addDigits(n/10);
        return (n%10) + addDigits(n/10);
    }


    public static int NthFibonacciNumber(int n){
        if(n==0|| n==1) return n;

        return NthFibonacciNumber(n-1)+ NthFibonacciNumber(n-2);
    }


    public static ArrayList<String> generateSubsequences(String s) {

        ArrayList<String> ans = new ArrayList<>();

        helper(0, s, "", ans);

        return ans;
    }

    public static void helper(int idx, String s, String curr, ArrayList<String> ans) {

        if (idx == s.length()) {
            ans.add(curr);
            return;
        }

        helper(idx + 1, s, curr + s.charAt(idx), ans);

        helper(idx + 1, s, curr, ans);
    }


    public static boolean isPalindrome(String S, int l, int r) {
        if (l >= r) return true;

        if (S.charAt(l) != S.charAt(r)) {
            return false;
        }

        return isPalindrome(S, l+1, r-1);
    }
}