package Lab6;

// E/17/256
// Lab:hasting
// 18/8/2021



import Lab6.ValueEntry;

import java.util.Arrays;
import java.util.LinkedList;

public class HashChains {
    private LinkedList<ValueEntry>[] linked_list;
    private int capacity;
    private int current_size;

    public HashChains (int capacity) {
        this.capacity=capacity;
        this.current_size=0;
        linked_list =new LinkedList[capacity];
        for (int i=0;i<capacity;i++) {
            linked_list[i]=new LinkedList<ValueEntry>();

        }

    }
    private int hash_func(int key) {

        return key % capacity;
    }
    public boolean isempty() {
        return current_size==0;
    }
    public int get_current_size() {
        return this.current_size;

    }
    public void insert(int key,String value) {

        ValueEntry new_entry=new ValueEntry(key,value);
        int hash=hash_func(key);
        for (ValueEntry input:linked_list[hash]) {
            if(input.getKey()==key) {
                System.out.println("key "+key+" already exists\n");
            }
        }
        linked_list[hash].add(new_entry);
        current_size +=1;
    }

    public String get(int key) {
        int hash=hash_func(key);
        for (ValueEntry input:linked_list[hash]) {
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



}


