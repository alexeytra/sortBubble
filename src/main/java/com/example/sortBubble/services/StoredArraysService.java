package com.example.sortBubble.services;

import com.example.sortBubble.dao.StoredArraysDao;
import com.example.sortBubble.models.StoredArrays;

import java.util.List;

public class StoredArraysService {
    private StoredArraysDao storedArraysDao = new StoredArraysDao();

    public StoredArraysService() { }

    public StoredArrays findArray(int id) {
        return storedArraysDao.findById(id);
    }

    public void saveArray(StoredArrays storedArrays) {
        storedArraysDao.save(storedArrays);
    }

    public void deleteArray(StoredArrays storedArrays) {
        storedArraysDao.delete(storedArrays);
    }

    public void updateArray(StoredArrays storedArrays) {
        storedArraysDao.update(storedArrays);
    }

    public List<StoredArrays> findAllArrays() {
        return storedArraysDao.findAll();
    }

}
