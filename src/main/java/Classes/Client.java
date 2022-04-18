package Classes;

import java.util.List;
import java.util.regex.Pattern;

public class Client extends Entity{
    public String name;
    public User contactPerson;
    public String email;
    public String phone;

    public static void copyClient(Client sourceClient, Client destinationClient){
        destinationClient.name = sourceClient.name;
        destinationClient.contactPerson = sourceClient.contactPerson;
        destinationClient.email = sourceClient.email;
        destinationClient.phone = sourceClient.phone;
        destinationClient.updated = sourceClient.updated;
    }

    public static Client findById(List<Client> clients, String id) {
        return clients.stream().filter(c -> c.id.equals(id)).findFirst().orElse(null);
    }

    public boolean isEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(regex, email);
    }

    public boolean isPhone(String phone) {
        String regex = "^[07]{2}[0-9]{8}$";
        return Pattern.matches(regex, phone);
    }
}
