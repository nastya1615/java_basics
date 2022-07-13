public class StorageDevice {
    private final double volume;
    private final double weight;
    private final TypeOfStorageDevice typeOfStorageDevice;

    StorageDevice( double volume, double weight, TypeOfStorageDevice typeOfStorageDevice){
        this.volume = volume;
        this.weight = weight;
        this.typeOfStorageDevice = typeOfStorageDevice;
    }

    public double getVolume() {
        return volume;
    }

    public double getWeight() {
        return weight;
    }

    public TypeOfStorageDevice getTypeOfStorageDevice() {
        return typeOfStorageDevice;
    }
}
