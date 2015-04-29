package com.opi

import com.opi.blog.BaseMetricsConfigurerAdapter
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
@EnableMetrics(proxyTargetClass = true)
class BlogApplication {

    @Bean
    MetricsConfigurerAdapter metricsConfigurerAdapter() {
        new BaseMetricsConfigurerAdapter();
    }
    
    static void main(String[] args) {
        SpringApplication.run BlogApplication, args
    }
}
