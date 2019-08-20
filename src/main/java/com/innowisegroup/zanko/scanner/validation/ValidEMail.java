package com.innowisegroup.zanko.scanner.validation;

import lombok.experimental.UtilityClass;

import java.util.regex.Pattern;

@UtilityClass
public class ValidEMail {

    public static boolean checkEMail(String eMail){
        Pattern pattern = Pattern.compile("^[a-zA-Z]\\w*@\\w+\\.[a-zA-Z]+$");
        return pattern.matcher(eMail).matches();
    }
}