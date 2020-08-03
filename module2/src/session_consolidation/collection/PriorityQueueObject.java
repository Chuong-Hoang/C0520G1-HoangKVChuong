package session_consolidation.collection;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueObject {
    public static void main(String[] args) {
        Queue<Worker> priorityQueue = new PriorityQueue<>();

        Worker w1 = new Worker("Chuong", "F001", 32);
        Worker w2 = new Worker("Thanh", "F002", 30);
        Worker w3 = new Worker("Minh", "F003", 35);
        Worker w4 = new Worker("Anh", "F004", 22);
        Worker w5 = new Worker("Phuong", "F005", 25);
        Worker w6 = new Worker("Minh", "F006", 21);
        Worker w7 = new Worker("Minh", "F007", 38);

        priorityQueue.offer(w1);
        priorityQueue.offer(w2);
        priorityQueue.offer(w3);
        priorityQueue.offer(w4);
        priorityQueue.offer(w5);
        priorityQueue.offer(w6);
        priorityQueue.offer(w7);

        System.out.println("Using Iterator to traverse PriorityQueue:");
        Iterator<Worker> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }

        System.out.println("-----------------------------------");
        System.out.println("Poll elements from PriorityQueue:");
        //Using PriorityQueue, we do not need command 'Collection.sort(Comparable<E>)
        Worker w;
        while (true) {
            w = priorityQueue.poll();
            if(w == null) break;
            System.out.println(w.toString());
        }
    }
}
