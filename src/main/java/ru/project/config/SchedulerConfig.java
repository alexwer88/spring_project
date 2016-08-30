package ru.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@Profile({"prod", "dev"})
@EnableScheduling
@Configuration
public class SchedulerConfig {
}
