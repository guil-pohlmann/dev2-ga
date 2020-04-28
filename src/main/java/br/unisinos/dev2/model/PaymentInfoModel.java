package br.unisinos.dev2.model;

import br.unisinos.dev2.dto.PaymentInfoDTO;

public class PaymentInfoModel extends AbstractModel {

    private String creditCardOwner;

    private String creditCardNumber;

    private String provider;

    private String validToMonth;

    private String validToYear;

    private PaymentInfoModel(){}

    public PaymentInfoModel(PaymentInfoDTO paymentInfoDTO) {
        this.creditCardOwner = paymentInfoDTO.getCreditCardOwner();
        this.creditCardNumber= paymentInfoDTO.getCreditCardNumber();
        this.provider = paymentInfoDTO.getProvider();
        this.validToMonth = paymentInfoDTO.getValidToMonth();
        this.validToYear = paymentInfoDTO.getValidToYear();
    }

    public String getCreditCardOwner() {
        return creditCardOwner;
    }

    public void setCreditCardOwner(String creditCardOwner) {
        this.creditCardOwner = creditCardOwner;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getValidToMonth() {
        return validToMonth;
    }

    public void setValidToMonth(String validToMonth) {
        this.validToMonth = validToMonth;
    }

    public String getValidToYear() {
        return validToYear;
    }

    public void setValidToYear(String validToYear) {
        this.validToYear = validToYear;
    }
}
