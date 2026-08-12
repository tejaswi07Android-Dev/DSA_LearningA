package google;

import java.util.*;

public class LevelUp {
    public static void main(String[] args) {

        // Test 1
        // 1 -> 2 -> 3 -> 4
        //           ^    |
        //           |____|
        ListNode head1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        head1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n3;

        ListNode result1 = detectCycle(head1);

        System.out.println(result1 == null ? "null" : result1.val);
        // Expected: 3


        // Test 2
        // 1 -> 2 -> 3 -> null
        ListNode head2 = new ListNode(1);
        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(3);

        head2.next = n5;
        n5.next = n6;

        ListNode result2 = detectCycle(head2);

        System.out.println(result2 == null ? "null" : result2.val);
        // Expected: null


        // Test 3
        // 1 -> 2 -> 3 -> 4
        //      ^         |
        //      |_________|
        ListNode head3 = new ListNode(1);
        ListNode n7 = new ListNode(2);
        ListNode n8 = new ListNode(3);
        ListNode n9 = new ListNode(4);

        head3.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n7;

        ListNode result3 = detectCycle(head3);

        System.out.println(result3 == null ? "null" : result3.val);
        // Expected: 2


        // Test 4
        // 1 -> itself
        ListNode head4 = new ListNode(1);
        head4.next = head4;

        ListNode result4 = detectCycle(head4);

        System.out.println(result4 == null ? "null" : result4.val);
        // Expected: 1


        // Test 5
        // Empty list
        ListNode result5 = detectCycle(null);

        System.out.println(result5 == null ? "null" : result5.val);


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
}
