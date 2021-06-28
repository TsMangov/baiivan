package deploy.deploytest.model.binding;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AnalizDenUpdateBindingModel {
    private Long id;
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
    private String creatorByUsername;
    private boolean isDeleted;
    private Long pismoDenId;

    public AnalizDenUpdateBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public AnalizDenUpdateBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNumberAnaliz() {
        return numberAnaliz;
    }

    public AnalizDenUpdateBindingModel setNumberAnaliz(String numberAnaliz) {
        this.numberAnaliz = numberAnaliz;
        return this;
    }

    public String getAnalizType() {
        return analizType;
    }

    public AnalizDenUpdateBindingModel setAnalizType(String analizType) {
        this.analizType = analizType;
        return this;
    }

    public Double getPh() {
        return ph;
    }

    public AnalizDenUpdateBindingModel setPh(Double ph) {
        this.ph = ph;
        return this;
    }

    public Double getCu() {
        return cu;
    }

    public AnalizDenUpdateBindingModel setCu(Double cu) {
        this.cu = cu;
        return this;
    }

    public Double getMn() {
        return mn;
    }

    public AnalizDenUpdateBindingModel setMn(Double mn) {
        this.mn = mn;
        return this;
    }

    public Double getFe() {
        return fe;
    }

    public AnalizDenUpdateBindingModel setFe(Double fe) {
        this.fe = fe;
        return this;
    }

    public Double getSo4() {
        return so4;
    }

    public AnalizDenUpdateBindingModel setSo4(Double so4) {
        this.so4 = so4;
        return this;
    }

    public Double getCa() {
        return ca;
    }

    public AnalizDenUpdateBindingModel setCa(Double ca) {
        this.ca = ca;
        return this;
    }

    public String getAnalizText() {
        return analizText;
    }

    public AnalizDenUpdateBindingModel setAnalizText(String analizText) {
        this.analizText = analizText;
        return this;
    }

    public String getCreatorByUsername() {
        return creatorByUsername;
    }

    public AnalizDenUpdateBindingModel setCreatorByUsername(String creatorByUsername) {
        this.creatorByUsername = creatorByUsername;
        return this;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public AnalizDenUpdateBindingModel setDeleted(boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    public Long getPismoDenId() {
        return pismoDenId;
    }

    public AnalizDenUpdateBindingModel setPismoDenId(Long pismoDenId) {
        this.pismoDenId = pismoDenId;
        return this;
    }
}
