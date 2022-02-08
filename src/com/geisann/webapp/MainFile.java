package com.geisann.webapp;

import java.io.File;

public class MainFile {
    public static void findFiles(File dir) {
        File[] list = dir.listFiles();
        if (list != null) {
            for (File file : list) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (dir.isDirectory()) {
                    System.out.println("Directory: " + dir.getName());
                    findFiles(file);
                }
            }
        }
    }

    public static void main(String[] args) {
        File dir = new File("C://Users//a//Documents//GitHub//basejava");
        findFiles(dir);
    }
}
