package acalidonio.labo2pnc.service.impl;

import acalidonio.labo2pnc.domain.entity.Wizard;
import acalidonio.labo2pnc.repository.WizardRepository;
import acalidonio.labo2pnc.service.WizardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WizardServiceImpl implements WizardService {

    private final WizardRepository wizardRepository;

    @Autowired
    public WizardServiceImpl(WizardRepository wizardRepository) {
        this.wizardRepository = wizardRepository;
    }

    public Wizard createWizard(Wizard wizard) {
        return wizardRepository.save(wizard);
    }

    public List<Wizard> getAllWizards() {
        return wizardRepository.findAll();
    }

    public List<Wizard> getDeatheaters() {
        return wizardRepository.findByIsDeatheaterTrue();
    }

    public Optional<Wizard> updateWizard(UUID id, Wizard wizardDetails) {
        return wizardRepository.findById(id).map(wizard -> {
            wizard.setName(wizardDetails.getName());
            wizard.setHouse(wizardDetails.getHouse());
            wizard.setPatronus(wizardDetails.getPatronus());
            wizard.setIsDeatheater(wizardDetails.getIsDeatheater());
            return wizardRepository.save(wizard);
        });
    }

    public List<Wizard> getByPatronus(String patronus) {
        return wizardRepository.findByPatronusIgnoreCase(patronus);
    }

    public void deleteWizard(UUID id) {
        wizardRepository.deleteById(id);
    }
}
