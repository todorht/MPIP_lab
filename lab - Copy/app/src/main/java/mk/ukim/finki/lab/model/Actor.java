package mk.ukim.finki.lab.model;

public class Actor {

    private Long id;
    private String name;
    private String surname;

    public Actor(String name, String surname) {
        this.id = (long) (Math.random() *1000);
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
