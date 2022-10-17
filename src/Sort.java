import java.util.Arrays;

/**
 * Simple sorting algorithms and their performance
 * Reg:
 *
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
    static int [] create_worst_data1(int size_of_array) {
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
                    int temp =data[j];
                    data[j]=data[j+1];
                    data[j+1]=temp;

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
        int temp =data[minimumIndex];
           data[minimumIndex]=data[i];
           data[i]=temp;
       }
    }

    static void insertion_sort(int [] data) {
        // Implement
    }







    public static void main(String [] args) {
        // create arrays of different size populate with data
        // measure the time taken by different algorithms to
        // sort the array.
        // Think about effects of caches, other apps running etc.

        int [] arr=create_rand_data(10);
        display(arr);
        selection_sort(arr);
        display(arr);
        System.out.println(Arrays.toString(arr));
    }
}
