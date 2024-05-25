package com.example.softwareproject3_1;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class parent {
    public static final parent instance = new parent();
    private List<child> observers = new Vector<>();

    private parent() {} // Private constructor for Singleton pattern

    public static parent getInstance() {
        return instance;
    }

    public void addChildObserver(child observer) {

        observers.add(observer);
        Log.d("ObserverRegistration", "Observer added: " + observer.getClass().getSimpleName());
        Log.d("parent", String.valueOf(observers.size()));
        notifyChildObservers();


    }



    public void notifyChildObservers( ) {



        for (child observer : observers) {
            observer.afterchange( );
            Log.d("parent", "notifyChildObservers() called");


        }
    }
}
