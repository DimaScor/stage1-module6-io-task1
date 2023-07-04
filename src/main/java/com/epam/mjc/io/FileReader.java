package com.epam.mjc.io;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class FileReader {

    public Profile getDataFromFile(File file) {

        StringBuilder sb = new StringBuilder();
        try (BufferedReader bf = new BufferedReader(new java.io.FileReader(file))) {
            while (bf.ready()) {
                sb.append(bf.readLine()).append(" ");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage() + "some problems with filename/or path");
        }
        ArrayList<String> list = new ArrayList<>(Arrays.asList(sb.toString().split(" ")));

        int indexName = list.indexOf("Name:");
        int indexAge = list.indexOf("Age:");
        int indexOfEmail = list.indexOf("Email:");
        int indexOfPhone = list.indexOf("Phone:");

        Profile profile = new Profile();
        profile.setName(list.get(indexName + 1));
        profile.setEmail(list.get(indexOfEmail + 1));

        try {
            profile.setAge(Integer.parseInt(list.get(indexAge + 1)));
            profile.setPhone(Long.parseLong(list.get(indexOfPhone + 1)));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() + "Parsing trouble");
        }


        return profile;
    }
}
