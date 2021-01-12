package example.soysin;

import javax.swing.*;
import java.util.List;

public class FAModel {
    private Integer numberOfState;
    private List<String> transaction;
    private List<Integer> listState;
    private Integer startState;
    private List<Integer> finalState;
    private List<String> listAlphabet;
    private Integer numberOfTransaction;

    public FAModel(Integer numberOfState) {
        this.numberOfState = numberOfState;
    }

    public Integer getNumberOfState() {
        return numberOfState;
    }

    public void setNumberOfState(Integer numberOfState) {
        this.numberOfState = numberOfState;
    }
}
