package Lab6;

import Hashing.hashchains;
import Hashing.hashingtable;

public class Main {


    public static void main(String[]args) {

       HashTable hashTable=new HashTable(15);


        //print double hashing table
        hashTable.insert(60,"value is 60");
        hashTable.insert(32,"value is 32");
        hashTable.insert(61,"value is 61");
        hashTable.insert(34,"value is 34");
        hashTable.insert(93,"value is 93");
        hashTable.insert(63,"value is 63");
        hashTable.insert(31,"value is 31");
        hashTable.printlist();

        System.out.println("\ninsert 62\n");
        hashTable.insert(32,"value is 62");
        hashTable.printlist();


    }
}
