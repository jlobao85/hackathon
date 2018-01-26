package org.academiadecodigo.bootcamp;

public class BitsToEuro {

    public static double convertToEuro(int bits) {
        return bits * 5.49;
    }

    public static int convertToBit(double money) {
        return (int)Math.round(money / 5.49);
    }
}
