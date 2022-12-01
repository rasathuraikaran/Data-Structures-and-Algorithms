package Hashing;




import java.util.Arrays;
import java.util.LinkedList;

public class hashchains {
    private LinkedList<Entry>[] linked_list;
    private int max;
    private int cur_size;
    //constructor

    public hashchains (int max) {
        this.max=max;
        this.cur_size=0;
        linked_list =new LinkedList[max];
        for (int i=0;i<max;i++) {
            linked_list[i]=new LinkedList<Entry>();

        }

    }
    //hash function
    private int hash_func(int key) {

        return key % max;
    }
    //check whether the hash table is empty or not
    public boolean empty() {
        return cur_size==0;
    }
    //current size
    public int get_cur_size() {
        return this.cur_size;

    }
    //insert values
    public void insert(int key,String value) {

        Entry new_entry=new Entry(key,value);
        int hash=hash_func(key);
        LinkedList<Entry> column = linked_list[hash];
        for (Entry input:column) {
            if(input.getKey()==key) {
                System.out.println("key "+key+" already exists\n");
            }
        }
        column.add(new_entry);
        cur_size +=1;
    }

    public String get(int key) {
        int hash=hash_func(key);
        LinkedList<Entry> column = linked_list[hash];
        for (Entry input:column) {
            if(input.getKey()==key) {
                return input.getValue();
            }
        }
        return null;
    }

    public void printList() {
        Arrays.stream(linked_list).forEach(x->{
            if(x!=null) {
                x.forEach(y->{
                    if(y!=null) {
                        System.out.println("key:"+y.getKey()+"  value:"+y.getValue());
                    }
                });
            }
        });
    }
    //remove a key ,value from the table
    public void remove(int key) {
        int hash=hash_func(key);
        LinkedList<Entry> column = linked_list[hash];
        for (Entry input:column) {
            if(input.getKey()==key) {
                column.remove(input);
            }
        }
        cur_size=cur_size-1;
    }
    //clear all the linked lists

    public void clear() {
        this.cur_size=0;
        linked_list =new LinkedList[max];
        for(int i=0;i<max;i++) {
            linked_list[i]=new LinkedList<Entry>();
        }
    }

}
