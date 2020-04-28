package br.unisinos.dev2.dto;

public class PaymentInfoDTO extends AbstractDTO {
    private String creditCardOwner;

    private String creditCardNumber;

    private String provider;

    private String validToMonth;

    private String validToYear;

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
