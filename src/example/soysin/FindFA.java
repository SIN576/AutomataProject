package example.soysin;

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
