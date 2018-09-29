package ResultType;

import com.alibaba.fastjson.JSONObject;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午10:59 2018/9/29
 * @ Description：响应的Json格式 status msg data
 * @ Modified By：
 * @Version: $
 */
public class ResponseResult {

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public static ResponseResult build(Integer status, String msg, Object data) {
        return new ResponseResult(status, msg, data);
    }

    public static ResponseResult build(Integer status, String msg) {
        return new ResponseResult(status, msg, null);
    }

    public ResponseResult (Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    //OK 响应成功，有返回数据Data
    public static ResponseResult ok(Object data) {
        return new ResponseResult(data);
    }
    //响应成功，返回数据Data为null
    public static ResponseResult ok() {
        return new ResponseResult(null);
    }


    public ResponseResult (Object data) { //响应成功
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }
    public ResponseResult() {

    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }



}
