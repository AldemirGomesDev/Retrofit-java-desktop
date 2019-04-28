package services.api;

import models.api.PublicidadeResult;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PublicidadeServiceAPI {
	
	@FormUrlEncoded
    @POST("marketing.php")
    Call<PublicidadeResult> getPublicidade(@Field("operation") int operation,
                                        @Field("type_user") int typeUser);

}
