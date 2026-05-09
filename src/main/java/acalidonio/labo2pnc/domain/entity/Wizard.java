package acalidonio.labo2pnc.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "Wizards")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Wizard {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;
    @Column(name = "house")
    private String house;
    @Column(name = "patronus")
    private String patronus;
    @Column(name = "isDeatheater")
    private Boolean isDeatheater;
}

