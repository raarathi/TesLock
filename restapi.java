package com.example.bcorcoran.teslock;


//import org.springframework.web.client.RestTemplate;
//import org.springframework.http.converter.StringHttpMessageConverter;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ApacheClient
{

    private HttpClient httpClient;
    private HttpResponse response;
    private StatusLine statusLine;

    public ApacheClient() throws IOException
    {
        httpClient = new DefaultHttpClient();
        response = httpClient.execute(new HttpGet("http://localhost:8080/mockTesla/vehicles/1234567890/command/drive_state"));
        statusLine = response.getStatusLine();
        this.main();
    }

    public void main() throws IOException
    {
        if (statusLine.getStatusCode() == HttpStatus.SC_OK)
        {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            response.getEntity().writeTo(out);
            out.close();
            String responseString = out.toString();
            //..more logic
        }
        else
        {
            //Closes the connection.
            response.getEntity().getContent().close();
            throw new IOException(statusLine.getReasonPhrase());
        }
    }
}
//public class apigrab {
    //new

    //RequestTask()



    //execute("http://localhost:8080/mockTesla/vehicles/1234567890/command/drive_state");
//}
   // String url = "http://localhost:8080/mockTesla/vehicles/1234567890/command/drive_state";
   // RestTemplate restTemplate = new RestTemplate();
   // restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
   // String result = restTemplate.getForObject(url, String.class, "Android");

