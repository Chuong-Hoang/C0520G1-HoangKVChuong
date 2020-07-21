package session09_arrayList_and_linkedList.homeworks.array_list;
import java.util.Arrays;

public class MyList2 {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList2() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList2(int capacity) {
        //this.size = capacity;
        elements = new Object[capacity];
    }

    public void addLast(int index, Object element) {
        elements = Arrays.copyOf(elements, size + 1);
        elements[size] = element;
        size++; // ask Tien why this has to be acted while newLength = size+1?
    }

    public Object[] remove(int index) {

        Object[] newArrList = new Object[size-1];

        for(int i = 0; i < size-1; i++) {
            if(i < index) newArrList[i] = elements[i];
            else {
                newArrList[i] = elements[i+1];
            }
        }

        elements = newArrList;
        return elements;
    }

    public int size() {
        int count = 0;
        for(Object obj : elements) {
            if(obj != null) count++;
        }
        return count;
    }

    public Object[] clone() {
        Object[] newList = Arrays.copyOf(elements, size);
        return  newList;
    }

    public boolean contains(Object obj) {
        for(int i = 0; i < elements.length; i++) {
            if(elements[i].equals(obj)) return true;
        }
        return false;
    }

    public int indexOf(Object obj) {
        int index = -1;
        for(int i = 0; i < elements.length; i++) {
            if(elements[i].equals(obj)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public Object get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        return elements[index];
    }

    public void clear() {
        elements = new Object[0];
    }
}
