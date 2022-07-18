public class Main {
    public static void main(String[] args) {

        Computer computer = new Computer(new Proseccor(2.4,4,ProcessorManufacturer.AMD, 5,3.2),new RAM(TypeOfRAM.DDR4,5.2,20.8),
                new StorageDevice(4,8,TypeOfStorageDevice.SSD),new Screen(14.5,TypeOfScreen.VA,8.7),
                new Keyboard(TypeOfKeyboard.mechanical,Backlight.YES,7.8),"APPLE","MacBook Pro");

        computer.setProseccor(new Proseccor(2.8,4,ProcessorManufacturer.Intel,4,4));

        System.out.println(computer);

    }
}
