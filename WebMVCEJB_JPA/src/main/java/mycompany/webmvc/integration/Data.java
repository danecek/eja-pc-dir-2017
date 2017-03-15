package mycompany.webmvc.integration;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

@Singleton
public class Data {

    private final List<String> data = new ArrayList<>();

    @PostConstruct
    void init() {
        add("Hello");
    }

    @Lock(LockType.READ)
    public List<String> getAll() {
        return data;
    }

    @Lock(LockType.WRITE)
    public void add(String item) {
        data.add(item);
    }

}
