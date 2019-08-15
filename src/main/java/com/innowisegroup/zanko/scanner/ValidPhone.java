package com.innowisegroup.zanko.scanner;

import lombok.experimental.UtilityClass;

import java.util.regex.Pattern;

@UtilityClass
public class ValidPhone {

    public static boolean checkPhone(String phone){
        Pattern pattern = Pattern.compile("^375\\d{2}\\s\\d{7}$");
        return pattern.matcher(phone).matches();
    }
}
