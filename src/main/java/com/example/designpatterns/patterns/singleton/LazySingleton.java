package com.example.designpatterns.patterns.singleton;

/**
 * className LazySingleton
 * date 2021/2/18
 *
 * @author JC
 */
public class LazySingleton {
    private static volatile LazySingleton instance;
    private LazySingleton(){

    }

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class){
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
