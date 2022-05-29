package org.typograf.DTO;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class CompletedOrderForExpertDTO {
    private Integer idCompletedOrder;

    @Min(value = 1,message = "Минимум 1")
    @Max(value = 10,message = "Максимум 10")
    private Integer factDifficilty;

    @NotBlank(message = "Введите оценочное суждение инженера")
    private String jadgmentCompany;

    private String expertOpinion;

    private Integer ratingFirm;

    public CompletedOrderForExpertDTO() {
    }

    public Integer getFactDifficilty() {
        return factDifficilty;
    }

    public void setFactDifficilty(Integer factDifficilty) {
        this.factDifficilty = factDifficilty;
    }

    public String getExpertOpinion() {
        return expertOpinion;
    }

    public void setExpertOpinion(String expertOpinion) {
        this.expertOpinion = expertOpinion;
    }

    public String getJadgmentCompany() {
        return jadgmentCompany;
    }

    public void setJadgmentCompany(String jadgmentCompany) {
        this.jadgmentCompany = jadgmentCompany;
    }

    public Integer getRatingFirm() {
        return ratingFirm;
    }

    public void setRatingFirm(Integer ratingFirm) {
        this.ratingFirm = ratingFirm;
    }

    public Integer getIdCompletedOrder() {
        return idCompletedOrder;
    }

    public void setIdCompletedOrder(Integer idCompletedOrder) {
        this.idCompletedOrder = idCompletedOrder;
    }
}
