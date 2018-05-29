package org.client;


public class Client {

	// to get stub execute in src directory: wsimport -d ./ -keep -p gen http://localhost:1234/ComputationService?wsdl
	
	public static void main(String args[])
	{
		// get reference to remote service
		gen.ComputationService service = new gen.ComputationServiceService().getComputationServicePort();
			
		int result=service.factorial(5);
		System.out.println("Result: " + result);
	}
}
