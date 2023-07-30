package com.company;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] grid = new char[3][3];
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
            for (int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    System.out.print(grid[i][j]+" ");
                }
                System.out.println();
            }
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
            grid[x][y] = (order == 0 ? 'X' : 'O');
            count++;
            order^=1;

            for (int i = 0; i < grid.length; i++){
                if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] != '.'){
                    if (grid[i][0] == 'X'){
                        result = "X has won";
                    }else{
                        result = "O has won";
                    }
                    break;
                }
            }
            for (int i = 0; i < grid.length; i++){
                if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]  && grid[0][i] != '.'){
                    if (grid[0][i] == 'X'){
                        result = "X has won";
                    }else{
                        result = "O has won";
                    }
                    break;
                }
            }
            if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != '.'){
                if (grid[0][0] == 'X'){
                    result = "X has won";
                }else{
                    result = "O has won";
                }
                break;
            }
            if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] != '.'){
                if (grid[0][2] == 'X'){
                    result = "X has won";
                }else{
                    result = "O has won";
                }
                break;
            }

            if (!result.isEmpty()){
                break;
            }else if(count == 9){
                result = "Draw";
                break;
            }
        }
        System.out.println("Result: " + result);
    }
}
