package org.belisario.adapters.out.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Jacksonized
@Data
@AllArgsConstructor
@Builder
public class ProposalDTO {

    private Long proposalId;

    private String customer;

    private BigDecimal priceTonne;

    private Integer tonnes;

    private Boolean approved;
}
