package org.publisher;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


//Damit exportiert werden kann muss @WebService angegeben werden
@WebService(name = "Publisher", targetNamespace = "http://localhost:8080/Publisher")
//Gibt ann dass Soap als Kommunikation genutzt wird und dass der style rpc ist, also remote procedure call
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Publisher {
		
		@WebMethod(operationName="getAlbumPrice")
		@WebResult(name = "result")
		public double getAlbumPrice(@WebParam(name="artist") String artist, @WebParam(name="album") String album)
		{
			
			
			if(artist.equals("Sabaton"))
			{
				
				switch (album)
				{
			
				case "The last Stand":
				{
					return 10.99;
				}
				case "Hereos":
				{
					return 11.99;
				}
				case "Carolus Rex":
				{
					return 12.99;
				}
				case "Primo Victoria":
				{
					return 10.99;
				}
				case "Coat of Arms":
				{
					return 13.99;
				}
				case "Metalizer":
				{
					return 12.99;
				}
				case "In the Army now":
				{
					return 10.99;
				}
				default:
					return 0;
			}
			
			}
			return 0;
			
		}
		
		@WebMethod(operationName="getAlbumNames")
		@WebResult(name = "result")
		public String getAlbumNames(@WebParam(name="artist") String artist)
		{
			if(artist.equals("Sabaton"))
			{
				return "The-last-Stand\n "+ "Hereos\n "+ "Carolus-Rex\n "+ "Primo-Victoria\n "+ "Coat-of-Arms\n "+ "Metalizer\n "+ "In-the-Army-now\n ";
			}
			
			return "Nicht verfügbar";
		}
		
		@WebMethod(operationName="buyAlbum")
		@WebResult(name = "result")
		public boolean buyAlbum(@WebParam(name="artist") String artist, @WebParam(name="album") String album)
		{
			if(artist.equals("Sabaton"))
			{
				
				switch (album)
				{
			
				case "The last Stand":
				{
					return true;
				}
				
				case "Hereos":
				{
					return true;
				}
				case "Carolus Rex":
				{
					return true;
				}
				case "Primo Victoria":
				{
					return true;
				}
				case "Coat of Arms":
				{
					return true;
				}
				case "Metalizer":
				{
					return true;
				}
				case "In the Army now":
				{
					return true;
				}
				default:
					return false;
			}
			
			}
			return false;
		}

}
