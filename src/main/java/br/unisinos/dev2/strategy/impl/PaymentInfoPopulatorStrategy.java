package br.unisinos.dev2.strategy.impl;

import br.unisinos.dev2.dto.PaymentInfoDTO;
import br.unisinos.dev2.model.PaymentInfoModel;
import br.unisinos.dev2.strategy.PopulatorStrategy;
import org.springframework.stereotype.Component;

@Component
public class PaymentInfoPopulatorStrategy implements PopulatorStrategy<PaymentInfoModel, PaymentInfoDTO> {

    @Override
    public void populate(PaymentInfoModel source, PaymentInfoDTO target) {
        target.setCreditCardNumber(source.getCreditCardNumber());
        target.setCreditCardOwner(source.getCreditCardOwner());
        target.setProvider(source.getProvider());
        target.setValidToMonth(source.getValidToMonth());
        target.setValidToYear(source.getValidToYear());
    }
}
