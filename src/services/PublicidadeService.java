package services;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import environment.APIConnection;
import models.api.PublicidadeResult;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import services.api.PublicidadeServiceAPI;

public enum PublicidadeService {
	
	INSTANCE;

    private Retrofit retrofit;

    PublicidadeService() {
        retrofit = APIConnection.INSTANCE.getRetrofit();
    }

    public PublicidadeResult getPublicidade() throws IOException {
        PublicidadeServiceAPI service = retrofit.create(PublicidadeServiceAPI.class);

        Call<PublicidadeResult> call = service.getPublicidade(3, 1);

        PublicidadeResult result = null;

        Response<PublicidadeResult> response = call.execute();
        result = response.body();

        if (response.code() != 200) {
            result = getRideResult(response);
        }

        return result;
    }

    private PublicidadeResult getRideResult(Response<PublicidadeResult> response) throws IOException {
        PublicidadeResult result = null;

        TypeAdapter<PublicidadeResult> adapter = new Gson().getAdapter(PublicidadeResult.class);

        if (response.errorBody() != null)
            result = adapter.fromJson(response.errorBody().string());

        return result;
    }

}
