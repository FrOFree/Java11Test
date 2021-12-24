package lixl.func.impl;

import lixl.func.VoidFunc1;

import java.util.function.Consumer;

public class VoidFunc1impl implements VoidFunc1 {

    @Override
    public void func1(String str) {
        System.out.println(this.equals(str));
    }

}
