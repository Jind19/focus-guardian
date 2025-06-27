package com.guardian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the Focus Guardian application.
 *This application helps users track their digital discipline by allowing them to log
 * how they avoided social media, record their success status, and view analytics.
 */

@SpringBootApplication
public class FocusGuardianApplication {

    public static void main(String[] args) {
        // Launch the application
        SpringApplication.run(FocusGuardianApplication.class, args);

    }
}
