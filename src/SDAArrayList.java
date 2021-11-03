import java.util.*;

public class SDAArrayList<E> extends AbstractList {
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    transient Object[] elementData; // non-private to simplify nested class access
    private int size;

    public SDAArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }
    public SDAArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }


    public SDAArrayList(Collection<? extends E> c) {
        Object[] a = c.toArray();
        if ((size = a.length) != 0) {
            if (c.getClass() == ArrayList.class) {
                elementData = a;
            } else {
                elementData = Arrays.copyOf(a, size, Object[].class);
            }
        } else {
            // replace with empty array.
            elementData = EMPTY_ELEMENTDATA;
        }
    }
    private void add(E e, Object[] elementData, int s) {
        if (s == elementData.length)
            elementData = grow(size + 1);
        elementData[s] = e;
        size = s + 1;
    }
    public E get(int index) {
        Objects.checkIndex(index, size);
        return elementData(index);
    }
    E elementData(int index) {
        return (E) elementData[index];
    }


    public boolean add(Object e) {
        modCount++;
        add((E) e, elementData, size);
        return true;
    }
    private Object[] grow(int i) {
        return grow(size + 1);
    }
    private void fastRemove(Object[] es, int i) {
        modCount++;
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null;
    }
    public E remove(int index) {
        Objects.checkIndex(index, size);
        final Object[] es = elementData;

        @SuppressWarnings("unchecked") E oldValue = (E) es[index];
        fastRemove(es, index);

        return oldValue;
    }
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "SDAArrayList{" +
                "elementData=" + Arrays.toString(elementData) +
                ", size=" + size +
                '}';
    }

    public void display(){
        for (Object element : elementData) {
            System.out.println(element);
        }
    }
}
