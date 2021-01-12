package example.soysin;

import java.util.List;

public class MainProject {
    public static void main(String[] args){
        System.out.println("*******Automata Project!********");
        System.out.println("=========Team 5 Cs G5!==========");

        List<String> stringList = InputData.inputAlphabet();
        Integer numberOfState = InputData.inputNumberOfState();
        List<String> listState = InputData.listStates(numberOfState);
        String startState = InputData.inputStartState(listState);
        List<String> listFinalState = InputData.listFinalState(listState);
        List<List<String>> transactions = InputData.transactions(listState,stringList);

        System.out.println("w = "+stringList.toString());
        System.out.println("number of state = "+numberOfState);
        System.out.println("list of state : "+ listState.toString());
        System.out.println("Start state is : "+startState);
        System.out.println("Final state is : "+listFinalState.toString());
        System.out.println("transaction : ");
        for (List<String> s: transactions) {
            System.out.println(s.get(0) + "----"+ s.get(1)+"--->"+ s.get(2));
        }
    }
}
