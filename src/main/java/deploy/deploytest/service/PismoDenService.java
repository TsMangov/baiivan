package deploy.deploytest.service;

import deploy.deploytest.model.binding.PismoDenUpdateBindingModel;
import deploy.deploytest.model.entities.PismoDen;
import deploy.deploytest.model.service.PismoDenServiceModel;
import deploy.deploytest.model.viewModels.PismoDenViewModel;

import java.util.List;
import java.util.Optional;

public interface PismoDenService {
    //todo make it view model
    List<PismoDenViewModel> getAllPisma();

    void createNewPismo(PismoDenServiceModel pismoModel);

    PismoDen getPismoDenById(Long pismoDen);

    //todo with view
    PismoDenViewModel findById(Long pismoDenid);

    boolean updatePismoDen(PismoDenUpdateBindingModel pismoDenUpdateBindingModel);
}
