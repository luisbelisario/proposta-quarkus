package org.belisario.application.ports.out;

import org.belisario.adapters.out.dto.ProposalDTO;

public interface MessagePort {

    public void sendMessage(ProposalDTO proposalDTO);
}
