package ReverseInteger;
/*

Reverse digits of an integer.

Example1: x = 123, return 321

Example2: x = -123, return -321

Input Format

an integer x

Output Format

a Reverse Integer

Sample Input

123

Sample Output

321

Explanation

Reverse digits of an integer.

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.


 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner ui=new Scanner(System.in);
        int n=ui.nextInt();


        if(n==-2147483648) System.exit(0);;
        int sign =n<0?-1:1;
        int ans=0;

        if(n<-1) n *= -1;

        while(n!=0){
            if (ans>214748364) System.exit(0);;
            if (ans==214748364 && (n%10)>7) System.exit(0);;
            ans=ans*10 +(n%10);
            n/=10;

        }
        if (sign==-1) System.out.println(ans*(-1));
        else System.out.println(ans);



        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}