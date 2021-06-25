package deploy.deploytest.model.service;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class PismoDenServiceModel {
    private LocalDate pismoDate;
    private LocalDate analizDate;
    private String numberPismo;

    public PismoDenServiceModel() {
    }

    public LocalDate getPismoDate() {
        return pismoDate;
    }

    public PismoDenServiceModel setPismoDate(LocalDate pismoDate) {
        this.pismoDate = pismoDate;
        return this;
    }

    public LocalDate getAnalizDate() {
        return analizDate;
    }

    public PismoDenServiceModel setAnalizDate(LocalDate analizDate) {
        this.analizDate = analizDate;
        return this;
    }

    public String getNumberPismo() {
        return numberPismo;
    }

    public PismoDenServiceModel setNumberPismo(String numberPismo) {
        this.numberPismo = numberPismo;
        return this;
    }
}
