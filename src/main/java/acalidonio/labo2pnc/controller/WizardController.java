package acalidonio.labo2pnc.controller;

import acalidonio.labo2pnc.domain.entity.Wizard;
import acalidonio.labo2pnc.service.WizardService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/deatheaters")
    public ResponseEntity<List<Wizard>> getDeatheaters() {
        return ResponseEntity.ok(wizardService.getDeatheaters());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Wizard> updateWizard(@PathVariable UUID id, @RequestBody Wizard wizard) {
        return wizardService.updateWizard(id, wizard)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/patronus/{patronus}")
    public ResponseEntity<List<Wizard>> getWizardsByPatronus(@PathVariable String patronus) {
        return ResponseEntity.ok(wizardService.getByPatronus(patronus));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteWizard(@PathVariable UUID id) {
        wizardService.deleteWizard(id);
        return ResponseEntity.noContent().build();
    }
}
