package com.opi.blog

import com.codahale.metrics.annotation.Timed
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class BlogMetricsController {

    @Autowired
    MetricWriterJava metricWriterJava

    @Autowired
    MetricWriterGroovy metricWriterGroovy

    @RequestMapping(value = '/hello/{name}', method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Timed(absolute = true, name = 'sayhello')
    String sayHello(@PathVariable(value = 'name') String name) {

        //random java metric
        int t = metricWriterJava.time('java.metric', {
            (1..1000).each { sleep(1) }
            42
        })

        //random groovy metric
        int x = metricWriterGroovy.time('groovy.metric', {
            (1..1000).each { sleep(1) }
            99
        })

        "Hello $name. $t $x"
    }
    
}
