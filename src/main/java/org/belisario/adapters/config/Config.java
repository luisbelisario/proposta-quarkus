package org.belisario.adapters.config;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Default;
import org.belisario.application.core.service.ProposalService;
import org.belisario.application.ports.out.MessagePort;
import org.belisario.application.ports.out.ProposalDBPort;

@Dependent
public class Config {

    @Default
    public ProposalService proposalService(ProposalDBPort proposalDBPort, MessagePort messagePort) {
        return new ProposalService(proposalDBPort, messagePort);
    }
}
