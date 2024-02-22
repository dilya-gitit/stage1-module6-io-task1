package com.epam.mjc.io;

import java.io.*;


public class FileReader {
    public Profile getDataFromFile(File file) {
        StringBuilder sb = new StringBuilder();
        try (java.io.FileReader fr = new java.io.FileReader(file)){
            int data;
            while ((data =fr.read()) != -1) {
                sb.append((char)data);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String[] tokens = sb.toString().split("\\s*[:\\n]\\s*");
        return getProfile(tokens);
    }

    private static Profile getProfile(String[] tokens) {
        Profile pr = new Profile();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("Name")) {
                pr.setName(tokens[i+1]);
            }
            if (tokens[i].equals("Age")) {
                pr.setAge(Integer.parseInt(tokens[i+1]));
            }
            if (tokens[i].equals("Email")) {
                pr.setEmail(tokens[i+1]);
            }
            if (tokens[i].equals("Phone")) {
                pr.setPhone((long)Integer.parseInt(tokens[i+1]));
            }
        }
        return pr;
    }
}
