package com.innowisegroup.zanko.scanner;

import lombok.experimental.UtilityClass;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@UtilityClass
public class CreateUser {

    public static User getUser() {
        User user = new User();

        String firstName;
        String lastName;
        String eMail;
        String role;
        String cellPhones;
        String exit;
        List<String> listPhone = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

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
        System.out.println("Enter Role (ADMIN / USER / MANAGER):");
        role = scanner.nextLine().trim().toUpperCase();
        if (!(role.equalsIgnoreCase(Role.ADMIN.name()) | role.equalsIgnoreCase(Role.MANAGER.name()) | role.equalsIgnoreCase(Role.USER.name()))) {
            System.out.println("Entered role is incorrect...");
            do {
                System.out.println("Enter Role (ADMIN / USER / MANAGER):");
                role = scanner.nextLine().trim().toUpperCase();
            } while (!role.equalsIgnoreCase(Role.ADMIN.name()) | role.equalsIgnoreCase(Role.MANAGER.name()) | role.equalsIgnoreCase(Role.USER.name()));
        }
        if (role.equalsIgnoreCase("ADMIN")) {
            user.setRole(Role.ADMIN);
        } else if (role.equalsIgnoreCase("USER")) {
            user.setRole(Role.USER);
        } else {
            user.setRole(Role.MANAGER);
        }
        System.out.println("Enter three phone format 375** ******* :");
        cellPhones = scanner.nextLine();
        if (!ValidPhone.checkPhone(cellPhones)) {
            System.out.println("Entered phone is incorrect...");
            int counter = 0;
            do {
                System.out.println("Enter " + (counter + 1) + " phone:");
                cellPhones = scanner.nextLine();
                if (ValidPhone.checkPhone(cellPhones)) {
                    ++counter;
                    listPhone.add(cellPhones);
                }
            } while (counter < 3);
        } else {
            int counter = 0;
            ++counter;
            listPhone.add(cellPhones);
            do {
                System.out.println("Entered " + (counter + 1) + " phone");
                cellPhones = scanner.nextLine();
                if (ValidPhone.checkPhone(cellPhones)) {
                    ++counter;
                    listPhone.add(cellPhones);
                }
            } while (counter < 3);
        }
        user.setCellPhones(listPhone);
        return user;
    }
}
