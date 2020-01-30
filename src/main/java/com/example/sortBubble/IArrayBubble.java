package com.example.sortBubble;

import java.util.Comparator;

public interface IArrayBubble<T> {
    void bubbleSort(Comparator<? super T> comparator);
    void printArray();
    void storeIntoDB();
}
