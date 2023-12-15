package org.belisario.application.core.service;

import jakarta.transaction.Transactional;
import org.belisario.adapters.in.request.ProposalRequest;
import org.belisario.adapters.out.dto.ProposalDTO;
import org.belisario.adapters.out.dto.ProposalDetailsDTO;
import org.belisario.application.core.domain.Proposal;
import org.belisario.application.ports.out.MessagePort;
import org.belisario.application.ports.out.ProposalDBPort;

public class ProposalService implements ProposalServicePort {

    private final ProposalDBPort proposalDBPort;

    private final MessagePort messagePort;

    public ProposalService(ProposalDBPort proposalDBPort, MessagePort messagePort) {
        this.proposalDBPort = proposalDBPort;
        this.messagePort = messagePort;
    }

    @Override
    public ProposalDetailsDTO findFullProposal(Long id) {
        Proposal proposal = proposalDBPort.findOne(id);
        return ProposalDetailsDTO.builder()
                .proposalId(proposal.getId())
                .proposalValidityDays(proposal.getProposalValidityDays())
                .country(proposal.getCountry())
                .priceTonne(proposal.getPriceTonne())
                .customer(proposal.getCustomer())
                .tonnes(proposal.getTonnes())
                .build();
    }

    @Override
    @Transactional
    public ProposalDetailsDTO createNewproposal(ProposalRequest proposalRequest) {
        Proposal proposal = proposalDBPort.createProposal(proposalRequest);
        return ProposalDetailsDTO.builder()
                .proposalId(proposal.getId())
                .created(proposal.getCreated())
                .proposalValidityDays(proposal.getProposalValidityDays())
                .country(proposal.getCountry())
                .priceTonne(proposal.getPriceTonne())
                .customer(proposal.getCustomer())
                .tonnes(proposal.getTonnes())
                .approved(proposal.getApproved())
                .build();
    }

    @Override
    @Transactional
    public void removeProposal(Long id) {
        proposalDBPort.deleteProposal(id);
    }

    @Override
    public ProposalDetailsDTO approveProposal(Long id) {
        Proposal proposal = proposalDBPort.approveProposal(id);
        ProposalDTO dto = ProposalDTO.builder()
                .proposalId(proposal.getId())
                .customer(proposal.getCustomer())
                .priceTonne(proposal.getPriceTonne())
                .tonnes(proposal.getTonnes())
                .approved(proposal.getApproved())
                .build();
        messagePort.sendMessage(dto);
        return ProposalDetailsDTO.builder()
                .proposalId(proposal.getId())
                .proposalValidityDays(proposal.getProposalValidityDays())
                .created(proposal.getCreated())
                .country(proposal.getCountry())
                .priceTonne(proposal.getPriceTonne())
                .customer(proposal.getCustomer())
                .tonnes(proposal.getTonnes())
                .approved(proposal.getApproved())
                .build();
    }
}
