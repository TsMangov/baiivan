package deploy.deploytest.service;

import deploy.deploytest.model.entities.AnalizDen;
import deploy.deploytest.model.viewModels.StatusLogViewModel;

import java.util.List;

public interface StatusLogService {

    void addNewDeleteStatus(AnalizDen analizDen, String username);

    void addNewWrongDeleteStatus(AnalizDen analizDen, String username);

    void addNewUpdateAnalizStatus(AnalizDen analizDen, String username, String changes);

    List<StatusLogViewModel> getStatusLogsForAnalizDen(Long analizId);

    void addNewCreateStatus(AnalizDen analizDen, String creatorByUsername);
}
