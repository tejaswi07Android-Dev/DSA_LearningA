import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.HashSet;

public class HardPrepHome {
    public static void main(String[] args) {
        System.out.println(longestSubString("pwwkew"));

    }


    public static int longestSubString(String s){
        int length;
        int maxLength = 0;
        HashSet<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        while (r < s.length()){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }

            set.add(s.charAt(r));

            length = r-l+1;
            maxLength = Math.max(length, maxLength);
            r++;
        }
        return maxLength;
    }


    public static boolean isBalanced(TreeNode Head){
        return true;
    }
}
