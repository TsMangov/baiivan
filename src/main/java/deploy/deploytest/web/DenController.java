package deploy.deploytest.web;

import deploy.deploytest.model.binding.*;
import deploy.deploytest.model.service.AnalizDenServiceModel;
import deploy.deploytest.model.service.PismoDenServiceModel;
import deploy.deploytest.model.viewModels.PismoDenViewModel;
import deploy.deploytest.service.AnalizDenService;
import deploy.deploytest.service.PismoDenService;
import deploy.deploytest.service.StatusLogService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/den")
public class DenController {
    private final ModelMapper modelMapper;
    private final PismoDenService pismoDenService;
    private final AnalizDenService analizDenService;
    private final StatusLogService statusLogService;

    public DenController(ModelMapper modelMapper, PismoDenService pismoDenService, AnalizDenService analizDenService, StatusLogService statusLogService) {
        this.modelMapper = modelMapper;
        this.pismoDenService = pismoDenService;
        this.analizDenService = analizDenService;
        this.statusLogService = statusLogService;
    }

    @GetMapping("/allPisma")
    public String getPisma( Model model){
        model.addAttribute("allPisma", pismoDenService.getAllPisma() );
        return "pisma-den-all";
    }

    @GetMapping("/addPisma")
    public String addNewPismo(Model model){
        if (!model.containsAttribute("pismoDenBindingModel")){
            model.addAttribute("pismoDenBindingModel", new PismoDenBindingModel());
        }
        return "pisma-den-add";
    }

    @PostMapping("/addPisma")
    public String addNewPismoConfirm(
            @Valid PismoDenBindingModel pismoDenBindingModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Principal principal) throws IOException {

//        System.out.println();
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("pismoDenBindingModel", pismoDenBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.pismoDenBindingModel", bindingResult);
            return "redirect:addPisma";
        }

   //   System.out.println();
        PismoDenServiceModel pismo = modelMapper.map(pismoDenBindingModel, PismoDenServiceModel.class);
        this.pismoDenService.createNewPismo(pismo);
//        System.out.println();
        return "redirect:allPisma";
    }


 //   addAnalizToDen

    @GetMapping("/allAnalizByPismo/{id}")
    public String allAnalizByPismo(@PathVariable("id") Long PismoDenid, Model model){
       if(!model.containsAttribute("analizDenBindingModel")){
           model.addAttribute("analizDenBindingModel", new AnalizDenBindingModel());
       }
       model.addAttribute("allAnalizByChosenId", this.analizDenService.getAllAnalizByPismoId(PismoDenid));
       model.addAttribute("PismoDen", this.pismoDenService.findById(PismoDenid)) ;
       return "analiz-den-all";
    }

    @PostMapping("/addNewAnalizToPismoDenWithId/{id}")
    public String allAnalizByPismoConfirm(
            @PathVariable("id") Long PismoDenid,
            @Valid AnalizDenBindingModel analizDenBindingModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Principal principal) throws IOException {

        System.out.println();
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("analizDenBindingModel", analizDenBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.analizDenBindingModel", bindingResult);
            return "redirect:/den/allAnalizByPismo/"+PismoDenid;
        }

        AnalizDenServiceModel analiz = modelMapper.map(analizDenBindingModel, AnalizDenServiceModel.class);
        analiz.setDeleted(false);
        analiz.setPismoDen(PismoDenid);
        analiz.setCreatorByUsername(principal.getName());
        this.analizDenService.saveAnalizToPismoDen(analiz);
          System.out.println();

//        System.out.println();
        return "redirect:/den/allAnalizByPismo/"+PismoDenid;
    }

    @PostMapping("/delAnalizDen/{id}")
    public String changeAnalizStatusToDeleted(
            @PathVariable("id") Long analizId, Principal principal){
        this.analizDenService.changeStatusToDeleted(analizId, principal.getName());
        Long a = this.analizDenService.getPismoDenIdFromAnalizDenId(analizId);
        return "redirect:/den/allAnalizByPismo/" + a;
    }


    @GetMapping("/pismo-den-update/{id}")
    public String updatePismoDen(@PathVariable("id") Long pismoId, Model model){

        PismoDenViewModel pismo = this.pismoDenService.findById(pismoId);
        PismoDenUpdateBindingModel pismoDenUpdateBindingModel = this.modelMapper.map(pismo, PismoDenUpdateBindingModel.class);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(pismo.getPismoDate(), formatter);
        pismoDenUpdateBindingModel.setPismoDate(date);
        date = LocalDate.parse(pismo.getAnalizDate(), formatter);
        pismoDenUpdateBindingModel.setAnalizDate(date);

        if(!model.containsAttribute("pismoDenUpdateBindingModel")){
            model.addAttribute("pismoDenUpdateBindingModel",pismoDenUpdateBindingModel );
        }
        return "pisma-den-update";
    }



    @PostMapping("/pismo-den-update/{id}")
    public String updatePismoDenConfirm(@PathVariable("id") Long pismoId,
                                        @Valid PismoDenUpdateBindingModel pismoDenUpdateBindingModel,
                                        BindingResult bindingResult, RedirectAttributes redirectAttributes,
                                        Model model) {
    if (bindingResult.hasErrors()){
        redirectAttributes.addFlashAttribute("pismoDenUpdateBindingModel", pismoDenUpdateBindingModel);
        redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.pismoDenUpdateBindingModel", bindingResult);
        return "redirect:/den/pismo-den-update/{id}";
    }

        pismoDenUpdateBindingModel.setId( pismoId );
        boolean isSaved = this.pismoDenService.updatePismoDen(pismoDenUpdateBindingModel);
        if (!isSaved){
            redirectAttributes.addFlashAttribute("pismoDenUpdateBindingModel", pismoDenUpdateBindingModel);
            return "redirect:/den/pismo-den-update/{id}";
        }
        return "redirect:/den/allPisma";
    }


    @GetMapping("/updateAnalizDen/{id}")
    public String updateAnalizDen(@PathVariable("id") Long analizId, Model model){

        AnalizDenUpdateBindingModel analiz = this.analizDenService.findByIdToUpdate(analizId);

        if(!model.containsAttribute("analizDenUpdateBindingModel")){
            model.addAttribute("analizDenUpdateBindingModel",analiz );
        }
        model.addAttribute("PismoDen", this.pismoDenService.findById(analiz.getPismoDenId())) ;
        return "analiz-den-update";
    }



    @PostMapping("/updateAnalizDen/{id}")
    public String updateAnalizDenConfirm(@PathVariable("id") Long analizId,
                                        @Valid AnalizDenUpdateBindingModel analizDenUpdateBindingModel,
                                        BindingResult bindingResult, RedirectAttributes redirectAttributes,
                                        Model model, Principal principal) {
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("analizDenUpdateBindingModel", analizDenUpdateBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.analizDenUpdateBindingModel", bindingResult);
            return "redirect:/den/updateAnalizDen/{id}";
        }

        analizDenUpdateBindingModel.setId( analizId );
        boolean isSaved = this.analizDenService.updateAnalizDen(analizDenUpdateBindingModel, principal.getName() );
        if (!isSaved){
            redirectAttributes.addFlashAttribute("analizDenUpdateBindingModel", analizDenUpdateBindingModel);
            return "redirect:/den/updateAnalizDen/{id}";
        }
        System.out.println(        );
        Long a = this.analizDenService.getPismoDenIdFromAnalizDenId(analizId);
        return "redirect:/den/allAnalizByPismo/" + a;
    }


    @GetMapping("/AnalizDenStatusLogs/{id}")
    public String getStatusLogsForAnalizDen(@PathVariable("id") Long analizId, Model model){

        model.addAttribute("AllStatusLogs", this.statusLogService.getStatusLogsForAnalizDen(analizId)) ;
        return "analiz-den-logs";
    }


}//program end
