package google;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.*;
import java.util.HashMap;
import java.lang.Math;
class ada {
    public static void main(String[] args) {
        Scanner ui=new Scanner (System.in);
        int laps=0;
        int testcases=ui.nextInt();
        int arr[]=new int[testcases];

        for(int i=0;i<testcases;i++){
            int length=ui.nextInt();
            int ntimes=ui.nextInt();
            ui.nextLine();
            laps=0;
            int count = 0;
            for(int k=0;k<ntimes;k++){
                int dis=ui.nextInt();
                char dir=ui.next().charAt(0);
               ui.nextLine();

                if(dir=='A'){
                    count=count-dis;
                }
                else{
                    count=count+dis;
                }
                if (Math.abs(count)>length){

                    if(count>0){
                        laps=(count/length)+laps;
                        count =(count%length);
                        //System.out.println(count);
                    }
                    else{
                        laps=Math.abs(count/length)+laps;
                        count =count%length;
                    }

                }

            }
            arr[i]=laps;


        }
        for(int i=0;i<testcases;i++){
            System.out.println(arr[i]);
        }
    }
}
