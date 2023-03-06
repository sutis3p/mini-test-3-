package com.example.baitapmvc.service;

import com.example.baitapmvc.model.Painting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaintingServiceImpl implements PaintingService{
    private static Map<Integer, Painting> paintings;
    static {
        paintings = new HashMap<>();
        paintings.put(1,new Painting(1,"u1","GGDGD", 100.0, 70.0, "vvb", "good", 290.0));
        paintings.put(2,new Painting(2,"u2","đhdh", 60.0, 30.0, "hdhd", "nomal", 839.0));
        paintings.put(3,new Painting(3,"u3","shjks", 130.0, 50.0, "fabric", "good", 74884.0));
    }
    @Override
    public List<Painting> findAll() {
        return new ArrayList<>(paintings.values());
    }

    @Override
    public void create(Painting painting) {
        paintings.put(painting.getId(), painting);;
    }

    @Override
    public Painting findById(int id) {
        return paintings.get(id);
    }

    @Override
    public void update(int id, Painting painting) {
        paintings.put(id, painting);
    }

    @Override
    public void remove(int id) {
        paintings.remove(id);
    }
}
