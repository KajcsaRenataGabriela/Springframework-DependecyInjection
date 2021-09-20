package guru.springframework.sfgdi.controller;

import guru.springframework.sfgdi.services.PetService;
import org.springframework.stereotype.Controller;

@Controller
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    public String tellTheTruth(){
        return petService.getPetType();
    }
}
