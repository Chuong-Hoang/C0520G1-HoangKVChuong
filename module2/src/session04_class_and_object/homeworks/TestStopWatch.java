package session4_class_and_object.homeworks;

public class TestStopWatch {
    public static void main(String[] args) {
        StopWatch sw = new StopWatch();

        // define and initialize an array of random numbers
        int len = 10;
        int[] numbers = new int[len];
        for(int i = 0; i < len; i++){
            numbers[i] = (int) (Math.random()*len + 1);
        }
//        System.out.print("Before selection sort: ");
//        for(int x : numbers) System.out.print(x + "  ");
//        System.out.println();

        //Selection sort starts here
        sw.start();
        for(int n = 0; n < len; n++) {
            int min = numbers[n];
            int index = -1;
            for (int i = n; i < len; i++) {
                if (min > numbers[i]) {
                    min = numbers[i];
                    index = i;
                }
            }
            if (index != -1) {
                int temp = numbers[n];
                numbers[n] = numbers[index];
                numbers[index] = temp;
            }
//            System.out.print("sort " + (n+1) + ": ");
//            for(int x : numbers) System.out.print(x + "  ");
//            System.out.println();
        }
        // Selection sort ends here
        sw.stop();
        System.out.println("Time of selection sort: " + (sw.getElapsedTime()) + " milliseconds.");
//        System.out.print("After selection sort: ");
//        for(int x : numbers) System.out.print(x + "  ");
    }

}
