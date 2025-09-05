import java.util.Scanner;
public class TicTacToe{
    public static void main(String []a){
        char[][] board = new char[3][3];

        for(int row = 0;row<board.length;row++){
            for(int col =0 ; col < board[0].length;col++){
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);
        boolean[][] winningCells = new boolean[3][3];

        while(!gameOver){
            printBoard(board, winningCells);
            System.out.println("Player"+ " " + player +" " + " enter row and column(0-2) : ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            //check valid input 
            if(row < 0 || row >= 3 || col<0 || col >= 3){
                System.out.println("Invalid position . Try again !");
                continue;
            }

            if(board[row][col]== ' '){
                board[row][col] = player;
                gameOver= haveWon(board,player, winningCells);

                if(gameOver){
                    printBoard(board,winningCells);
                    System.out.println("🎉 Player " + player + " has won!");
                }
            else if(isDraw(board)){
                    printBoard(board, winningCells);
                    System.out.println("It's a Draw !");
                    gameOver = true;
                }
                else{
                    if(player=='X'){
                        player = 'O';
                        }
                        else{
                            player = 'X';
                        }
                    }
                }
            else{
                System.out.println("Invalid move . Try again !");
            }
        }
       // printBoard(board);
    }
    public static boolean haveWon(char[][]board, char player,boolean[][]win){
        //check rows
        for(int row = 0;row < board.length;row++){
            if(board[row][0] == player && board[row][1]== player && board[row][2]==player){
                win[row][0] = win[row][1] = win[row][2] = true;
                return true;
            }
        }

        //check columns
        for(int col = 0;col < board[0].length;col++){
            if(board[0][col]==player && board[1][col]==player && board[2][col]==player){
                win[0][col] = win[1][col] = win[2][col] = true;
                return true;
            }
        }

        //check diagonal 
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
            win[0][2] = win[1][1] = win[2][0] = true; 
            return true;
        }
        if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
            win[0][2] = win[1][1] = win[2][0] = true;
            return true;
        }
        return false;
    }

    //Draw 
    public static boolean isDraw(char[][] board) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
   
    public static void printBoard(char[][]board, boolean[][]win){
        System.out.println("----------------");
        for(int row = 0 ;row < board.length;row++){
            System.out.print("| ");
            for(int col = 0 ; col < board[0].length;col++){
                if (win[row][col]) {
                    System.out.print("[" + board[row][col] + "]|"); // highlight winning cells
                } else {
                    System.out.print(" " + board[row][col] + " | ");
                }
                
            }
            System.out.println();
            System.out.println("----------------");
        }
    }
        
}