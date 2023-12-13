package org.belisario.adapters.in.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.belisario.application.core.domain.Proposal;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "proposal")
public class ProposalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    private String customer;

    @Column(name = "price_tonne")
    private BigDecimal priceTonne;

    private Integer tonnes;

    private String country;

    @Column(name = "proposal_validity_days")
    private Integer proposalValidityDays;

    private LocalDate created;

    public static Proposal toProposal(ProposalEntity proposalEntity) {
        Proposal proposal = new Proposal();
        proposal.setId(proposalEntity.getId());
        proposal.setCustomer(proposalEntity.getCustomer());
        proposal.setPriceTonne(proposalEntity.getPriceTonne());
        proposal.setTonnes(proposalEntity.getTonnes());
        proposal.setCountry(proposalEntity.getCountry());
        proposal.setProposalValidityDays(proposalEntity.getProposalValidityDays());
        proposal.setCreated(proposalEntity.getCreated());
        return proposal;
    }
}
