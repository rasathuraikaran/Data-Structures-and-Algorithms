package LillysHomework;

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
     * Complete the 'lilysHomework' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int lilysHomework(List<Integer> arr) {
        // Write your code here

        // we are going to find two ways  one is assending one and desending one

        // create a listone
        List<Integer> list1 = new ArrayList<>(arr);
        //crea a list2
        List<Integer> list2 = new ArrayList<>(arr);

        // create a hashmap to hold a key as asssending list1 value and  normal index of arr
        Map<Integer, Integer> hashmap1 = new HashMap<>();

        // create a hashmap to hold a key as desending  list2 value and  normal index of arr

        Map<Integer, Integer> hashmap2 = new HashMap<>();



        // follwing steps belongs to assending order
        Collections.sort(list1); // sort the list  as assending order
        int count1 = 0;
        //insert a key and values key as arr get(i) and value as i
        for(int i=0;i<arr.size();i++){
            hashmap1.put(arr.get(i),i);
        }
        for(int i=0;i<list1.size();i++){
            //the elemnt in assending order check the arr in correct position if not then go to if condition
            if(arr.get(i)!=list1.get(i)){
                //swap the value  as well as in arr
                Integer temp = arr.get(i);
                arr.set(i,arr.get(hashmap1.get(list1.get(i))));
                arr.set(hashmap1.get(list1.get(i)),temp);
                hashmap1.put(temp,hashmap1.get(list1.get(i)));

                // increamnet the count
                count1++;
            }
        }

        int count2 = 0;
        Collections.sort(list1,Collections.reverseOrder());// sort the list  as dessending  order
        //insert a key and values key as arr get(i) and value as i
        for(int i=0;i<arr.size();i++){
            hashmap2.put(list2.get(i),i);
        }
        for(int i=0;i<list1.size();i++){
            //the elemnt in desending  order check the arr in correct position if not then go to if condition

            if(list2.get(i)!=list1.get(i)){
                //swap the value  as well as in arr
                Integer temp = list2.get(i);
                list2.set(i,list2.get(hashmap1.get(list1.get(i))));
                list2.set(hashmap2.get(list1.get(i)),temp);
                hashmap2.put(temp,hashmap2.get(list1.get(i)));
                // increamnet the count
                count2++;
            }
        }
        // return whether count 1 or count2 is minimum
        return Math.min(count1,count2);


    }


}

public class LillyHomeWork {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
