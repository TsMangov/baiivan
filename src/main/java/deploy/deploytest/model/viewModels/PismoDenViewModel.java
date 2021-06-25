package deploy.deploytest.model.viewModels;

import javax.persistence.Column;
import java.time.LocalDate;

public class PismoDenViewModel {
    private Long id;
    private String pismoDate;

    private String analizDate;

    private String numberPismo;

    public PismoDenViewModel() {
    }

    public Long getId() {
        return id;
    }

    public PismoDenViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPismoDate() {
        return pismoDate;
    }

    public PismoDenViewModel setPismoDate(String pismoDate) {
        this.pismoDate = pismoDate;
        return this;
    }

    public String getAnalizDate() {
        return analizDate;
    }

    public PismoDenViewModel setAnalizDate(String analizDate) {
        this.analizDate = analizDate;
        return this;
    }

    public String getNumberPismo() {
        return numberPismo;
    }

    public PismoDenViewModel setNumberPismo(String numberPismo) {
        this.numberPismo = numberPismo;
        return this;
    }
}
