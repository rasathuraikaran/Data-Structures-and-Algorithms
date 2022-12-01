package Lab6;

import java.util.Arrays;

public class HashTable {
    private int HASH_TABLE_SIZE;
    private int size;
    private ValueEntry[] list ;
    private int totalprimeSize;

    public HashTable(int HASH_TABLE_SIZE) {
        this.HASH_TABLE_SIZE = HASH_TABLE_SIZE;
       size=0;
        this.list = new ValueEntry[HASH_TABLE_SIZE];
    }



    //to get the number of key value pairs
    public int getSize(){
            return size;
    }

    public boolean isEmpty(){

        return  size==0;
    }


    //Function to clear the hashtable
    public void makeEmpty(){
        size=0;
        for(int i=0;i<HASH_TABLE_SIZE;i++){
            list[i]=null;
        }


    }


    public void insert(int key, String value){
        // checking the size of table and
        //  comparing it with users input value


        if(size==HASH_TABLE_SIZE){
            System.out.println("Table is full");

        }

        int hash1=myhash1(key);
        int i=1;
        while(list[hash1]!=null){
            if(list[i].getKey()==key){
                System.out.println("key "+key+" already exists\n");
                return;
            }
            hash1=(hash1+myhash2(key,i))%HASH_TABLE_SIZE;
            i=i+1;
        }
       list[hash1]=new ValueEntry(key, value);
        size ++;
    }


    private int  myhash1(int key
    ){
        return key%HASH_TABLE_SIZE;

    }

    private int myhash2 (int key,int i){
        return i*(1+(key %( HASH_TABLE_SIZE-1)));

    }


    public void printlist() {

        Arrays.stream(list).forEach(input ->
                {
                    if(input!=null) {
                        System.out.println("key : "+input.getKey()+" value :"+input.getValue());
                    }
                }
        );
    }






}
