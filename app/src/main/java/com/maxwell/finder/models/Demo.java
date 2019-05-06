package com.maxwell.finder.models;

import com.maxwell.finder.BaseActivity;
import com.maxwell.finder.MapsActivity;

public class Demo {
    private String name;
    private Class activity;

    public Demo(String name, Class activity) {
        this.name = name;
        this.activity = activity;
    }

    public String getName() {
        return name;
    }

    public Class getActivity() {
        return activity;
    }
}
