package es13;

public class MainWrapperPrimitivi {
    public static void main(String[] args) {
        boolean bool = false;
        byte bytee = (byte) 127;
        short shortt = (short) 32767;
        int intero1 = 1; // INTERO DEFAULT
        long intero2 = 3000;
        float decimale1 = 1.222222222222222222222f;
        double decimale2 = 1.2222222222222222222222222222222222222222222222222; // DECIMALE DEFAULT
        char carattere = 'V';

        // PRIMITIVO -> WRAPPER
        // Boolean Bool = new Boolean(bool);
        // Byte Bytee = new Byte(bytee);
        // Short Shortt = new Short(shortt);
        // Integer Intero1 = new Integer(intero1); // Integer Intero1 = intero1; //
        // Autoboxing
        // Long Intero2 = new Long(intero2);
        // Float Decimale1 = new Float(decimale1);
        // Double Decimale2 = new Double(decimale2); // Double Decimale2 = decimale2; //
        // Autoboxing
        // Character Carattere = new Character(carattere);
        // PRIMITIVO -> WRAPPER (METODO VALUEOF)
        Boolean Bool = Boolean.valueOf(bool);
        Byte Bytee = Byte.valueOf(bytee);
        Short Shortt = Short.valueOf(shortt);
        Integer Intero1 = Integer.valueOf(intero1); // Integer Intero1 = intero1; // Autoboxing
        Long Intero2 = Long.valueOf(intero2);
        Float Decimale1 = Float.valueOf(decimale1);
        Double Decimale2 = Double.valueOf(decimale2); // Double Decimale2 = decimale2; // Autoboxing
        Character Carattere = Character.valueOf(carattere);

        // WRAPPER -> PRIMITIVO
        bool = Bool.booleanValue();
        bytee = Bytee.byteValue();
        shortt = Shortt.shortValue();
        intero1 = Intero1.intValue(); // intero1 = Intero1; // Autounboxing
        intero2 = Intero2.longValue();
        decimale1 = Decimale1.floatValue();
        decimale2 = Decimale2.doubleValue(); // decimale2 = Decimale2; // Autounboxing
        carattere = Carattere.charValue();

        // WRAPPER -> STRING
        String num1 = String.valueOf(intero1);
        String num2 = Integer.toString(intero1);
        String num3 = intero1 + "";

        // STRING -> WRAPPER
        Integer num4 = Integer.valueOf("123");
        Float num5 = Float.valueOf("123.456");
        Double num6 = Double.valueOf("123.456");
        // ...

        // STRING -> PRIMITIVO
        Integer num7 = Integer.parseInt("123");
        // Integer num8 = Integer.parseInt(" 13"); // errore : non possono esserci spazi
        // Integer num9 = Integer.parseInt("2.5"); // errore: non può essere un numero
        // decimale
        Float num10 = Float.parseFloat("123.456");
        Double num11 = Double.parseDouble("123.456");
        // ...

        System.out.println(Character.isLetter(Carattere));
        System.out.println(Character.isDigit(Carattere));
        System.out.println(Character.isSpaceChar(Carattere));
        System.out.println(Character.toLowerCase(Carattere));
        System.out.println(Character.toUpperCase(Carattere));

        int a = 1000, b = 1000;
        Integer x = a, y = b;
        @SuppressWarnings("deprecation")
        Integer z = new Integer(1000);
        Integer w = Integer.valueOf(1000);
        System.out.println(a == b); // true
        // (Integer cache: vale per interi tra -128 e 127 )
        System.out.println(x == y); // entro il range puntano alla stessa memoria e quindi da true
        System.out.println(x == w); // fuori dal range vengono creati oggetti diversi e da false
        System.out.println(x == z); // false
        System.out.println(x.equals(z)); // confronta il valore effettivo e funziona sempre

    }
}
