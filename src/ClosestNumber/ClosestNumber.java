package ClosestNumber;

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
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
        Collections.sort(arr);
        int minidifference=arr.get(1)-arr.get(0);
        List<Integer> newarr=new ArrayList<Integer>();
        for(int i=2;i<arr.size();i++){
            if(minidifference>arr.get(i)-arr.get(i-1))minidifference=arr.get(i)-arr.get(i-1);
        }

        for(int i=1;i<arr.size();i++){
            if(minidifference==arr.get(i)-arr.get(i-1)){
                newarr.add(arr.get(i-1)) ;
                newarr.add(arr.get(i)) ;
            }
        }
        return newarr;
        // Write your code here

    }

}

public class ClosestNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.closestNumbers(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

