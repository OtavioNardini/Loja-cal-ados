package br.unitins.topicos1.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.oracle.svm.core.annotate.Delete;

import br.unitins.topicos1.dto.EnderecoResponseDTO;
import br.unitins.topicos1.model.Endereco;
import br.unitins.topicos1.service.EnderecoService;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

@Path("/enderecos")
public class EnderecoResourse {
    @Inject
    private EnderecoService enderecoService;

    // seleciona todas os endereços do banco de dados
    @GET
    public List<EnderecoResponseDTO> getAll() {
        return enderecoService.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Endereco insert(Endereco endereco) {
        // adiciona o endereco no banco de dados
        endereco.persist();

        return endereco;
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Endereco uptadte(@PathParam("id") Long id, Endereco endereco) {

        Endereco entity = Endereco.findById(id);

        entity.setPrincipal(endereco.getPrincipal());
        entity.setLogradouro(endereco.getLogradouro());
        entity.setBairro(endereco.getBairro());
        entity.setNumero(endereco.getNumero());
        entity.setComplemento(endereco.getComplemento());
        entity.setCep(endereco.getCep());
        entity.setMunicipio(endereco.getMunicipio());
        entity.setEstado(endereco.getEstado());
        

        return entity;
    }

    @Delete
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        enderecoService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }


    @GET
    @Path("/count")
    public long count(){
        return enderecoService.count();
    }

    @GET
    @Path("/search/{nome}")
    public List<EnderecoResponseDTO> search(@PathParam("nome") String nome){
        return enderecoService.findByNome(nome);
        

    
}
}