package Lab6;

import Hashing.hashchains;
import Hashing.hashingtable;

public class Main {


    public static void main(String[]args) {
       HashTable hashTable=new HashTable(15);


        //print double hashing table
        hashTable.insert(60,"value is 60");
        hashTable.insert(123,"value is 123");
        hashTable.insert(32,"value is 32");
        hashTable.insert(61,"value is 61");
        hashTable.insert(34,"value is 34");
        hashTable.insert(93,"value is 93");

        hashTable.insert(31,"value is 31");

hashTable.printlist();
        System.out.println("The value of key 123:" + (hashTable.get(123)) + "\n");



        //hashchains

     System.out.println("Hashchains functions  created ");

        HashChains hashchains = new HashChains(5);





        hashchains.insert(52, "insert 52");
        hashchains.insert(56, "insert 56");
        hashchains.insert(50, "insert 50");
        hashchains.printList();

        System.out.println("checking get function is working or not");
        System.out.println("The value of key 52:" + (hashchains.get(52)));

















    }
}
