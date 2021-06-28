package deploy.deploytest.service.impl;

import deploy.deploytest.model.entities.AnalizDen;
import deploy.deploytest.model.entities.StatusLog;
import deploy.deploytest.model.entities.UserEntity;
import deploy.deploytest.model.viewModels.StatusLogViewModel;
import deploy.deploytest.repository.StatusLogRepository;
import deploy.deploytest.service.AnalizDenService;
import deploy.deploytest.service.StatusLogService;
import deploy.deploytest.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class StatusLogServiceImpl implements StatusLogService {
    private final StatusLogRepository statusLogRepository;
    private final UserService userService;

    public StatusLogServiceImpl(StatusLogRepository statusLogRepository, UserService userService) {
        this.statusLogRepository = statusLogRepository;
        this.userService = userService;
    }

    @Override
    public void addNewDeleteStatus(AnalizDen analizDen, String username) {
        StatusLog statusLog = new StatusLog();
        UserEntity user = this.userService.getUserByUsername(username);
        statusLog.setAnalizDen(analizDen);
        statusLog.setStatusChangeDateAndTime(LocalDateTime.now());
        statusLog.setUserEntity(user);
        statusLog.setStatusChangeText("Статуса на анализа променен на изтрит");
        this.statusLogRepository.saveAndFlush(statusLog);
    }

    @Override
    public void addNewWrongDeleteStatus(AnalizDen analizDen, String username) {
        StatusLog statusLog = new StatusLog();
        UserEntity user = this.userService.getUserByUsername(username);
        statusLog.setAnalizDen(analizDen);
        statusLog.setStatusChangeDateAndTime(LocalDateTime.now());
        statusLog.setUserEntity(user);
        statusLog.setStatusChangeText("Опит за повторно изтриване");
        this.statusLogRepository.saveAndFlush(statusLog);
    }

    @Override
    public void addNewUpdateAnalizStatus(AnalizDen analizDen, String username, String changes) {
        StatusLog statusLog = new StatusLog();
        UserEntity user = this.userService.getUserByUsername(username);
        statusLog.setAnalizDen(analizDen);
        statusLog.setStatusChangeDateAndTime(LocalDateTime.now());
        statusLog.setUserEntity(user);
        statusLog.setStatusChangeText("Редактиране: " + changes);
        this.statusLogRepository.saveAndFlush(statusLog);
    }

    @Override
    public void addNewCreateStatus(AnalizDen analizDen, String creatorByUsername) {
        StatusLog statusLog = new StatusLog();
        UserEntity user = this.userService.getUserByUsername(creatorByUsername);
        statusLog.setAnalizDen(analizDen);
        statusLog.setStatusChangeDateAndTime(LocalDateTime.now());
        statusLog.setUserEntity(user);
        statusLog.setStatusChangeText("Първо въвеждане за Анализа");
        this.statusLogRepository.saveAndFlush(statusLog);
    }


    @Override
    public List<StatusLogViewModel> getStatusLogsForAnalizDen(Long analizId) {
        List<StatusLog> list = this.statusLogRepository.findAllByAnalizDen_Id(analizId);
        List<StatusLogViewModel> result = new ArrayList<>();
        for (StatusLog statusLog : list) {
            StatusLogViewModel log = new StatusLogViewModel();
            log.setPismoDenNumber(statusLog.getAnalizDen().getPismoDen().getNumberPismo());
            log.setNumberAnaliz(statusLog.getAnalizDen().getNumberAnaliz());
            log.setAnalizType(statusLog.getAnalizDen().getAnalizType());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String formattedString = statusLog.getStatusChangeDateAndTime().format(formatter);
            log.setStatusChangeDateAndTime(formattedString);
            log.setStatusChangeText(statusLog.getStatusChangeText());
            log.setUsernameMadeTheChange(statusLog.getUserEntity().getFullname());
            result.add(log);
        }

        return result;
    }


}
