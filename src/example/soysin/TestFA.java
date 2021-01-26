package example.soysin;

import java.util.List;

public class TestFA {
    protected static boolean testFa(){
        FAModel faModel = InputData.mainInputData(1);

//        for (List<String> tx:
//             faModel.getTransaction()) {
//            if (tx.get(1).equals("o")){
//                System.out.println("NFA**");
//                return false;
//            }
//        }
        if (faModel.getNumberOfState() * faModel.getListAlphabet().size() == faModel.getTransaction().size()){
            return true;
        }
        else {
            return false;
        }
    }
}
