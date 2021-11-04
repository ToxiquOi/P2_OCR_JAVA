package com.hemebiotech.analytics;

import java.io.*;
import java.util.Map;

/**
 * Application Main class
 */
class MainApplication {
    final static String SEPARATOR = System.getProperty("file.separator");
    final static String IN_FILE = System.getProperty("user.dir") + SEPARATOR + "Project02Eclipse" + SEPARATOR + "symptoms.txt";
    final static String OUT_FILE = "./result.out";

    public static void main(String[] args) {
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(IN_FILE, OUT_FILE);
        analyticsCounter.run();
    }
}
