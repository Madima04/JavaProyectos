package net.mario.block1ProcessFileAndStreams.POJOs;

public class Persona {
    private String name;
    private String town;
    private int age;

    public Persona(String name, String town , int age) {
        this.name = name;
        this.town = town;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persona" + "\n" +
                "name = " + name + "\n" +
                "town = " + town + "\n" +
                "age = " + age + "\n" +
                "---------------------------------------" + "\n"
                ;
    }
}
