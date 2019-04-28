package services;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import environment.APIConnection;
import models.api.LocationResult;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import services.api.LocationServiceAPI;

public enum LocationService {
	
	INSTANCE;

    private Retrofit retrofit;

    LocationService() {
        retrofit = APIConnection.INSTANCE.getRetrofit();
    }

    public LocationResult saveLocation(int user_id, String user_type, int type_function, double lat, double lng ) throws IOException {
        LocationServiceAPI service = retrofit.create(LocationServiceAPI.class);

        Call<LocationResult> call = service.saveLocation(user_id, user_type, type_function, lat, lng);

        LocationResult result = null;

        Response<LocationResult> response = call.execute();
        result = response.body();

        if (response.code() != 200) {
            result = getResult(response);
        }

        return result;
    }

    private LocationResult getResult(Response<LocationResult> response) throws IOException {
        LocationResult result = null;

        TypeAdapter<LocationResult> adapter = new Gson().getAdapter(LocationResult.class);

        if (response.errorBody() != null)
            result = adapter.fromJson(response.errorBody().string());

        return result;
    }
}
