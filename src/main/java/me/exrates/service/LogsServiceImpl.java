package me.exrates.service;

import lombok.extern.log4j.Log4j2;
import me.exrates.model.LogsWrapper;
import me.exrates.repository.LogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class LogsServiceImpl implements LogsService {

    @Autowired
    private LogsRepository logsRepository;

    @Override
    public void onIncomeLogs(LogsWrapper logsWrapper) {

    }

}
