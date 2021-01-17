package example.soysin;

//this class for generate FA example: number of state: 2, FA= {q0, q1}
public class FindFA {
    protected static FAModel faModel;

    public FindFA(FAModel faModel) {
        this.faModel = faModel;
    }

    @Override
    public String toString() {
        return "FindFA{" +
                "number of state=" + faModel.getNumberOfState() +
                '}';
    }
}
