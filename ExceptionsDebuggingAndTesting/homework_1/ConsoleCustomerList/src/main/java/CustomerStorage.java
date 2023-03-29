import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        int INDEX_PHONE = 3;
        String[] components = data.split("\\s+");

        String rejexPhone = "^(8|\\+7)\\d{10}";
        String rejexEmail = "[A-Za-z1-9_.]+@[a-z]+.(ru|com)";

        if (components.length != 4) {
            throw new IllegalArgumentException("Некорректный формат данных, верный формат данных:\n" +
                    "add Василий Петров vasily.petrov@gmail.com +79215637722");
        }

        if (components[INDEX_EMAIL].matches(rejexEmail)==false){
            throw new IllegalArgumentException("некорректный формат электронной почты, правильный формат : nastya1615325@gmail.com");
        }

        if (components[INDEX_PHONE].matches(rejexPhone) == false) {
            throw new IllegalArgumentException("некорректный формат номера, правильный формат : +79371615325 или 89371615325");
        }

        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {

        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}