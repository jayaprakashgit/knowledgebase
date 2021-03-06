package com.interlan;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.springframework.stereotype.Component;

@Component("customerService")
public class CustomerServiceImpl implements ICustomerService{

	public Customer getCustomerDetails(String name) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setName("JP-"+UUID.randomUUID().toString());
		customer.setAddress("Bedok");
		customer.setAge(19);
		return customer;
	}

	public GenericResponse addCustomer(Customer customer) {
		System.out.println("CustomerServiceImpl :: addCustomer called");
		// TODO Auto-generated method stub
		GenericResponse response = new GenericResponse();
		if(customer != null && customer.getAge() > 18){
			response.setMessage("Successfully stored...");
			response.setSuccess(true);
		}
		else{
			response.setMessage("Not Eligilble to Store...");
			response.setSuccess(false);
		}
		return response;
	}

	


	public Response uploadFile(List<Attachment> attachments, @Context HttpServletRequest request) {
		System.out.println("UploadServiceImpl :: uploadFile Starts");
		for (Attachment attachment : attachments) {
			DataHandler handler = attachment.getDataHandler();
			try {
				InputStream stream = handler.getInputStream();
				MultivaluedMap<String, String> map = attachment.getHeaders();
				System.out.println("fileName Here" + getFileName(map));
				OutputStream out = new FileOutputStream(new File("C:/uploads/" + getFileName(map)));

				int read = 0;
				byte[] bytes = new byte[1024];
				while ((read = stream.read(bytes)) != -1) {
					out.write(bytes, 0, read);
				}
				stream.close();
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("UploadServiceImpl :: uploadFile Finish");
		return Response.ok("file uploaded").build();
	}

	private String getFileName(MultivaluedMap<String, String> header) {
		String[] contentDisposition = header.getFirst("Content-Disposition").split(";");
		for (String filename : contentDisposition) {
			if ((filename.trim().startsWith("filename"))) {
				String[] name = filename.split("=");
				String exactFileName = name[1].trim().replaceAll("\"", "");
				return exactFileName;
			}
		}
		return "unknown";
	}
	
}
