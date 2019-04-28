package models.api;

import com.google.gson.annotations.SerializedName;

import models.Publicidade;

public class PublicidadeResult extends APIResult {
	
	@SerializedName("publicidade")
    private Publicidade publicidade;

    public Publicidade getPublicidade() {
        return publicidade;
    }

    @Override
    public String toString() {
        return "PublicidadeResult{" +
                "publicidade=" + publicidade +
                ", result=" + result +
                ", msg='" + msg + '\'' +
                '}';
    }

}
