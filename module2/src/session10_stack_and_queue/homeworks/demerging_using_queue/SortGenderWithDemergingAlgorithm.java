package session10_stack_and_queue.homeworks.demerging_using_queue;
import java.util.LinkedList;
import java.util.Queue;

public class SortGenderWithDemergingAlgorithm {
    public static void main(String[] args) {
        Queue<Person> input = new LinkedList<>();
        input.offer(new Person("AAA", "1988", "nu"));
        input.offer(new Person("BBB", "1986", "nam"));
        input.offer(new Person("CCC", "1985", "nam"));
        input.offer(new Person("DDD", "1984", "nu"));
        input.offer(new Person("EEE", "1982", "nu"));
        input.offer(new Person("FFF", "1980", "nam"));
        input.offer(new Person("GGG", "1978", "nu"));
        input.offer(new Person("HHH", "1977", "nam"));
        input.offer(new Person("III", "1975", "nu"));
        input.offer(new Person("JJJ", "1973", "nam"));
        input.offer(new Person("KKK", "1970", "nam"));


        // -- demerging algorithm
        Queue<Person> NU = new LinkedList<>();
        Queue<Person> NAM = new LinkedList<>();
        Queue<Person> output = new LinkedList<>();

        //put 'nu' and 'nam' into two different queues
        String str = "";
        while (!input.isEmpty()) {
            if (input.peek().getGender().equals("nu")) {
                Person nu = input.poll();
                str += nu.toString() + "\n";
                NU.offer(nu);
            } else {
                Person nam = input.poll();
                str += nam.toString() + "\n";
                NAM.offer(nam);
            }
        }

        while (!NU.isEmpty()) {
            output.offer(NU.poll());
        }

        while (!NAM.isEmpty()) {
            output.offer(NAM.poll());
        }
        // show input
        System.out.println("Before demerge:");
        System.out.println(str);
        System.out.println("--------------------------------------------");

        // show output
        System.out.println("After demerge:");
        int i = 1;
        while (!output.isEmpty()) {
            System.out.println(i + ". " + output.poll());
            i++;
        }
    }
}
