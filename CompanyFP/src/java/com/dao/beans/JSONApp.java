package com.dao.beans;

import java.util.List;

public class JSONApp {


    private String answer;
    private String msgError;
    private List data;

    
    public JSONApp(String resultado, String msgError, List objects) {
        this.answer = resultado;
        this.msgError = msgError;
        this.data = objects;
    }
    
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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
}
