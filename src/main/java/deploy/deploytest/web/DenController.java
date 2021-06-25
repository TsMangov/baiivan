package deploy.deploytest.web;

import deploy.deploytest.model.binding.AnalizDenBindingModel;
import deploy.deploytest.model.binding.PismoDenBindingModel;
import deploy.deploytest.model.binding.ProductBindingModel;
import deploy.deploytest.model.service.AnalizDenServiceModel;
import deploy.deploytest.model.service.PismoDenServiceModel;
import deploy.deploytest.model.service.ProductServiceModel;
import deploy.deploytest.service.AnalizDenService;
import deploy.deploytest.service.PismoDenService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;

@Controller
@RequestMapping("/den")
public class DenController {
    private final ModelMapper modelMapper;
    private final PismoDenService pismoDenService;
    private final AnalizDenService analizDenService;


    public DenController(ModelMapper modelMapper, PismoDenService pismoDenService, AnalizDenService analizDenService) {
        this.modelMapper = modelMapper;
        this.pismoDenService = pismoDenService;
        this.analizDenService = analizDenService;
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
        this.analizDenService.saveAnalizToPismoDen(analiz);
          System.out.println();

//        System.out.println();
        return "redirect:/den/allAnalizByPismo/"+PismoDenid;
    }

}
