public class Keyboard {
    private final TypeOfKeyboard typeOfKeyboard;
    private final Backlight backlight;
    private final double weight;

    public Keyboard(TypeOfKeyboard typeOfKeyboard, Backlight backlight, double weight) {
        this.typeOfKeyboard = typeOfKeyboard;
        this.backlight = backlight;
        this.weight = weight;
    }

    public TypeOfKeyboard getTypeOfKeyboard() {
        return typeOfKeyboard;
    }

    public Backlight getBacklight() {
        return backlight;
    }

    public double getWeight() {
        return weight;
    }
}
