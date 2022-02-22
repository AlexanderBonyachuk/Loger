package com.bonalex;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;

public class Mylogger {
    public static void main(String[] args) {

        writeToLog("Started");

        try {
            for (int i = 0; i < 5; i++) {
                int d = 10 / i;
            }
        } catch (Exception e) {
//            System.out.println(e.getMessage());
            writeToLog(e.toString());
        }
    }

    public static void writeToLog(String msg) {
        LocalDate today = LocalDate.now();
        String formatDate = today.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String fileName = "logger_" + formatDate + ".txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            LocalDateTime currentDateTime = LocalDateTime.now();
            String format = currentDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

            writer.append(format + " : ");
            writer.append(msg + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exeption writing logs" + e.getMessage());
        }
    }
}
