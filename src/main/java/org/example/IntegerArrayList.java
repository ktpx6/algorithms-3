package org.example;

public class IntegerArrayList {
    private static final double GROWTH_FACTOR = 1.5;
    private int size = 0;
    private int capacity = 10;
    private int[] elements;

    public IntegerArrayList() {
        elements = new int[capacity];
    }

    private void grow() {
        capacity = (int) (capacity * GROWTH_FACTOR);
        int[] newElements = new int[capacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    public void add(int element) {
        if (size == capacity) {
            grow();
        }
        elements[size++] = element;
    }

    public void sort() {
        mergeSort(elements, 0, size - 1);
    }

    // Метод слияния
    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);  // Сливаем
        }
    }

    private void merge(int[] array, int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        System.arraycopy(array, left, leftArray, 0, leftSize);
        System.arraycopy(array, middle + 1, rightArray, 0, rightSize);

        int i = 0, j = 0, k = left;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < leftSize) {
            array[k++] = leftArray[i++];
        }

        while (j < rightSize) {
            array[k++] = rightArray[j++];
        }
    }

    public int get(int index) {
        if (index >= 0 && index < size) {
            return elements[index];
        }
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    public int size() {
        return size;
    }
}
