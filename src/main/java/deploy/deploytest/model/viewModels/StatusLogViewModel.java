package deploy.deploytest.model.viewModels;

import deploy.deploytest.model.entities.AnalizDen;
import deploy.deploytest.model.entities.PismoDen;
import deploy.deploytest.model.entities.UserEntity;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class StatusLogViewModel {
    private String statusChangeText;
    private String statusChangeDateAndTime;
    private String usernameMadeTheChange;

    private String numberAnaliz;
    private String analizType;
    private String pismoDenNumber;

    public StatusLogViewModel() {
    }

    public String getStatusChangeText() {
        return statusChangeText;
    }

    public StatusLogViewModel setStatusChangeText(String statusChangeText) {
        this.statusChangeText = statusChangeText;
        return this;
    }

    public String getStatusChangeDateAndTime() {
        return statusChangeDateAndTime;
    }

    public StatusLogViewModel setStatusChangeDateAndTime(String statusChangeDateAndTime) {
        this.statusChangeDateAndTime = statusChangeDateAndTime;
        return this;
    }

    public String getUsernameMadeTheChange() {
        return usernameMadeTheChange;
    }

    public StatusLogViewModel setUsernameMadeTheChange(String usernameMadeTheChange) {
        this.usernameMadeTheChange = usernameMadeTheChange;
        return this;
    }

    public String getNumberAnaliz() {
        return numberAnaliz;
    }

    public StatusLogViewModel setNumberAnaliz(String numberAnaliz) {
        this.numberAnaliz = numberAnaliz;
        return this;
    }

    public String getAnalizType() {
        return analizType;
    }

    public StatusLogViewModel setAnalizType(String analizType) {
        this.analizType = analizType;
        return this;
    }

    public String getPismoDenNumber() {
        return pismoDenNumber;
    }

    public StatusLogViewModel setPismoDenNumber(String pismoDenNumber) {
        this.pismoDenNumber = pismoDenNumber;
        return this;
    }
}
