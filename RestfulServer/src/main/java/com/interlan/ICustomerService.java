package com.interlan;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.model.wadl.Description;
import org.apache.cxf.jaxrs.model.wadl.DocTarget;

@Path("/customer")
public interface ICustomerService {

	@GET
	@Description(value="Resource", target=DocTarget.RESOURCE)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML})
	@Path("/getdetails/{name}")
	public Customer getCustomerDetails(@Description("Customer Name") @PathParam("name") final String name);
	
	@POST
	@Description(value="Resourcce", target=DocTarget.RESOURCE)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/addcustomer")
	public GenericResponse addCustomer(@Description("Input Customer")Customer customer);
	
	
	@POST
	@Path("/uploadFile")
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public Response uploadFile(List<Attachment> attachments, @Context HttpServletRequest request);

}
