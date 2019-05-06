package com.maxwell.finder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.maxwell.finder.adapter.DemoAdapter;
import com.maxwell.finder.models.Demo;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        List<Demo> demoList = new ArrayList<>();

        demoList.add(new Demo("Basic Map", MapsActivity.class));
        demoList.add(new Demo("Partial Map", PartialMapActivity.class));
        demoList.add(new Demo("UI Map", UIMapsActivity.class));

        DemoAdapter adapter = new DemoAdapter(demoList, this);

        RecyclerView rvDemos = findViewById(R.id.rvDemos);

        rvDemos.setAdapter(adapter);

        rvDemos.setHasFixedSize(true);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);

        rvDemos.setLayoutManager(manager);
    }
}
