package services;

import commands.AlertCommand;
import commands.Command;
import models.Configuration;
import repositories.log.FileLogRepository;
import repositories.log.LogRepository;

import java.util.List;

public class LogMonitor {
    private Command command;
    private LogRepository logRepository;

    public LogMonitor(Configuration config) {
        this.logRepository = new FileLogRepository(config.getLog_file());
        this.command = new AlertCommand(config.getApplication_name(), config.getUsers());
    }

    public void action() {
        List<String> logs = logRepository.getLogs();
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