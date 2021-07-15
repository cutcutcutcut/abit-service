package com.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Точка запуска программы
 * Отмечает класс как источник определений bean-компонентов для контекста приложения
 *
 * Сообщает Spring Boot начать добавление bean-компонентов на основе настроек пути к классам,
 * других bean-компонентов и различных настроек свойств. Например, если он spring-webmvc находится в
 * пути к классам, эта аннотация помечает приложение как веб-приложение и активирует
 * ключевые варианты поведения, такие как настройка DispatcherServlet.
 *
 * Сообщает Spring поиск других компонентов, конфигураций и служб
 * в com/service пакете, позволяя найти контроллеры.
 *
 * @author Алексей Бехтерев
 * @version 1.0
 */

@SpringBootApplication
public class Application {

    /**
     * Статический метод запуска приложения
     * @param args - массив параметров запуска
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}