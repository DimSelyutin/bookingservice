//package com.booking.config;
//
//
//import org.springframework.boot.test.util.TestPropertyValues;
//import org.springframework.context.ApplicationContextInitializer;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.ContextConfiguration;
//import org.testcontainers.containers.PostgreSQLContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//import lombok.extern.slf4j.Slf4j;
//
///**
// * Конфигурационный файл для поднятия одного контейнера перед тестами.
// */
//@Slf4j
//@ActiveProfiles("test")
//@ContextConfiguration(initializers = { TestContainersConfig.Initializer.class })
//@Testcontainers
//public abstract class TestContainersConfig {
//    @Container
//    public static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:16-alpine")
//            .withDatabaseName("book_service")
//            .withUsername("book_service");
//
//    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
//        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
//            TestPropertyValues.of(
//                            "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
//                            "spring.datasource.username=" + postgreSQLContainer.getUsername(),
//                            "spring.datasource.password=" + postgreSQLContainer.getPassword(),
//
//                            "spring.liquibase.change-log:classpath:db/changelog/db.changelog-master.yaml")
//                    .applyTo(configurableApplicationContext.getEnvironment());
//        }
//    }
//}