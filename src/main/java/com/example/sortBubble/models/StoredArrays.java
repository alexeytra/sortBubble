package com.example.sortBubble.models;


import javax.persistence.*;

@Entity
@Table(name = "stored_arrays")
public class StoredArrays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "stored_array")
    private String storedArray;

    public StoredArrays() {}

    public StoredArrays(String stored_array) {
        this.storedArray = stored_array;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStoredArray() {
        return storedArray;
    }

    public void setStoredArray(String storedArray) {
        this.storedArray = storedArray;
    }

    @Override
    public String toString() {
        return "StoredArrays{" +
                "id=" + id +
                ", storedArray='" + storedArray + '\'' +
                '}';
    }
}
