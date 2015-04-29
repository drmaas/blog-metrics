package com.opi.blog

import com.codahale.metrics.MetricRegistry
import com.codahale.metrics.Timer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class MetricWriterGroovy {

    @Autowired
    MetricRegistry metricRegistry

    def time(String name, Closure c) {
        Timer timer = metricRegistry.timer(name)
        final Timer.Context context = timer.time()
        def result = null
        try {
            result = c.call()
        }
        finally {
            context.stop();
        }
        result
    }
}
