package es15;
public class MainVector {
    public static void main(String[] args) {
        Vector v = new Vector();
        v.putElement(10);
        v.putElement(20);
        v.putElement(30);
        System.out.println(v.getElement(0));
        System.out.println(v.getElement(1));
        System.out.println(v.getElement(2));
        System.out.println(v.size());

        OrderedVector ov = new OrderedVector(OrderedVector.Order.ASC);
        ov.putElement(10);
        ov.putElement(20);
        ov.putElement(30);
        System.out.println(ov.getElement(0));
        System.out.println(ov.getElement(1));
        System.out.println(ov.getElement(2));
        System.out.println(ov.size());
    }
}
