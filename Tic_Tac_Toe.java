import java.util.Scanner;

public class Tic_Tac_Toe {
    public static void main(String[] args){
        char[][] board = new char[3][3];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                board[i][j] = ' ';
            }
        }

        char player = 'x';
//        boolean isGameOver = false; no need as it will be always false
        Scanner sc  = new Scanner(System.in);
        while(true){
            printBoard(board);
            System.out.println("current player is " + player);
            int row = sc.nextInt();
            int col = sc.nextInt();

            if(!isValidMove(row,col,board)){
                System.out.println("Invalid Move. Try Again");
                continue;
            }

            board[row][col] = player;

            if(isWinner(board,player)){
                printBoard(board);
                System.out.println(player + " wins!!!");
                break;
            }

            if(isFull(board)){
                printBoard(board);
                System.out.println("It's a Draw");
                break;
            }

            player = (player == 'x') ? 'o' : 'x';
        }

    }

    public static void printBoard(char[][] board){

        System.out.println("-------------");
        for(int i=0; i<board.length; i++){
            System.out.print("| ");
            for(int j=0; j<board[i].length; j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.println("\n-------------");
        }

    }

    public static boolean isValidMove(int row, int col,char[][] board){

        return (row>=0 && row<3) && (col>=0 && col<3) && board[row][col] == ' ';

    }

    public static boolean isWinner(char[][] board, char symbol){

        for(int i=0; i<3; i++){
            if((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                    (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)){
                return true;
            }
        }

        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    public static Boolean isFull(char[][] board){

        for(char[] row : board){
            for(char c: row){
                if(c == ' '){
                    return false;
                }
            }
        }
        return true;
    }

}
