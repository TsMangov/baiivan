package deploy.deploytest.service.impl;

import deploy.deploytest.model.entities.PismoDen;
import deploy.deploytest.model.service.PismoDenServiceModel;
import deploy.deploytest.model.viewModels.PismoDenViewModel;
import deploy.deploytest.repository.PismoDenRepository;
import deploy.deploytest.service.PismoDenService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class PismoDenServiceImpl implements PismoDenService {
    private final ModelMapper modelMapper;
    private final PismoDenRepository pismoDenRepository;


    public PismoDenServiceImpl(ModelMapper modelMapper, PismoDenRepository pismoDenRepository) {
        this.modelMapper = modelMapper;
        this.pismoDenRepository = pismoDenRepository;
    }


    @Override
    public List<PismoDenViewModel> getAllPisma() {
        List<PismoDen> list = this.pismoDenRepository.findAll();
        List<PismoDenViewModel> result = new ArrayList<>();
        for (PismoDen pismoDen : list) {
            PismoDenViewModel pismoDenViewModel = new PismoDenViewModel();
            pismoDenViewModel.setNumberPismo(pismoDen.getNumberPismo());
            pismoDenViewModel.setId(pismoDen.getId());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String formattedString = pismoDen.getAnalizDate().format(formatter);
            pismoDenViewModel.setAnalizDate(formattedString);
            formattedString = pismoDen.getPismoDate().format(formatter);
            pismoDenViewModel.setPismoDate(formattedString);
            result.add(pismoDenViewModel);

        }
        return result;

    }

    @Override
    public void createNewPismo(PismoDenServiceModel pismoModel) {
        PismoDen pismo = modelMapper.map(pismoModel, PismoDen.class);
        this.pismoDenRepository.saveAndFlush(pismo);
    }

    @Override
    public PismoDen getPismoDenById(Long pismoDen) {
            return this.pismoDenRepository.findById(pismoDen).orElseThrow();

    }

    @Override
    public PismoDenViewModel findById(Long pismoDenid) {
        PismoDen pismo = this.pismoDenRepository.findById(pismoDenid).orElseThrow();
        PismoDenViewModel pismoDenViewModel = new PismoDenViewModel();
        pismoDenViewModel.setNumberPismo(pismo.getNumberPismo());
        pismoDenViewModel.setId(pismo.getId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedString = pismo.getAnalizDate().format(formatter);
        pismoDenViewModel.setAnalizDate(formattedString);
        formattedString = pismo.getPismoDate().format(formatter);
        pismoDenViewModel.setPismoDate(formattedString);
        return pismoDenViewModel;
    }
}
