public class Proseccor {
    private final double frequency;
    private final int numberOfCores;
    private final ProcessorManufacturer processorManufacturer;
    private final double volume;
    private final double weight;

    Proseccor (double frequency,int numberOfCores,ProcessorManufacturer processorManufacturer, double volume, double weight){
        this.frequency = frequency;
        this.numberOfCores = numberOfCores;
        this.processorManufacturer = processorManufacturer;
        this.volume = volume;
        this.weight = weight;
    }


    public double getFrequency() {
        return frequency;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public ProcessorManufacturer getProcessorManufacturer() {
        return processorManufacturer;
    }

    public double getVolume() {
        return volume;
    }

    public double getWeight() {
        return weight;
    }
}
