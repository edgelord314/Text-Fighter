package com.hotmail.kalebmarc.textfighter.main;

import javax.swing.*;

public class Ui {
    private Ui(){}

    public static boolean guiEnabled = true;

    /*
     * The whole purpose of this class is to make it easy to change from using the Console to other
     * ways to output information. For example, switching to a GUI application, instead of changing
     * every System.out.println() in the program, you can change just the methods in this class.
     *
     * Also to control whether popup should actually be a popup or not, based on user preference
     */
    public static void print(String input){
        System.out.print(input);
    }
    public static void println(String input){
        System.out.println(input);
    }
    public static void print(int input){
        System.out.print(input);
    }
    public static void println(int input){
        System.out.println(input);
    }
    public static void print(boolean input){
        System.out.print(input);
    }
    public static void println(boolean input){
        System.out.println(input);
    }
    public static void print(double input){
        System.out.print(input);
    }
    public static void println(double input){
        System.out.println(input);
    }
    public static void println(){
        System.out.println();
    }

    /**
     *
     * @param msgType Ex. JOptionPane.ERROR_MESSAGE
     */
    public static void popup(String title, String body, int msgType){//TODO make sure title and body actually are title and body.
        if (guiEnabled) {
            JOptionPane.showMessageDialog(null, title, body, msgType);
        } else {
            Action.cls();
            println(body);
            Action.pause();
        }
    }

    public static int confirmPopup(String body, String title){
        if (guiEnabled){
            return JOptionPane.showConfirmDialog(null, body, title, JOptionPane.YES_NO_OPTION);
        } else {
            Action.cls();
            println(body);
            println("(Y/N)");

            //TODO Replace this next snippet when using JTools lib
            //TODO Or.. Just write this better.
            //----------------------------------------------------
            java.util.Scanner in = new java.util.Scanner(System.in);

            while(!in.hasNextLine()) {
                in.nextLine();
            }

            String valid = in.nextLine();
            valid = valid.toUpperCase();
            char input = valid.charAt(0);
            //-----------------------------------------------------

            Action.cls();
            if(input == 'Y') return 0;
            return 1;
        }
    }
}
