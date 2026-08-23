package google;

public class LevelUpHome {
    public static void main(String[] args) {
        System.out.println(solve("abcde", "aceb"));
    }

    public static int numDecodings(String A) {
        if(A.isEmpty() || A.charAt(0) == '0') return 0;
        int n = A.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;


        for(int i = 2; i <= n; i++){
            if(A.charAt(i-1) != '0'){
                dp[i] += dp[i-1];
            }

            int ch = (A.charAt(i-2) - '0') * 10 + (A.charAt(i-1) - '0');
            if(10 <= ch && ch <= 26){
               dp[i] += dp[i-2];
            }


        }

        return dp[n];
    }


    public static int solve(String A, String B) {
        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(A.charAt(i-1) == B.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];

    }

}
