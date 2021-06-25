package deploy.deploytest.service.impl;

import deploy.deploytest.model.entities.AnalizDen;
import deploy.deploytest.model.service.AnalizDenServiceModel;
import deploy.deploytest.repository.AnalizDenRepository;
import deploy.deploytest.service.AnalizDenService;
import deploy.deploytest.service.PismoDenService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalizDenServiceImpl implements AnalizDenService {
    private final ModelMapper modelMapper;
    private final AnalizDenRepository analizDenRepository;
    private final PismoDenService pismoDenService;

    public AnalizDenServiceImpl(ModelMapper modelMapper, AnalizDenRepository analizDenRepository, PismoDenService pismoDenService) {
        this.modelMapper = modelMapper;
        this.analizDenRepository = analizDenRepository;
        this.pismoDenService = pismoDenService;
    }


    @Override
    public List<AnalizDen> getAllAnalizByPismoId(Long id) {
        return this.analizDenRepository.findAllByPismoDen_Id(id);
    }

    @Override
    public void saveAnalizToPismoDen(AnalizDenServiceModel analizModel) {
        AnalizDen analizDen = modelMapper.map(analizModel, AnalizDen.class);
        analizDen.setPismoDen(this.pismoDenService.getPismoDenById(analizModel.getPismoDen()));
        this.analizDenRepository.saveAndFlush(analizDen);


        System.out.println();
    }
}
