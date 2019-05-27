package me.exrates.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import me.exrates.model.LogsWrapper;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j2
@EnableRabbit
@Component
public class RabbitLogsListener {

    @Autowired
    private LogsService logsService;
    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "${user_logs_queue_local}")
    public void processRefillEvent(String incomeLogs) {
        try {
            log.debug("income logs " + incomeLogs);
            logsService.onIncomeLogs(objectMapper.readValue(incomeLogs, LogsWrapper.class));
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
    }
}
