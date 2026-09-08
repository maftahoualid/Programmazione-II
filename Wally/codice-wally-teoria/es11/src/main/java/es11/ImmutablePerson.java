package es11;

public final class ImmutablePerson {

    private final String name;
    private final int age;
    final String indirizzo;

    public ImmutablePerson(String name, int age) {
        this.name = verifyName(name) ? name : null;
        this.age = verifyAge(age) ? age : -1;
        this.indirizzo = "Default";
    }

    public ImmutablePerson(String name) {
        this(name, 18);
    }

    private static boolean verifyAge(int age) {
        if (age > 0 && age < 150)
            return true;
        else {
            System.out.println("Età non valida");
            return false;
        }
    }

    private static boolean verifyName(String name) {
        if (name != null && !name.isEmpty())
            return true;
        else {
            System.out.println("Nome non valido");
            return false;
        }
    }

    // getters
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "ImmutablePerson{name='" + name + "', age=" + age + "}";
    }
}
