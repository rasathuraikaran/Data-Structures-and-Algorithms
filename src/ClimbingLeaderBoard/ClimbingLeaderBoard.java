package ClimbingLeaderBoard;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.HashMap;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {



        // Write your code here
        List<Integer> output = new ArrayList<>(); // set

        Set<Integer> hashset = new HashSet<>(ranked); // input ranked to output as hasset (set)

        ranked = new ArrayList<>(hashset);//make a uniq arraylist

        Collections.sort(ranked); //sort the array
        int lowest=ranked.size()+1;
        int rank=0;
        for(int i=0;i<player.size();i++){

            for(;rank < ranked.size(); rank++){
                if(player.get(i)<ranked.get(rank))
                    break;


            }

            output.add(lowest-rank);
        }
        return output;









  /* HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        List<Integer> output=new ArrayList<>();
        int j=2;
          hashmap.put(1,ranked.get(0));
        for(int i=1;i<ranked.size();i++){
            if(ranked.get(i)==ranked.get(i-1)) continue;
            else    {hashmap.put(j,ranked.get(i));
                    j++;}

        }
        System.out.println(hashmap);

         for(int i=0;i<player.size();i++){
           for (int k=1;k<=hashmap.size();k++){

               if(player.get(i)>=hashmap.get(k)){
                         output.add(k);
                   break;


               }
               if(player.get(i)<hashmap.get(hashmap.size())){
                      output.add(hashmap.size()+1);
                   break;
               }
           }

        }

            return output;*/
    }








}

public class ClimbingLeaderBoard  {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}


