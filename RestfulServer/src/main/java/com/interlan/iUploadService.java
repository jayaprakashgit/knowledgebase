package com.interlan;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;

@Path("/upload")
public interface iUploadService {

	@POST
	@Path("/uploadFile")
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public Response uploadFile(List<Attachment> attachments, @Context HttpServletRequest request);
}
