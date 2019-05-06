package com.maxwell.finder;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class LocationsMapActivity extends BaseActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    public static final CameraPosition ARGENTINA =
            new CameraPosition.Builder().target(new LatLng(-35.1143641,-65.260953))
                .zoom(15)
                .tilt(10)
                .build();

    public static final CameraPosition ESPAÑA =
            new CameraPosition.Builder().target(new LatLng(40.4381311,-3.8196196))
                    .zoom(15)
                    .tilt(20)
                    .build();

    public static final CameraPosition CHINA =
            new CameraPosition.Builder().target(new LatLng(34.4375405,104.0626254))
                    .zoom(15)
                    .tilt(50)
                    .build();

    public static final CameraPosition IRLANDA =
            new CameraPosition.Builder().target(new LatLng(54.4627617,-7.0369448))
                    .zoom(15)
                    .tilt(65)
                    .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button btArg = findViewById(R.id.btArg);
        btArg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(ARGENTINA));
            }
        });

        Button btEsp = findViewById(R.id.btEsp);
        btEsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(ESPAÑA));
            }
        });

        Button btChi = findViewById(R.id.btChi);
        btChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(CHINA));
            }
        });

        Button btIrl = findViewById(R.id.btIrl);
        btIrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(IRLANDA));
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }
}
