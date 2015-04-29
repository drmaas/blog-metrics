package com.opi.blog

import com.codahale.metrics.ConsoleReporter
import com.codahale.metrics.MetricRegistry
import com.readytalk.metrics.StatsDReporter
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter

import java.util.concurrent.TimeUnit

/**
 * Created by a566589 on 3/26/15.
 */
class BaseMetricsConfigurerAdapter extends MetricsConfigurerAdapter {

    @Override
    void configureReporters(MetricRegistry metricRegistry) {
        StatsDReporter.forRegistry(metricRegistry).prefixedWith('blog-metrics.v1')
                .build('localhost', 8125)
                .start(10000, TimeUnit.MILLISECONDS)

        //log to console for testing purposes
        ConsoleReporter.forRegistry(metricRegistry).build().start(10000, TimeUnit.MILLISECONDS)
    }
}
