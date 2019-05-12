package com.maxwell.finder;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;
import com.maxwell.finder.models.Direction;
import com.maxwell.finder.models.Polyline;
import com.maxwell.finder.models.Step;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MapsPolylineActivity extends BaseActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng fromLocation = new LatLng(-34.4789895,-58.6744368);
        LatLng toLocation = new LatLng(-34.476681,-58.643915);

        mMap.addMarker(new MarkerOptions().position(fromLocation));
        mMap.addMarker(new MarkerOptions().position(toLocation));

        mMap.setMinZoomPreference(15f);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(fromLocation));

        callDirectionsAPI();

//        mMap.addPolyline(new PolylineOptions()
//            .add(fromLocation, toLocation).width(5).color(Color.BLUE));
    }

    private void callDirectionsAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com/maps/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GMapsDirectionsAPI api = retrofit.create(GMapsDirectionsAPI.class);

//        Call<ResponseBody> call = api.getDirectionRaw("-34.4789895,-58.6744368", "-34.476681,-58.643915", "AIzaSyD18mE43dJ424QvArvzXD5QWdswwVIGsnY");
//
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                try {
//                    Log.e("finder_debug", response.body().string());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Log.e("finder_debug", t.getMessage());
//            }
//        });

        Call<Direction> call = api.getDirection("-34.4789895,-58.6744368", "-34.476681,-58.643915", "AIzaSyD18mE43dJ424QvArvzXD5QWdswwVIGsnY");

        call.enqueue(new Callback<Direction>() {
            @Override
            public void onResponse(Call<Direction> call, Response<Direction> response) {
                for(Step step : response.body().getRoutes().get(0).getLegs().get(0).getSteps()){
                    Polyline polyline = step.getPolyline();

                    List<LatLng> points = PolyUtil.decode(polyline.getPoints());

                    mMap.addPolyline(new PolylineOptions().addAll(points).width(5).color(Color.BLUE));
                }
            }

            @Override
            public void onFailure(Call<Direction> call, Throwable t) {
                Log.e("finder_debug", t.getMessage());
            }
        });
    }
}
