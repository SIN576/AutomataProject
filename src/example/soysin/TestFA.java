package example.soysin;

public class TestFA {
    protected static void testFa(){
        FAModel faModel = InputData.mainInputData(1);
        if (faModel.getNumberOfState() * faModel.getListAlphabet().size() == faModel.getTransaction().size()){
            System.out.println("DFA");
        }
    }
}
