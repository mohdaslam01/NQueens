class Solution {
    public List<List<String>> solveNQueens(int n) {
        //creating board of input of n * n 
        //if 0 is n, then board size is too 0 leading to 0
        //ex ..2 if n is 2, the board is of 2 x 2 simillary for 8 queens that is n is 8 ,the board is 8 x 8
        char board[][]=new char[n][n];
        for (char[] board1 : board) {
            for (int j = 0; j<board.length; j++) {
                board1[j] = '.';
            }
        }
        List<List<String>> string2DList = new ArrayList<>();
        queen(board, 0, string2DList);
        return string2DList;
    }
    static void queen(char[][] board, int initialRow, List<List<String>> rowList){
        if(board.length==initialRow){
            rowList.add(construct(board));
            return;
        }
        for(int i=0; i<board.length; i++){
            if(isAccept(board, initialRow, i)){
                board[initialRow][i]='Q';
                queen(board, initialRow+1, rowList);
                board[initialRow][i]='.';
            }
        }
    }
    static List<String> construct(char board[][]){
        List<String> internal=new ArrayList<>();
        for (char[] board1 : board) {
            String row = new String(board1);
            internal.add(row);
        }

        return internal;
    }
    static boolean isAccept(char[][] board, int initialRow, int column){
        for(int i=0; i<initialRow;i++){
            if(board[i][column]!='Q'){
            } else {
                return false;
            }
        }
        for(int i=1; i<=((column>=initialRow)?initialRow:column); i++){
            if(board[initialRow-i][column-i]=='Q')
                return false;
        }
        for(int i=1; i<=((initialRow<board.length-1-column)?initialRow:board.length-1-column); i++){
            if(board[initialRow-i][column+i]=='Q')
                return false;
        }
        return true;
    }
}









/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication50;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Aslam
 */
public class JavaApplication50 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Solution s=new Solution();
        List<List<String>> solarr = s.solveNQueens(7);
        System.out.println(solarr);
        System.out.println();
    }
    
}
