package session9_arrayList_and_linkedList.practice.list;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);
        listInteger.add(5);

        System.out.println(listInteger);
        System.out.println("Element 1: " + listInteger.get(1));
        //System.out.println("Element 6: " + listInteger.get(6));
        System.out.println("Element 0: " + listInteger.get(0));
        //System.out.println("Element -1: " + listInteger.get(-1));

    }
}
