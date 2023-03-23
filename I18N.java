import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class I18N {

private static void printStringDetails(String s) throws UnsupportedEncodingException {
    // let's see the chars (code points) inside स्त्री
    System.out.println ("String is " + s);
    System.out.println ("String length is " + s.length());
    System.out.println ("String chars are " + s.length());
    int i = 0;
    for (char c: s.toCharArray())
        System.out.println ("char " + i++ + ": " + Character.toString(c) + " Code point: " + String.format ("0x%x", (int) c));

    System.out.print ("UTF-8 bytes: ");
    for (byte b: s.getBytes("UTF-8")) {
        int bi = b;
        bi = bi & 0xff; // get only the 2 lsbs
        System.out.print (String.format("%02x", bi) + " ");
    }
    System.out.println ();

    // this will print junk because ISO-8859 does not support Indian chars
    System.out.print ("ISO-8859 bytes: ");
    for (byte b: s.getBytes("ISO-8859-1")) {
        int bi = b;
        bi = bi & 0xff; // get only the 2 lsbs
        System.out.print (String.format("%02x", bi) + " ");
    }
    System.out.println ();

    // upper case does not have any effect for Indian languages
    System.out.println ("upper case string: " + s.toUpperCase());
    System.out.println ("upper = lower is " + s.equals(s.toUpperCase()));

    System.out.println ("------------");
}

public static void main (String args[]) throws UnsupportedEncodingException {

    // let's see the chars (code points) inside स्त्री
    String s = "की";
    printStringDetails (s);
    s = " स्त्री";
    printStringDetails (s);
}

}

