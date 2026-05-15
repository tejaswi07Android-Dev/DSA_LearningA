import java.util.*;

public class Scaler {

    public static void main(String[] args) {

//        System.out.println(day3AP6(new int[]{2, 1, 6, 4}));
//        System.out.println(day3AP4(new int[]{-7, 1, 5, 2, -4, 3, 0}));
//        System.out.println(day3Ass3(new int[]{1, 3, 2, 6, 4}, 3, 11));
//        System.out.println(Arrays.toString(day3AP2(new int[]{1,2,3,4,5})));
//        System.out.println(Arrays.toString(day3AP5(new int[]{3, 7, 90, 20, 10, 50, 40}, 6)));


//        System.out.println(Arrays.toString(day4Ass2(5, new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}})));

//        System.out.println(Arrays.deepToString(returnSpiral(5)));
//        System.out.println(Arrays.toString(nextPerm(new int[]{1,3,5,4,2,6,5,4,0})));
//        System.out.println(Arrays.toString(plusOne(new int[]{0,3,2,1})));
//        System.out.println(Arrays.toString(plusOne(new int[]{0,3,2,1})));
//        System.out.println(waterTrapped(new int[]{2,1,3,2,1,2,4,3,2,1,3,1}));
//        System.out.println(waterTrapped(new int[]{4,3,2,1,6,1,8}));
//        System.out.println(Arrays.toString(twoDistinct(new int[]{4,6,1,3,6,4,3,5,5,1,7})));
//        returnSpiral(5);
//        System.out.println(squareSum(5));
//        System.out.println(fun(2,10));
//        System.out.println(isPrime(3));

    }


    /// TC = O(n)
    /// SC = O(1)
    public static int day3Ass3(int[] A, int B, int C) {
        int sum = 0;
        for (int i = 0; i < B; i++) {
            sum += A[i];
        }

        if (sum == C) return 1;
        int s = 0;
        int e = B;

        while (e < A.length) {
            sum = sum + A[e] - A[s];
            if (sum == C) return 1;
            e++;
            s++;
        }
        return 0;
    }

    public static int day3AP1(int[] A, int B) {
        int sum = 0;
        int n = A.length;
        for (int i = 0; i < B; i++) sum += A[i];


        int maxSum = sum;

        for (int i = 1; i <= B; i++) {
            sum = sum - A[B - i] + A[n - i];
            maxSum = Math.max(maxSum, sum);

        }

        return maxSum;

    }

    public static int[] day3AP2(int[] A) {
        int n = A.length;
        int[] result = new int[n];

        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * A[i - 1];
        }

        int right = 1;

        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right *= A[i];
        }

        return result;

    }

    /// TC = O(n)
    /// SC = O(1)
    public static int day3AP3(int[] A, int B) {
        int minIndex = 0;
        int sum = 0;

        for (int i = 0; i < B; i++) sum += A[i];

        int s = 0;
        int e = B;
        int minSum = sum;
        while (e < A.length) {

            sum = sum + A[e] - A[s];

            if (sum < minSum) {
                minSum = sum;
                minIndex = s + 1;
            }

            e++;
            s++;
        }


        return minIndex;
    }

    /// TC = O(n)
    /// SC = O(1)
    public static int day3AP4(int[] A) {
        int sumRight = 0;
        for (int a : A) sumRight += a;

        int leftSum = 0;
        for (int i = 0; i < A.length; i++) {
            sumRight -= A[i];

            if (sumRight == leftSum) return i;

            leftSum += A[i];
        }
        return -1;
    }

    /// TC = O(n)
    /// SC = O(1)
    public static int[] day3AP5(int[] A, int B) {
        int n = A.length;

        reverse(A, 0, n - 1);
        reverse(A, 0, B - 1);
        reverse(A, B, n - 1);

        return A;

    }

    /// TC = O(n)
    /// SC = O(1)
    public static int day3AP6(int[] A) {

        int rightOdd = 0;
        int rightEven = 0;
        int n = A.length;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) rightEven += A[i];
            else rightOdd += A[i];
        }

        int count = 0;
        int leftOdd = 0;
        int leftEven = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) rightEven -= A[i];
            else rightOdd -= A[i];

            int newEven = rightEven + leftOdd;
            int newOdd = rightOdd + leftEven;

            if (newEven == newOdd) count++;

            if (i % 2 == 0) leftEven += A[i];
            else leftOdd += A[i];

        }

        return count;

    }

    public static void reverse(int[] A, int l, int r) {
        while (l < r) {
            int temp = A[l];
            A[l] = A[r];
            A[r] = temp;
            l++;
            r--;
        }
    }

    public static int[] day4Ass2(int A, int[][] B) {

        int[] ans = new int[A];

        for (int i = 0; i < B.length; i++) {
            int s = B[i][0];
            int e = B[i][1];
            int v = B[i][2];
            ans[s] += v;
            if (e + 1 < A) ans[e + 1] -= v;
        }

        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i - 1] + ans[i];
        }
        return ans;
    }


    public static int[][] day4Ass3(int[][] A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();


        int a1 = A[0][0];
        int b1 = A[0][1];

        for (int i = 1; i < A.length; i++) {
            int a2 = A[i][0];
            int b2 = A[i][1];

            if (b1 > a2) {
                b1 = Math.max(b1, b2);
            } else {

                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(a1);
                temp.add(b1);
                ans.add(temp);

                // move to next
                a1 = a2;
                b1 = b2;

            }
        }

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(a1);
        temp.add(b1);
        ans.add(temp);
        int[][] result = new int[ans.size()][2];

        for (int i = 0; i < ans.size(); i++) {
            result[i][0] = ans.get(i).get(0);
            result[i][1] = ans.get(i).get(1);
        }

        return result;
    }


    public static int[][] day4Ass3(int[][] A, int[] B) {
        int n = A.length;
        int[][] arr = new int[n + 1][2];

        int i1 = 0, j = 0;

        // insert while maintaining sorted order
        while (i1 < n && A[i1][0] < B[0]) {
            arr[j++] = A[i1++];
        }

        arr[j++] = B;

        while (i1 < n) {
            arr[j++] = A[i1++];
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int a1 = A[0][0];
        int b1 = A[0][1];

        for (int i = 1; i < A.length; i++) {
            int a2 = A[i][0];
            int b2 = A[i][1];

            if (b1 > a2) {
                b1 = Math.max(b1, b2);
            } else {

                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(a1);
                temp.add(b1);
                ans.add(temp);

                // move to next
                a1 = a2;
                b1 = b2;

            }
        }

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(a1);
        temp.add(b1);
        ans.add(temp);
        int[][] result = new int[ans.size()][2];

        for (int i = 0; i < ans.size(); i++) {
            result[i][0] = ans.get(i).get(0);
            result[i][1] = ans.get(i).get(1);
        }

        return result;
    }


    public static int[][] returnSpiral(int A) {
        int[][] mat = new int[A][A];

        int top = 0, bottom = A - 1;
        int left = 0, right = A - 1;

        int val = 11;

        while (top <= bottom && left <= right) {

            //  top row
            for (int j = left; j <= right; j++) {
                mat[top][j] = val++;
            }
            top++;

            //  right column
            for (int i = top; i <= bottom; i++) {
                mat[i][right] = val++;
            }
            right--;

            //  bottom row
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    mat[bottom][j] = val++;
                }
                bottom--;
            }

            //  left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    mat[i][left] = val++;
                }
                left++;
            }
        }


        for (int[] ints : mat) {
            System.out.println(Arrays.toString(ints));
        }


        return mat;


    }

    public static ArrayList<ArrayList<Integer>> squareSum(int A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        for (int a = 0; a * a < A; a++) {
            for (int b = a; b * b < A; b++) {
                if ((a * a) + (b * b) == A) {
                    ArrayList<Integer> newEntry = new ArrayList<Integer>();
                    newEntry.add(a);
                    newEntry.add(b);
                    ans.add(newEntry);
                }
            }
        }
        return ans;
    }

    public static int[] plusOne(int[] A){
        int n = A.length;

        //  remove leading zeros first
        int start = 0;
        while (start < n && A[start] == 0) start++;

        if (start == n) return new int[]{1};

        int[] arr = new int[n - start];
        System.arraycopy(A, start, arr, 0, arr.length);

        // add one
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < 9) {
                arr[i]++;
                return arr;
            }
            arr[i] = 0;
        }

        // all 9 case
        int[] res = new int[arr.length + 1];
        res[0] = 1;
        return res;
    }



    public static int[] nextPermutation(int[] A){
        int n = A.length;
        int i = n-2;


        // Finding the pivot point -> where we get first smaller number after a greater number from right side <-
        while (i>=0 && A[i] >= A[i+1]){
            i--;
        }


        // Finding next big number for swapping from right side
        if(i>=0){
            int j = n-1;

            while(A[j] <= A[i]){
                j--;
            }

            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }

        int l = i+1, r = n-1;

        // Sorting or reversing remaining
        while (l<r){
            int temp = A[l];
            A[l] = A[r];
            A[r] = temp;
            r--;
            l++;
        }

        return A;
    }


    public static int[] nextPerm(int[] A){
        int n = A.length;
        int i = n-2;

        while(i>=0 && A[i] >= A[i+1]){
            i--;
        }

        if(i>=0){
            int j = n-1;
            while(A[j] <= A[i]){
                j--;
            }

            int temp = A[j];
            A[j] = A[i];
            A[i] = temp;
        }

        int l = i+1, r = n-1;
        while(l<r){
            int temp = A[l];
            A[l] = A[r];
            A[r] = temp;
            l++;
            r--;
        }

        return A;



    }


    public static int waterTrapped(int[] A){
        int ans = 0;
        int n = A.length;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = 0;
        rightMax[n-1] = 0;

        for(int i = 1; i< n-1; i++){
            leftMax[i] = Math.max(leftMax[i-1], A[i-1]);
            rightMax[n-1-i] = Math.max(rightMax[n-i], A[n-i]);
        }

        for (int i = 0; i < n; i++){
            ans += Math.max(0, (Math.min(leftMax[i], rightMax[i])-A[i]));
        }

        return ans;
    }

    public static int[] twoDistinct(int[] A){
        int val = 0;
        for(int a : A) val ^= a;

        int i = 1;
        while((val & i) == 0){
            i = i  << 1;
        }

        int uni1 = 0, uni2 = 0;
        for(int a : A){
            if((a & i) == 0){
                uni1 ^= a;
            }else{
                uni2 ^= a;
            }
        }

        if(uni1 < uni2){
            return new int[]{uni1, uni2};
        }
        return new int[]{uni2, uni1};
    }


    public static int fun(int x, int n){
        if(n==0) return 1;
        else if (n%2==0) return fun(x*x, n/2);
        else return x * fun(x*x, (n-1)/2);
    }

    static int bar(int x, int y){
        if(y==0) return 0;
        return (x+bar(x,y-1));
    }

    static int foo(int x, int y){
        if(y==0) return 1;
        return bar(x, foo(x, y-1));
    }


    public int solve(int A, int[] B) {
        HashSet<Integer> set = new HashSet<>();

        for(int i : B){
            int c = A - i;
            if(set.contains(c)){
                return 1;
            } else{
                set.add(i);
            }
        }
        return 0;
    }

    public int vll(int[] A){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n : A){
            map.put(n , map.getOrDefault(n , 0)+1);
        }
        int ans = 0;
        for(Integer key : map.keySet()){
            if(map.get(key) ==1){
                ans++;
            }
        }

        return ans;
    }

    public static ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<Integer>());

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
    }

    public boolean isPrime(int A) {
        if(A == 1) return false;
        for (int i = 2; i*i <= A; i++) {
            if (i < A && A % i == 0) return false;
        }
        return true;
    }

}
