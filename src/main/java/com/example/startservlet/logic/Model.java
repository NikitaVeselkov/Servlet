package com.example.startservlet.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Model implements Serializable {
    private static final Model instance = new Model();
    private final Map<Integer,User> model;

    public static Model getInstance(){
        return instance;

    }

    private Model (){
        model = new HashMap<>();

        model.put(1, new User("Nikita", "Veselkov",999999d));
        model.put(2, new User("Kiril", "Bilachev",99000d));
        model.put(3, new User("Alica", "Yung",10000d));

    }

    public void add(User user, int id){
        model.put(id,user);

    }
    public Map<Integer,User> getFromList(){
        return model;
    }
}
