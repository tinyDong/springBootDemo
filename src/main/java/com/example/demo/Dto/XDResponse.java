package com.example.demo.Dto;

public class XDResponse<T> {
    private String msg;
    private Integer code;
    private T data;

    public static <T> XDResponse success(){
        XDResponse response=new XDResponse();
        response.setMsg("成功");
        response.setCode(0);
        response.setData(null);
        return response;
    }

    public static <T> XDResponse failure(String msg){
        XDResponse response=new XDResponse();
        response.setMsg(msg);
        response.setCode(-2);
        response.setData(null);
        return response;
    }

    public static <T> XDResponse sysError(){
        XDResponse response=new XDResponse();
        response.setMsg("失败");
        response.setCode(-1);
        response.setData(null);
        return response;
    }

    public static <T> XDResponse<T> success(T data){
        XDResponse response=new XDResponse();
        response.setMsg("成功");
        response.setCode(0);
        response.setData(data);
        return response;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "XDResponse{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
