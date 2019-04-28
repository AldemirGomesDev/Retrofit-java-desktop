package environment;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

public enum APIConnection {
	
	INSTANCE;

    private final Retrofit retrofit;

    APIConnection() {
        retrofit = new Retrofit.Builder()
                .baseUrl(EnvVariables.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

}
