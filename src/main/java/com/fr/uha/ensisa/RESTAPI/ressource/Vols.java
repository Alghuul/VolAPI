package com.fr.uha.ensisa.RESTAPI.ressource;


import java.util.List;

import com.fr.uha.ensisa.RESTAPI.database.Connection;
import com.fr.uha.ensisa.RESTAPI.model.Vol;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;


@Path("/vols")
public class Vols {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getVols()
	{
		return "hello world";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/search")
	public List<Vol> getVols(@QueryParam ("departure")String departure,@QueryParam("arrival") String arrival,@QueryParam("departureTime") int time)
	{
		
		return Connection.searchVol(departure, arrival, time);
	}
	
	
	
	@GET
	@Path("/numVol-{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Vol getVol(@PathParam("id") String id)
	{
		return Connection.getVol(id);
	}
	
}
