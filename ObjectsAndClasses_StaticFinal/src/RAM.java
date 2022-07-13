public class RAM {
    private final TypeOfRAM typeOfRAM;
    private final double volume;
    private final double weight;

    RAM(TypeOfRAM typeOfRAM, double volume, double weight){
        this.typeOfRAM = typeOfRAM;
        this.volume = volume;
        this.weight = weight;
    }

    public TypeOfRAM getTypeOfRAM() {
        return typeOfRAM;
    }

    public double getVolume() {
        return volume;
    }

    public double getWeight() {
        return weight;
    }
}
