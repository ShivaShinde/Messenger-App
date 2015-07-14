package org.nuodb.shiva.messenger.resources;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nuodb.shiva.messenger.model.Message;
import org.nuodb.shiva.messenger.service.MessageService;

@Path("/messages")

public class MessageResource {
	
	MessageService messageService=new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> wantMessage()
	{
		return messageService.getAllMessages();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message addMessages(Message message)
	{
		return messageService.addMessage(message);
	}
	
	@Path("/{messageid}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessages(@PathParam("messageid") long messageid, Message message)
	{
		message.setId(messageid);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageid}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageid") long messageid)
	{
		messageService.removeMessage(messageid);
	}
	
	
@Path("/{messageid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageid") long messageid)
	{
		return messageService.getMessage(messageid);
	}



}
