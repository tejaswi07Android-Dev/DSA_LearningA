import javax.xml.transform.Source;
import java.util.*;

public class HardPrep {
    public static void main(String[] args) {

//        System.out.println(vote(new int[]{2, 1, 2, 1, 2, 1, 1}));

//        System.out.println(longestSequence(new int[]{0,3,7,2,5,8,4,6,0,1,-1,-2,-3}));

//        System.out.println(countSum(new int[]{1,5,2,3,3,3,3,4}, 6));

//        System.out.println(pivotIndex(new int[]{1,2,3}));

//        System.out.println(longestSubArraySum(new int[]{1,-1,0}, 0));

        System.out.println(Arrays.toString(productExceptOwn(new int[]{1, 2, 3, 4})));
        System.out.println(isValidParanthese("{}()]"));

    }


    public static int vote(int[] A) {
        int count = 1;
        int ele = A[0];

        for (int i = 1; i < A.length; i++) {
            int a = A[i];
            if (count == 0) {
                ele = a;
            }

            if (ele == a) {
                count++;
            } else {
                count--;
            }
        }

        return ele;
    }


    public static int longestSequence(int[] A) {
        Set<Integer> set = new HashSet<>();

        for (int a : A) set.add(a);
        int count = 1;
        int maxCount = 1;

        for (int a : A) {
            count = 1;
            if (!set.contains(a - 1)) {
                int k = a;
                while (set.contains(k + 1)) {
                    k++;
                    count++;
                }
            }

            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
    }


    public static int countSum(int[] A, int k) {
        int count = 0;
        HashSet<String> store = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();

        for (int a : A) {
            int curr = k - a;
            if (set.contains(curr)) {
                String s = Math.min(a, curr) + "#" + Math.max(a, curr);
                if (!store.contains(s)) {
                    count++;
                    store.add(s);
                }
            }
            set.add(a);
        }
        return count;
    }


    public static int pivotIndex(int[] A) {
        int leftSum = 0;
        int rightSum = 0;

        for (int a : A) leftSum += a;

        for (int i = A.length - 1; i >= 0; i--) {
            leftSum -= A[i];
            if (leftSum == rightSum) {
                return i;
            }
            rightSum += A[i];
        }

        return -1;
    }

    public static int pairSum(int[] A, int k) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        for (int a : A) {
            int curr = k - a;
            if (set.contains(curr)) {
                count++;
            }
            set.add(a);
        }
        return count;
    }

    public static int subArraySum(int[] A, int k) {
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int c = 0;
        for (int j : A) {
            prefixSum += j;
            if (map.containsKey(prefixSum - k)) {
                c += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return c;
    }


    public static int longestSubArraySum(int[] A, int k) {
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int length;
        int maxLength = 0;
        for (int i = 0; i < A.length; i++) {
            prefixSum += A[i];
            if (map.containsKey(prefixSum - k)) {
                length = i - map.get(prefixSum - k);
                maxLength = Math.max(length, maxLength);
            }
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        return maxLength;
    }

    public static int[] productExceptOwn(int[] A) {
        int n = A.length;
        int[] preProduct = new int[n];
        preProduct[0] = 1;
        for (int i = 1; i < n; i++) {
            preProduct[i] = preProduct[i - 1] * A[i - 1];
        }

        int[] ans = new int[n];

        int postProduct = 1;

        for (int i = n - 1; i >= 0; i--) {
            ans[i] = preProduct[i] * postProduct;
            postProduct *= A[i];
        }

        return ans;
    }


    public static boolean isValidParanthese(String A) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else {
                if (stack.empty()) return false;

                Character n = stack.pop();

                if (ch == ']' && n != '[' || ch == '}' && n != '{' || ch == ')' && n != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }

}
