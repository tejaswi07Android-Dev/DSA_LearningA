import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static String fin = "";

    public static void main(String[] args) {
//        var scanner = new Scanner(System.in);
//        var s = scanner.nextInt();
//        System.out.println(intToRoman(s));
//        System.out.println(mergeAlternately("abc", "pqr"));
//        System.out.println(kidsWithCandies(new int[]{5,6,8,4,1,2}, 5));
//        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
//        System.out.println(gcdOfStrings("ABCBCBBCACBA", "BCA"));
//        System.out.println(Arrays.toString(plusOne(new int[]{9})));
//        System.out.println(isIsomorphic("egg", "add"));
//        System.out.println(generate(5));
//        System.out.println(Arrays.toString(countBits(1)));
//        System.out.println(countDistinctIntegers(new int[]{2,13,12}));
//        System.out.println(countSquares(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}}));
//        getRow(10);
//        System.out.println(reverseVowels("IceCreAm"));
//        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
//        System.out.println(countPaths(0, 0, 4,4));
//        System.out.println(placeTiles(4, 2));
//        System.out.println(callGuest(2));
//        findSubset(3, new ArrayList<Integer>());
//        NQueens.totalNQueens(4);
//        System.out.println(Math.max(5, 6));
//        System.out.println(maximumDifference(new int[]{999,997,980,976,948,940,938,928,924,917,907,907,881,878,864,862,859,857,848,840,824,824,824,805,802,798,788,777,775,766,755,748,735,732,727,705,700,697,693,679,676,644,634,624,599,596,588,583,562,558,553,539,537,536,509,491,485,483,454,449,438,425,403,368,345,327,287,285,270,263,255,248,235,234,224,221,201,189,187,183,179,168,155,153,150,144,107,102,102,87,80,57,55,49,48,45,26,26,23,15}));
//        System.out.println(peopleAwareOfSecret(6,2,4));
//        System.out.println(canBeTypedWords("leet code", "e"));

//        LinkedList list = new LinkedList();
//        list.insert(10);
//        list.insert(12);
//        list.insert(15);
//        list.insert(18);
//        list.insert(21);
//        list.insert(24);
//        list.insert(26);
//        list.insert(31);

//        System.out.println(findFinalValue(new int[]{8,19,4,2,15,3}, 2));
//        System.out.println(prefixesDivBy5(new int[]{0,1,1,1,1,1}));

//        NewThingsKt.calculator(2.0, 7.0, Main::sum);

//        System.out.println(longestSubs("abcdabf"));
//        System.out.println(longestSubWithK("aaaabcccccdd", 3));
//        System.out.println(minWindow("ACB", "ABC"));
//        System.out.println(Arrays.toString(twoSum(new int[]{3, 3, 3}, 6)));

//        System.out.println(groupAnagrams(new String[]{"ate", "tea", "eat", "abc", "cab", "bac", "dgo", "dog", "god", "left"}));
//        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
//        System.out.println(repeatedNTimes(new int[]{1,2,3,3,4,4,4,5}));
//        moveZeroes(new int[]{1,0,3,0,4,5});
//        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));

//        System.out.println(isAnagrams("assabb", "basssb"));
//        int a = 5 + 5 * 2 + 2 * 2 + (2 * 3);
//        System.out.println(a);

        int a = 10, b = 5, c = 3;

        int d = a + c / 2 * b;

        System.out.println(d);


    }

    public static Double sum(Double a, Double b) {
        return a + b;
    }

    public static List<Integer> removeDuplicates(int[] nums) {
        HashSet<Integer> newList = new HashSet<>();
        for (int num : nums) {
            newList.add(num);
        }
        return newList.stream().toList();

    }

    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i];
            }
        }

        return roman.toString();
    }


    public static void stars() {
        var scanner = new Scanner(System.in);
        System.out.print("Enter the natural: ");
        var n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" * ");
            }
            int spaces = 2 * (n - i);
            for (int j = 1; j <= spaces; j++) {
                System.out.print("   ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print(" * ");
            }
            System.out.println();

        }

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" * ");
            }
            int spaces = 2 * (n - i);
            for (int j = 1; j <= spaces; j++) {
                System.out.print("   ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print(" * ");
            }
            System.out.println();

        }
    }

    public static int occurrence(String s, String sub) {
        int count = 0;
        int fromIndex = 0;

        while ((fromIndex = s.indexOf(sub, fromIndex)) != -1) {
            count++;
            fromIndex += 2;
        }
        String newStr = s.replace(sub, "");
        if (!s.contains(sub)) {
            fin = newStr;
            return 0;
        }

        return count + occurrence(newStr, sub);
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder newStr = new StringBuilder();
        int bign = 0;
        int smn = 0;

        if (word1.length() >= word2.length()) {
            for (int i = 0; i < word2.length(); i++) {
                newStr.append(word1.charAt(i));
                newStr.append(word2.charAt(i));
            }
            newStr.append(word1.substring(word2.length()));

        } else {
            for (int i = 0; i < word1.length(); i++) {
                newStr.append(word1.charAt(i));
                newStr.append(word2.charAt(i));
            }
            newStr.append(word2.substring(word1.length()));

        }


        return newStr.toString();
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxC = 0;
        List<Boolean> result = new ArrayList<>();

        for (int candy : candies) {
            if (maxC < candy) {
                maxC = candy;
            }
        }

        for (int candy : candies) {
            if (candy + extraCandies >= maxC) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }


    public static String gcdOfStrings(String str1, String str2) {
        HashSet<Character> res = new HashSet<>();
        StringBuilder result = new StringBuilder();
        if (str1.length() >= str2.length()) {
            for (int i = 0; i < str2.length(); i++) {
                if (str1.charAt(i) == str2.charAt(i)) {
                    res.add(str1.charAt(i));
                }
            }
        }

        for (Character c : res) {
            result.append(c);
        }

        return result.toString();
    }


    public static int[] plusOne(int[] digits) {
        int n = 0;
        int[] newRes = new int[n];
        if (digits[0] == 9) {
            n = digits.length + 1;
            newRes[0] = 1;
        } else {
            n = digits.length;
        }


        int carry = 1;
        int val;
        for (int i = digits.length - 1; i > 0; i--) {
            val = digits[i] + carry;
            newRes[i] = val % 10;
            carry = val / 10;


        }
        return newRes;
    }

    static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }


        HashMap<Character, Character> map = new HashMap<>();
        boolean isomorphic = true;
        for (int i = 0; i < s.length(); i++) {

            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    isomorphic = false;
                    break;
                }
            }
            map.put(s.charAt(i), t.charAt(i));


        }
        System.out.println(map);
        return isomorphic;
    }

    static List<List<Integer>> generate(int numRow) {
        List<List<Integer>> ans = new ArrayList<>();


        for (int i = 0; i < numRow; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    int n = ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j);
                    row.add(n);
                }
            }
            ans.add(row);
        }


        return ans;
    }

    static boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }

    static int[] countBits(int n) {
        int[] bits = new int[32];
        int index = 0;
        while (n != 0) {
            bits[index++] = (n & 1); // store last bit
            n >>>= 1;                // shift right
        }
        return bits;
    }

    static int countDistinctIntegers(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        int s = nums.length;
        for (int n : nums) {
            res.add(n);
        }
        for (int num : nums) {
            res.add(reverse(num));
        }

        HashSet<Integer> val = new HashSet<Integer>(res);

        return val.size();
    }


    static int reverse(int x) {
        var isPositive = true;
        if (x < 0) {
            isPositive = false;
            x = -x;
        }

        int result = 0;
        while (x != 0) {
            int digit = x % 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10) {
                return 0;
            }
            result = result * 10 + digit;
            x /= 10;
        }

        if (!isPositive) {
            result = -result;
        }
        return result;
    }

    static int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int[][] dp = new int[rows][columns];

        System.arraycopy(matrix[0], 0, dp[0], 0, columns);

        for (int i = 0; i < rows; i++) {
            dp[i][0] = matrix[i][0];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                count += dp[i][j];
            }
        }


        return count;
    }

    static List<Integer> getRow(int rowIndex) {
        if (rowIndex < 1) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            return row;
        }
        List<List<Integer>> ans = new ArrayList<>();


        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    int n = ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j);
                    row.add(n);
                }
            }
            ans.add(row);
        }

        for (List<Integer> an : ans) {
            System.out.println(an);
        }


        return ans.get(rowIndex);
    }

    static int minimumArea(int[][] grid) {
        int top = Integer.MAX_VALUE;
        int bottom = Integer.MIN_VALUE;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        int rows = grid.length;
        int columns = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    top = Math.min(top, i);
                    bottom = Math.max(bottom, i);
                    left = Math.min(left, j);
                    right = Math.max(right, j);

                }
            }
        }

        if (top == Integer.MAX_VALUE) {
            return 0;
        }
        return (bottom - top + 1) * (right - left + 1);
    }

    static String reverseVowels(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            while (left < right && isVowel(arr[left])) {
                left++;
            }
            while (left < right && isVowel(arr[right])) {
                right--;
            }

            // swap vowels
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
        return new String(arr);
    }

    static boolean isVowel(char c) {
        return c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U';
    }

    static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (nums[i] != nums[i + 1]) {
                    ans = nums[i];
                }
            } else if (i == n - 1) {
                if (nums[n - 1] != nums[n - 1 - 1]) {
                    ans = nums[n - 1];
                }
            } else {
                if (nums[i] != nums[i + 1] && nums[i] != nums[i - 1]) {
                    ans = nums[i];
                }
            }
        }

        return ans;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m, k = 0; i < m + n && k < n; i++, k++) {
            nums1[i] = nums2[k];
        }
    }

    public static int countPaths(int i, int j, int n, int m) {
        if (i == n || j == m) {
            return 0;
        }
        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        int dP = countPaths(i, j + 1, n, m);
        int rP = countPaths(i + 1, j, n, m);

        return dP + rP;
    }

    static int placeTiles(int n, int m) {
        if (n < m) {
            return 1;
        }
        if (n == m) {
            return 2;
        }

        int vert = placeTiles(n - m, m);

        int hor = placeTiles(n - 1, m);

        return vert + hor;
    }

    static int callGuest(int n) {
        if (n <= 1) {
            return 1;
        }
        int w1 = callGuest(n - 1);

        int w2 = (n - 1) * callGuest(n - 2);

        return w1 + w2;
    }

    static void findSubset(int n, ArrayList<Integer> subset) {
        if (n == 0) {
            printSubset(subset);
            return;
        }
        subset.add(n);
        findSubset(n - 1, subset);

        subset.removeLast();
        findSubset(n - 1, subset);
    }

    static void printSubset(ArrayList<Integer> subset) {
        System.out.print("( ");
        for (Integer integer : subset) {
            System.out.print(integer + " ");
        }
        System.out.print(")");
        System.out.println();
    }

    static int maximumDifference(int[] prs) {
        int ans = -1;
        int minVal = prs[0];

        for (int i = 1; i < prs.length; i++) {
            ans = Math.max(ans, prs[i] - minVal);
            minVal = Math.min(minVal, prs[i]);
        }
        return ans;
    }

    static int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = 1000000007;
        int[] dp = new int[n + 1];

        int curr = 0;

        dp[1] = 1;

        for (int day = 2; day <= n; day++) {
            if (day - delay > 0) {
                curr = (curr + dp[day - delay]) % mod;
            }

            if (day - forget > 0) {
                curr = (curr - dp[day - forget] + mod) % mod;
            }

            dp[day] = curr;
        }

        int total = 0;
        for (int day = n - forget + 1; day <= n; day++) {
            if (day > 0) {
                total = (total + dp[day]) % mod;
            }
        }
        return total;

    }

    public static int canBeTypedWords(String text, String broken) {
        String[] words = text.split("\\s+");
        int count = 0;
        for (String word : words) {
            boolean contains = false;
            for (int i = 0; i < broken.length(); i++) {
                if (word.contains(broken.charAt(i) + "")) {
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                count++;
            }
        }
        return count;
    }


    public static boolean kLengthApart(int[] nums, int k) {
        boolean ans = true;
        int count = 0;
        boolean nowAdd = false;
        ArrayList<Integer> counts = new ArrayList();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                if (nowAdd) {
                    counts.add(count);
                }
                nowAdd = true;
                count = 0;
            }
        }

        for (int i = 0; i < counts.size(); i++) {
            if (counts.get(i) < k) {
                ans = false;
                break;
            }
        }

        return ans;


    }


    public static int findFinalValue(int[] nums, int k) {
        int ans = k;
        boolean check = true;

        while (check) {
            for (int i = 0; i < nums.length; i++) {
                if (ans == nums[i]) {
                    ans = ans * 2;
                    break;
                } else if (i == nums.length - 1) {
                    check = false;
                }
            }
        }

        return ans;


    }

    public static List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList();
        for (int num : nums) {
            if (Integer.parseInt(String.valueOf(num), 2) % 5 == 0) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }

    public static int longestSubs(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // Shrink while duplicate exists
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }


    public static int longestSubWithK(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            Character c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > k) {
                Character lc = s.charAt(left);

                map.put(lc, map.get(lc) - 1);
                if (map.get(lc) == 0) {
                    map.remove(lc);
                }
                left++;
            }
//            map.put(c, map.getOrDefault(c, 0) + 1);

            maxLength = Math.max(maxLength, right - left + 1);

        }

        return maxLength;


    }

    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int n = s.length();

        HashMap<Character, Integer> windowMap = new HashMap<>();
        int required = tMap.size();
        int formed = 0;

        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;


        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            // If frequency in window equals required freq in tMap
            if (tMap.containsKey(c) && windowMap.get(c).intValue() == tMap.get(c).intValue()) {
                formed++;
            }
            while (formed == required) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }
                char lc = s.charAt(left);
                windowMap.put(lc, windowMap.get(lc) - 1);

                // If removing lc breaks the validity
                if (tMap.containsKey(c) && windowMap.get(c).equals(tMap.get(c))) {
                    formed--;
                }
                left++;

            }

        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Remove elements outside the window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove smaller elements from the back
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(i);

            // Start recording max once window reaches size k
            if (i >= k - 1) {
                ans[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return ans;

    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int c = target - nums[i];
            if (map.containsKey(c)) {
                return new int[]{map.get(c), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> check = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (check.contains(nums[i])) {
                return true;
            }
            check.add(nums[i]);
        }
        return false;
    }

    public static List<List<String>> groupBy(String[] s) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : s) {
            char[] words = word.toCharArray();
            Arrays.sort(words);
            String key = new String(words);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());


    }

    public static List<List<String>> groupAnagrams(String[] s) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : s) {
            char[] words = word.toCharArray();
            Arrays.sort(words);
            String key = new String(words);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }

    public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static int maxSubArray(int[] arr) {
        int maxSoFar = arr[0];       // Global maximum
        int currentMax = arr[0];     // Maximum sum ending at current position

        for (int i = 1; i < arr.length; i++) {
            // Either extend the previous subarray or start a new one
            currentMax = Math.max(arr[i], currentMax + arr[i]);

            // Update global maximum if needed
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;

    }

    public static int repeatedNTimes(int[] nums) {
        HashSet set = new HashSet();
        for (int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return nums[i];
            }else{
                set.add(nums[i]);
            }
        }
        return 0;
    }

    public static void moveZeroes(int[] nums) {
        int r;
        int l = 0;

        for(r = 0; r < nums.length ; r++){
            if(nums[r] != 0){
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                l++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public static int maxArea(int[] height) {
        int ans = 1;
        int r,l = 0;
        for(r = 0; r < height.length; r++){

            ans = Math.max(ans, area(Math.min(height[l], height[r]), r-l));
            if(height[l] < height[r]){
                l++;
            }

        }


        return ans;
    }

    public static int area(int a, int b){
        return a*b;
    }

    public static int[] twoSums(int[] arr, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int comp = target - arr[i];
            if(map.containsKey(comp)){
                return new int[]{map.get(comp), i};
            }else {
                map.put(arr[i], i);
            }
        }
        return new int[]{};
    }

    public static int lngSubString(String s){
        int l = 0;
        int ans = 0;
        HashSet<Character> set = new HashSet<>();

        for(int r = 0; r < s.length(); r++){
            while (set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            ans = Math.max(ans, r-l+1);
        }
        return ans;

    }

    // Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    //Output: [[1,6],[8,10],[15,18]]

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            // Overlap condition: current start <= previous end
            if (intervals[i][0] <= prev[1]) {
                // Merge intervals
                prev[1] = Math.max(prev[1], intervals[i][1]);
            } else {
                // No overlap, add previous interval to result
                merged.add(prev);
                prev = intervals[i];
            }
        }

        merged.add(prev); // Add the last interval
        return merged.toArray(new int[merged.size()][]);
    }

    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length() || s.isEmpty()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i = 0; i< s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) +1);
        }
        for(int i = 0; i< t.length(); i++){
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i),0) +1);
        }

        for(char ch : map.keySet()){
            if(!Objects.equals(map2.get(ch), map.get(ch))){
                return false;
            }
        }
        return true;

    }
    public static boolean isAnagrams(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i =0; i < s.length() ; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)-1);
        }

        for(int vl : map.values()){
            if(vl != 0) return false;
        }
        return true;
    }
    boolean containsDuplicates(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
        }
        return true;
    }

}




