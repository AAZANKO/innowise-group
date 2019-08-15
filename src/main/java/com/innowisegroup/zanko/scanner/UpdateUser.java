package com.innowisegroup.zanko.scanner;

import lombok.experimental.UtilityClass;

import java.io.File;

@UtilityClass
public class UpdateUser {

    public static void updateUser(User user, File file) {
        WriteUserToFile.writeUserToFile(user, file);
    }
}
