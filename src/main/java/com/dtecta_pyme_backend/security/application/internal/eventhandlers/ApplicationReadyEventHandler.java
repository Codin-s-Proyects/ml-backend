package com.dtecta_pyme_backend.security.application.internal.eventhandlers;

import com.dtecta_pyme_backend.security.domain.services.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ApplicationReadyEventHandler {
    private final RoleService roleService;
    private static final Logger LOGGER
            = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    public ApplicationReadyEventHandler(RoleService roleService) {
        this.roleService = roleService;
    }


    @EventListener
    public void on(ApplicationReadyEvent event) {
        var applicationName = event.getApplicationContext().getId();
        LOGGER.info("Starting to verify if roles seeding is needed for {} at {}",
                applicationName, currentTimestamp());
        roleService.seed();
        LOGGER.info("Roles seeding verification finished for {} at {}",
                applicationName, currentTimestamp());
    }

    private Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

}
