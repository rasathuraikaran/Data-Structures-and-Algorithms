
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;


/**
 * Simple sorting algorithms and their performance
 * Reg:E/18/168
 * Karan R
 */

public class Sort {



    //create an array of given size and populate it with random data
    static int [] create_rand_data(int size_of_array) {
        int [] data = new int[size_of_array];
        int i;
        for(i=0; i < data.length; i++)
            data[i] = (int)(Math.random() * 100);
        return data;
    }

    //create an array of given size and populate it with worst data arrangement
    static int [] create_worst_data(int size_of_array) {
        int [] data = new int[size_of_array];
        int i;
        for(i=0; i < data.length; i++)
            data[i] = data.length - i;
        return data;
    }

    //create an array of given size and populate it with best data arrangement
    static int [] create_best_data(int size_of_array) {
        int [] data = new int[size_of_array];
        int i;
        for(i=0; i < data.length; i++)
            data[i] = i;
        return data;
    }

    // function to swap. Would be useful since all need this
    static void swap(int []d, int i, int j) {
        int tmp = d[i];
        d[i] = d[j];
        d[j] = tmp;
    }

    // check if the soring worked on the array
    static boolean isSorted(int [] data) {
        int i;
        for(i=1; i < data.length; i++)
            if(data[i] < data[i-1]) break;
        return (i == data.length);
    }

    // If you want just display the array as well :)
    static void display(int []data) {
        System.out.println("=======");
        for(int i=0; i < data.length; i++)
            System.out.print(data[i] + "  ");
        System.out.println("\n=======");
    }


    /**********************************************************
     *     Implementation of sorting algorithms               *
     *********************************************************/
    static void buble_sort(int [] data)  {
        // traverse unsorted array
        for (int i=0; i<data.length-1;i++){

            for(int j=0;j<data.length-1;j++){
                //swapping the element if its greaterthan next element
                if (data[j]>data[j+1]) {
                    swap(data,j,j+1);


                }

            }
        }
    }

    static void selection_sort(int [] data) {
//static method - calling the function  without creatio of object


       for (int i=0; i<data.length;i++){
           int smallNumber=data[i]; //save the minimum value
           int minimumIndex=i; //store the minmmum index  for swapping purpose with i
           for (int j=i; j<data.length;j++){
               if(smallNumber>data[j]){
                   smallNumber=data[j];
                   minimumIndex=j;
               }


           }
           // swap the minimum elemnt to i and swap the i to minmimum index element
           swap(data,minimumIndex,i);

       }
    }
    static void insertion_sort(int [] data) {
        //static method - calling the function  without creatio of object
        //traverse the unsortted array
        for (int i=0;i<data.length;i++){
            //move the lement to forward until it is greaterthan to prevoius one
            //make a loop
    for (int j=i; j>0;j--){
        if(data[j]< data[j-1] ){
            //swappin  the functions
            swap(data,j,j-1);


        }
        else break;
    }
}

    }


    /**********************************************************
     *     Implementation for finding running time               *
     *********************************************************/

static HashMap<Integer,Long> get_execution_time_with_lenght(char algo,char algocase){
    HashMap<Integer,Long> ExecutionTimeWithLenght = new HashMap<Integer,Long>();
    for(int j=10000; j<=50000;j+=2000){

if(algocase=='w'){
    long startTime = System.nanoTime();
    if(algo=='s'){
        selection_sort(create_worst_data(j));
    } else if (algo=='i') {
        insertion_sort(create_worst_data(j));
    }
    else if(algo=='b'){
        buble_sort(create_worst_data(j));
    }
    long endTime   = System.nanoTime();
    long totalTime = endTime - startTime;
    ExecutionTimeWithLenght.put(j,totalTime);
}

       else  if(algocase=='b'){
            long startTime = System.nanoTime();
            if(algo=='s'){
                selection_sort(create_best_data(j));
            } else if (algo=='i') {
                insertion_sort(create_best_data(j));
            }
            else if(algo=='b'){
                buble_sort(create_best_data(j));
            }
            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            ExecutionTimeWithLenght.put(j,totalTime);
        }

else  if(algocase=='a'){
    long startTime = System.nanoTime();
    if(algo=='s'){
        selection_sort(create_rand_data(j));
    } else if (algo=='i') {
        insertion_sort(create_rand_data(j));
    }
    else if(algo=='b'){
        buble_sort(create_rand_data(j));
    }
    long endTime   = System.nanoTime();
    long totalTime = endTime - startTime;
    ExecutionTimeWithLenght.put(j,totalTime);
}


    }

    return ExecutionTimeWithLenght;
}

static void output_file_creator(File file,HashMap hashMap) throws FileNotFoundException {
    PrintWriter out=new PrintWriter(file);
    //keys are not ordered we have to get ordered(assending) thatswhy create another map to put keys as asscending order
    TreeMap<Integer,Long> tm=new  TreeMap<Integer,Long> (hashMap);
    Iterator itr=tm.keySet().iterator();//using iterator to looping the hashmap

    while(itr.hasNext())
    {
        int key=(int)itr.next();
        System.out.println("Lenght:  "+key+"     Time:   "+hashMap.get(key));//get the output on console
        out.println(key+ ","+hashMap.get(key));//write the values on csv files to key and values separated by commos
    }
    out.close();

}




static   HashMap<Integer,Long> get_execution_time_with_lenght_for_AverageCases(char algo,char algocase){
    HashMap<Integer, Long> newmap =new HashMap<>() ;

    if(algo=='s'&&algocase=='a') {
        HashMap<Integer, Long> map1 = get_execution_time_with_lenght('s', 'a');
        HashMap<Integer, Long> map2 = get_execution_time_with_lenght('s', 'a');
        HashMap<Integer, Long> map3 = get_execution_time_with_lenght('s', 'a');
        HashMap<Integer, Long> map4 = get_execution_time_with_lenght('s', 'a');




        for (int i : map1.keySet()) {
            newmap.put(i,newmap.get(i)+map1.get(i) );
        }
        for (int i : map2.keySet()) {
            newmap.put(i,newmap.get(i)+map2.get(i) );
        }

        for (int i : map3.keySet()) {
            newmap.put(i,newmap.get(i)+map3.get(i) );
        }
        for (int i : map4.keySet()) {
            System.out.println("hi");
            newmap.put(i/2,newmap.get(i)+map4.get(i) );
        }
        for (int i : newmap.keySet()) {

            newmap.put(i,newmap.get(i)/5 );
        }

    }
    return newmap;



}


    public static void main(String [] args) throws FileNotFoundException {

        /**********************************************************
         *     Implementation of selection sort              *
         *********************************************************/



        System.out.println(" /**********************************************************");
        System.out.println("worst case analysis for selectionsort");
        HashMap<Integer,Long> selectionSortForWorstCase = get_execution_time_with_lenght('s','w');
        File output=new File("worstcaseforselectionsort.csv");
        output_file_creator(output,selectionSortForWorstCase);
        System.out.println(" /**********************************************************");
        System.out.println();
        System.out.println();




        System.out.println(" /**********************************************************");
        System.out.println("best case analysis for selection sort");
        HashMap<Integer,Long> selectionSortForBestCase = get_execution_time_with_lenght('s','b');
        File output1=new File("bestcaseforselectionsort.csv");
        output_file_creator(output1,selectionSortForBestCase);
        System.out.println(" /**********************************************************");
        System.out.println();
        System.out.println();




        System.out.println(" /**********************************************************");
        System.out.println("Average  analysis for selection sort");
        HashMap<Integer,Long> selectionSortForAverageCase = get_execution_time_with_lenght('s','a');
        File output7=new File("averagecaseforselectionsort.csv");
        output_file_creator(output7,selectionSortForAverageCase);
        System.out.println(" /**********************************************************");
        System.out.println();
        System.out.println();

        System.out.println(" /**********************************************************");
        System.out.println("Average  analysis for selection sort");
        HashMap<Integer,Long> newselectionSortForAverageCase = get_execution_time_with_lenght_for_AverageCases('s','a');
        File output11=new File("newaveragecaseforselectionsort.csv");
        output_file_creator(output11,selectionSortForAverageCase);
        System.out.println(" /**********************************************************");
        System.out.println();
        System.out.println();








        /**********************************************************
         *     Implementation of insertion  sort              *
         *********************************************************/

        System.out.println(" /**********************************************************");
        System.out.println("worst case analysis for insertion sort");
        HashMap<Integer,Long> insertionSortForWorstCase = get_execution_time_with_lenght('i','w');
        File output3=new File("worstcaseforinsertionsort.csv");
        output_file_creator(output3,insertionSortForWorstCase);
        System.out.println(" /**********************************************************");
        System.out.println();
        System.out.println();




        System.out.println(" /**********************************************************");
        System.out.println("best case analysis for insertion sort");
        HashMap<Integer,Long> insertionSortForBestCase = get_execution_time_with_lenght('i','b');
        File output4=new File("bestcaseforinsertionsort.csv");
        output_file_creator(output4,insertionSortForBestCase);
        System.out.println(" /**********************************************************");
        System.out.println();
        System.out.println();



        System.out.println(" /**********************************************************");
        System.out.println("Average  analysis for selection sort");
        HashMap<Integer,Long> insertionSortSortForAverageCase = get_execution_time_with_lenght('s','a');
        File output8=new File("averagecaseforselectionsort.csv");
        output_file_creator(output8,selectionSortForAverageCase);
        System.out.println(" /**********************************************************");
        System.out.println();
        System.out.println();



        /**********************************************************
         *     Implementation of bubble  sort              *
         *********************************************************/
        System.out.println(" /**********************************************************");
        System.out.println("worst case analysis for bubbble sort");
        HashMap<Integer,Long> bubbleSortForWorstCase = get_execution_time_with_lenght('b','w');
        File output5=new File("worstcaseforbubblesort.csv");
        output_file_creator(output5,insertionSortForWorstCase);
        System.out.println(" /**********************************************************");
        System.out.println();
        System.out.println();



        System.out.println(" /**********************************************************");
        System.out.println("best case analysis for bubble sort");
        HashMap<Integer,Long> bubbleSortForBestCase = get_execution_time_with_lenght('b','b');
        File output6=new File("bestcaseforbubblesort.csv");
        output_file_creator(output6,insertionSortForBestCase);
        System.out.println(" /**********************************************************");
        System.out.println();
        System.out.println();




        System.out.println(" /**********************************************************");
        System.out.println("Average  analysis for bubble sort");
        HashMap<Integer,Long> averageSortSortForAverageCase = get_execution_time_with_lenght('s','a');
        File output9=new File("averagecaseforselectionsort.csv");
        output_file_creator(output9,selectionSortForAverageCase);
        System.out.println(" /**********************************************************");
        System.out.println();
        System.out.println();

















    }
}
