package Stonrdivision;
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
     * Complete the 'stoneDivision' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. LONG_INTEGER n
     *  2. LONG_INTEGER_ARRAY s
     */


    public static int findingCounts(long n, List<Long> s,HashMap<Long, Integer> hashmap){
        if (n==0||n==1) return 0;




            // check the value is already in hashmap or not
        else if (hashmap.containsKey(n)) return hashmap.get(n);



        int maxCounts=0;




        for (int i = 0; i < s.size(); i++){
            int counts=0;

            if(n<=s.get(i)) break; // base case



            if(n!=s.get(i) && n%s.get(i)==0){
                counts+=findingCounts(n/s.get(i),s,hashmap)*(n/(long)s.get(i))+1; // do the recursion
            }

            if(maxCounts<counts) maxCounts=counts; // get the max moves



        }

        hashmap.put(n,maxCounts);

        return maxCounts;



    }













    public static String stoneDivision(long n, List<Long> s) {
        // Write your code here

        Collections.sort(s);
        HashMap<Long, Integer> hashmap = new HashMap<Long, Integer>();


        int counts = findingCounts(n, s, hashmap);

        if(counts % 2 == 0){
            return "Second";
        }
        else{
            return "First";
        }



    }

}

public class StoneDivision  {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        long n = Long.parseLong(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Long> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        String result = Result.stoneDivision(n, s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


