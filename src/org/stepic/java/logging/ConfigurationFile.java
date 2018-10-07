package org.stepic.java.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class ConfigurationFile {
    private static void configureLogging() {
        Logger LoggerClassA = Logger.getLogger("org.stepic.java.logging.ClassA");
        Logger LoggerClassB = Logger.getLogger("org.stepic.java.logging.ClassB");
        Logger LoggerClassC = Logger.getLogger("org.stepic.java");

        LoggerClassA.setLevel(Level.ALL);
        LoggerClassB.setLevel(Level.WARNING);
        LoggerClassC.setUseParentHandlers(false);

        ConsoleHandler chc = new ConsoleHandler();
        chc.setLevel(Level.ALL);
        LoggerClassC.addHandler(chc);

        XMLFormatter xmlfc = new XMLFormatter();
        chc.setFormatter(xmlfc);
    }

}
