package example.soysin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.IOException;


public class Database {
    private static FileWriter file;
    public static void main(String[] args) {
        List<String> listAlphabet = new ArrayList<>();
        listAlphabet.add("a");
        listAlphabet.add("b");

        Integer numberOfState = 3;
        List<String> listOfState = InputData.listStates(numberOfState);
        String startState = "q0";
        List<String> listFinalStates = new ArrayList<>();
        listFinalStates.add("q1");

        List<String> eachTX = new ArrayList<>();
        eachTX.add("q0");
        eachTX.add("a");
        eachTX.add("q1");

        List<List<String>> tXs = new ArrayList<>();
        tXs.add(eachTX);

        FAModel faModel1 = new FAModel(listAlphabet, numberOfState, listOfState, startState, listFinalStates, tXs);

        List<FAModel> faModelList = new ArrayList<>();
        faModelList.add(faModel1);

        faModelList.add(faModel1);
//
//        for (FAModel f : faModelList
//        ) {
//            System.out.println(f.getListAlphabet().toString());
//        }
        org.json.JSONObject fa = Test.dfa();
        org.json.JSONObject nfa = Test.nfa();
        writeDataToFile(listAlphabet,numberOfState , listOfState , "q0", listFinalStates , eachTX);
    }

    public static void writeDataToFile(List<String> listAlphabet, int state, List<String> listOfState , String startState , List<String> listFinalStates, List<String> eachTX){

        JSONObject label1Object = new JSONObject();
        JSONArray label1Array = new JSONArray();
        JSONArray label2Array = new JSONArray();

        label1Array.add(label1Object);
        label1Object.put("alphabet", listAlphabet);
        label1Object.put("state", state);
        label1Object.put("listOfState", listOfState);
        label1Object.put("stateState", startState);
        label1Object.put("finalState", listFinalStates);
        label1Object.put("transaction",eachTX);
        label1Object.put("finalState", listFinalStates);


        try {
            // Constructs a FileWriter given a file name, using the platform's default charset
            file = new FileWriter("Srunchify.txt");
            file.write(label1Array.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + label1Array);
        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void readDataFromFile(){
        JSONParser parser = new JSONParser();
        try {
            Object obj1 = parser.parse(new FileReader("Srunchify.txt"));
            JSONObject jsonObject = (JSONObject) obj1;
            System.out.println(jsonObject.get("Author"));
            JSONArray companyList = (JSONArray) jsonObject.get("Company List");
            Iterator<JSONObject> iterator = companyList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

