package com.example.baitapmvc.service;

import com.example.baitapmvc.model.Painting;

import java.util.List;

public interface PaintingService {
    List<Painting> findAll();
    void create (Painting painting);
    Painting findById(int id);
    void update(int id, Painting painting);
    void remove(int id);
}
