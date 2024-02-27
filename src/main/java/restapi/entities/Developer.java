package restapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;

@Entity
@Table(name = "develovers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_gen")
    @SequenceGenerator(name = "id_gen", allocationSize = 1)
    private Long id;
    private String fullName;
    private String email;
    private BigDecimal salary;
    private ZonedDateTime createdAd;
    private ZonedDateTime updated;

    @PrePersist
    private void prePersist() {
        this.createdAd = ZonedDateTime.now();
    }

    @PreUpdate
    private void preUpdated() {
        this.updated = ZonedDateTime.now();
    }

    public Developer(String fullName, String email, BigDecimal salary) {
        this.fullName = fullName;
        this.email = email;
        this.salary = salary;
    }
}
