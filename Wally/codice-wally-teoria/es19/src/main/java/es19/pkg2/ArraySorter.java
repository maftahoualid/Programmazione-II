package es19.pkg2;

// TEMPLATE METHOD PATTERN
public abstract class ArraySorter {

	public final void sort(Object[] array) {
		// confronta ogni elemento con ogni altro elemento
		for (int i = 1; i < array.length; i++) {
			for (int j = 1; j < array.length; j++) {
				// se elemento precedente >= elemento corrente
				if( greaterEqual( array[j-1], array[j] ) ) {
					// swap elementi
					Object o = array[j]; 
					array[j]=array[j-1]; 
					array[j-1] = o;
				}
			}
		}
	}
	
	protected abstract boolean greaterEqual(Object a, Object b);

}
