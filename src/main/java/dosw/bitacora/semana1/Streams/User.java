package dosw.bitacora.semana1.Streams;

public class User {
    private int id;
    private String name;
    private int age;
    private boolean active;

    public User(int id, String name, int age, boolean active) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.active = active;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public boolean isActive() { return active; }
}