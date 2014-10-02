package com.vmware;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) {
        InputStream is = null;
        InputStreamReader reader = null;
        BufferedReader buffRead = null;

        try {
            is = App.class.getResourceAsStream("/db.properties");
            reader = new InputStreamReader(is);
            buffRead = new BufferedReader(reader);
            String word = null;
            while ((word = buffRead.readLine()) != null) {
                System.out.println(word);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (buffRead != null) buffRead.close();
                if (reader != null) reader.close();
                if (is != null) is.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}