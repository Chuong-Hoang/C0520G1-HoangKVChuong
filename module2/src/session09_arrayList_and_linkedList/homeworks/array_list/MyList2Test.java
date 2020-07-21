package session09_arrayList_and_linkedList.homeworks.array_list;

public class MyList2Test {
    public static void main(String[] args) {
        MyList2 myList = new MyList2();
        System.out.println(myList.size());
        myList.addLast(0, 10);
        myList.addLast(1, 20);
        myList.addLast(2, 30);
        System.out.println(myList.size());
        System.out.println(myList.remove(2));
        System.out.println(myList.size());

        System.out.println();
        System.out.println(myList.contains(20));
        System.out.println(myList.indexOf(20));
        System.out.println(myList.contains(30));
        System.out.println(myList.get(0));
        System.out.println(myList.get(3));

    }
}
