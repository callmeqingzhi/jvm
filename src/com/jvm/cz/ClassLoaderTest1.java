package com.jvm.cz;

import sun.misc.Launcher;

import java.net.URL;

public class ClassLoaderTest1 {

    public static void main(String[] args) {
        // 获取BootstrapClassLoader的类加载路径
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL.toExternalForm());
        }
    }
}
