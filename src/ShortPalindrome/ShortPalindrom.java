package ShortPalindrome;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;


public class ShortPalindrom  {

    public static void main(String[] args) {
        final int CONST = 1000000000+7;
             final int LENGTH = 26;
             int answer = 0;
            Scanner ui = new Scanner(System.in);
            String string = ui.next();
            int[] frequency = new int[LENGTH];
            int[][] pairfrequency = new int[LENGTH][LENGTH];
            int[] tripfrequency = new int[LENGTH];


        for(char ch: string .toCharArray()){

            answer = (answer+tripfrequency[ch-'a'])%CONST;
            for(int i=0; i<LENGTH; i++){
                tripfrequency[i] = (tripfrequency[i] + pairfrequency[i][ch-'a'])%CONST;
            }
            for(int i=0; i<LENGTH; i++){
                pairfrequency[i][ch-'a'] = (pairfrequency[i][ch-'a'] + frequency[i])%CONST;
            }
            frequency[ch-'a']++;
        }
        System.out.println(answer);
    }
}


