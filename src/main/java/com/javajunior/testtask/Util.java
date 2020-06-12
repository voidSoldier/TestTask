package com.javajunior.testtask;

import com.javajunior.testtask.model.History;
import com.javajunior.testtask.model.Security;
import com.javajunior.testtask.to.SecurityTo;

import java.util.ArrayList;
import java.util.List;

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
            char[] name = security.getName().toCharArray();
            boolean isValid = true;

            for (char c : name) {
                if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CYRILLIC ||
                        Character.isDigit(c) | Character.isWhitespace(c)) {
                } else throw new Util.IllegalSecurityNameException();
            }
        }
    }


    public static class Converter {
        public static List<SecurityTo> convertTo(List<Security> list) {
            List<SecurityTo> result = new ArrayList<>();

            for (Security sec : list) {
                SecurityTo secTo = new SecurityTo(sec);

                if (sec.getHistories().isEmpty()) continue;

                for (History hist : sec.getHistories()) {
                    secTo.setTradeDate(hist.getTradeDate());
                    secTo.setNumTrades(hist.getNumTrades());
                    secTo.setOpen(hist.getOpen());
                    secTo.setClose(hist.getClose());

                    result.add(secTo);
                }
            }

            return result;
        }
    }
}

