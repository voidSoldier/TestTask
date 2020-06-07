package com.javajunior.testtask;

import com.javajunior.testtask.model.Security;

public class Util {
    private Util() {
    }

    public static class EntityNotFoundException extends RuntimeException {
        public EntityNotFoundException() {
            super("Entity not found!");
        }
    }


    public static class IllegalSecurityNameException extends RuntimeException {
        public IllegalSecurityNameException() {
            super("Security name should consist only of cyrillic letters, numbers or white spaces!");
        }
    }


    public static class Validator {
        public static void checkName(Security security) {
            char[] legalSigns = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя 0123456789".toCharArray();
            char[] name = security.getName().toLowerCase().toCharArray();

            for (char c: name) {
                for (char legal : legalSigns) {
                    if (c != legal) throw new Util.IllegalSecurityNameException();
                }
            }
        }
    }
}
