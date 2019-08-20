package com.innowisegroup.zanko.scanner.command;

import com.innowisegroup.zanko.scanner.validation.ValidEMail;
import com.innowisegroup.zanko.scanner.validation.ValidPhone;
import com.innowisegroup.zanko.scanner.validation.ValidRole;
import com.innowisegroup.zanko.scanner.model.Role;
import com.innowisegroup.zanko.scanner.model.User;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@UtilityClass
public class CreateUser {

    public static final int MAX_ENTER_PHONE = 4;
    public static final int MAX_ENTER_ROLE = 4;
    private static int COUNTER = 0;

    public static User getUser() {
        User user = new User();
        Scanner scanner = new Scanner(System.in);

        String firstName;
        String lastName;
        String eMail;
        List<Role> listRole = new ArrayList<>();
        List<String> listPhone = new ArrayList<>();

        String consoleCommand;

        System.out.println("Enter first name:");
        firstName = scanner.nextLine();
        user.setFirstName(firstName);
        System.out.println("Enter last name:");
        lastName = scanner.nextLine();
        user.setLastName(lastName);
        System.out.println("Enter E-Mail:");
        eMail = scanner.nextLine();
        if (!ValidEMail.checkEMail(eMail)) {
            System.out.println("Entered email is incorrect...");
            do {
                System.out.println("Enter E-Mail format *******@*****.*** :");
                eMail = scanner.nextLine();
            } while (!ValidEMail.checkEMail(eMail));
        }
        user.setEMail(eMail);

        COUNTER = 0;
        while (true) {
            System.out.println("Want to enter Role? Y / N ");
            consoleCommand = scanner.nextLine();
            if ("y".equalsIgnoreCase(consoleCommand)) {
                listRole.add(Role.valueOf(CreateUser.addNewRole()));
                ++COUNTER;
            } else if ("n".equalsIgnoreCase(consoleCommand)) {
                break;
            }
            if (COUNTER >= MAX_ENTER_ROLE) {
                System.out.println("You drove more than 3 role, to retry? Y / N");
                consoleCommand = scanner.nextLine();
                if ("y".equalsIgnoreCase(consoleCommand)) {
                    COUNTER = 0;
                    listRole.clear();
                } else if ("n".equalsIgnoreCase(consoleCommand)) {
                    COUNTER = 0;
                    break;
                }
            }
        }
        user.setRole(listRole);

        COUNTER = 0;
        while (true) {
            System.out.println("Want to enter another phone? Y / N ");
            consoleCommand = scanner.nextLine();
            if ("y".equalsIgnoreCase(consoleCommand)) {
                listPhone.add(CreateUser.addNewPhone());
                ++COUNTER;
            } else if ("n".equalsIgnoreCase(consoleCommand)) {
                break;
            }
            if (COUNTER >= MAX_ENTER_PHONE) {
                System.out.println("You drove more than 3 phones, to retry? Y / N");
                consoleCommand = scanner.nextLine();
                if ("y".equalsIgnoreCase(consoleCommand)) {
                    COUNTER = 0;
                    listPhone.clear();
                }else if("n".equalsIgnoreCase(consoleCommand)) {
                    COUNTER = 0;
//                    listPhone.clear();
                    break;
                }
            }
        }
        user.setCellPhones(listPhone);
        return user;
    }

    private static String addNewPhone() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter three phone format 375** ******* :");
        String newPhones = scanner.nextLine();
        if (!ValidPhone.checkPhone(newPhones)) {
            return CreateUser.addNewPhone();
        }
        return newPhones;
    }

    private static String addNewRole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Role (ADMIN / USER / MANAGER / OPERATOR / HR / JUNIOR / SENIOR):");
        String addRole = scanner.nextLine().trim().toUpperCase();
        if (!ValidRole.checkRole(addRole)){
            return CreateUser.addNewRole();
        }
        return addRole;
    }
}