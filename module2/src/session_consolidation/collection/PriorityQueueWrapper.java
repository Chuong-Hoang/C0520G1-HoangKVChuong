package session_consolidation.collection;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueWrapper {
    public static void main(String[] args) {
        Queue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(12);
        priorityQueue.add(20);
        priorityQueue.add(5);
        priorityQueue.add(33);
        priorityQueue.add(16);
        priorityQueue.add(1);

        Iterator<Integer> iterator = priorityQueue.iterator();
        System.out.println("Using Iterator to traverse the Priority Queue");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("Poll elements: ");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}
