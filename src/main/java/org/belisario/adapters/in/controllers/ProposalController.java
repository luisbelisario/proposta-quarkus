package org.belisario.adapters.in.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.belisario.adapters.in.request.ProposalRequest;
import org.belisario.adapters.out.dto.ProposalDetailsDTO;
import org.belisario.application.core.service.ProposalServicePort;

@Path("/api/proposal")
public class ProposalController {

    @Inject
    ProposalServicePort proposalServicePort;

    @GET
    @Path("/{id}")
    public ProposalDetailsDTO findProposalDetails(@PathParam("id") Long id) {
        return proposalServicePort.findFullProposal(id);
    }

    @POST
    public Response createProposal(ProposalRequest proposalRequest) {
        ProposalDetailsDTO proposalDetailsDTO = proposalServicePort.createNewproposal(proposalRequest);
        return Response.ok(proposalDetailsDTO).build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeProposal(@PathParam("id") Long id) {
        proposalServicePort.removeProposal(id);
        return Response.ok().build();
    }

    @PATCH
    @Path("/approve/{id}")
    public Response approveProposal(@PathParam("id") Long id) {
        ProposalDetailsDTO proposalDetailsDTO = proposalServicePort.approveProposal(id);
        return Response.ok(proposalDetailsDTO).build();
    }

}
