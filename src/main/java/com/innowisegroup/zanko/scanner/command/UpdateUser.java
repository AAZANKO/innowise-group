package com.innowisegroup.zanko.scanner.command;

import com.innowisegroup.zanko.scanner.readwrite.WriteUserToFile;
import com.innowisegroup.zanko.scanner.model.User;
import lombok.experimental.UtilityClass;

import java.io.File;

@UtilityClass
public class UpdateUser {

    public static void updateUser(User user, File file) {
        WriteUserToFile.writeUserToFile(user, file);
    }
}
