package deploy.deploytest.service.impl;

import deploy.deploytest.model.binding.AnalizDenUpdateBindingModel;
import deploy.deploytest.model.entities.AnalizDen;
import deploy.deploytest.model.service.AnalizDenServiceModel;
import deploy.deploytest.model.viewModels.StatusLogViewModel;
import deploy.deploytest.repository.AnalizDenRepository;
import deploy.deploytest.service.AnalizDenService;
import deploy.deploytest.service.PismoDenService;
import deploy.deploytest.service.StatusLogService;
import deploy.deploytest.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AnalizDenServiceImpl implements AnalizDenService {
    private final ModelMapper modelMapper;
    private final AnalizDenRepository analizDenRepository;
    private final PismoDenService pismoDenService;
    private final UserService userService;
    private final StatusLogService statusLogService;

    public AnalizDenServiceImpl(ModelMapper modelMapper, AnalizDenRepository analizDenRepository, PismoDenService pismoDenService, UserService userService, StatusLogService statusLogService) {
        this.modelMapper = modelMapper;
        this.analizDenRepository = analizDenRepository;
        this.pismoDenService = pismoDenService;
        this.userService = userService;
        this.statusLogService = statusLogService;
    }


    @Override
    public List<AnalizDen> getAllAnalizByPismoId(Long id) {
        return this.analizDenRepository.findAllByPismoDen_Id(id);
    }

    @Override
    public void saveAnalizToPismoDen(AnalizDenServiceModel analizModel) {
        AnalizDen analizDen = modelMapper.map(analizModel, AnalizDen.class);
        analizDen.setPismoDen(this.pismoDenService.getPismoDenById(analizModel.getPismoDen()));
        analizDen.setUserCreator(this.userService.getUserByUsername(analizModel.getCreatorByUsername()));
        this.analizDenRepository.saveAndFlush(analizDen);
        this.statusLogService.addNewCreateStatus(analizDen, analizModel.getCreatorByUsername());

        System.out.println();
    }

    @Override
    public void changeStatusToDeleted(Long analizId, String username) {
        AnalizDen analizDen = this.analizDenRepository.findById(analizId).orElseThrow();
        if(analizDen.isDeleted()){
            this.statusLogService.addNewWrongDeleteStatus(analizDen, username);
        }else{
            analizDen.setDeleted(true);
            this.analizDenRepository.saveAndFlush(analizDen);
            this.statusLogService.addNewDeleteStatus(analizDen, username);
        }


    }

    @Override
    public AnalizDenUpdateBindingModel findByIdToUpdate(Long analizId) {
        AnalizDen analizDen = this.analizDenRepository.findById(analizId).orElseThrow();
        AnalizDenUpdateBindingModel result = modelMapper.map( analizDen , AnalizDenUpdateBindingModel.class );
        return result;
    }

    @Override
    public boolean updateAnalizDen(AnalizDenUpdateBindingModel analizModel, String username) {
        try {
            //todo way to handle null return
            AnalizDen analizDen = this.analizDenRepository.findById(analizModel.getId()).orElse(null);
            assert analizDen != null;
            String changes = "";
            if( !analizDen.getNumberAnaliz().equals( analizModel.getNumberAnaliz() )){
                changes = changes + "Номер анализ от " + analizDen.getNumberAnaliz() + " към " + analizModel.getNumberAnaliz() + "; ";
                analizDen.setNumberAnaliz(analizModel.getNumberAnaliz());
            }
            if( !analizDen.getAnalizType().equals( analizModel.getAnalizType() )){
                changes = changes + "Тип анализ от " + analizDen.getAnalizType() + " към " + analizModel.getAnalizType() + "; ";
                analizDen.setAnalizType(analizModel.getAnalizType());
            }
            if( !analizDen.getPh().equals( analizModel.getPh() )){
                changes = changes + "Ph от " + analizDen.getPh() + " към " + analizModel.getPh() + "; \n";
                analizDen.setPh(analizModel.getPh());
            }
            if( !analizDen.getCu().equals( analizModel.getCu() )){
                changes = changes + "Cu от " + analizDen.getCu() + " към " + analizModel.getCu() + "; \n";
                analizDen.setCu(analizModel.getCu());
            }
            if( !analizDen.getMn().equals( analizModel.getMn() )){
                changes = changes + "Mn от " + analizDen.getMn() + " към " + analizModel.getMn() + "; \n";
                analizDen.setMn(analizModel.getMn());
            }
            if( !analizDen.getFe().equals( analizModel.getFe() )){
                changes = changes + "Fe от " + analizDen.getFe() + " към " + analizModel.getFe() + "; \n";
                analizDen.setFe(analizModel.getFe());
            }
            if( !analizDen.getSo4().equals( analizModel.getSo4() )){
                changes = changes + "SO4 от " + analizDen.getSo4() + " към " + analizModel.getSo4() + "; \n";
                analizDen.setSo4(analizModel.getSo4());
            }
            if( !analizDen.getCa().equals( analizModel.getCa() )){
                changes = changes + "Ca от " + analizDen.getCa() + " към " + analizModel.getCa() + "; \n";
                analizDen.setCa(analizModel.getCa());
            }
            if( !analizDen.getAnalizText().equals( analizModel.getAnalizText() )){
                if ( !analizDen.getAnalizText().isBlank() && !analizModel.getAnalizText().isBlank() ) {
                    changes = changes + "Забележка от " + analizDen.getAnalizText() + " към " + analizModel.getAnalizText() + "; \n";
                }else if (analizDen.getAnalizText().isBlank()){
                    changes = changes + "Забележка от ... към " + analizModel.getAnalizText() + "; \n";
                }else if ( analizModel.getAnalizText().isBlank() ){
                    changes = changes + "Забележка от " + analizDen.getAnalizText() + " към ...; \r\n";
                }
                analizDen.setAnalizText(analizModel.getAnalizText());

            }

            this.analizDenRepository.save(analizDen);
            this.statusLogService.addNewUpdateAnalizStatus(analizDen, username, changes);
            //todo make status change with username

        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Long getPismoDenIdFromAnalizDenId(Long analizId) {
        AnalizDen analizDen = this.analizDenRepository.findById(analizId).orElseThrow();
        return analizDen.getPismoDen().getId();
    }


}
