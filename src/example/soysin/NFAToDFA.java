package example.soysin;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class NFAToDFA {
    private static JSONArray newListState =new JSONArray();
    private static JSONArray newTransaction = new JSONArray();
    private static String newStartState = "";
    private static JSONArray newFinalStates = new JSONArray();
    private static String rejectState = "";
    private static JSONArray oldStates= new JSONArray();
    private static JSONArray listOldStates= new JSONArray();

    public static void main(String[] args) {
        System.out.println(Test.nfa());

        if (oldStates.isEmpty()){
            oldStates.add("q0");
            oldStates.add("q1");
        }
        //for store old list state
        //store old list state in list
        listOldStates.add(oldStates);
        convertNFAtoDFA(Test.nfa());

        System.out.println("newListState: "+newListState.toString());
        System.out.println("newStartState: "+newStartState);
        System.out.println("rejectState: "+rejectState);
        System.out.println("newFinalStates: "+newFinalStates);
        System.out.println("newTransaction: "+newTransaction.toString());
       // convertNFAtoDFA(Test.nfaE());
    }
    public static int num = 0;
    public static String state1 = "q0'";
    public static String oldState = "q0'";
    //function convert nfa to dfa
    public static JSONObject convertNFAtoDFA(JSONObject nfa){
        JSONObject jsonObject = new JSONObject();
        JSONArray transactions = (JSONArray) nfa.get("transactions");
        System.out.println("transactions: "+transactions);
        JSONArray alphabets = (JSONArray) nfa.get("alphabets");
        JSONArray finalStates = (JSONArray) nfa.get("finalStates");
        newListState.add("q0'");
        newStartState = "q0'";
        oldStates = new JSONArray();
        oldStates = (JSONArray) listOldStates.get(num);
//        System.out.println(oldStates);
//        System.out.println(newListState);
        String state = null;

        for (int j = 0; j < alphabets.size(); j++) {
           // System.out.println(oldStates.get(i));
            oldState = state1;
            for (int i = 0; i < oldStates.size(); i++) {
                state = transaction((String) oldStates.get(i), (String) alphabets.get(j),transactions,finalStates);
               // System.out.println(state);
                //System.out.println(newListState.get(num)+"--->"+alphabets.get(j)+"--->"+state);
                state1=state;
              //  System.out.println(count);
                if (!isValid(state,newListState)){
                    newListState.add(state);
                }
            }
        }
        System.out.println(listState);
//        num = num + 1;
//       // System.out.println(num+" vs "+ listOldStates.size());
//        if (num < listOldStates.size()){
//            convertNFAtoDFA(nfa);
//        }
        return jsonObject;
    }
    //function find sate
    public static String transaction(String state, String alphabet,JSONArray transactions,JSONArray finalStates){
        //System.out.println("transactions2: "+transactions);
        String toState ="qREJECT";
//        System.out.println(state);
//        System.out.println(alphabet);
        System.out.println("");
        for (int i = 0; i < transactions.size() ; i++) {
            JSONArray transaction = (JSONArray) transactions.get(i);
           // System.out.println("transaction: "+transaction);
            if (state.equals(transaction.get(0)) ){
               // System.out.println(transaction);
                if (alphabet.equals(transaction.get(1))){
                    System.out.println(transaction.get(0)+"---->"+alphabet+"---->"+transaction.get(2));
                    toState = (String) transaction.get(2);
                    JSONArray listState =isValidE(toState,transactions);
                    // System.out.println(listState);
                    if (!checkObject(listState)){
                        String state1 = "q"+newListState.size()+"'";
                        // String state1 ="test";
                        checkFinalState(listState,finalStates);
                        //    System.out.println(state1);
                        checkObject(listState);
                        toState = state1;
                        break;
                    }
                }
            }
        }
        if (toState.equals("qREJECT")){
            System.out.println(state+"---->"+alphabet+"---->{}");
        }
        return toState;
    }
    public static void checkFinalState(JSONArray listState,JSONArray finalStates){
        for (int i = 0; i < listState.size(); i++) {
            for (int j = 0; j < finalStates.size(); j++) {
                if (listState.get(i).equals(finalStates.get(j))){
                    String state= "q"+newListState.size()+"'";
                    newFinalStates.add(state);
                    return;
                }
            }
        }
        return;
    }
    public static boolean checkObject(JSONArray jsonArray){
       // System.out.println(jsonArray);
        for (int i = 0; i < listOldStates.size(); i++) {
            if (jsonArray.equals(listOldStates.get(i))){
                return true;
            };
        }
        listOldStates.add(jsonArray);
        return false;
    }
    public static JSONArray listState = new JSONArray();

    //function check is valid E transaction or not
    public static JSONArray isValidE(String state, JSONArray transactions){
        if (!isValid(state,listState)){
            listState.add(state);
        }
        for (int i = 0; i < transactions.size(); i++) {
            JSONArray transaction = (JSONArray) transactions.get(i);
            if (state.equals(transaction.get(0)) && transaction.get(1).equals("o")&&!isValid((String) transaction.get(2),listState)){
               // System.out.println(transaction.get(0)+"--->"+transaction.get(1)+"--->"+transaction.get(2));
                listState.add(transaction.get(2));
            }
        }
      //  System.out.println(listState.toString());
        return listState;
    }
    //function check state is valid or not
    public static boolean isValid(String state,JSONArray listState){
      //  System.out.println("listSate:"+ listState);
      //  System.out.println("state: "+ state);
        for (int i = 0; i < listState.size() ; i++) {
            if (listState.get(i).equals(state)){
                return true;
            }
        }
        return false;
    }
}
