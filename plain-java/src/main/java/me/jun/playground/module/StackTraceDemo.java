package me.jun.playground.module;

public class StackTraceDemo {
    /**
     * Exception in thread "main" java.lang.NumberFormatException: For input string: "Fail"
     * 	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
     * 	at java.base/java.lang.Integer.parseInt(Integer.java:662)
     * 	at java.base/java.lang.Integer.parseInt(Integer.java:778)
     * 	at me.jun.playground.module.StackTraceDemo.main(StackTraceDemo.java:5)
     */
    public static void main(String[] args) {
        int i = Integer.parseInt("Fail");
        System.out.println(i);
    }
}
