package org.belisario.adapters.out.message;

import jakarta.enterprise.context.ApplicationScoped;
import org.belisario.adapters.out.dto.ProposalDTO;
import org.belisario.application.ports.out.MessagePort;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class MessageAdapter implements MessagePort {

    private final Logger LOG = LoggerFactory.getLogger(MessageAdapter.class);

    @Channel("proposal")
    Emitter<ProposalDTO> proposalDTOEmitter;

    public void sendMessage(ProposalDTO proposalDTO) {
        LOG.info("Nova proposta aprovada! Enviando proposta aprovada pelo Kafka!");
        proposalDTOEmitter.send(proposalDTO).toCompletableFuture().join();
    }
}
