package data.lab;

public class Mentor {
    private int id;
    private String name;
    private String role;

    public Mentor(int id, String name, String role) {
        this.name = name;
        this.role = role;
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "middle.Mentor{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                "id:" + id + '}';
    }
}
