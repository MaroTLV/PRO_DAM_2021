package com.app.companyfp_app.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Objeto plano Java para representar el cuerpo de la petición POST /affiliates/login
 */
public class ResponseJSON {
    @SerializedName("answer")
    private String answer;
    @SerializedName("msgError")
    private String msgError;
    @SerializedName("data")
    private List data;

    public ResponseJSON(String answer, String msgError, List data) {
        this.setAnswer(answer);
        this.setMsgError(msgError);
        this.setData(data);
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
