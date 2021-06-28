package deploy.deploytest.model.service;

import deploy.deploytest.model.entities.PismoDen;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

public class AnalizDenServiceModel {
    private String numberAnaliz;
    private String analizType;
    private Double ph;
    private Double cu;
    private Double mn;
    private Double fe;
    private Double so4;
    private Double ca;
    private String analizText;
    private boolean isDeleted;
    private Long pismoDen;
    private String creatorByUsername;

    public AnalizDenServiceModel() {
    }

    public String getNumberAnaliz() {
        return numberAnaliz;
    }

    public AnalizDenServiceModel setNumberAnaliz(String numberAnaliz) {
        this.numberAnaliz = numberAnaliz;
        return this;
    }

    public String getAnalizType() {
        return analizType;
    }

    public AnalizDenServiceModel setAnalizType(String analizType) {
        this.analizType = analizType;
        return this;
    }

    public Double getPh() {
        return ph;
    }

    public AnalizDenServiceModel setPh(Double ph) {
        this.ph = ph;
        return this;
    }

    public Double getCu() {
        return cu;
    }

    public AnalizDenServiceModel setCu(Double cu) {
        this.cu = cu;
        return this;
    }

    public Double getMn() {
        return mn;
    }

    public AnalizDenServiceModel setMn(Double mn) {
        this.mn = mn;
        return this;
    }

    public Double getFe() {
        return fe;
    }

    public AnalizDenServiceModel setFe(Double fe) {
        this.fe = fe;
        return this;
    }

    public Double getSo4() {
        return so4;
    }

    public AnalizDenServiceModel setSo4(Double so4) {
        this.so4 = so4;
        return this;
    }

    public Double getCa() {
        return ca;
    }

    public AnalizDenServiceModel setCa(Double ca) {
        this.ca = ca;
        return this;
    }

    public String getAnalizText() {
        return analizText;
    }

    public AnalizDenServiceModel setAnalizText(String analizText) {
        this.analizText = analizText;
        return this;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public AnalizDenServiceModel setDeleted(boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    public Long getPismoDen() {
        return pismoDen;
    }

    public AnalizDenServiceModel setPismoDen(Long pismoDen) {
        this.pismoDen = pismoDen;
        return this;
    }

    public String getCreatorByUsername() {
        return creatorByUsername;
    }

    public AnalizDenServiceModel setCreatorByUsername(String creatorByUsername) {
        this.creatorByUsername = creatorByUsername;
        return this;
    }
}
