package com.nhnacademy.edu.project.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.nhnacademy.edu.project")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MainConfig {

}
