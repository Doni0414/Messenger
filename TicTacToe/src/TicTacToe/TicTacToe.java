package TicTacToe;

import java.util.Scanner;

public class TicTacToe implements Game{
    private Scanner scanner;
    private char[][] grid;
    private final static char X_TOKEN = 'X';
    private final static char O_TOKEN = 'O';
    private final static String X_WON = "X has won";
    private final static String O_WON = "O has won";

    @Override
    public void start(){
        scanner = new Scanner(System.in);
        grid = new char[3][3];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++){
                grid[i][j] = '.';
            }
        }
        int count = 0;
        int order = 0;
        String result = "";

        while(count < 9){
            String playerOrder = "";
            if (order==0){
                playerOrder = "First player X";
            }else {
                playerOrder = "Second player O";
            }
            printGrid();
            System.out.println("Now it's turn of " + playerOrder);
            System.out.print("Enter your move: ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            while (x < 0 || x >= 3 || y < 0 || y >= 3 || (x >= 0 && x < 3 && y >= 0 && y < 3 && grid[x][y]!='.')){
                System.out.print("Invalid input. Please enter your correct move: ");
                x = scanner.nextInt();
                y = scanner.nextInt();
            }
            System.out.println();
            grid[x][y] = (order == 0 ? X_TOKEN : O_TOKEN);
            count++;
            order^=1;

           result = check();

            if (!result.isEmpty()){
                break;
            }else if(count == 9){
                result = "Draw";
                break;
            }
        }
        System.out.println("Result: " + result);
    }
    private String check(){
        for (int i = 0; i < grid.length; i++){
            if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] != '.'){
                if (grid[i][0] == 'X'){
                    return X_WON;
                }else{
                    return O_WON;
                }
            }
        }
        for (int i = 0; i < grid.length; i++){
            if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]  && grid[0][i] != '.'){
                if (grid[0][i] == 'X'){
                    return X_WON;
                }else{
                    return O_WON;
                }
            }
        }
        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != '.'){
            if (grid[0][0] == 'X'){
                return X_WON;
            }else{
                return O_WON;
            }
        }
        if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] != '.'){
            if (grid[0][2] == 'X'){
                return X_WON;
            }else{
                return O_WON;
            }
        }
        return "";
    }
    private void printGrid(){
        for (char[] row: grid){
            for (char x: row)
                System.out.print(x + " ");
            System.out.println();
        }
    } 
}
