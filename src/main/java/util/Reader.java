package util;

import java.util.Scanner;

public final class Reader implements GameConstants{
    private static Scanner sc;

    private Reader() throws IllegalStateException {
        throw new IllegalStateException("Can't create instance of util.Reader");
    }

    private static Scanner getScanner() {
        if (sc == null) {
            sc = new Scanner(System.in);
        }
        return sc;
    }

    public static String getString() {
        return getScanner().nextLine();
    }


}
