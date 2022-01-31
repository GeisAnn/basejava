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
        //String filePath = ".\\.gitignore";
        //File dir = new File(".\\src\\com\\geisann\\webapp");
        File dir = new File(".");
        /*File file = new File(filePath);
        try {
            System.out.println("!!!" + file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());*/
        findFiles(dir);
       /* } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }
}
