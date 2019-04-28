package models;

import com.google.gson.annotations.SerializedName;

public class Publicidade {
	
	@SerializedName("id")
    private int id;
    @SerializedName("type_user")
    private int typeUser;
    @SerializedName("message")
    private String message;
    @SerializedName("url_img")
    private String urlImage;
    @SerializedName("link")
    private String link;
    @SerializedName("status")
    private int status;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTypeUser() {
		return typeUser;
	}
	public void setTypeUser(int typeUser) {
		this.typeUser = typeUser;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "Publicidade [id=" + id + ", typeUser=" + typeUser + ", message=" + message + ", urlImage=" + urlImage
				+ ", link=" + link + ", status=" + status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ "]";
	}
    
    

}
