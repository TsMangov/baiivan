package deploy.deploytest.service;

import deploy.deploytest.model.binding.AnalizDenUpdateBindingModel;
import deploy.deploytest.model.entities.AnalizDen;
import deploy.deploytest.model.service.AnalizDenServiceModel;
import deploy.deploytest.model.viewModels.StatusLogViewModel;

import java.util.List;

public interface AnalizDenService {
    //tood make it with view
    List<AnalizDen> getAllAnalizByPismoId(Long id);

    void saveAnalizToPismoDen(AnalizDenServiceModel analizModel);

    void changeStatusToDeleted(Long analizId, String username);

    AnalizDenUpdateBindingModel findByIdToUpdate(Long analizId);

    boolean updateAnalizDen(AnalizDenUpdateBindingModel analizModel, String username);

    Long getPismoDenIdFromAnalizDenId(Long analizId);

}
