package org.server;

import javax.swing.JOptionPane;

import javax.xml.ws.Endpoint;

public class Server
{

	public static void main(String[] args)
	{
		
		// publish service using an endpoint
		Endpoint endpoint = Endpoint.publish("http://localhost:8080/ComputationService", new org.publisher.ComputationService());
		
		// wait for termination
		JOptionPane.showMessageDialog( null, "Kill Server?" );
		
		// shut down endpoint
		endpoint.stop();
		
	}
}
