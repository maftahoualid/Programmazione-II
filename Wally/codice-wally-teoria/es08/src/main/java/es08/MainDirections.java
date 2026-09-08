package es08;

public class MainDirections {
    public enum Dir {
        N, S, E, W
    }

    public static void main() {
        Dir n = Dir.N;
        Dir x = null;
        System.out.println(n.name()); // N
        System.out.println(n.ordinal()); // 0

        System.out.println(n == Dir.N); // true
        System.out.println(n == Dir.S); // false
        System.out.println(n == x); // false
        // System.out.println(x.equals(Dir.E)); // errore: x punta a null

        for (Dir i : Dir.values()) {
            System.out.println(i.name());
        } // N S E W

        // Scanner sc = new Scanner(System.in);
        Dir move = Dir.E; // sc.nextLine();
        switch (move) {
            case N:
                break;
            case S:
                break;
            case E:
                break;
            case W:
                break;
            default:
                break;
        }

    }
}