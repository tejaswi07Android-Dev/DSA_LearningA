import java.util.*;

public class NQueens {
    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }
    public static boolean isSafe(int row, int col, char[][] board){
        for(int j = 0; j< board.length; j++){
            if(board[row][j] == 'Q'){
                return false;
            }
        }

        for(int i = 0; i<board[0].length; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        int r = row;
        for(int c = col; c>=0 && r>=0; c--, r--){
            if(board[r][c]== 'Q'){
                return false;
            }
        }

        r = row;
        for(int c = col; c<board.length && r>=0; r--, c++){
            if(board[r][c]== 'Q'){
                return false;
            }
        }

        r = row;
        for(int c = col; r<board.length && c>=0; c--, r++){
            if(board[r][c]== 'Q'){
                return false;
            }
        }

        r = row;
        for(int c = col; r<board.length && c<board.length; c++, r++){
            if(board[r][c]== 'Q'){
                return false;
            }
        }

        return true;


    }

    public static void saveBoard(char[][] board, List<List<String>> allBoards){
        StringBuilder row;
        List<String> brd = new ArrayList<>();

        for(int i =0; i<board.length; i++){
            row = new StringBuilder();
            for(int j =0; j<board[0].length; j++){
                if(board[i][j] == 'Q'){
                    row.append('Q');
                }else{
                    row.append('.');
                }
            }
            brd.add(row.toString());
        }
        allBoards.add(brd);
    }

    public static void helper(char[][] board, List<List<String>> allBoards, int col){
        if(col == board.length){
            saveBoard(board, allBoards);
            return;
        }

        for(int row = 0; row<board.length; row++){
            if(isSafe(row, col, board)){
                board[row][col] = 'Q';
                helper(board, allBoards, col+1);
                board[row][col] = '.';
            }
        }
    }

    public static int totalNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];

        helper(board, allBoards, 0);
        System.out.println(allBoards);
        return allBoards.size();
    }
}