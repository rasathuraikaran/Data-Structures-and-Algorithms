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
        for (int i=0; i<data.length-1;i++){
            for(int j=0;j<data.length-1;j++){
                if (data[j]>data[j+1]) {
                    int temp =data[j];
                    data[j]=data[j+1];
                    data[j+1]=temp;

                }
                else continue;
            }
        }
    }

    static void selection_sort(int [] data) {
        // Implement
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
        buble_sort(arr);
        display(arr);
    }
}
