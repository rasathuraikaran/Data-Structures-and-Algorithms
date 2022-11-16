package FraudentActivityNotification;

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
     * Complete the 'activityNotifications' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY expenditure
     *  2. INTEGER d
     */

    public static int activityNotifications(List<Integer> expenditure, int d) {
        // Write your code here
        int notifications=0;


        //Store the count of each element at their respective index in count array so create frequencyArray
        int[] frequncyArray=new int[500];
/*

The counting sort algorithm sorts array elements by counting the number of occurrences of each unique element in the array. The count is saved in an auxiliary array, and sorting is accomplished by mapping the count to an index in the auxiliary array.



*/

        // Store cumulative sum of the elements of the count array. It helps in placing the elements into the correct index of the sorted array
        for(int i=0;i<d;i++){
            //Get the frequency of each number
            frequncyArray[expenditure.get(i)]=frequncyArray[expenditure.get(i)]+1;
        }



        // create a sub array to hold the elements as values of d
        int[] subArray=new int[d];

        //iterating to rest of elements
        for(int startIndex=d;startIndex<expenditure.size();startIndex++){
            //set the index of subarray as 0
            int indexOfSubArray=0;

            for(int i=0;i<500;i++){
                //get the value of frequency as i th position of frequncy
                //so you can get the assending one elemnet
                int frequncy=frequncyArray[i];

                //
                while(frequncy>0){
                    //frquncy basicallly if one time elemnt comes frequncy =1
                    subArray[indexOfSubArray]=i; // set the value in in subarray position and the value  here i is original value
                    frequncy--;
                    indexOfSubArray++; //increase the index sub array
                }
            }

            int expendi=expenditure.get(startIndex); //  get the expenditure value of the next elemnet of current sub array
            double median=getMedian(subArray); // find the median
            if(expendi>=2*median){   //get the count of notifications
                notifications++;
            }
            frequncyArray[expenditure.get(startIndex)]++;  // then same procedure to frequncy of elemnt
            frequncyArray[expenditure.get(startIndex-d)]--;

        }
        return notifications;
    }



    // method for getting mediun
    public static double getMedian(int[] subArray){
        int size=subArray.length;
        if(size%2!=0){
            return subArray[size/2];
        }
        else{
            return (subArray[size/2]+subArray[(size/2)-1])/2.0;

        }
    }

}

public class FradulentActivityNotifications {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
