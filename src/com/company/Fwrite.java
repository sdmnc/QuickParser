package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class Fwrite {
    public void fwrite(String username, String phonenumber,String curUrl) {

        curUrl = curUrl.substring(1);
        try(FileWriter writer = new FileWriter("D:\\JAVA\\notes1.csv", true))
        {

            writer.write(username);
            writer.append(",");
            writer.write(phonenumber);
            writer.append(",");
            writer.write(curUrl);
            writer.append(",");
            writer.append('\s');
            writer.append('\n');
            writer.close();
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
