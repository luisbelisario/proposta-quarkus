package org.belisario.application.core.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Proposal {

    private Long id;

    private String customer;

    private BigDecimal priceTonne;

    private Integer tonnes;

    private String country;

    private Integer proposalValidityDays;

    private LocalDate created;

    private Boolean approved;

    public Proposal() {
    }

    public Proposal(Long id, String customer, BigDecimal priceTonne, Integer tonnes, String country, Integer proposalValidityDays, LocalDate created) {
        this.id = id;
        this.customer = customer;
        this.priceTonne = priceTonne;
        this.tonnes = tonnes;
        this.country = country;
        this.proposalValidityDays = proposalValidityDays;
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public BigDecimal getPriceTonne() {
        return priceTonne;
    }

    public void setPriceTonne(BigDecimal priceTonne) {
        this.priceTonne = priceTonne;
    }

    public Integer getTonnes() {
        return tonnes;
    }

    public void setTonnes(Integer tonnes) {
        this.tonnes = tonnes;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getProposalValidityDays() {
        return proposalValidityDays;
    }

    public void setProposalValidityDays(Integer proposalValidityDays) {
        this.proposalValidityDays = proposalValidityDays;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }
}
