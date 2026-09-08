package es15;
public class OrderedVector extends Vector {
    public enum Order {
        ASC, DESC
    };

    private Order ordine;

    public OrderedVector(Order ordine) {
        this.ordine = ordine;
    }

    public void putElement(int e) {
        if (ordine == Order.ASC) {
            for (int i = 0; i < size(); i++) {
                if (getElement(i) > e) {
                    super.putElement(i, e);
                    return;
                }
            }
        } else {
            for (int i = 0; i < size(); i++) {
                if (getElement(i) < e) {
                    super.putElement(i, e);
                    return;
                }
            }
        }
        super.putElement(e);
    }
}
