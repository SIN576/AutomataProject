package example.soysin;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Test {

    public static void main(String[] args) {
        JSONObject fa = dfa();
        JSONObject nfa = nfa();

        System.out.println(fa);
        System.out.println(nfa);
        JSONArray alphabets = (JSONArray) fa.get("alphabets");
        System.out.println(alphabets);
        System.out.println(fa.get("numberOfState"));
        System.out.println(fa.get("listState"));
        System.out.println(fa.get("finalStates"));
        System.out.println(fa.get("transactions"));

        alphabets = (JSONArray) nfa.get("alphabets");
        System.out.println(alphabets);
        System.out.println(nfa.get("numberOfState"));
        System.out.println(nfa.get("listState"));
        System.out.println(nfa.get("finalStates"));
        System.out.println(nfa.get("transactions"));
    }
    public static JSONObject nfa1(){
        //create object
        JSONObject fa = new JSONObject();

        JSONArray alphabets = new JSONArray();
        alphabets.add("a");
        alphabets.add("b");

        Integer numberOfState = 2;
        JSONArray listState = InputData.listStates(numberOfState);
        JSONArray finalStates = new JSONArray();
        finalStates.add("q1");

        JSONArray transaction1 = new JSONArray();
        transaction1.add("q0");
        transaction1.add("a");
        transaction1.add("q1");

        JSONArray transaction2 = new JSONArray();
        transaction2.add("q0");
        transaction2.add("b");
        transaction2.add("q0");

        JSONArray transaction3 = new JSONArray();
        transaction3.add("q0");
        transaction3.add("b");
        transaction3.add("q1");

        JSONArray transaction4 = new JSONArray();
        transaction4.add("q1");
        transaction4.add("a");
        transaction4.add("q1");

        JSONArray transactions = new JSONArray();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);

        fa.put("alphabets",alphabets);
        fa.put("numberOfState",numberOfState);
        fa.put("listState",listState);
        fa.put("startState","q0");
        fa.put("finalStates",finalStates);
        fa.put("transactions",transactions);

        return fa;
    }
    public static JSONObject dfa(){
        //create object
        JSONObject fa = new JSONObject();

        JSONArray alphabets = new JSONArray();
        alphabets.add("a");
        alphabets.add("b");

        Integer numberOfState = 2;
        JSONArray listState = InputData.listStates(numberOfState);
        JSONArray finalStates = new JSONArray();
        finalStates.add("q1");

        JSONArray transaction1 = new JSONArray();
        transaction1.add("q0");
        transaction1.add("a");
        transaction1.add("q1");

        JSONArray transaction2 = new JSONArray();
        transaction2.add("q0");
        transaction2.add("b");
        transaction2.add("q0");

        JSONArray transaction3 = new JSONArray();
        transaction3.add("q1");
        transaction3.add("b");
        transaction3.add("q1");

        JSONArray transaction4 = new JSONArray();
        transaction4.add("q1");
        transaction4.add("a");
        transaction4.add("q1");

        JSONArray transactions = new JSONArray();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);

        fa.put("alphabets",alphabets);
        fa.put("numberOfState",numberOfState);
        fa.put("listState",listState);
        fa.put("startState","q0");
        fa.put("finalStates",finalStates);
        fa.put("transactions",transactions);

        return fa;
    }
    public static JSONObject nfa2(){
        JSONObject fa = new JSONObject();
        JSONArray alphabets = new JSONArray();
        alphabets.add("a");
        alphabets.add("b");

        Integer numberOfState = 2;
        JSONArray listState = InputData.listStates(numberOfState);
        JSONArray finalStates = new JSONArray();
        finalStates.add("q1");

        JSONArray transaction1 = new JSONArray();
        transaction1.add("q0");
        transaction1.add("a");
        transaction1.add("q1");

        JSONArray transaction2 = new JSONArray();
        transaction2.add("q0");
        transaction2.add("b");
        transaction2.add("q0");

        JSONArray transaction3 = new JSONArray();
        transaction3.add("q1");
        transaction3.add("b");
        transaction3.add("q1");

        JSONArray transactions = new JSONArray();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction3);

        fa.put("alphabets",alphabets);
        fa.put("numberOfState",numberOfState);
        fa.put("listState",listState);
        fa.put("startState","q0");
        fa.put("finalStates",finalStates);
        fa.put("transactions",transactions);

        return fa;
    }
    public static JSONObject nfaE(){
        JSONObject fa = new JSONObject();
        JSONArray alphabets = new JSONArray();
        alphabets.add("a");
        alphabets.add("b");

        Integer numberOfState = 2;
        JSONArray listState = InputData.listStates(numberOfState);
        JSONArray finalStates = new JSONArray();
        finalStates.add("q1");

        JSONArray transaction1 = new JSONArray();
        transaction1.add("q0");
        transaction1.add("a");
        transaction1.add("q1");

        JSONArray transaction2 = new JSONArray();
        transaction2.add("q0");
        transaction2.add("b");
        transaction2.add("q0");

        JSONArray transaction3 = new JSONArray();
        transaction3.add("q1");
        transaction3.add("b");
        transaction3.add("q1");

        JSONArray transaction4 = new JSONArray();
        transaction4.add("q1");
        transaction4.add("o");
        transaction4.add("q1");


        JSONArray transactions = new JSONArray();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);

        fa.put("alphabets",alphabets);
        fa.put("numberOfState",numberOfState);
        fa.put("listState",listState);
        fa.put("startState","q0");
        fa.put("finalStates",finalStates);
        fa.put("transactions",transactions);

        return fa;
    }
    public static JSONObject nfa(){
        JSONObject fa = new JSONObject();
        JSONArray alphabets = new JSONArray();
        alphabets.add("a");
        alphabets.add("b");

        Integer numberOfState = 2;
        JSONArray listState = InputData.listStates(numberOfState);
        JSONArray finalStates = new JSONArray();
        finalStates.add("q1");

        JSONArray transaction1 = new JSONArray();
        transaction1.add("q0");
        transaction1.add("a");
        transaction1.add("q1");

        JSONArray transaction2 = new JSONArray();
        transaction2.add("q0");
        transaction2.add("b");
        transaction2.add("q0");

        JSONArray transaction3 = new JSONArray();
        transaction3.add("q1");
        transaction3.add("b");
        transaction3.add("q1");

        JSONArray transaction4 = new JSONArray();
        transaction3.add("q1");
        transaction3.add("b");
        transaction3.add("q1");


        JSONArray transactions = new JSONArray();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);

        fa.put("alphabets",alphabets);
        fa.put("numberOfState",numberOfState);
        fa.put("listState",listState);
        fa.put("startState","q0");
        fa.put("finalStates",finalStates);
        fa.put("transactions",transactions);

        return fa;
    }


}
