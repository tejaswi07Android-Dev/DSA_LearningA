import javax.xml.transform.Source;
import java.util.*;

public class HardPrep {
    public static void main(String[] args) {

//        System.out.println(vote(new int[]{2, 1, 2, 1, 2, 1, 1}));

//        System.out.println(longestSequence(new int[]{0,3,7,2,5,8,4,6,0,1,-1,-2,-3}));

//        System.out.println(countSum(new int[]{1,5,2,3,3,3,3,4}, 6));

//        System.out.println(pivotIndex(new int[]{1,2,3}));

//        System.out.println(longestSubArraySum(new int[]{1,-1,0}, 0));

//        System.out.println(Arrays.toString(productExceptOwn(new int[]{1, 2, 3, 4})));
//        System.out.println(isValidParanthese("{}()]"));

        ArrayList<ArrayList<Integer>> intervals = new ArrayList<>();

        intervals.add(new ArrayList<>(Arrays.asList(1, 3)));
        intervals.add(new ArrayList<>(Arrays.asList(2, 6)));
        intervals.add(new ArrayList<>(Arrays.asList(8, 10)));
        intervals.add(new ArrayList<>(Arrays.asList(15, 18)));

//        System.out.println(mergeList(intervals));

//        System.out.println(maximumSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

        System.out.println(maxProfit(new int[]{7,6,5,4,2,1,7}));

        int[] A = new int[]{1,1,2,3,4,4};
        removeDuplicates(A);
        System.out.println(Arrays.toString(A));
//        System.out.println(Arrays.toString(moveZeroes(new int[]{5, 2, 0, 1, 0, 0, 7, 3})));

//        System.out.println(uniqueElements(new int[]{1,1,2,3,5,4,2}));

//        System.out.println(majority(new int[]{1,2,3,5,4,2,1,2,2,2,2,2,3}));

//        System.out.println(Arrays.toString(prodExceptOwn(new int[]{1, 2, 3, 4})));

        System.out.println(longestSubString("abcjackloj"));

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


    public static ArrayList<ArrayList<Integer>> mergeList(ArrayList<ArrayList<Integer>> A){
        int a1 = A.get(0).get(0);
        int b1 = A.get(0).get(1);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 1; i < A.size(); i++){
            int a2 = A.get(i).get(0);
            int b2 = A.get(i).get(1);

            if(b1 >= a2){
                b1 = Math.max(b1, b2);
            }else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(a1);
                temp.add(b1);
                ans.add(temp);

                a1 = a2;
                b1 = b2;
            }


        }
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(a1);
        temp.add(b1);
        ans.add(temp);

        return ans;

    }


    public static int maximumSubArray(int[] A){
        int ans = A[0];
        int maxAns = A[0];

        for(int i = 1; i < A.length; i++){
            ans += A[i];
            maxAns = Math.max(ans, maxAns);
            if(ans < 0){
                ans = 0;
            }

        }

        return maxAns;
    }




    // ------------------------------------------------------------------------------------------------


    public static int maxProfit(int[] A){
        int n = A.length;
        int preMin = A[0];
        int ans = 0;
        int maxAns = 0;

        for(int i = 1; i< n; i++){
            ans = A[i] - preMin;
            maxAns = Math.max(ans, maxAns);
            preMin = Math.min(preMin, A[i]);
        }
        return maxAns;
    }

    public static void moveZeroes(int[] A){
        int idx = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] != 0){
                A[idx] = A[i];
                idx++;
            }
        }

        while (idx < A.length){
            A[idx++] = 0;
        }
    }

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0)
            return 0;

        int i = 0;

        for (int j = 1; j < nums.length; j++) {

            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    public static int uniqueElements(int[] A){
        HashSet<Integer> set = new HashSet<>();
        for(int a : A){
            set.add(a);
        }
        return set.size();
    }

    public static int majority(int[] A){
        int n = A[0];
        int c = 1;
        for(int i = 1; i < A.length; i++){
            if(n == A[i]){
                c++;
            }else{
                c--;
            }
            if(c == 0){
                n = A[i];
                c = 1;
            }
        }
        return n;
    }

    public static int[] prodExceptOwn(int[] A){
        int n = A.length;
        int[] preProd = new int[n];

        preProd[0] = 1;

        for(int i = 1; i < n; i++){
            preProd[i] = preProd[i-1] * A[i-1];
        }

        int right = 1;
        for(int i = n-1; i>=0; i--){
            preProd[i] = preProd[i] * right;
            right *= A[i];
        }
        return preProd;

    }


    public static int longestSubString(String s){
        int ans = 1;
        int maxAns = 1;
        HashSet<Character> set = new HashSet<>();
        int l = 0;
        for(int r =0; r < s.length(); r++){
            while (set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            ans = r-l+1;
            maxAns = Math.max(ans, maxAns);
        }
        return maxAns;

    }


    public void merge(int[] nums1, int m, int[] nums2, int n){
        int i = m-1;
        int j = n-1;
        int k = m+n -1;

        while (i >= 0 && j>= 0){
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }else{
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }

        while (j>=0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }





}

