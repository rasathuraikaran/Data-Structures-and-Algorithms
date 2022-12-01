package Hashing;



import java.util.Arrays;

public class hashingtable {
    private Entry[] list;
    private int max;
    private int cur_size;
    //constructor
    public hashingtable(int max) {

        this.max = max;
        this.list=new Entry[max];
        this.cur_size=0;
    }
    //method to clear the hash table
    public void clear() {

        this.list=new Entry[max];
        this.cur_size=0;
    }
    // return the current size of the table
    public int get_cur_size() {
        return this.cur_size;

    }
    //check whether the hash table is full or not
    public boolean full() {
        return cur_size==max;
    }
    //check whether the hash table is empty or not
    public boolean empty() {
        return cur_size==0;
    }
    //hash function to obtain the index
    public int hasf1(int key) {

        return key % max;
    }
    // function to handle collisions
    public int hasf2(int key,int i) {

        return i*(1+(key %( max-1)));
    }
    //check whether the given key is in the table or not
    public boolean containskey(int key) {
        return get(key)!=null;
    }
    //insert  key and value
    public void insertval(int key,String value) {

        if(cur_size>(max-1)) return;
        Entry new_insert=new Entry(key,value);
        int hash_var1=hasf1(key);
        int i=1;
        while(list[hash_var1]!=null) {
            if(list[i].getKey()==key) {
                System.out.println("key "+key+" already exists\n");
                return;
            }
            hash_var1=(hash_var1+hasf2(key,i))%max;
            i=i+1;

        }
        list[hash_var1]=new_insert;
        cur_size=cur_size+1;
    }
    //return the input list
    public Entry[] getInputList() {
        return this.list;
    }

    public String get(int key) {
        int hash_var1=hasf1(key);
        Entry readinsert=list[hash_var1];
        int i=1;
        while(readinsert!=null && !(readinsert.getKey()==key)) {
            hash_var1=(hash_var1+hasf2(key,i))%max;
            i=i+1;

        }
        return list[hash_var1].getValue();
    }

    public void remove_input(int key) {
        if(!containskey(key)) return;
        int hash_var1=hasf1(key);
        Entry readinsert=list[hash_var1];
        int i=1;
        while(readinsert!=null && !(readinsert.getKey()==key)) {
            hash_var1=(hash_var1+hasf2(key,i)) % max;
            readinsert=list[hash_var1];
            i=i+1;

        }
        list[hash_var1]=null;
        cur_size=cur_size-1;
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