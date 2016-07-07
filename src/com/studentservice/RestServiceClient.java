package com.studentservice;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class RestServiceClient {
	
	public String getRESTResponse(Student student) {
		
		String output = "";
		try {
			
			ClientConfig clientConfig = new DefaultClientConfig();
			
			clientConfig.getFeatures().put(
					JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			
			Client client = Client.create(clientConfig);
			
			WebResource webResource = client
					.resource("http://localhost:8080/RestFulDemo/rest/jsonServices/send");
			System.out.println(student);
			ClientResponse response = webResource.accept("application/json")
					.type("application/json").post(ClientResponse.class, student);
			System.out.println(response);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}
			
			output = response.getEntity(String.class);
			
			System.out.println("Server response .... \n");
			System.out.println("JSON:" + output.replace('\\',' '));
			
		} catch (Exception e) {
			
			e.printStackTrace();

		}
		return output.replace('\\', '\u0000');

	}

}

