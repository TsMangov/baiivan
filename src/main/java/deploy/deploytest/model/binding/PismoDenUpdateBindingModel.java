package deploy.deploytest.model.binding;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class PismoDenUpdateBindingModel {
    private Long id;
    @PastOrPresent(message = "Датата не може да е за бъдещ период")
    @NotNull(message = "Трябва да въведете дата")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pismoDate;

    @PastOrPresent(message = "Датата не може да е за бъдещ период")
    @NotNull(message = "Трябва да въведете дата")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate analizDate;
    @NotBlank(message = "Трябва да се въведе номер на писмо")
    @Size(min = 1, max = 60, message = "Номер на писмото трябва да е между 1 и 60 символа")
    private String numberPismo;

    public PismoDenUpdateBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public PismoDenUpdateBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDate getPismoDate() {
        return pismoDate;
    }

    public PismoDenUpdateBindingModel setPismoDate(LocalDate pismoDate) {
        this.pismoDate = pismoDate;
        return this;
    }

    public LocalDate getAnalizDate() {
        return analizDate;
    }

    public PismoDenUpdateBindingModel setAnalizDate(LocalDate analizDate) {
        this.analizDate = analizDate;
        return this;
    }

    public String getNumberPismo() {
        return numberPismo;
    }

    public PismoDenUpdateBindingModel setNumberPismo(String numberPismo) {
        this.numberPismo = numberPismo;
        return this;
    }
}
