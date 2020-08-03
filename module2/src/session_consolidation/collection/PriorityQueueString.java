package session_consolidation.collection;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueString {
    public static void main(String[] args) {
        Queue<String> priorityQueue = new PriorityQueue<>();
        //Queue can use add()/offer(); remove()/poll(); element()/peek();
        priorityQueue.offer("Chuong");
        priorityQueue.offer("Binh");
        priorityQueue.offer("Nguyen");
        priorityQueue.offer("Anh");
        priorityQueue.offer("Thanh");
        priorityQueue.offer("Quan");
        priorityQueue.offer("Hoang");

        //Using Iterator to traverse the PriorityQueue (Sorting AlphaB)
        Iterator<String> iterator = priorityQueue.iterator();
        System.out.println("Using Iterator to traverse the PriorityQueue:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("Poll elements from the PriorityQueue:");
        String name = null;
        while(true) {
            name = priorityQueue.poll();
            if(name == null) break;
            System.out.println(name);
        }
    }
}
