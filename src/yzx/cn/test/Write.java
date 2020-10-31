package yzx.cn.test;

/**
 * @author YZX
 * @date 2019年9月26日
 * @time 上午7:28:19
 */
/*
 * public class Singleton{ private Singleton singleton; private Singleton(){
 * 
 * } public Singleton getSingleton() { if(singleton == null) { singleton = new
 * Singleton(); } return singleton; } } public class Singleton{ private static
 * Singleton singleton; private Singleton(){
 * 
 * } public static synchronized Singleton getSingleton() { if(singleton == null)
 * singleton = new Singleton(); return singleton; } } public class Singleton{
 * private static singleton = new Singleton(); private Singleton() {
 * 
 * } public static Singleton getInstance() { return singleton; } } public class
 * Singleton{ private class SingletonHolder{ private static final Singleton
 * INSTANCE = new Singleton(); private Singleton() {}; private static final
 * Singleton getInstance() { return SingletonHOlder.INSTANCE; } } } public class
 * Singleton{ private volatile static Singleton instance; private Singleton(){
 * 
 * } public static Singleton getInstance() { if(instance == null) {
 * synchronized(Singleton.class) { if(instance == null) { instance = new
 * Singleton(); } } } } return instance; }
 * 
 * 
 */






