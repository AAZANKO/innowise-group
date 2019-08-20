package com.innowisegroup.zanko.scanner.readwrite;

import com.innowisegroup.zanko.scanner.model.User;
import lombok.experimental.UtilityClass;

import java.io.*;
import java.util.Scanner;

@UtilityClass
public class ReadUserToFile {

    public static User readUserToFile(File file) throws IOException, ClassNotFoundException {
        User user = null;
        try (Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(file)))) {
            if (scanner.hasNext()) {
                String input = scanner.nextLine();
                if (!input.isEmpty()) {
                    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
                    user = (User) objectInputStream.readObject();
                }
            }
        }
        return user;
    }
}
