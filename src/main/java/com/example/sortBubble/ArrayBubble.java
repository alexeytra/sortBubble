package com.example.sortBubble;

import com.example.sortBubble.models.StoredArrays;
import com.example.sortBubble.services.StoredArraysService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayBubble<T extends Number> implements IArrayBubble{
    private T[] array;
    private int numElem;


    public ArrayBubble(T[] array) {
        this.array = array;
        this.numElem = array.length;
    }

    private void swap(int f, int s) {
        T temp = array[f];
        array[f] = array[s];
        array[s] = temp;
    }

    public void bubbleSort(Comparator comparator) {
        for (int i = numElem - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comparator.compare(array[j], array[j + 1]) < 0) {
                    swap(j, j + 1);
                }
            }
        }
    }

    public void printArray() {
        Arrays.stream(array).forEach(array -> System.out.print(array + " "));
        System.out.println("\n");
    }

    public T[] getArray() {
        return array;
    }

    public void storeIntoDB() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sortBubble", "postgres", "7849");
            Statement statement = connection.createStatement();
            // создание таблицы
            String querry = "CREATE TABLE IF NOT EXISTS stored_arrays(id serial PRIMARY KEY, stored_array text NOT NULL);";
            statement.executeUpdate(querry);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        StoredArraysService storedArraysService = new StoredArraysService();
        StoredArrays storedArrays = new StoredArrays(Arrays.toString(array));
        storedArraysService.saveArray(storedArrays);
        List<StoredArrays> storedArrays1 = storedArraysService.findAllArrays();
        storedArrays1.forEach(System.out::println);
    }


}
