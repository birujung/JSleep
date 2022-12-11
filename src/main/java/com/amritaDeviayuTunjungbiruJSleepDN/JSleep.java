package com.amritaDeviayuTunjungbiruJSleepDN;

import com.amritaDeviayuTunjungbiruJSleepDN.dbjson.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class of the JSleep application.
 *
 * <p>This class contains the `main()` method, which is the entry point of the application.
 * It also uses the `@SpringBootApplication` annotation to enable Spring Boot auto-configuration and component scanning.</p>
 *
 * @author Amrita Deviayu Tunjungbiru (2106636584)
 * @since 27 September 2022
 * @version 1.0
 * @see JsonDBEngine
 * @see SpringBootApplication
 */
@SpringBootApplication
public class JSleep {
    public static void main(String[] args) {
        JsonDBEngine.Run(JSleep.class);
        SpringApplication.run(JSleep.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
    }
}