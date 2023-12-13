package org.belisario.adapters.out.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.belisario.adapters.in.entity.ProposalEntity;
import org.belisario.adapters.in.request.ProposalRequest;
import org.belisario.application.core.domain.Proposal;
import org.belisario.application.ports.out.ProposalDBPort;

@ApplicationScoped
public class ProposalDBAdapter implements ProposalDBPort {

    @Inject
    ProposalRepository proposalRepository;


    @Override
    public Proposal findOne(Long id) {
        ProposalEntity proposalEntity = proposalRepository.findById(id);
        return ProposalEntity.toProposal(proposalEntity);
    }

    @Override
    @Transactional
    public Proposal createProposal(ProposalRequest proposalRequest) {
        ProposalEntity proposalEntity = ProposalRequest.toProposalEntity(proposalRequest);
        proposalRepository.persist(proposalEntity);
        return ProposalEntity.toProposal(proposalEntity);
    }

    @Override
    @Transactional
    public void deleteProposal(Long id) {
        ProposalEntity proposalEntity = proposalRepository.findById(id);
        proposalRepository.delete(proposalEntity);
    }
}
