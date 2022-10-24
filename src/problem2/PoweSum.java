package problem2;
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
     * Complete the 'powerSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER X
     *  2. INTEGER N
     */

    public static int powerSum(int X, int N) {

        // Complete this function
        return calc(X,N,1);// call the function snd return the value

    }

    static int calc(int x, int power, int counter) {
        //take the pwer of present counter and assign as variable reference as value
        int value= (int) Math.pow(counter,power);
        //if value same x then  one return one
        if (value == x) {
            return 1;
        }
        //if value greater than x stop the function and returnn 0
        else if (value > x) {
            return 0;
        }
        // call as recursiion to get  return an integer that represents the number of possible combinations.
        else {
            return (calc(x,power,counter+1) + calc(x-value,power,counter+1));
        }
    }

}

public class PoweSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int X = Integer.parseInt(bufferedReader.readLine().trim());

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.powerSum(X, N);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

