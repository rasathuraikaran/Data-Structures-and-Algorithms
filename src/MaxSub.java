
/*
Author => Karan R
        E/18/168



 */
import java.util.Random;


class MaxSub {

    static int MAX_NUM = 200;
    static int start, end;

    static int [] generate(int howmany) {
        int [] data = new int[howmany];
        Random randomGenerator = new Random();
        for(int i=0; i<howmany; i++)
            data[i] = randomGenerator.nextInt(MAX_NUM) - (MAX_NUM/2);
        return data;
    }

    static void show(int []data, int s, int e) {
        for(int i=s; i<e; i++)
            System.out.print(data[i] + " ");
        System.out.println();
    }
    static int sumofsubArray(int []data, int s, int e) {
        int sum=data[s];
        for(int i=s; i<e; i++){
            if (i==s) continue;
            sum=sum+data[i];
        }

        return  sum;
    }

//Brute force method implementation to find the maximum sub array sum

    static int findMaxSub(int [] data) {
        // find the MaxSub array sum and return
        int summation=-20000000;
        for(int i=0; i<data.length; i++){
            for(int j=i;j<data.length;j++){
                int  sum=sumofsubArray(data,i,j);
                if(summation<sum){
                    summation=sum;
                }
            }

        }
        return  summation;
    }

    //Dynamic programming method
    static int DynamicfindMaxSub(int array[])
    {

        int localMax=0;
        int globalMax=-200000;


        for (int i = 0; i < array.length; i++)
        {
            localMax=Math.max(array[i],array[i]+localMax);//we are simply storing the latest local_maximum in an int type variable ‘local_max’ because that’s what we need to calculate next local_maximum.
        // when local sum as arra[i] then it statrs a new sub array
            if(globalMax<localMax) globalMax=localMax;//we are using a variable ‘global_max’ to keep track of the maximum value of local_maximum, which in the end comes out to be the required output.
        }
        return globalMax;
    }
//////





    public static void main(String [] args) {
        // try it with a known array first
        // then use a random array and see it works

        int [] data = {1, 12, -129, 192, 2, 10, -19, 25, -200, 91, 10};
        findMaxSub(data);


        System.out.println("Max sum  from   brute-force= " + findMaxSub(data));
        System.out.println("Max sum from Dynamic programming method = " + DynamicfindMaxSub(data));


        System.out.println("");
        data = generate(100);
        System.out.println("Max sum  from   brute-force= " + findMaxSub(data));
        System.out.println("Max sum from Dynamic programming method = " + DynamicfindMaxSub(data));


    }
}


/*
a. what is the time complexity of your brute-force approach?
O(n**2)

Can we apply the ideas of dynamic programming to this?
yes   (kadones alogorithm)

 */