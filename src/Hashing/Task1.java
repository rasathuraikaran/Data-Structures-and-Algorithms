package Hashing;



public class Task1 {

    public static void main(String[]args) {

        hashingtable hashTable=new hashingtable(15);


        //print double hashing table
        hashTable.insertval(60,"value is 60");
        hashTable.insertval(32,"value is 32");
        hashTable.insertval(61,"value is 61");
        hashTable.insertval(34,"value is 34");
        hashTable.insertval(93,"value is 93");
        hashTable.insertval(63,"value is 63");
        hashTable.insertval(31,"value is 31");
        hashTable.printlist();

        System.out.println("\ninsert 62\n");
        hashTable.insertval(62,"value is 62");
        hashTable.printlist();

        System.out.println("\nremove 61\n");
        hashTable.remove_input(61);
        hashTable.printlist();

        System.out.println("\nCheck empty or not\n");

        boolean empty1= hashTable.empty();
        if (empty1) {
            System.out.println("Hash table is empty\n");
        }else {
            System.out.println("Hash table is not empty\n");
        }


        System.out.println("The value of key 123:"+(hashTable.get(123))+"\n");

        System.out.println("\nCheck hash table is full or not\n");

        boolean full= hashTable.full();
        if (full) {
            System.out.println("Hash table is full\n");
        }else {
            System.out.println("Hash table is not full\n");
        }

        System.out.println("\nsize of the table\n");
        int size=hashTable.get_cur_size();
        System.out.println("Hash tables current size is: "+size+"\n");

        System.out.println("Hash table is cleared\n");
        hashTable.clear();
        hashTable.printlist();

        //linked list hashing

        hashchains hashchains=new hashchains(5);

        System.out.println("\nHash table is checked whether it is empty or not\n");

        boolean emptyy= hashchains.empty();
        if (emptyy) {
            System.out.println("Hash Table is empty\n");
        }else {
            System.out.println("Hash table is not empty\n");
        }
        //print linked list
        hashchains.insert(50, "value is 50");
        hashchains.insert(52, "value is 52");
        hashchains.insert(53, "value is 53");
        hashchains.insert(55, "value is 55");
        hashchains.insert(56, "value is 56");
        hashchains.insert(56, "value is 56");
        hashchains.printList();
        int hsize=hashchains.get_cur_size();
        System.out.println("\nhash table size is: "+hsize+"\n");

        System.out.println("\nRemove key 55\n");
        hashchains.remove(55);
        hashchains.printList();
        hashchains.clear();
        hashchains.printList();

    }
}



