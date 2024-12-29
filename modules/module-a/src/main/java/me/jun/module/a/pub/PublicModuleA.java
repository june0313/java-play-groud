package me.jun.module.a.pub;

import me.jun.module.a.pri.PrivateModuleA;

public class PublicModuleA {
    public void run() {
        PrivateModuleA privateModuleA = new PrivateModuleA();

        System.out.println(privateModuleA.get());
    }
}
