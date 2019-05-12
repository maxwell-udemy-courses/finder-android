package com.maxwell.finder;

import com.maxwell.finder.models.Direction;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GMapsDirectionsAPI {
    @GET("directions/json")
    Call<Direction> getDirection(@Query("origin") String origin, @Query("destination") String destination, @Query("key") String key);

    @GET("directions/json")
    Call<ResponseBody> getDirectionRaw(@Query("origin") String origin, @Query("destination") String destination, @Query("key") String key);
}
