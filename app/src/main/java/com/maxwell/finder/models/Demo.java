package com.maxwell.finder.models;

import com.maxwell.finder.BaseActivity;

public class Demo {
    private String name;
    private BaseActivity activity;

    public Demo(String name, BaseActivity activity) {
        this.name = name;
        this.activity = activity;
    }

    public String getName() {
        return name;
    }

    public BaseActivity getActivity() {
        return activity;
    }
}
