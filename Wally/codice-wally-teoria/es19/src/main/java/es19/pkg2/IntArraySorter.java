package es19.pkg2;

public class IntArraySorter extends ArraySorter {
	@Override
	protected boolean greaterEqual(Object a, Object b) {
		Integer x = (Integer) a; // manca check cast
		Integer y = (Integer) b; // manca check cast
		return x >= y;
	}
}
