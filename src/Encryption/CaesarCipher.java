package Encryption;
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
import java.lang.Math;

class Result {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k)  {
        // Write your code here
        //Use the Split method and store the array of Strings returned in a String array.
        k=k%26;
        char[] arr = new char[s.length()];

        // Copying character by character into array
        // using for each loop
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }

        for(int i=0;i<arr.length;i++){

            //only change the alphabets otherwise continue  arr [i]>96&&arr[i]<123 small alphabets arr [i]>64&&arr[i]<91 big alphabets
            if((arr [i]>96&&arr[i]<123)  || (arr [i]>64&&arr[i]<91)){

                //value means rotating value
                int value=arr[i]+k;
                // value greater than 122 we have to do some opeation to return small alphabets abcd because for example z=122 but z+2=124 this is not b
                if(value>122){
                    arr[i]=(char)(value-26);//opeation to over 122
                }


                else  if((arr [i]<91) && (arr [i]+k>90)){
                    arr[i]=(char)(value-26);// some time capital letters take too value so we have to make return
                }
                else{
                    arr[i] =(char)(value); //otherwise it takes rotate value as arr i
                }


            }

        }
        String string1 = new String(); // create a string
        String string2 = string1.valueOf(arr);   // make char array as string
        return string2;

    }


}

public class CaesarCipher {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


