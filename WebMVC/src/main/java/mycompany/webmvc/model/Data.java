package mycompany.webmvc.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Data {

    public static Data inst = new Data();

    private final List<String> data = new CopyOnWriteArrayList<String>();

    private Data() {
        add("Hello");
    }

    public List<String> getAll() {
        return data;
    }

    public void add(String item) {
        data.add(item);
    }

}
