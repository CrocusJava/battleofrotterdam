package com.battleweb.tools;

import java.io.IOException;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Stateless
@LocalBean
public class ToolJSON {
	
	public JsonObject getJsonObjectRequest(HttpServletRequest request) throws IOException{
		
		JsonReader jsonReaderRequest=Json.createReader(request.getReader());
		JsonObject jsonObjectRequest=jsonReaderRequest.readObject();
		jsonReaderRequest.close();

		return jsonObjectRequest;
	}
	
	public void setJsonObjectResponse(HttpServletResponse response, JsonObject jsonObject) throws IOException{
		
		response.setContentType("application/json");
		JsonWriter jsonWriterResponse=Json.createWriter(response.getWriter());
		jsonWriterResponse.writeObject(jsonObject);
		jsonWriterResponse.close();
	}
	
}
