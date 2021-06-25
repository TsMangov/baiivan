package deploy.deploytest.service;

import deploy.deploytest.model.entities.AnalizDen;
import deploy.deploytest.model.service.AnalizDenServiceModel;

import java.util.List;

public interface AnalizDenService {
    //tood make it with view
    List<AnalizDen> getAllAnalizByPismoId(Long id);

    void saveAnalizToPismoDen(AnalizDenServiceModel analizModel);
}
