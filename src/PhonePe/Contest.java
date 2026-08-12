package PhonePe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Contest {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '0', '1'},
                {'1', '1', '1', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'1', '0', '0', '1', '1'}
        };

//        System.out.println(numberOfIsland(grid));

        System.out.println(Arrays.toString(twoSum(new int[]{1, 6, 3, 4, 2}, 8)));

    }

    public static int numberOfIsland(char[][] grid){
        if(grid == null || grid.length == 0){
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;

        int count =0;

        for(int i = 0; i< row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    public static void dfs(char[][] grid, int row, int col){
        if(row < 0 || row >= grid.length ||
           col < 0 || col >= grid[0].length||
            grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0';

        dfs(grid, row-1, col);
        dfs(grid, row+1, col);
        dfs(grid, row, col-1);
        dfs(grid, row, col+1);
    }

    public static int[] twoSum(int[] nums, int target){
        if(nums.length <= 1) return new int[]{-1, -1};

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int comp = target - nums[i];
            if(map.containsKey(comp)){
                return new int[]{map.get(comp), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 1;

        for(int num: nums){
            if (!set.contains(num - 1)) {

                int current = num;
                int length = 1;

                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }

        }
        return longest;
    }

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;
        int longest = 0;
        while(right < s.length()){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            int len = right - left +1;

            longest = Math.max(len, longest);

            right++;
        }

        return longest;
    }
}

