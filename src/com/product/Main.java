package com.product;

import com.lib.open.PublicA;
//import com.lib.close.PrivateB;

public class Main {

    public static void main(String[] args) {
        final PublicA a = new PublicA();
        System.out.println(a.addTwo.apply(1));

        // final PrivateB b = new PrivateB();
        // System.out.println(b.addOne.apply(1));
    }
}
