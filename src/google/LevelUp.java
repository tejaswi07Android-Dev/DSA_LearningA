package google;

import java.util.*;

public class LevelUp {
    public static void main(String[] args) {

        System.out.println(lis(new int[]{10, 9, 2, 5, 3, 7, 101, 18})); // 4
// Example LIS: 2, 3, 7, 101

        System.out.println(lis(new int[]{0, 1, 0, 3, 2, 3})); // 4
// Example LIS: 0, 1, 2, 3

        System.out.println(lis(new int[]{7, 7, 7, 7, 7})); // 1
// Strictly increasing, so equal values don't count

        System.out.println(lis(new int[]{1, 2, 3, 4, 5})); // 5

        System.out.println(lis(new int[]{5, 4, 3, 2, 1})); // 1

        System.out.println(lis(new int[]{1})); // 1

        System.out.println(lis(new int[]{1, 3, 2, 4, 3, 5})); // 4
// Example LIS: 1, 2, 4, 5
// Another: 1, 3, 4, 5

        System.out.println(lis(new int[]{3, 10, 2, 1, 20})); // 3
// Example LIS: 3, 10, 20

        System.out.println(lis(new int[]{50, 3, 10, 7, 40, 80})); // 4
// Example LIS: 3, 7, 40, 80

        System.out.println(lis(new int[]{2, 2, 2, 3, 4})); // 3
// Example LIS: 2, 3, 4

        System.out.println(lis(new int[]{-5, -1, -3, 0, 2, -2, 4})); // 5
// Example LIS: -5, -3, 0, 2, 4

        System.out.println(lis(new int[]{4, 10, 4, 3, 8, 9})); // 3
// Example LIS: 4, 8, 9

        System.out.println(lis(new int[]{1, 5, 2, 3, 4, 6})); // 5
// Example LIS: 1, 2, 3, 4, 6

        System.out.println(lis(new int[]{10, 20, 10, 30, 20, 50})); // 4
// Example LIS: 10, 20, 30, 50

        System.out.println(lis(new int[]{})); // 0
// Empty array

    }


    public static int countSubArraySumTarget(int[] A, int T) {
        int count = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int j : A) {
            prefixSum += j;

            int comp = prefixSum - T;

            if (map.containsKey(comp)) {
                count += map.get(comp);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static int shortestSubarray(int[] A, int K) {
        int count = Integer.MAX_VALUE;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < A.length; i++) {
            prefixSum += A[i];

            int comp = prefixSum - K;

            if (map.containsKey(comp)) {
                count = Math.min(count, i - map.get(comp));
            }

            map.put(prefixSum, i);
        }

        return count == Integer.MAX_VALUE ? -1 : count;
    }

    public static int searchTarget(int[] A, int T) {
        int l = 0;
        int r = A.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (A[m] == T) return m;

            if (A[m] > T) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }

    public static int longestUniqueSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        HashSet<Character> set = new HashSet<>();
        int len = 1;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            len = Math.max(len, right - left + 1);

        }
        return len;
    }

    public static int maxWater(int[] A) {
        if (A.length <= 1) return 0;

        int maxWater = 0;

        int left = 0;
        int right = A.length - 1;

        while (left < right) {
            int w = Math.min(A[left], A[right]);
            int h = right - left;

            maxWater = Math.max(maxWater, w * h);

            if (A[right] < A[left]) {
                right--;
            } else {
                left++;
            }
        }

        return maxWater;
    }

    public static int[][] mergeIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[][]{};

        if (intervals.length == 1) return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> res = new ArrayList<>();

        int a1 = intervals[0][0];
        int b1 = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int a2 = intervals[i][0];
            int b2 = intervals[i][1];

            if (b1 > a2) {
                b1 = Math.max(b1, b2);
            } else {
                int[] temp = new int[]{a1, b1};

                res.add(temp);
                a1 = a2;
                b1 = b2;
            }
        }

        int[] temp = new int[]{a1, b1};

        res.add(temp);

        int s = res.size();

        int[][] ans = new int[s][2];

        for (int i = 0; i < s; i++) {
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }

        return ans;

    }

    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            if (!map.containsKey(ch)) {
                return false;
            } else {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    map.remove(ch);
                }
            }
        }

        return map.isEmpty();
    }

    public static int[] nextGreaterElement(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= A[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(A[i]);
        }

        return result;
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }


        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;


        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;


    }

    public static int kthLargest(int[] A, int K) {
        if (A == null || A.length == 0 || K > A.length) return -1;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int a : A) {
            pq.offer(a);
            if (pq.size() > K) {
                pq.poll();
            }
        }

        return pq.peek();
    }

    public static int longestConsecutive(int[] A) {
        if (A.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();

        for (int a : A) set.add(a);
        int max = 0;
        for (int a : A) {
            if (!set.contains(a - 1)) {
                int check = a;
                int len = 0;
                while (set.contains(check++)) {
                    len++;
                }
                max = Math.max(max, len);
            }
        }

        return max;
    }

    public static int longestSubarrayAtMostKDistinct(int[] A, int K) {
        if (K == 0) return 0;

        HashMap<Integer, Integer> freq = new HashMap<>();
        int l = 0;
        int maxLen = 0;
        for (int r = 0; r < A.length; r++) {
            freq.put(A[r], freq.getOrDefault(A[r], 0) + 1);

            while (freq.size() > K) {
                freq.put(A[l], freq.get(A[l]) - 1);

                if (freq.get(A[l]) == 0) {
                    freq.remove(A[l]);
                }

                l++;
            }
            if (freq.size() == K) maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }

    public static int largestRectangle(int[] A) {
        int n = A.length;


        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= n; i++) {
            int currHeight = (i == A.length) ? 0 : A[i];

            while (!stack.isEmpty() && A[stack.peek()] >= currHeight) {
                int index = stack.pop();

                int height = A[index];

                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                maxArea = Math.max(maxArea, height * width);
            }
            stack.add(i);
        }


        return maxArea;
    }

    public static int firstOccurrence(int[] A, int T) {
        int left = 0;
        int right = A.length - 1;

        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (A[mid] == T) ans = mid;

            if (T < A[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static int singleNumber(int[] A) {
        int ans = 0;
        for (int a : A) ans ^= a;

        return ans;
    }

    public static long maxSubarraySum(int[] A) {
        if (A.length == 0) return 0;
        long ans = A[0];
        long sum = A[0];

        for (int i = 1; i < A.length; i++) {
            sum += A[i];
            ans = Math.max(sum, ans);
            sum = Math.max(0, sum);
        }
        return ans;
    }

    public static boolean hasPairWithSum(int[] A, int K) {
        HashSet<Integer> set = new HashSet<>();

        for (int a : A) {
            int comp = K - a;
            if (set.contains(comp)) {
                return true;
            }
            set.add(a);
        }
        return false;
    }

    public static int[] twoSum(int[] A, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int comp = K - A[i];
            if (map.containsKey(comp)) {
                return new int[]{map.get(comp), i};
            }
            map.put(A[i], i);
        }

        return new int[]{-1, -1};
    }

    public static boolean isBalanced(Node root) {
        if (helper(root) == -1) {
            return false;
        }

        return true;
    }

    public static int helper(Node root) {
        if (root == null) return 0;

        int left = helper(root.left);
        if (left == -1) return -1;
        int right = helper(root.right);
        if (right == -1) return -1;

        if (Math.abs(right - left) > 1) return -1;
        return Math.max(right, left) + 1;
    }

    public static List<Integer> rightSideView(Node root) {
        if (root == null) return new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 1; i <= size; i++) {
                Node temp = q.poll();

                if (i == size) ans.add(temp.val);

                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
        }

        return ans;
    }

    public static int maxSumLevel(Node root) {
        if (root == null) return -1;
        int currLevel = 0;
        int ans = 0;
        long maxSum = Long.MIN_VALUE;

        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            long sum = 0;
            for (int i = 0; i < size; i++) {
                Node temp = q.poll();
                sum += temp.val;

                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }

            if (sum > maxSum) {
                maxSum = sum;
                ans = currLevel;
            }

            currLevel++;
        }

        return ans;

    }

    public static int minDistance(String A, String B) {
        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int curr = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    curr = Math.min(curr, dp[i - 1][j - 1]);
                    dp[i][j] = curr + 1;
                }
            }
        }

        return dp[n][m];
    }

    public static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < m; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        System.out.println(dp[n - 1][m - 1]);
        return dp[n - 1][m - 1];
    }

    public static int knapsackRecursion(int[] values, int[] weights, int capacity) {
        int n = weights.length;
        int m = capacity;

        int[][] dp = new int[n + 1][m + 1];

//        for(int i = 0; i <= n; i++){
//            Arrays.fill(dp[i], -1);
//        }

        return helperKnapSack(dp, values, weights, capacity, values.length);


    }

    public static int helperKnapSack(int[][] dp, int[] values, int[] weights, int capacity, int idx) {
        if (capacity == 0 || idx == 0) {
            dp[idx][capacity] = 0;
            return 0;
        }

        if (dp[idx][capacity] != 0) {
            return dp[idx][capacity];
        } else {
            int include = 0;
            if (weights[idx - 1] <= capacity) {
                include = values[idx - 1] + helperKnapSack(dp, values, weights, capacity - weights[idx - 1], idx - 1);
            }
            int exclude = helperKnapSack(dp, values, weights, capacity, idx - 1);

            dp[idx][capacity] = Math.max(include, exclude);
        }


        return dp[idx][capacity];
    }


    public static int knapsack(int[] values, int[] weights, int capacity) {
        int n = weights.length;
        int m = capacity;

        int[] dp = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            for (int c = weights[i - 1]; c <= capacity; c++) {

                dp[c] = Math.max(
                        dp[c],
                        values[i - 1] + dp[c - weights[i - 1]]
                );

            }
        }

        return dp[capacity];
    }


    public static boolean subsetSumTopDown(int[] A, int B) {
        int n = A.length;
        int m = B;
        Boolean[][] dp = new Boolean[n + 1][m + 1];
        dp[0][0] = true;
        return helper(dp, A, B, A.length);
    }

    private static boolean helper(Boolean[][] dp, int[] A, int sum, int idx) {
        if (sum == 0) {
            return true;
        }
        if (idx == 0) {

            return false;
        }

        if (dp[idx][sum] != null) {
            return dp[idx][sum];
        }

        if (A[idx - 1] <= sum) {
            boolean include = helper(dp, A, sum - A[idx - 1], idx - 1);

            boolean skip = helper(dp, A, sum, idx - 1);


            dp[idx][sum] = include || skip;
            return dp[idx][sum];
        } else {
            boolean skip = helper(dp, A, sum, idx - 1);
            dp[idx][sum] = skip;
            return dp[idx][sum];
        }
    }

    public static boolean subsetSumBottomUp(int[] A, int B) {
        int n = A.length;
        int m = B;

        boolean[][] dp = new boolean[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int j = 1; j <= m; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= B; j++) {

                if (A[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - A[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[n][m];
    }

    public static boolean subsetSum(int[] A, int B) {
        boolean[] dp = new boolean[B+1];
        dp[0] = true;

        for(int i = 1; i <= A.length; i++){
            for(int j = B; j >= A[i-1]; j--){
                dp[j] = dp[j] || dp[j - A[i-1]];
            }
        }

        return dp[B];
    }


    public static boolean canPartition(int[] A) {
        int totalSum = 0;
        for(int a : A) totalSum += a;

        if(totalSum %2 == 1) return false;
        int point = totalSum/2;
        boolean[] dp = new boolean[point+1];
        dp[0] = true;

        for(int i = 1; i <= A.length; i++){
            for (int j = point; j>= A[i-1]; j--){
                dp[j] = dp[j] || dp[j-A[i-1]];
            }
        }

        return dp[point];
    }

    public static int findTargetSumWays(int[] A, int target) {
        HashMap<String, Integer> map = new HashMap<>();
        return helperSum(map, A, target, 0);
    }

    public static int helperSum(HashMap<String, Integer> map, int[] A, int T, int i){
        if(i == A.length){
            if(T == 0){
                return 1;
            }else {
                return 0;
            }
        }

        String key = i +","+ T;

        if(map.containsKey(key)){
            return map.get(key);
        }else{
            int n = helperSum(map, A, T - A[i], i+1) + helperSum(map, A, T + A[i], i+1);
            map.put(key , n);

        }

        return map.get(key);

    }

    public static int lis(int[] A) {
        int ans = 0;
        int[] dp = new int[A.length +1];


        for(int i = 0; i < A.length; i++){
            ans = Math.max(ans, helperLis(dp, A, i));
        }
        return ans;
    }

    private static int helperLis(int[] dp, int[] A, int i) {
        int ans = 1;

        if(dp[i] != 0){
            return dp[i];
        }
        for(int k = 0; k < i; k++){
            if(A[k] < A[i]){
                ans = Math.max(ans, helperLis(dp, A, k) +1);

            }
        }
        dp[i] = ans;
        return ans;
    }

}
