package services;

import models.Configuration;
import repositories.log.FileLogRepository;
import repositories.log.LogRepository;

import java.util.List;

public class LogMonitor {
    private AlertCommand command;
    private LogRepository logRepo;

    public LogMonitor(Configuration config) {
        this.logRepo = new FileLogRepository(config.getLog_file());
        this.command = new AlertCommand(config.getApplication_name(), config.getUsers());
    }

    public void action() {
        List<String> logs = logRepo.getLogs();
        for (String log : logs) {
            if ("ERROR".equals(getSeverity(log))) {
                command.execute();
            }
        }
    }

    private String getSeverity(String log) {
        return log.split(" ")[1];
    }
}