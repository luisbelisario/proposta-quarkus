package org.belisario.application.core.service;

import org.belisario.adapters.in.request.ProposalRequest;
import org.belisario.adapters.out.dto.ProposalDetailsDTO;

public interface ProposalServicePort {

    ProposalDetailsDTO findFullProposal(Long id);

    ProposalDetailsDTO createNewproposal(ProposalRequest proposalRequest);

    void removeProposal(Long id);

    ProposalDetailsDTO approveProposal(Long id);
}
