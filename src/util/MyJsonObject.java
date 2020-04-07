package util;

public class MyJsonObject<T> {

    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public MyJsonObject() {
    }

    public MyJsonObject(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String toJsonObject(){
        String json = "";
        json += "{/r" + "code:" + code + "/r";
        json += "msg:" + msg + "/r";
        json += "data:{"+"/r" + data.toString() + "/r" + "}";
        return json;
    }

}
