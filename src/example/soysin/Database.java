package example.soysin;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileWriter;
import java.io.IOException;


public class Database {
    private static FileWriter file;
    public static void main(String[] args) {

        JSONObject fa = Test.dfa();
        JSONObject nfa = Test.nfa();
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(fa);
        jsonArray.add(nfa);
        //Call Function Write FA to file FA.txt
        writeDataToFile(jsonArray);
        //Call Function Read FA to file FA.txt
        readDataFromFile();
    }

    public static void writeDataToFile(JSONArray jsonArray){

        // JSON Array. Key value pairs are unordered. JSONArray supports java.util.List interface.
//        JSONArray label1Array = new JSONArray();
//
//        // Add as FA JSONObject form in to Array
//        label1Array.add(fa);
//        label1Array.add(nfa);

        try {
            // Constructs a FileWriter given a file name, using the platform's default charset
            file = new FileWriter("FA.txt");
            file.write(jsonArray.toJSONString());
            //Show message if write success
          //  System.out.println("Successfully Copied JSON Object to File...");
//            System.out.println("\nJSON Object: " + jsonArray);
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

    public static JSONArray readDataFromFile(){
        JSONParser parser = new JSONParser();
        try {
            Object obj1 = parser.parse(new FileReader("FA.txt"));
            // A JSON array. JSONObject supports java.util.List interface.
            JSONArray jsonArray = (JSONArray) obj1;
          //  System.out.println("json: "+jsonArray);
            // An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
            // Iterators differ from enumerations in two ways:
            // 1. Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
            // 2. Method names have been improved.
            return jsonArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}