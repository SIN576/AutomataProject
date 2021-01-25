package example.soysin;


import javax.swing.*;
import java.util.List;

public class FAModel {
    private List<String> listAlphabet;
    private Integer numberOfState;
    private List<String> listState;
    private String startState;
    private List<String> finalState;
    private List<List<String>> transaction;


    public FAModel(List<String> listAlphabet, Integer numberOfState, List<String> listState, String startState, List<String> finalState, List<List<String>> transaction) {
        this.listAlphabet = listAlphabet;
        this.numberOfState = numberOfState;
        this.listState = listState;
        this.startState = startState;
        this.finalState = finalState;
        this.transaction = transaction;
    }

    public FAModel() {
    }

    public List<String> getListAlphabet() {
        return listAlphabet;
    }

    public void setListAlphabet(List<String> listAlphabet) {
        this.listAlphabet = listAlphabet;
    }

    public Integer getNumberOfState() {
        return numberOfState;
    }

    public void setNumberOfState(Integer numberOfState) {
        this.numberOfState = numberOfState;
    }

    public List<String> getListState() {
        return listState;
    }

    public void setListState(List<String> listState) {
        this.listState = listState;
    }

    public String getStartState() {
        return startState;
    }

    public void setStartState(String startState) {
        this.startState = startState;
    }

    public List<String> getFinalState() {
        return finalState;
    }

    public void setFinalState(List<String> finalState) {
        this.finalState = finalState;
    }

    public List<List<String>> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<List<String>> transaction) {
        this.transaction = transaction;
    }

}
