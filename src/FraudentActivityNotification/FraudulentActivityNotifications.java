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
        int count_of_notifications=0;
        int[] frequncy_arr=new int[201];

        for(int i=0;i<d;i++){
            //Get the frequency of each number
            frequncy_arr[expenditure.get(i)]=frequncy_arr[expenditure.get(i)]+1;
        }

        int[] sub_arr=new int[d];
        for(int start_index=d;start_index<expenditure.size();start_index++){
            int index_of_subarr=0;
            for(int i=0;i<201;i++){
                int frequncy=frequncy_arr[i];
                while(frequncy>0){
                    //get the array which store the current values which use to find median
                    sub_arr[index_of_subarr]=i;
                    frequncy--;
                    index_of_subarr++;
                }
            }

            int expenditure_of_day=expenditure.get(start_index);
            double median=findMedian(sub_arr);
            if(expenditure_of_day>=2*median){   //get the count of notifications
                count_of_notifications++;
            }

            frequncy_arr[expenditure.get(start_index-d)]--;
            frequncy_arr[expenditure.get(start_index)]++;
        }
        return count_of_notifications;
    }

    public static double findMedian(int[] sub_arr){
        int size=sub_arr.length;
        if(size%2==0){
            return (sub_arr[size/2]+sub_arr[(size/2)-1])/2.0;
        }
        else{
            return sub_arr[size/2];
        }

    }

}
public class  FraudulentActivityNotifications  {
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



