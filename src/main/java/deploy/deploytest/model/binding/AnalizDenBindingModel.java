package deploy.deploytest.model.binding;

import deploy.deploytest.model.entities.PismoDen;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AnalizDenBindingModel {
    @NotBlank(message = "Въведете номер на анализ.")
    @Size(min = 1, max = 60, message = "Номер на анализ трябва да е между 1 и 60 символа.")
    private String numberAnaliz;

    @NotBlank(message = "Въведете тип на анализ")
    @Size(min = 1, max = 60, message = "Номер на анализ трябва да е между 1 и 60 символа.")
    private String analizType;
    @DecimalMin(value = "0.0", message = "Ph не може да е отрицателно число.")
    private Double ph;
    @DecimalMin(value = "0.0", message = "Cu не може да е отрицателно число.")
    private Double cu;
    @DecimalMin(value = "0.0", message = "Mn не може да е отрицателно число.")
    private Double mn;
    @DecimalMin(value = "0.0", message = "Fe не може да е отрицателно число.")
    private Double fe;
    @DecimalMin(value = "0.0", message = "SO4 не може да е отрицателно число.")
    private Double so4;
    @DecimalMin(value = "0.0", message = "Ca не може да е отрицателно число.")
    private Double ca;

    private String analizText;

    private boolean isDeleted;

    public AnalizDenBindingModel() {
    }

    public String getNumberAnaliz() {
        return numberAnaliz;
    }

    public AnalizDenBindingModel setNumberAnaliz(String numberAnaliz) {
        this.numberAnaliz = numberAnaliz;
        return this;
    }

    public String getAnalizType() {
        return analizType;
    }

    public AnalizDenBindingModel setAnalizType(String analizType) {
        this.analizType = analizType;
        return this;
    }

    public Double getPh() {
        return ph;
    }

    public AnalizDenBindingModel setPh(Double ph) {
        this.ph = ph;
        return this;
    }

    public Double getCu() {
        return cu;
    }

    public AnalizDenBindingModel setCu(Double cu) {
        this.cu = cu;
        return this;
    }

    public Double getMn() {
        return mn;
    }

    public AnalizDenBindingModel setMn(Double mn) {
        this.mn = mn;
        return this;
    }

    public Double getFe() {
        return fe;
    }

    public AnalizDenBindingModel setFe(Double fe) {
        this.fe = fe;
        return this;
    }

    public Double getSo4() {
        return so4;
    }

    public AnalizDenBindingModel setSo4(Double so4) {
        this.so4 = so4;
        return this;
    }

    public Double getCa() {
        return ca;
    }

    public AnalizDenBindingModel setCa(Double ca) {
        this.ca = ca;
        return this;
    }

    public String getAnalizText() {
        return analizText;
    }

    public AnalizDenBindingModel setAnalizText(String analizText) {
        this.analizText = analizText;
        return this;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public AnalizDenBindingModel setDeleted(boolean deleted) {
        isDeleted = deleted;
        return this;
    }


}
