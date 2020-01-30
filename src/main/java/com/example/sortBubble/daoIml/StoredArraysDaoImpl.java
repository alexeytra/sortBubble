package com.example.sortBubble.daoIml;

import com.example.sortBubble.models.StoredArrays;

import java.util.List;

public interface StoredArraysDaoImpl {
    StoredArrays findById(int id);
    void save(StoredArrays storedArrays);
    void update(StoredArrays storedArrays);
    void delete(StoredArrays storedArrays);
    List<StoredArrays> findAll();
}
