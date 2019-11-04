package ca.costsaver.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main03Logger {

    public static void main(String[] args) {


        Logger logger = LoggerFactory.getLogger(Main03Logger.class);
        logger.debug("Hello World");

    }
}
