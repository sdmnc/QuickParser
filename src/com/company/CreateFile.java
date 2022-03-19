package com.company;

import java.io.File;
import java.io.IOException;


public class CreateFile {

    public void createFile () {
        try {
            File myObj = new File("\"C:\\Users\\NT\\Documents\\Java_txt\\notes2.csv\"");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}



