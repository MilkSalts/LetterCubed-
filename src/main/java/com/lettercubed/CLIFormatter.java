package com.lettercubed;

public class CLIFormatter extends Formatter {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\u001B[4m";

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\u001B[H\u001B[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error clearing screen: " + e.getMessage());
        }
    }

    public static void printHeader(String title) {
        int width = 50;
        String border = "=".repeat(width);
        System.out.println(CYAN + border + RESET);
        int padding = (width - title.length()) / 2;
        System.out.println(CYAN + " ".repeat(padding) + BOLD + title + RESET + CYAN + " ".repeat(padding) + RESET);
        System.out.println(CYAN + border + RESET);
    }

    public static void printMenu(String[] options) {
        System.out.println();
        for (int i = 0; i < options.length; i++) {
            System.out.println(BLUE + (i + 1) + ". " + RESET + options[i]);
        }
        System.out.println();
    }

    public static String colorText(String text, String color) {
        return color + text + RESET;
    }

    @Override
    public String formatSuccess(String message) {
        return GREEN + "✓ " + message + RESET;
    }

    @Override
    public String formatError(String message) {
        return RED + "✗ " + message + RESET;
    }

    @Override
    public String formatInfo(String message) {
        return YELLOW + "ℹ " + message + RESET;
    }

    public static void printSuccess(String message) {
        Formatter.printSuccess(message);
    }

    public static void printError(String message) {
        Formatter.printError(message);
    }

    public static void printInfo(String message) {
        Formatter.printInfo(message);
    }

    public static void printTable(String[] headers, String[][] data) {
        int[] columnWidths = new int[headers.length];
        for (int i = 0; i < headers.length; i++) {
            columnWidths[i] = Math.min(headers[i].length(), getMaxColumnWidth(data, i));
        }

        printTableRow(headers, columnWidths, BOLD + BLUE);
        printTableSeparator(columnWidths);

        for (String[] row : data) {
            printTableRow(row, columnWidths, "");
        }
    }

    private static int getMaxColumnWidth(String[][] data, int columnIndex) {
        int maxWidth = 10;
        for (String[] row : data) {
            if (columnIndex < row.length && row[columnIndex] != null) {
                maxWidth = Math.max(maxWidth, Math.min(row[columnIndex].length(), 20));
            }
        }
        return maxWidth;
    }

    private static void printTableRow(String[] row, int[] columnWidths, String color) {
        System.out.print(color);
        for (int i = 0; i < row.length; i++) {
            String cell = row[i] != null ? truncateText(row[i], columnWidths[i]) : "";
            System.out.print("| " + String.format("%-" + columnWidths[i] + "s", cell) + " ");
        }
        System.out.println("|" + RESET);
    }

    private static void printTableSeparator(int[] columnWidths) {
        for (int width : columnWidths) {
            System.out.print("+" + "-".repeat(width + 2));
        }
        System.out.println("+");
    }

    private static String truncateText(String text, int maxLength) {
        return text.length() > maxLength ? text.substring(0, maxLength - 3) + "..." : text;
    }
}
