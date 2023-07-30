package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] grid = new int[9][9]; //sudoku grid
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                grid[i][j] = scanner.nextInt();
        System.out.println(validSudoku(grid));
    }
    public static boolean validSudoku(int[][] grid){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0)
                    continue;
                if (!checkColumn(grid, grid[i][j], j)
                        || !checkRow(grid, grid[i][j], i)
                        || !checkBox(grid, grid[i][j], i, j))
                    return false;
            }
        }
        return true;
    }
    //checkColumn checks how many times occurs key in the given column
    //if it occurs 2 times then current sudoku is invalid
    public static boolean checkColumn(int[][] grid, int key, int column){
        int count = 0;
        for (int i = 0; i < grid.length; i++)
            if (key == grid[i][column])
                count++;
        return count == 1;
    }
    //checkRow checks how many times occurs key in the given row
    //if it occurs 2 times then current sudoku is invalid
    public static boolean checkRow(int[][] grid, int key, int row){
        int count = 0;
        for (int i = 0; i < grid.length; i++)
            if (key == grid[row][i])
                count++;
        return count == 1;
    }
    //checkBox checks how many times occurs key in its box
    //if it occurs 2 times then current sudoku is invalid
    public static boolean checkBox(int[][] grid, int key, int row, int column){
        int count = 0;
        int startRow = (row / 3) * 3, startColumn = (column / 3) * 3;
        int endRow = startRow + 3, endColumn = startColumn + 3;
        for (int i = startRow; i < endRow; i++)
            for (int j = startColumn; j < endColumn; j++)
                if (grid[i][j] == key)
                    count++;
        return count == 1;
    }
}

