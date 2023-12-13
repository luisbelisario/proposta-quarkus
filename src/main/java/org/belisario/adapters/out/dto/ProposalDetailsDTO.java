package org.belisario.adapters.out.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;
import org.belisario.application.core.domain.Proposal;

import java.math.BigDecimal;

@Jacksonized
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProposalDetailsDTO {

    private Long proposalId;

    private String customer;

    private BigDecimal priceTonne;

    private Integer tonnes;

    private String country;

    private Integer proposalValidityDays;
}
