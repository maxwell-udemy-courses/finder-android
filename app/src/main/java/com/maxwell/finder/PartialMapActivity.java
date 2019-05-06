package com.maxwell.finder;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class PartialMapActivity extends BaseActivity implements OnMapReadyCallback, View.OnClickListener {
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partial_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button scrollUp = findViewById(R.id.scrollUp);
        Button scrollDown = findViewById(R.id.scrollDown);
        Button scrollRight = findViewById(R.id.scrollRight);
        Button scrollLeft = findViewById(R.id.scrollLeft);
        Button zoomIn = findViewById(R.id.zoomIn);
        Button zoomOut = findViewById(R.id.zoomOut);

        scrollUp.setOnClickListener(this);
        scrollDown.setOnClickListener(this);
        scrollRight.setOnClickListener(this);
        scrollLeft.setOnClickListener(this);
        zoomIn.setOnClickListener(this);
        zoomOut.setOnClickListener(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.scrollUp:
                mMap.animateCamera(CameraUpdateFactory.scrollBy(0, -100));
                break;
            case R.id.scrollDown:
                mMap.animateCamera(CameraUpdateFactory.scrollBy(0, 100));
                break;
            case R.id.scrollRight:
                mMap.animateCamera(CameraUpdateFactory.scrollBy(100, 0));
                break;
            case R.id.scrollLeft:
                mMap.animateCamera(CameraUpdateFactory.scrollBy(-100, 0));
                break;
            case R.id.zoomIn:
                mMap.moveCamera(CameraUpdateFactory.zoomIn());
                break;
            case R.id.zoomOut:
                mMap.moveCamera(CameraUpdateFactory.zoomOut());
                break;
        }
    }
}
