package joshuaburt_sec005_ex03;

/*
Exercise 03: [10 marks] Define a generic queue (FIFO: first in, first out) class (store it in file – DataQueue.java). Add appropriate field: variable(s)
required, constructors, methods to add an element (enqueue), delete an element (dequeue) and to print elements
Using this generic class, you should be able to process the following in the driver class – DataQueueTest.java):
a) Queue of Strings
b) Queue of Stock values – type double
 */


import java.util.ArrayList;
public class DataQueue<T>{
    private int count = 0; //queue array index counter
    ArrayList<T> queueArray = new ArrayList<>(); //hold enqueue and dequeue methods

    public void enqueue(T stringQueue){
        queueArray.add(stringQueue); //stringQueue value added to queueArray
        count++; //index counter increased accordingly
    }
    public void dequeue(){
        if(queueArray.size()<=0){ //if dequeue is called before any enqueue, clear array (skip to next command)
            queueArray.clear();
        }
        else {
            queueArray.remove(queueArray.size() - count); //remove first in array value (first-in)
            count -= 1; //index counter decreased accordingly
        }
    }
    public void print(){
        System.out.println(queueArray); //prints queueArray to console
    }
}