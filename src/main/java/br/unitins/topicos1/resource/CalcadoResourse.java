package br.unitins.topicos1.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
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
import br.unitins.topicos1.dto.CalcadoDTO;
import br.unitins.topicos1.dto.CalcadoResponseDTO;
import br.unitins.topicos1.service.CalcadoService;

@Path("/calçados")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CalcadoResourse {

    @Inject
    CalcadoService calcadoService;

    @GET
    public List<CalcadoResponseDTO> getAll() {
        return calcadoService.getAll();
    }

    @GET
    @Path("/{id}")
    public CalcadoResponseDTO findById(@PathParam("id") Long id) {
        return calcadoService.findById(id);
    }

    @POST
    @Transactional
    public Response insert(CalcadoDTO dto) {
        try {
            CalcadoResponseDTO calcado = calcadoService.create(dto);
            return Response.status(Status.CREATED).entity(calcado).build();
        } catch(ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, CalcadoDTO dto) {
        try {
            CalcadoResponseDTO calcado = calcadoService.update(id, dto);
            return Response.ok(calcado).build();
        } catch(ConstraintViolationException e) {
            Result result = new Result(e.getConstraintViolations());
            return Response.status(Status.NOT_FOUND).entity(result).build();
        }      
    }

    @Delete
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        calcadoService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }


    @GET
    @Path("/count")
    public long count(){
        return calcadoService.count();
    }

    @GET
    @Path("/search/{nome}")
    public List<CalcadoResponseDTO> search(@PathParam("nome") String nome){
        return calcadoService.findByNome(nome);
        


}
}