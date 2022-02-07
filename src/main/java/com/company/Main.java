package com.company;

import java.util.logging.*;

public class Main {
    // logers

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {

        System.out.println("\n  " + Main.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace('/','\\').substring(1));
//        System.out.println("\n : " + Main.class.getClassLoader().getResource("com/company/"));
//        System.out.println("\n : " + Main.class.getResource(""));
//        System.out.println("\n : " + Main.class.getClassLoader().getResource(Main.class.getName().replace('.','\\') + ".class").toString());

//        Handler fileHandler = new FileHandler("C:\\Java_\\Zanyatia_\\SIMPLE/myJavaLog.log");
        Handler fileHandler = new FileHandler(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace('/','\\').substring(1) + "myJavaLog.log");
        fileHandler.setFilter(new MyFilter());
        fileHandler.setFormatter(new MyFormatter());
        logger.setUseParentHandlers(false);
        logger.addHandler(fileHandler);
        logger.info("info");        // don't display
        logger.info("info max");    }

    static class MyFilter implements Filter {
        @Override
        public boolean isLoggable(LogRecord record) {
            return record.getMessage().endsWith("max");
        }
    }

    static class MyFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return record.getLevel() + ": " + record.getMessage() + "\n";
        }
    }
}