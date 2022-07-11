public class Cargo {

    private final double weight;
    private final String deliveryAddress;
    private final boolean allowedToFlip;
    private final String registrationNumber;
    private final boolean fragile;
    private final Dimensions dimensions;

    public Cargo(double weight, String deliveryAddress, boolean allowedToFlip, String registrationNumber, boolean fragile, Dimensions dimensions) {
        this.weight = weight;
        this.registrationNumber = registrationNumber;
        this.fragile = fragile;
        this.deliveryAddress = deliveryAddress;
        this.allowedToFlip = allowedToFlip;
        this.dimensions = dimensions;
    }

    public Cargo setDeliveryAddress(String deliveryAddress) {
        return new Cargo(weight, deliveryAddress, allowedToFlip, registrationNumber, fragile, dimensions);
    }

    public Cargo setDimensions(Dimensions dimensions) {
        return new Cargo(weight, deliveryAddress, allowedToFlip, registrationNumber, fragile, dimensions);

    }

    public Cargo setWeight(Double weight) {
        return new Cargo(weight, deliveryAddress, allowedToFlip, registrationNumber, fragile, dimensions);
    }


    public double getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public boolean getAllowedToFlip() {
        return allowedToFlip;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean getFragile() {
        return fragile;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }


}
