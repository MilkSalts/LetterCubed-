package com.lettercubed;

public class HypeFormatter extends Formatter {
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";
    public static final String BOLD = "\u001B[1m";

    @Override
    public String formatSuccess(String message) {
        return BOLD + GREEN + "🔥 SUCCESS: " + message.toUpperCase() + "!!! " + RESET;
    }

    @Override
    public String formatError(String message) {
        return BOLD + RED + "🚨 ERROR: " + message.toUpperCase() + "!!! " + RESET;
    }

    @Override
    public String formatInfo(String message) {
        return BOLD + BLUE + "📢 INFO: " + message.toUpperCase() + "! " + RESET;
    }
}
