package com.fr.uha.ensisa.RESTAPI.ressource;


import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.fr.uha.ensisa.RESTAPI.database.Connection;
import com.fr.uha.ensisa.RESTAPI.model.Vol;


@Path("vols")
public class Vols {

	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/test")
	public String getit()
	{
		return "Hello";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vol> getVols()
	{
		return Connection.getAllVols();
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
