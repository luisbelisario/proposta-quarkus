package org.belisario.adapters.in.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;
import org.belisario.adapters.in.entity.ProposalEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

@Jacksonized
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProposalRequest {

    private String customer;

    private BigDecimal priceTonne;

    private Integer tonnes;

    private String country;

    private Integer proposalValidityDays;

    public static ProposalEntity toProposalEntity(ProposalRequest proposalRequest) {
        ProposalEntity proposalEntity = new ProposalEntity();
        proposalEntity.setCustomer(proposalRequest.getCustomer());
        proposalEntity.setPriceTonne(proposalRequest.getPriceTonne());
        proposalEntity.setTonnes(proposalRequest.getTonnes());
        proposalEntity.setCountry(proposalRequest.getCountry());
        proposalEntity.setProposalValidityDays(proposalRequest.getProposalValidityDays());
        proposalEntity.setCreated(LocalDate.now());
        proposalEntity.setApproved(false);
        return proposalEntity;
    }
}
