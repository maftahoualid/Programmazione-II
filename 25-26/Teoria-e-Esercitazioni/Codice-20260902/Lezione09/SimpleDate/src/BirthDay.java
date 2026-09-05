public class BirthDay {
    private static Date date = new Date(1, 1, 1970);
    private static BirthDay instance;

    private BirthDay() { }

    public static BirthDay getInstance() {
        if (instance == null) instance = new BirthDay();
        return instance;
    }

    public Date getDate() { return date; }
}
