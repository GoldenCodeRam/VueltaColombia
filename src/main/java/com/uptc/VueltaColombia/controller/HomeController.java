package com.uptc.VueltaColombia.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Slf4j
public class HomeController {
    // Initializing instance of Logger for Controller
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);
    @GetMapping("/")
    public String homePage() {
        LocalDateTime localDateTime = LocalDateTime.now();
        log.info("Bienvenido a la página principal " + localDateTime);
        log.info("Se ingresó a las " + localDateTime);
        return "Bienvenido a SpringBoot";
    }
    @GetMapping("/logs")
    public String logsPage() {
        LocalDateTime localDateTime = LocalDateTime.now();
        log.info("Esta es la página de logs " + localDateTime);
        log.info("Se generó un log a las " + localDateTime);
        return "Bienvenido a la página de logs";
    }

    @GetMapping("/warnings")
    public String waringsPage() {
        LocalDateTime localDateTime = LocalDateTime.now();
        log.warn("Esta es la página de warnings " + localDateTime);
        log.warn("Se generó un warn a las " + localDateTime);

        return "Bienvenido a la página de warnings";
    }

    @GetMapping("/errors")
    public String errorsPage() {
        LocalDateTime localDateTime = LocalDateTime.now();
        log.error("Esta es la página de errors " + localDateTime);
        log.error("Se generó un error a las " + localDateTime);

        return "Bienvenido a la página de errors";
    }
}
