package org.belisario.application.ports.out;

import org.belisario.adapters.in.request.ProposalRequest;
import org.belisario.application.core.domain.Proposal;

public interface ProposalDBPort {

    Proposal findOne(Long id);

    Proposal createProposal(ProposalRequest proposalRequest);

    void deleteProposal(Long id);
}
