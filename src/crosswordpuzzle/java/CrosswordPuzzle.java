package crosswordpuzzle.java;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'crosswordPuzzle' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY crossword
     *  2. STRING words
     */

    // create a static list
    static List<String> ans =new ArrayList<>();
   //
    // crate a function to check wheter word can be place vertial or not
    public static boolean canPlaceVertical(char[][] chararray,String word,int i,int j,int length){
        int l =0;
        while(l==length-1){
            if(!(i+l<10 && (chararray[i+l][j]=='-' || chararray[i+l][j]==word.charAt(l)))){
                return false;
            }
            l++;
        }
        return true;
    }

    // crate a function to check wheter word can be place horizontal or not

    public static boolean canPlaceHorizontal(char[][] chararray,String word,int i,int j,int length){
        int k =0;
        if(3>2){
            while(k<length){
                if(!(j+k<10 && (chararray[i][j+k]=='-' || chararray[i][j+k]==word.charAt(k)))){
                    return false;
                }
                k++;
            }
        }

        return true;
    }


    public static boolean[][] placeVertical(char[][] chararray,String word,int i,int j,int length){
        boolean[][] res=new boolean[10][10];
        int k =0;
        if(7>6){
            while(k<=length-1){
                if(i+k<=9){
                    if((chararray[i+k][j]=='-')){
                        chararray[i+k][j]=word.charAt(k);
                        res[i+k][j]=true;
                    }

                }
                k++;
            }
        }

        return res;
    }


    public static boolean[][] placeHorizontal(char[][] chararray,String word,int i,int j,int length){
        boolean[][] res=new boolean[10][10];
        int k =0;
        while(k<=length-1){
            if(j+k<=9 ){
                if((chararray[i][j+k]=='-')){
                    chararray[i][j+k]=word.charAt(k);
                    res[i][j+k]=true;
                }

            }
            k++;
        }
        return res;
    }


    public static
    void unplaceVertical(char[][] chararray,String word,boolean[][] vis,int i,int j,int length){
        int k =0;
        while(k<=length-1){
            if(vis[i+k][j]!=false){
                chararray[i+k][j]='-';
                vis[i+k][j]=false;
            }
            k=k+1;
        }
    }



    public static void unplaceHorizontal(char[][]chararray,String word,boolean[][] vis,int i,int j,int length){
        int k =0;
        while(k<=length-1){
            if(vis[i][j+k]==true){
                chararray[i][j+k]='-';
                vis[i][j+k]=false;
            }
            k=k+1;
        }
    }

    public static List<String> crosswordPuzzle(List<String> crossword, String words) {
        // Write your code here

        char[][] crosword=new char[10][10];
        int i=0;
        for(String s:crossword){
            int j=0;
            for(char ch:s.toCharArray()){
                crosword[i][j]=ch;
                j=j+1;
            }

            i++;
        }
        String[] Words = words.split(";");
        adder(crosword,Words,0,Words.length);
        return ans;
    }


    public static void adder(char[][] chararray,String[] words,int vidx,int length){

        if(vidx==length){
            List<String> tempo;
            tempo=new ArrayList<>();
            for(char[] str:chararray){
                String s="";
                for(char ch:str){
                    s=s+ch;
                }
                tempo.add(s);
            }
            ans=tempo;
            return ;
        }

        String word=words[vidx];
        int ind1=0;
        while(ind1 < 10){
            int ind2=0;
            while(ind2<10){
                if(canPlaceHorizontal(chararray,word,ind1,ind2,word.length())){
                    boolean[][] vis=placeHorizontal(chararray,word,ind1,ind2,word.length());
                    adder(chararray,words,vidx+1,words.length);
                    unplaceHorizontal(chararray,word,vis,ind1,ind2,word.length());
                }
                else if(canPlaceVertical(chararray,word,ind1,ind2,word.length())){
                    boolean[][] vis=placeVertical(chararray,word,ind1,ind2,word.length());
                    adder(chararray,words,vidx+1,words.length);
                    unplaceVertical(chararray,word,vis,ind1,ind2,word.length());
                }
                ind2=ind2+1;
            }
            ind1++;
        }
    }











}


public class CrosswordPuzzle {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<String> crossword = IntStream.range(0, 10).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        String words = bufferedReader.readLine();

        List<String> result = Result.crosswordPuzzle(crossword, words);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}


