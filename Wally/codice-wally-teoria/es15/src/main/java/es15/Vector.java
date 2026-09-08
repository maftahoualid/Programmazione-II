package es15;
import java.util.ArrayList;

public class Vector {
    private ArrayList<Integer> vect = new ArrayList<>();

    public void putElement(int e) {
        vect.add(e);
    }

    public void putElement(int index, int e) {
        vect.add(index, e);
    }

    public int getElement(int index) {
        return vect.get(index);
    }

    public int size() {
        return vect.size();
    }
}
