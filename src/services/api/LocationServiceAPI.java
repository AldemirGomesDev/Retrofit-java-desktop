package services.api;

import models.api.LocationResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LocationServiceAPI {
	
	@GET("_current_location.php")
    Call<LocationResult> saveLocation(@Query("user_id") int user_id,
                                      @Query("user_type") String user_type,
                                      @Query("type_function") int type_function,
                                      @Query("lat") double lat,
                                      @Query("lng") double lng
    );

}
