package mk.ukim.finki.dians.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.dians.model.User;
import mk.ukim.finki.dians.model.Wine;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class DataHolder {

    public static List<Wine> wines = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    List<Long> id = null;
    List<String> name = null;
    List<String> address = null;
    List<String> phone = null;
    List<String> website = null;
    List<String>  openingHours = null;
    List<Double> lat = null;
    List<Double> lon = null;


    @PostConstruct
    public void init() throws IOException {
        wines = new ArrayList<>();
        id = new ArrayList<>();
        name = new ArrayList<>();
        address = new ArrayList<>();
        phone = new ArrayList<>();
        website = new ArrayList<>();
        openingHours = new ArrayList<>();
        lat = new ArrayList<>();
        lon = new ArrayList<>();
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("Data/output.txt");
        assert inputStream!=null;
        Scanner scanner = new Scanner(inputStream);

        //String[] columnNames = bufferedReader.nextLine().split(",");

        String line;
        scanner.nextLine();
        while (scanner.hasNextLine())   //returns a Boolean value
        {
            line = scanner.nextLine();
            String[] parts = line.split(",");
            id.add(Long.valueOf(parts[0]));
            name.add(parts[1]);
            address.add(parts[2]);
            phone.add(parts[3]);
            website.add(parts[4]);
            openingHours.add(parts[5]);
            lat.add(Double.valueOf(parts[6]));
            lon.add(Double.valueOf(parts[7]));
        }

        for(int i=0; i < id.size();i++){
            wines.add(new Wine(id.get(i), name.get(i), address.get(i), phone.get(i), website.get(i), openingHours.get(i), lat.get(i), lon.get(i)));
        }

        users.add(new User("Admin", "admin", "admin@gmail.com"));
    }
}
