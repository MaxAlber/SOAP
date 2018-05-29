package org.client;

import javax.swing.JOptionPane;

public class Client {

	// to get stub execute in src directory: wsimport -d ./ -keep -p gen http://localhost:8080/Publisher?wsdl
	
	public static void main(String args[]) {
		Client client = new Client();
		
		// get reference to remote service
		gen.Publisher service = new gen.PublisherService().getPublisherPort();
		
		
		while (true)
		{
		
		String switcher;
		
		switcher = JOptionPane.showInputDialog("Was möchten sie tun ? \n"
				+ "1. Preis von Album bekommen\n"
				+ "2. Alle Alben ausgeben\n"
				+ "3. Album kaufen\n");
		
		switch(switcher)
		{
			case "1":
			{
				client.getAlbumPrice(service);
				break;
			}
			case "2":
			{
				client.getAlbumNames(service);
				break;
			}
			case "3":
			{
				client.buyAlbum(service);
				break;
			}
			default:
				JOptionPane.showInputDialog("Falsche Eingabe");
				break;
			
		}
		
		}
		
	}
	

		
		
	
	
	private void getAlbumPrice(gen.Publisher service)
	{
		double price = service.getAlbumPrice(JOptionPane.showInputDialog("Bitte den Artisten eingeben: (Zb. Sabaton)"), JOptionPane.showInputDialog("Bitte name des Albums eingeben: (Zb. The last Stand)"));
		if(price>0)
		{
			JOptionPane.showMessageDialog(null, "Das Album kostet " + price + "$");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Dieses Album ist nicht verfügbar");
		}
	}
	
	private void getAlbumNames(gen.Publisher service)
	{
		String names = service.getAlbumNames(JOptionPane.showInputDialog("Bitte den Artisten eingeben: (Zb. Sabaton)"));
		if(!names.equals("not available"))
		{
			JOptionPane.showMessageDialog(null, names);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Leider liegen hierzu keine Informationen vor.");
		}
	}
	
	private void buyAlbum(gen.Publisher service)
	{
		boolean bought = service.buyAlbum(JOptionPane.showInputDialog("Bitte den Artisten eingeben: (Zb. Sabaton)"), JOptionPane.showInputDialog("Bitte name des Albums eingeben: (Zb. The last Stand)"));
		if(bought)
		{
			JOptionPane.showMessageDialog(null, "Gekauft!");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Das Album ist momentan nicht verfügbar");
		}
	}
	
}
