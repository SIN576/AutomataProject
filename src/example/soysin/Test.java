package example.soysin;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        JSONObject fa = dfa();
        JSONObject nfa = nfa();

        JSONArray objects = fa.getJSONArray("transactions");
        JSONObject object = objects.getJSONObject(0);
        JSONArray jsonArray = object.getJSONArray("tx1");
        System.out.println(jsonArray.get(1));
    }
    public static JSONObject dfa(){
        //create object
        JSONObject fa = new JSONObject();

        JSONArray jsonArray = new JSONArray();
        jsonArray.put("a");
        jsonArray.put("b");
        fa.put("alphabets",jsonArray);

        fa.put("numberOfState",3);
        fa.put("listState",InputData.listStates(3));
        fa.put("startState","q0");

        JSONArray jsonArray1 = new JSONArray();
        jsonArray1.put("q1");
        fa.put("finalStates",jsonArray1);

        JSONArray jsonArray2 = new JSONArray();
        jsonArray2.put("q0");
        jsonArray2.put("a");
        jsonArray2.put("q1");


        JSONArray jsonArray3 = new JSONArray();
        jsonArray3.put("q0");
        jsonArray3.put("b");
        jsonArray3.put("q0");

        JSONArray jsonArray4 = new JSONArray();
        jsonArray4.put("q1");
        jsonArray4.put("a");
        jsonArray4.put("q2");

        JSONArray jsonArray5 = new JSONArray();
        jsonArray5.put("q1");
        jsonArray5.put("b");
        jsonArray5.put("q1");

        JSONArray jsonArray6 = new JSONArray();
        jsonArray6.put("q2");
        jsonArray6.put("a");
        jsonArray6.put("q2");

        JSONArray jsonArray7 = new JSONArray();
        jsonArray7.put("q2");
        jsonArray7.put("b");
        jsonArray7.put("q2");

        JSONArray transactions = new JSONArray();
        JSONObject txs = new JSONObject();
        txs.put("tx1",jsonArray2);
        txs.put("tx2",jsonArray3);
        txs.put("tx3",jsonArray4);
        txs.put("tx4",jsonArray5);
        txs.put("tx5",jsonArray6);
        txs.put("tx6",jsonArray7);


        transactions.put(txs);

        fa.put("transactions",transactions);
        return fa;
    }
    public static JSONObject nfa(){
        JSONObject fa = new JSONObject();

        JSONArray jsonArray = new JSONArray();
        jsonArray.put("a");
        jsonArray.put("b");
        fa.put("alphabets",jsonArray);

        fa.put("numberOfState",3);
        fa.put("listState",InputData.listStates(3));
        fa.put("startState","q0");

        JSONArray jsonArray1 = new JSONArray();
        jsonArray1.put("q1");
        fa.put("finalStates",jsonArray1);

        JSONArray jsonArray2 = new JSONArray();
        jsonArray2.put("q0");
        jsonArray2.put("a");
        jsonArray2.put("q1");

        JSONArray jsonArray3 = new JSONArray();
        jsonArray3.put("q0");
        jsonArray3.put("o");
        jsonArray3.put("q0");

        JSONArray jsonArray4 = new JSONArray();
        jsonArray4.put("q1");
        jsonArray4.put("a");
        jsonArray4.put("q2");

        JSONArray jsonArray6 = new JSONArray();
        jsonArray6.put("q2");
        jsonArray6.put("a");
        jsonArray6.put("q2");

        JSONArray jsonArray7 = new JSONArray();
        jsonArray7.put("q2");
        jsonArray7.put("b");
        jsonArray7.put("q2");

        JSONArray transactions = new JSONArray();
        transactions.put(jsonArray2);
        transactions.put(jsonArray3);
        transactions.put(jsonArray4);
        transactions.put(jsonArray6);
        transactions.put(jsonArray7);

        fa.put("transactions",transactions);
        return fa;
    }


}
