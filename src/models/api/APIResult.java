package models.api;

import com.google.gson.annotations.SerializedName;

public abstract class APIResult {
	
	@SerializedName("result")
    protected int result;
    @SerializedName("msg")
    protected  String msg;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
