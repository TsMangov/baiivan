package deploy.deploytest.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "analiz_den")
public class AnalizDen extends BaseEntity{
    @Column(name = "number_analiz", nullable = false)
    private String numberAnaliz;
    @Column(name = "analiz_type" )
    private String analizType;
    @Column(name = "ph" )
    private Double ph;
    @Column(name = "cu" )
    private Double cu;
    @Column(name = "mn" )
    private Double mn;
    @Column(name = "fe" )
    private Double fe;
    @Column(name = "so4" )
    private Double so4;
    @Column(name = "ca" )
    private Double ca;
    @Column(name = "analiz_text" )
    private String analizText;
    @Column
    private boolean isDeleted;
    @ManyToOne
    private PismoDen pismoDen;
    @ManyToOne
    private UserEntity userCreator;

    public AnalizDen() {
    }

    public String getNumberAnaliz() {
        return numberAnaliz;
    }

    public AnalizDen setNumberAnaliz(String numberAnaliz) {
        this.numberAnaliz = numberAnaliz;
        return this;
    }

    public String getAnalizType() {
        return analizType;
    }

    public AnalizDen setAnalizType(String analizType) {
        this.analizType = analizType;
        return this;
    }

    public Double getPh() {
        return ph;
    }

    public AnalizDen setPh(Double ph) {
        this.ph = ph;
        return this;
    }

    public Double getCu() {
        return cu;
    }

    public AnalizDen setCu(Double cu) {
        this.cu = cu;
        return this;
    }

    public Double getMn() {
        return mn;
    }

    public AnalizDen setMn(Double mn) {
        this.mn = mn;
        return this;
    }

    public Double getFe() {
        return fe;
    }

    public AnalizDen setFe(Double fe) {
        this.fe = fe;
        return this;
    }

    public Double getSo4() {
        return so4;
    }

    public AnalizDen setSo4(Double so4) {
        this.so4 = so4;
        return this;
    }

    public Double getCa() {
        return ca;
    }

    public AnalizDen setCa(Double ca) {
        this.ca = ca;
        return this;
    }

    public String getAnalizText() {
        return analizText;
    }

    public AnalizDen setAnalizText(String analizText) {
        this.analizText = analizText;
        return this;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public AnalizDen setDeleted(boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    public PismoDen getPismoDen() {
        return pismoDen;
    }

    public AnalizDen setPismoDen(PismoDen pismoDen) {
        this.pismoDen = pismoDen;
        return this;
    }

    public UserEntity getUserCreator() {
        return userCreator;
    }

    public AnalizDen setUserCreator(UserEntity userCreator) {
        this.userCreator = userCreator;
        return this;
    }
}
