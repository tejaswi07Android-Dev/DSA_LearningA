import java.util.*;

public class Contest {

    public static void main(String[] args) {
//        int[] a = distinctElement(new int[]{1,2,1,3,4,2,3}, 4);
//        System.out.println(Arrays.toString(a));
//
//        System.out.println(singleNumberII(new int[]{2,2,2,3,4,4,4,3,3,5}));
//
//        ArrayList<ArrayList<Integer>> intervals = new ArrayList<>();
//
//        intervals.add(new ArrayList<>(Arrays.asList(1, 3)));
//        intervals.add(new ArrayList<>(Arrays.asList(2, 6)));
//        intervals.add(new ArrayList<>(Arrays.asList(8, 10)));
//        intervals.add(new ArrayList<>(Arrays.asList(15, 18)));
//
//        System.out.println(mergeOverLapping(intervals));
//
//        System.out.println(generateSubsequences("abc"));

//        System.out.println(longestConsecutiveSequence(new int[]{100,4,200,1,3,2,5}));

//        System.out.println(Arrays.toString(productArray(new int[]{1, 2, 3, 4, 5})));

//        System.out.println(maxSumSubarray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

//        System.out.println(groupAnagram(new String[]{"eat","tea","tan","ate","nat","bat"}));

//        System.out.println(Arrays.toString(sortColors(new int[]{2, 0, 2, 1, 1, 0,0})));

//        System.out.println(longestSubStringWithoutRepeating("abcdabcefgb"));

//        System.out.println(countPair(new int[]{1,5,7,-1,5, 4,5, 2, 4,6,0},6));

//        System.out.println(longestSubarrayWithZeroSum(new int[]{1,-1,3,2,-2,-3}));

//        System.out.println(leadersInArray(new int[]{16,17,4,3,5,2}));

//        System.out.println(Arrays.toString(singleNumberIII(new int[]{1, 2, 3, 1, 2, 5})));

//        System.out.println(maxConsecutiveOnes(new int[]{1,1,1,1,0,1,1,1,0}));

//        System.out.println(equilibriumIndex(new int[]{1,3,5,2,2}));

        int[][] A = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

//        System.out.println(mergeIntervals(A));

//        System.out.println(mooreVoting(new int[] {2,2,1,1,1,2,2,1,1,1}));


        System.out.println(isValid("(){[{]}}"));

    }


    public static int longestSubarraySumK(int[] A, int K) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        for(int i = 0; i < A.length; i++) {

            sum += A[i];

            // If entire subarray from 0 to i gives K
            if(sum == K) {
                maxLen = i + 1;
            }

            // Check if (sum - K) existed before
            if(map.containsKey(sum - K)) {
                int len = i - map.get(sum - K);
                maxLen = Math.max(maxLen, len);
            }

            // Store first occurrence only
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    // TC = O(N)
    // SC = O(N)
    public static int[] distinctElement(int[] A, int B){
        int n = A.length;
        int[] ans = new int[n-B+1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < B; i++){
            map.put(A[i], map.getOrDefault(A[i], 0)+1);
        }
        int idx = 0;
        ans[idx++] = map.size();

        for(int i = B; i < n; i++){
            int next = A[i];
            int prev = A[i-B];

            map.put(next, map.getOrDefault(next, 0)+1);
            if(map.containsKey(prev)){
                map.put(prev, map.get(prev)-1);
                if(map.get(prev) == 0){
                    map.remove(prev);
                }
            }

            ans[idx++] = map.size();
        }

        return ans;
    }


    // TC = O(N);
    // SC = O(1);
    public static int singleNumberII(int[] A){
        int ones = 0;
        int twos = 0;

        for(int a : A){
            ones = (ones ^ a) & ~ twos;
            twos = (twos ^ a) & ~ ones;
        }

        return ones;
    }

    // TC = O(N)
    // SC = O(1) because only output is stored

    public static ArrayList<ArrayList<Integer>> mergeOverLapping(ArrayList<ArrayList<Integer>> A){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int a1 = A.getFirst().get(0);
        int b1 = A.getFirst().get(1);

        for(int i = 1; i < A.size(); i++){
            int a2 = A.get(i).get(0);
            int b2 = A.get(i).get(1);

            if(b1 > a2){
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


    public static ArrayList<String> generateSubsequences(String s) {

        ArrayList<String> ans = new ArrayList<>();

        helper(0, s, "", ans);

        return ans;
    }

    public static void helper(int idx, String s, String curr,
                              ArrayList<String> ans) {

        // Base case
        if(idx == s.length()) {
            ans.add(curr);
            return;
        }

        // Include current character
        helper(idx + 1, s, curr + s.charAt(idx), ans);

        // Exclude current character
        helper(idx + 1, s, curr, ans);
    }

    // TC = O(n)
    // SC = O(n)
    public static int longestConsecutiveSequence(int[] A){
        int maxLen = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int a : A) set.add(a);

        for(int a : A){
            if(!set.contains(a-1)){
                int curr = a;
                int len = 1;
                while (set.contains(curr +1)){
                    len++;
                    curr++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }


    // TC = O(N)
    // SC = O(N)
    public static int[] productArray(int[] A){
        int n = A.length;

        int[] preProd = new int[n];

        preProd[0] = 1;
        for(int i = 1; i < n; i++){
            preProd[i] = preProd[i-1] * A[i-1];
        }

        int right = 1;


        for(int i = n-1; i >= 0; i--){
            preProd[i] = preProd[i] * right;

            right *= A[i];
        }

        return preProd;
    }


    // TC = O(n)
    // SC = O(1)
    public static int maxSumSubarray(int[] A){
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for(int a : A){
            sum += a;

            maxSum = Math.max(maxSum, sum);

            if(sum < 0) sum = 0;
        }


        return maxSum;
    }


    //TC = O(N)
    //SC = O(N)
    public static ArrayList<ArrayList<String>> groupAnagram(String[] A){
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(String word : A){
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            String str = String.valueOf(ch);

            if(map.containsKey(str)){
                map.get(str).add(word);
            }else {
                ArrayList<String> list = new ArrayList<>();
                list.add(word);

                map.put(str, list);
            }
        }

        return new ArrayList<>(map.values());
    }

    //TC = O(N)
    //SC = O(1)
    public static int[] sortColors(int[] A){
        int[] freq = new int[3];

        for(int a : A){
            freq[a]++;
        }
        int id = 0;
        for(int i = 0; i < 3; i ++){
            int f = freq[i];
            for(int j = 0; j< f; j++){
                A[id++] = i;
            }
        }

        return A;
    }

    // TC = O(N);
    // SC = O(N);
    public static int longestSubStringWithoutRepeating(String A){
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        char[] ch = A.toCharArray();
        int ans = 0;
        for(int i = 0; i < ch.length; i++){

            while (set.contains(ch[i])){
                set.remove(ch[left++]);
            }

            set.add(ch[i]);

            ans = Math.max(ans, i - left + 1);
        }

        return ans;

    }

    //TC = O(N)
    //SC = O(N)
    public static int countPair(int[] A, int K){
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < A.length; i++){
            int c = K-A[i];
            if(map.containsKey(c)){
                count++;
            }
            map.put(A[i], i);
        }

        return count;
    }

    // TC = O(N)
    // SC = O(N)
    public static int longestSubarrayWithZeroSum(int[] A){
        int maxLength = 0;
        int n = A.length;
        int sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        for(int i = 0; i < n; i++){
            sum += A[i];

            if(sum == 0){
                maxLength = i+1;
            }
            if(map.containsKey(sum)){
                int len = i - map.get(sum);
                maxLength = Math.max(len, maxLength);
            }

            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }

        }
        return maxLength;
    }

    // TC = O(N)
    // SC = O(1)
    public static ArrayList<Integer> leadersInArray(int[] A){
        ArrayList<Integer> ans = new ArrayList<>();

        int rightMax = Integer.MIN_VALUE;
        int n = A.length;
        for(int i = n-1 ; i >= 0; i--){
            if(A[i] > rightMax){
                ans.add(A[i]);
            }

            rightMax = Math.max(rightMax, A[i]);
        }

        Collections.reverse(ans);

        return ans;
    }

    // TC = O(N)
    // SC = O(1)
    public static int[] singleNumberIII(int[] A){
        int xor = 0;

        for(int a: A) xor ^= a;

        int c = 1;

        while ((xor & c) == 0){
            c <<=1;
        }
        int u = 0, v = 0;
        for(int a: A){
            if((a&c) == 0){
                u ^= a;
            }else{
                v ^= a;
            }
        }

        return new int[]{u,v};
    }




    // TC = O(n)
    // SC = O(1)
    public static int maxConsecutiveOnes(int[] A){
        int maxCount = 0;
        int count = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] == 1){
                count++;
            }else{
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }

        maxCount = Math.max(maxCount, count);

        return maxCount;
    }



    public static int equilibriumIndex(int[] A){
        int n = A.length;
        int[] leftSum = new int[n];

        leftSum[0] = 0;

        for (int i = 1; i < n; i++){
            leftSum[i] = leftSum[i-1] + A[i-1];
        }

        int rightSum = 0;

        for(int i = n -1; i >= 0; i--){
            if(rightSum == leftSum[i]){
                return i;
            }

            rightSum += A[i];
        }

        return -1;

    }

    public static ArrayList<ArrayList<Integer>> mergeIntervals(int[][] A){
        ArrayList<ArrayList<Integer>>  ans = new ArrayList<>();

        Arrays.sort(A, (a,b) -> Integer.compare(a[0] , b[0]));

        int a1 = A[0][0];
        int b1 = A[0][1];

        for(int i = 1; i < A.length; i++){
            int a2 = A[i][0];
            int b2 = A[i][1];

            if(a2 <= b1){
                b1 = Math.max(b1, b2);
            }else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(a1);
                temp.add(b1);
                ans.add(temp);
                a1 = a2;
                b1 =b2;
            }

        }

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(a1);
        temp.add(b1);
        ans.add(temp);

        return ans;

    }

    public static int mooreVoting(int[] A){
        int n = A.length;
        Arrays.sort(A);
        return A[(n+1)/2];
    }


    public static boolean isValid(String s) {
        Stack<Character> brc = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                brc.push(c);
            }else{
                if((c == ')' && brc.peek() == '(') || (c == '}' && brc.peek() == '{') || (c == ']' && brc.peek() == '[')){
                    brc.pop();
                }
            }
        }

        return brc.isEmpty();

    }

}
