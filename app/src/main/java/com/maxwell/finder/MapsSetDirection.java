package com.maxwell.finder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MapsSetDirection extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_direction);

        final EditText etOrigin = findViewById(R.id.etOrigin);
        final EditText etDestination = findViewById(R.id.etDestination);
        Button btGoToDestination = findViewById(R.id.btGoToDestination);

        btGoToDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String origin = etOrigin.getText().toString();
                String destination = etDestination.getText().toString();

                if(origin.isEmpty() || destination.isEmpty()){
                    return;
                }

                try {
                    String originEncoded = URLEncoder.encode(origin, "utf-8");
                    String destinationEncoded = URLEncoder.encode(destination, "utf-8");

                    Intent intent = new Intent(MapsSetDirection.this, MapsInputPolylineActivity.class);
                    intent.putExtra("from_location", originEncoded);
                    intent.putExtra("to_location", destinationEncoded);
                    startActivity(intent);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
