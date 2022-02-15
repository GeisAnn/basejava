package com.geisann.webapp;

import java.io.File;

public class MainFile {
    public static void findFiles(File dir, String indent) {
        File[] list = dir.listFiles();
        if (list != null) {
            for (File file : list) {
                if (file.isFile()) {
                    System.out.println(indent + "File: " + file.getName());
                } else if (dir.isDirectory()) {
                    System.out.println(indent + "Directory: " + file.getName());
                    findFiles(file, indent + "   ");
                }
            }
        }
    }

    public static void main(String[] args) {
        File dir = new File("C:/Users/a/Documents/GitHub/basejava");
        findFiles(dir, "");
    }
}
