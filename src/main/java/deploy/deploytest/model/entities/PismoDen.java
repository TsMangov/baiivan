package deploy.deploytest.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "pismo_den")
public class PismoDen extends BaseEntity{

    @Column(name = "pismo_date", nullable = false)
    private LocalDate pismoDate;
    @Column(name = "analiz_date", nullable = false)
    private LocalDate analizDate;
    @Column(name = "number_pismo", nullable = false)
    private String numberPismo;

    public PismoDen() {
    }

    public LocalDate getPismoDate() {
        return pismoDate;
    }

    public PismoDen setPismoDate(LocalDate pismoDate) {
        this.pismoDate = pismoDate;
        return this;
    }

    public LocalDate getAnalizDate() {
        return analizDate;
    }

    public PismoDen setAnalizDate(LocalDate analizDate) {
        this.analizDate = analizDate;
        return this;
    }

    public String getNumberPismo() {
        return numberPismo;
    }

    public PismoDen setNumberPismo(String numberPismo) {
        this.numberPismo = numberPismo;
        return this;
    }
}
