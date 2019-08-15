package com.innowisegroup.zanko.scanner;


import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

@UtilityClass
public class DeleteUser {

    public static void deleteUser(File file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        writer.print("");
        writer.close();
    }
}