package workspace.previous;

import java.util.Objects;

public class Animal {
    private String name;
    private String color;
    private String type;

    public Animal(String name, String color, String type) {
        this.name = name;
        this.color = color;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "workspace.previous.Animal{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name) && Objects.equals(color, animal.color) && Objects.equals(type, animal.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, type);
    }
}
