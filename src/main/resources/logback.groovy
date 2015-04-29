import ch.qos.logback.classic.AsyncAppender
import ch.qos.logback.core.ConsoleAppender
import net.logstash.logback.encoder.LogstashEncoder

appender("CONSOLE", ConsoleAppender) {
    encoder(LogstashEncoder)
}

appender("ASYNCCONSOLE", AsyncAppender) {
    appenderRef("CONSOLE")
}

root(INFO, ["ASYNCCONSOLE"])