package deploy.deploytest.model.binding;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class PismoDenBindingModel {

    @PastOrPresent(message = "Датата не може да е за бъдещ период")
    @NotNull(message = "Трябва да въведете дата")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pismoDate;

    @PastOrPresent(message = "Датата не може да е за бъдещ период")
    @NotNull(message = "Трябва да въведете дата")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate analizDate;
    @NotBlank(message = "Трябва да се въведе номер на писмо")
    @Size(min = 3, max = 60, message = "Номер на писмото трябва да е между 3 и 60 символа")
    private String numberPismo;

    public PismoDenBindingModel() {
    }

    public LocalDate getPismoDate() {
        return pismoDate;
    }

    public PismoDenBindingModel setPismoDate(LocalDate pismoDate) {
        this.pismoDate = pismoDate;
        return this;
    }

    public LocalDate getAnalizDate() {
        return analizDate;
    }

    public PismoDenBindingModel setAnalizDate(LocalDate analizDate) {
        this.analizDate = analizDate;
        return this;
    }

    public String getNumberPismo() {
        return numberPismo;
    }

    public PismoDenBindingModel setNumberPismo(String numberPismo) {
        this.numberPismo = numberPismo;
        return this;
    }
}
