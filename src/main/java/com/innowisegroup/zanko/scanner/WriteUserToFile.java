package com.innowisegroup.zanko.scanner;

import lombok.experimental.UtilityClass;

import java.io.*;

@UtilityClass
public class WriteUserToFile {

    public static void writeUserToFile(User user, File file) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
