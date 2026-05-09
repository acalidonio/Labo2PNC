package acalidonio.labo2pnc.repository;

import acalidonio.labo2pnc.domain.entity.Wizard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WizardRepository extends JpaRepository<Wizard, UUID> {
    List<Wizard> findByIsDeatheaterTrue();
    List<Wizard> findByPatronusIgnoreCase(String patronus);
}
