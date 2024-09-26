package spring.learning.domain.entities;

import org.springframework.stereotype.Component;

@Component
public class Ticket {

    private Integer id;
    private String name;

    public Ticket() {
        this.id = 0;
        this.name = "";
    }
    public Ticket(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
