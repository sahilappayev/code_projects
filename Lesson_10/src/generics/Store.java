package generics;

import java.util.Arrays;


// diamond operator <>
// T = type, E - element,
public class Store<T, COMPANY> extends Test<T> {

    private int size = 10;
    private int currentIndex = 0;
    private T[] datas = (T[]) new Object[size];  // after compile type eraser
    private COMPANY company;


    public int getSize() {
        return size;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public int addData(T data) {
        if (currentIndex >= datas.length) {
            size = size * 2; //20
            T[] newDatas = (T[]) new Object[size];
            for (int i = 0; i < datas.length; i++) {
                newDatas[i] = datas[i];
            }
            datas = newDatas;
        }

        int retVal = currentIndex;
        datas[currentIndex] = data;
        currentIndex++;
        return retVal;
    }

    public int addData(int index, T data) {
        if (index > currentIndex) throw new IndexOutOfBoundsException("Olmazz!!");
        datas[index] = data;
        currentIndex++;
        return index;
    }


    public T getData(int index) {
        if (index > datas.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + datas.length);
        }
        return datas[index];
    }


    @Override
    public String toString() {
        return "Store{" +
                "size=" + size +
                ", index=" + currentIndex +
                ", datas=" + Arrays.toString(datas) +
                '}';
    }
}
