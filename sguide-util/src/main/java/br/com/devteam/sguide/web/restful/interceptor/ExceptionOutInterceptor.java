package br.com.devteam.sguide.web.restful.interceptor;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

import br.com.devteam.sguide.exception.AuthenticationException;
import br.com.devteam.sguide.exception.AuthorizationException;
import br.com.devteam.sguide.exception.EntityExistsException;
import br.com.devteam.sguide.exception.EntityNotFoundException;
import br.com.devteam.sguide.web.response.HttpResponse;

public class ExceptionOutInterceptor extends AbstractPhaseInterceptor<Message> {

	public ExceptionOutInterceptor() {
		super(Phase.POST_INVOKE);
	}
	
	@Override
	public void handleMessage(Message message) throws Fault {
		Throwable throwable = message.getContent(Throwable.class);
		
		//Check for Fault nested exceptions
		if(throwable instanceof Fault)
			throwable = throwable.getCause();
		
		//default: Unexpected error(server_error)
		Response response = build(Status.INTERNAL_SERVER_ERROR, throwable.getMessage());
		
		//Invalid Credentials(forbidden)
		if(throwable instanceof AuthenticationException)
			response = build(Status.FORBIDDEN, throwable.getMessage());
		
		//Permission Denied(unauthorized)
		if(throwable instanceof AuthorizationException)
			response = build(Status.UNAUTHORIZED, throwable.getMessage());
		
		//Entity doesn't exist(not_found)
		if(throwable instanceof EntityNotFoundException)
			response = build(Status.NOT_FOUND, throwable.getMessage());
		
		//Entity already exist(conflict)
		if(throwable instanceof EntityExistsException)
			response = build(Status.CONFLICT, throwable.getMessage());
		
		//Sets the response
		message.getExchange().put(Response.class, response);
	}
	
	private Response build(Status status, String msg){
		return Response.status(status).entity(new HttpResponse(msg)).build();
	}
	
}