package acalidonio.labo2pnc.service;

import acalidonio.labo2pnc.domain.entity.Wizard;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface WizardService {
    Wizard createWizard(Wizard wizard);
    List<Wizard> getAllWizards();
    List<Wizard> getDeatheaters();
    Optional<Wizard> updateWizard(UUID id, Wizard wizardDetails);
    List<Wizard> getByPatronus(String patronus);
    void deleteWizard(UUID id);
}
