package google;

import java.util.*;

public class LevelUp {
    public static void main(String[] args) {


        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println(maxSumLevel(root));
// Expected: 2


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
        for (int i = 0; i < A.length ; i++) {
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
        if(A == null || A.length == 0 || K > A.length) return -1;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int a : A){
            pq.offer(a);
            if(pq.size()>K){
                pq.poll();
            }
        }

        return pq.peek();
    }

    public static int longestConsecutive(int[] A) {
        if(A.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();

        for(int a : A) set.add(a);
        int max = 0;
        for (int a : A){
            if(!set.contains(a-1)){
                int check = a;
                int len = 0;
                while (set.contains(check++)){
                    len++;
                }
                max = Math.max(max, len);
            }
        }

        return max;
    }

    public static int longestSubarrayAtMostKDistinct(int[] A, int K) {
        if(K == 0) return 0;

        HashMap<Integer, Integer> freq = new HashMap<>();
        int l = 0;
        int maxLen = 0;
        for(int r = 0; r < A.length; r++){
            freq.put(A[r], freq.getOrDefault(A[r], 0)+1);

            while(freq.size() > K){
                freq.put(A[l], freq.get(A[l]) - 1);

                if (freq.get(A[l]) == 0) {
                    freq.remove(A[l]);
                }

                l++;
            }
            if(freq.size() ==K) maxLen = Math.max(maxLen, r -l +1);
        }

        return maxLen;
    }

    public static int largestRectangle(int[] A) {
        int n = A.length;


        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i <= n; i++){
            int currHeight = (i == A.length) ? 0 : A[i];

            while(!stack.isEmpty() && A[stack.peek()] >= currHeight){
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
        int right = A.length -1;

        int ans  = -1;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(A[mid] == T) ans = mid;

            if(T < A[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return ans;
    }

    public static int singleNumber(int[] A) {
        int ans = 0;
        for(int a : A) ans ^= a;

        return ans;
    }

    public static long maxSubarraySum(int[] A) {
        if(A.length == 0) return 0;
        long ans = A[0];
        long sum = A[0];

        for(int i = 1; i < A.length; i++){
            sum += A[i];
            ans = Math.max(sum, ans);
            sum = Math.max(0 , sum);
        }
        return ans;
    }

    public static boolean hasPairWithSum(int[] A, int K) {
        HashSet<Integer>  set = new HashSet<>();

        for(int a : A){
            int comp = K -a;
            if(set.contains(comp)){
                return true;
            }
            set.add(a);
        }
        return false;
    }

    public static int[] twoSum(int[] A, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            int comp =  K - A[i];
            if(map.containsKey(comp)){
                return new int[]{map.get(comp), i};
            }
            map.put(A[i], i);
        }

        return new int[]{-1, -1};
    }

    public static boolean isBalanced(Node root) {
        if(helper(root) == -1){
            return false;
        }

        return true;
    }

    public static int helper(Node root){
        if(root == null) return 0;

        int left = helper(root.left);
        if(left == -1) return -1;
        int right = helper(root.right);
        if(right == -1) return -1;

        if(Math.abs(right - left) > 1) return -1;
        return Math.max(right ,left) + 1;
    }

    public static List<Integer> rightSideView(Node root) {
        if(root == null) return  new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()){
            int size = q.size();
            for(int i = 1; i <= size; i++){
                Node temp = q.poll();

                if(i == size) ans.add(temp.val);

                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
        }

        return ans;
    }

    public static int maxSumLevel(Node root) {
        if(root == null) return -1;
        int currLevel = 0;
        int ans = 0;
        long maxSum = Long.MIN_VALUE;

        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()){
            int size = q.size();

            long sum = 0;
            for(int i =0 ; i < size; i++){
                Node temp = q.poll();
                sum += temp.val;

                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }

            if(sum > maxSum){
                maxSum = sum;
                ans = currLevel;
            }

            currLevel++;
        }

        return ans;

    }
}
