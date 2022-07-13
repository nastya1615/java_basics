public class Screen {
    private final double diagonal;
    private final TypeOfScreen typeOfScreen;
    private final double weight;

    Screen (double diagonal, TypeOfScreen typeOfScreen,double weight){

        this.diagonal = diagonal;
        this.typeOfScreen = typeOfScreen;
        this.weight = weight;

    }

    public double getDiagonal() {
        return diagonal;
    }

    public TypeOfScreen getTypeOfScreen() {
        return typeOfScreen;
    }

    public double getWeight() {
        return weight;
    }
}
