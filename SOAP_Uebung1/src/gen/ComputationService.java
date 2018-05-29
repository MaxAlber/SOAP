
package gen;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ComputationService", targetNamespace = "http://localhost:8080/ComputationService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ComputationService {


    /**
     * 
     * @param n
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(name = "result", partName = "result")
    @Action(input = "http://localhost:8080/ComputationService/ComputationService/factorialRequest", output = "http://localhost:8080/ComputationService/ComputationService/factorialResponse")
    public int factorial(
        @WebParam(name = "n", partName = "n")
        int n);

}
