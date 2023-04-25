package br.unitins.topicos1.resource;

import java.util.List;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
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

import br.unitins.topicos1.application.Result;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.dto.TelefoneResponseDTO;
import br.unitins.topicos1.service.TelefoneService;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

@Path("/telefones")
public class TelefoneResourse {

    @Inject
    TelefoneService telefoneService;

    @GET
    public List<TelefoneResponseDTO> getAll() {
        return telefoneService.getAll();
    }

    @GET
    @Path("/{id}")
    public TelefoneResponseDTO findById(@PathParam("id") Long id) {
        return telefoneService.findById(id);
    }

    @POST
    public Response insert(TelefoneDTO dto) {
        try {
            TelefoneResponseDTO telefone = telefoneService.create(dto);
            return Response.status(Status.CREATED).entity(telefone).build();
        } catch(ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, TelefoneDTO dto) {
        try {
            TelefoneResponseDTO telefone = telefoneService.update(id, dto);
            return Response.ok(telefone).build();
        } catch(ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }      
    }

    @Delete
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        telefoneService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }


    @GET
    @Path("/count")
    public long count(){
        return telefoneService.count();
    }

    @GET
    @Path("/search/{nome}")
    public List<TelefoneResponseDTO> search(@PathParam("nome") String nome){
        return telefoneService.findByNome(nome);
        


}
}
