package example.soysin;


import org.json.JSONArray;

import java.util.List;

public class FAModel {
    private JSONArray listAlphabet;
    private Integer numberOfState;
    private JSONArray listState;
    private String startState;
    private JSONArray finalState;
    private JSONArray transaction;


    public FAModel(JSONArray listAlphabet, Integer numberOfState, JSONArray listState, String startState, JSONArray finalState, JSONArray transaction) {
        this.listAlphabet = listAlphabet;
        this.numberOfState = numberOfState;
        this.listState = listState;
        this.startState = startState;
        this.finalState = finalState;
        this.transaction = transaction;
    }

    public JSONArray getListAlphabet() {
        return listAlphabet;
    }

    public void setListAlphabet(JSONArray listAlphabet) {
        this.listAlphabet = listAlphabet;
    }

    public Integer getNumberOfState() {
        return numberOfState;
    }

    public void setNumberOfState(Integer numberOfState) {
        this.numberOfState = numberOfState;
    }

    public JSONArray getListState() {
        return listState;
    }

    public void setListState(JSONArray listState) {
        this.listState = listState;
    }

    public String getStartState() {
        return startState;
    }

    public void setStartState(String startState) {
        this.startState = startState;
    }

    public JSONArray getFinalState() {
        return finalState;
    }

    public void setFinalState(JSONArray finalState) {
        this.finalState = finalState;
    }

    public JSONArray getTransaction() {
        return transaction;
    }

    public void setTransaction(JSONArray transaction) {
        this.transaction = transaction;
    }

}
