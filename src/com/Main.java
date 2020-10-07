package com;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static String text ="";
    static Random r;
    public static void main(String[] args) {
        final int k = 16;
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Random re = new Random(5);
        r = new Random(str.charAt(re.nextInt(str.length())));
        for(int i = 0; i < k; i++) {
            try {
                if(re.nextBoolean()) {
                    Numer num = new Numer();
                    num.start();
                    num.join();
                }
                else {
                    Strer strer = new Strer();
                    strer.start();
                    strer.join();
                }
            } catch (Exception e) {
                e.getCause();
            }
        }
        /*
        Outputer o = new Outputer();
        o.start();
        */
        Checker ch = new Checker();
        ch.start();
    }
}
class Numer extends Thread {
    int k = Main.r.nextInt(10);

    @Override
    public void run() {
        Main.text += k;
    }
}
class Strer extends Thread {
    char k = (char) (Main.r.nextInt(26) + 97);

    @Override
    public void run() {
        Main.text += k;
    }
}
class Outputer extends Thread {
    File file = new File("database.txt");

    @Override
    public void run() {
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(Main.text);
            writer.close();
        }
        catch(Exception e) {
            e.getCause();
        }
    }
}
class Checker extends Thread {
    File file = new File("database.txt");

    @Override
    public void run() {
        try {
            Scanner writer = new Scanner(file);
            if(writer.nextLine().equals(Main.text)) {
                System.out.println("OK");
            }
            else {
                System.out.println("ERROR");
            }
        }
        catch(Exception e) {
            e.getCause();
        }
    }
}
