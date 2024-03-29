package com.innowisegroup.zanko.scanner;

import com.innowisegroup.zanko.scanner.command.CreateUser;
import com.innowisegroup.zanko.scanner.command.DeleteUser;
import com.innowisegroup.zanko.scanner.model.User;
import com.innowisegroup.zanko.scanner.readwrite.ReadUserToFile;
import com.innowisegroup.zanko.scanner.readwrite.WriteUserToFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ScanerDemo {

    private static final Path PATH = Paths.get("src", "main", "resources");
    private static final File FILE_PATH = PATH.toFile();
    private static final File FILE = new File(FILE_PATH, "user.txt");

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        do {
            enterCommandToConsole();

            while (!scanner.hasNextInt()) {
                scanner.next();
                enterCommandToConsole();
            }

            int command = scanner.nextInt();
            if (command == 1) {
                User user = CreateUser.getUser();
                WriteUserToFile.writeUserToFile(user, FILE);
            } else if (command == 2) {
                User userUpdate = CreateUser.getUser();
                WriteUserToFile.writeUserToFile(userUpdate, FILE);
            } else if (command == 3) {
                try {
                    DeleteUser.deleteUser(FILE);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else if (command == 4) {
                try {
                    User userRead = ReadUserToFile.readUserToFile(FILE);
                    if (userRead == null) {
                        System.out.println("User is not found");
                    } else {
                        System.out.println(userRead);
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else if (command == 0) {
                break;
            }
        } while (true);
    }

    private static void enterCommandToConsole() {
        System.out.println("1. Create");
        System.out.println("2. Update");
        System.out.println("3. Delete");
        System.out.println("4. Get");
        System.out.println("0. Exit");
        System.out.println("\n Enter command ('1', '2', '3', '4', '0') ->");
    }
}