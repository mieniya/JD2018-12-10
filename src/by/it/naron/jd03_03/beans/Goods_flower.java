package by.it.naron.jd03_03.beans;

import java.util.Objects;

public class Goods_flower {
    private int id;
    private String name;
    private String colour;
    private int size;

    public Goods_flower() {
    }

    public Goods_flower(int id, String name, String colour, int size) {
        this.id = id;
        this.name = name;
        this.colour = colour;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods_flower that = (Goods_flower) o;
        return id == that.id &&
                size == that.size &&
                Objects.equals(name, that.name) &&
                Objects.equals(colour, that.colour);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, colour, size);
    }

    @Override
    public String toString() {
        return "Goods_flower{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", size=" + size +
                '}';
    }
}
