package acalidonio.labo2pnc.controller;

import acalidonio.labo2pnc.domain.entity.Wizard;
import acalidonio.labo2pnc.service.WizardService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wizards")
@AllArgsConstructor
public class WizardController {

    private final WizardService wizardService;

    @PostMapping
    public ResponseEntity<Wizard> createWizard(@RequestBody Wizard wizard) {
        return ResponseEntity.ok(wizardService.createWizard(wizard));
    }

    @GetMapping
    public ResponseEntity<List<Wizard>> getAllWizards() {
        return ResponseEntity.ok(wizardService.getAllWizards());
    }

}
