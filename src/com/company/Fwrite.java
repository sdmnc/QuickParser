package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class Fwrite {
    public void fwrite(String username, String phonenumber,String curUrl) {
        phonenumber = phonenumber.replaceAll(" ", "");
        phonenumber = phonenumber.substring(1);
        curUrl = curUrl.substring(18);
        try(FileWriter writer = new FileWriter("C:\\Users\\NT\\Documents\\Java_txt\\notes2.csv", true))
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
