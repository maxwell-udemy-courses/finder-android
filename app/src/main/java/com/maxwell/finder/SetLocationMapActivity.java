package com.maxwell.finder;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class SetLocationMapActivity extends BaseActivity implements OnMapReadyCallback {
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_location_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        final EditText etFind = findViewById(R.id.etFind);
        Button btFind = findViewById(R.id.btFind);

        btFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = etFind.getText().toString();

                if(word.isEmpty()){
                    return;
                }

                Address address = getLocationFromAddress(word);

                LatLng location = new LatLng(address.getLatitude(), address.getLongitude());

                Log.e("finder_debug", "lat: " + location.latitude + " lng:" + location.longitude);

                mMap.addMarker(new MarkerOptions().position(location).title(address.getAddressLine(0)));
                mMap.setMinZoomPreference(15);
                mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
            }
        });
    }

    private Address getLocationFromAddress(String sAddress){
        Geocoder coder = new Geocoder(SetLocationMapActivity.this);
        List<Address> addressList;

        try {
            addressList = coder.getFromLocationName(sAddress, 1);

            if(addressList == null){
                return null;
            }

            return addressList.get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }
}
