package la.foton.treinamento.desafio.autorizador.rest;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Stateless
@Path("/cliente")
@Produces("application/json")
public class ClienteRest {

    @GET
    public String cadastra() {
        return "Cliente cadastrado";
    }
}
