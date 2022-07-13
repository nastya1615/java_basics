public class Computer {

    Proseccor proseccor;
     RAM ram;
     StorageDevice storageDevice;
     Screen screen;
     Keyboard keyboard;
    private final String vendor;
    private final String name;

    Computer ( Proseccor proseccor, RAM ram, StorageDevice storageDevice, Screen screen, Keyboard keyboard, String vendor,String name){
        this.keyboard = keyboard;
        this.proseccor = proseccor;
        this.ram = ram;
        this.screen = screen;
        this.storageDevice = storageDevice;
        this.vendor = vendor;
        this.name = name;
    }

    public void setProseccor(Proseccor proseccor) {
        this.proseccor = proseccor;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public void setStorageDevice(StorageDevice storageDevice) {
        this.storageDevice = storageDevice;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public double totalWeight (){
        return proseccor.getWeight() + keyboard.getWeight() + ram.getWeight() + screen.getWeight() + storageDevice.getWeight();
    }

    public String toString (){
        return "Характеристики компьютера "+ name + "\nпроизводитель: " + vendor +
                "\nПроцессор:\n" +
                "   частота: " + proseccor.getFrequency()+"\n" +
                "   количество ядер: " + proseccor.getNumberOfCores()+ "\n" +
                "   производитель: " + proseccor.getProcessorManufacturer()+ "\n" +
                "   вес: " + proseccor.getWeight()+ "\n"+
                "\nОперативная память:\n" +
                "   тип: " + ram.getTypeOfRAM()+"\n" +
                "   объем: " + ram.getVolume()+ "\n" +
                "   вес: " + ram.getWeight()+ "\n" +
                "\nНакопитель информации:\n" +
                "   тип: " + storageDevice.getTypeOfStorageDevice()+"\n" +
                "   объем: " + storageDevice.getVolume()+ "\n" +
                "   вес: " + storageDevice.getWeight()+ "\n" +
                "\nЭкран:\n" +
                "   тип: " + screen.getTypeOfScreen()+"\n" +
                "   диагональ: " + screen.getDiagonal()+ "\n" +
                "   вес: " + screen.getWeight()+ "\n" +
                "\nКлавиатура:\n" +
                "   тип: " + keyboard.getTypeOfKeyboard()+"\n" +
                "   наличие подстветки: " + keyboard.getBacklight()+ "\n" +
                "   вес: " + keyboard.getWeight()+ "\n" +
                "\nОбщий вес:"+totalWeight();



    }
}
