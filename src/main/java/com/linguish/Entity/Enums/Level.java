package com.linguish.Entity.Enums;

public enum Level {
        BASIC, INTERMEDIATE, ADVANCED;


        public static Level fromString(String value) {
                switch(value.toUpperCase()) {
                    case "BASIC":
                        return BASIC;
                    case "INTERMEDIATE":
                        return INTERMEDIATE;
                    case "ADVANCED":
                        return ADVANCED;
                    default:
                        throw new IllegalArgumentException("El valor " + value + " no es válido.");
                }
        }
}
