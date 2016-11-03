package com.lib.open;
import com.lib.close.B;
public class A {
    public int add(final int x) {
        return B.addOne(x) + 1;
    }
}
