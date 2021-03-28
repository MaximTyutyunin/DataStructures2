package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Chess {
    static int counterOfHappy = 0;
    public static void main(String[] args) {

        int [] board = {-1,-1,-1,-1};
       // Integer[] board = {0,4,7,5,2,6,1,3};
        System.out.println(doesHit(board));
        placeQuins(board,0);
        System.out.println(counterOfHappy);
    }

    private static void placeQuins(int[] array, int columnAndQuinNumber){

        for(int i = 0 ; i <= array.length-1; i++){
            array[columnAndQuinNumber] = i;
            if(doesHit(array)){
                array[columnAndQuinNumber] = -1;
                continue;
            }else{
                if(columnAndQuinNumber == array.length-1) {// base case
                    counterOfHappy++;
                    array[columnAndQuinNumber] = -1;
                    continue;
                }
                placeQuins(array, columnAndQuinNumber+1);
            }
        }
        array[columnAndQuinNumber] = -1;
    }

    private static boolean doesHit(int[] board) {
        int x = 0, y =0;
        int width = 0, height = 0;
        /*внешний цикл получает координаты первой точки,
        а затем внутренний цикл получает координаты другой точки.
        Первое «if» сохраняет первые координаты в «x, y»,
        а второе «if» возвращает истину, если есть столкновение ферзей.*/
        for(int i = 0; i < board.length; i++){
            if( board[i] != -1){
                x = i;
                y = board[i];
                for(int j = 0; j < i; j++){
                    if (y == board[j]) return true;
                    if( board[j] != -1) {
                        width = Math.abs(j - x);
                        height = Math.abs(board[j] - y);
                        if(width == height) return true;
                    }
                }
            }
        }

        return false;
    }
}
