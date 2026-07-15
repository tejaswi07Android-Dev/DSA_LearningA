import java.util.ArrayList;

public class BackTracking {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        ArrayList<Integer> set = new ArrayList<>();
//        subset(0, set, arr);

        StringBuilder curr = new StringBuilder();
//        generateBinary(0, 3, curr);

        String s = "abc";
        subsequence(0, s, curr);
    }


    public static void subset(int i, ArrayList<Integer> set, ArrayList<Integer> arr){
        if(i == arr.size()){
            System.out.println(set);
            return;
        }

        // case 1 <- Include
        set.add(arr.get(i));
        subset(i+1, set, arr);
        set.removeLast();  // <- BackTracking

        // case 2  <- Exclude
        subset(i+1, set, arr);
    }

    public static void generateBinary(int idx, int n, StringBuilder curr){


        // Base Case
        if(idx == n){
            System.out.println(curr);
            return;
        }

        // Choose 0
        curr.append("0");
        generateBinary(idx+1, n, curr);
        curr.deleteCharAt(curr.length() -1);


        // Choose 1

        curr.append("1");
        generateBinary(idx+1, n, curr);
        curr.deleteCharAt(curr.length() -1);
    }



    public static void subsequence(int idx, String s, StringBuilder curr){

        // Base Case
        if(idx == s.length()){
            System.out.print(curr);
            System.out.print(" -> ");
            return;
        }
        // Include
        curr.append(s.charAt(idx));
        subsequence(idx +1, s, curr);
        curr.deleteCharAt(curr.length() -1);

        subsequence(idx +1, s, curr);

    }


}
