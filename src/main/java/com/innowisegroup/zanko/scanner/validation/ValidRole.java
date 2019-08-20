package com.innowisegroup.zanko.scanner.validation;

import com.innowisegroup.zanko.scanner.model.Role;
import lombok.experimental.UtilityClass;

import java.util.regex.Pattern;

@UtilityClass
public class ValidRole {

    public static boolean checkRole(String addRole){
        for (Role role : Role.values()) {
            if (role.name().equalsIgnoreCase(addRole)) {
                return true;
            }
        }
        return false;
    }
}
