/**
 * 
 */
package org.bonitasoft.connector;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.commons.httpclient.HttpClient;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;
import org.bonitasoft.engine.connector.ConnectorException;

/**
 *The connector execution will follow the steps
 * 1 - setInputParameters() --> the connector receives input parameters values
 * 2 - validateInputParameters() --> the connector can validate input parameters values
 * 3 - connect() --> the connector can establish a connection to a remote server (if necessary)
 * 4 - executeBusinessLogic() --> execute the connector
 * 5 - getOutputParameters() --> output are retrieved from connector
 * 6 - disconnect() --> the connector can close connection to remote server (if any)
 */
public class BosBugzillaUpdateBugImpl extends AbstractBosBugzillaUpdateBugImpl {

    Logger logger = Logger.getLogger("org.bonitasoft");

    @Override
	protected void executeBusinessLogic() throws ConnectorException{
		//Get access to the connector input parameters
		//getUrl();
		//getUid();
		//getPwd();
		//getProduct();
		//getComponent();
		//getSummary();
		//getDescription();
		//getVersion();
		//getOp_sys();
		//getPlatform();
		//getPriority();
		//getSeverity();
		//getStatus();
		//getAsignee();
		//getQa_contact();
		//getCc();
		//getCategory();
		//getDeadline();
		//getExpVendor();
	
  	  try{
  	    HttpClient httpClient = new HttpClient();
  	    XmlRpcClient rpcClient = new XmlRpcClient();
  	    XmlRpcCommonsTransportFactory factory = new XmlRpcCommonsTransportFactory(rpcClient);
  	    XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();

  	    factory.setHttpClient(httpClient);
  	    rpcClient.setTransportFactory(factory);
  	    config.setServerURL(new URL(getUrl()));
  	    rpcClient.setConfig(config);

  	    // map of the login data
  	    Map<String, String> loginMap = new HashMap<String, String>();
  	    loginMap.put("login", getUid());
  	    loginMap.put("password", getPwd());
  	    loginMap.put("rememberlogin", "Bugzilla_remember");

  	    // login to bugzilla
  	    Object loginResult = rpcClient.execute("User.login", new Object[]{loginMap});
  	    logger.info("loginResult=" + loginResult);

  	    // map of the bug data
  	    Map<String, Object>  bugMap = new HashMap<String, Object>();
  	    
  		bugMap.put("ids", getBugid());
		bugMap.put("version", getVersion());

  		if (getProduct() != null && !(getProduct().equals("")))
  			bugMap.put("product", getProduct());
  		if (getComponent() != null && !(getComponent().equals("")))
  			bugMap.put("component", getComponent());
  		if (getSummary() != null && !(getSummary().equals("")))
  			bugMap.put("summary", getSummary());
  		if (getDescription() != null && !(getDescription().equals("")))
  			bugMap.put("description",getDescription());
  		if (getOp_sys() != null && !(getOp_sys().equals("")))
  			bugMap.put("op_sys", getOp_sys());
  		if (getPlatform() != null && !(getPlatform().equals("")))
  			bugMap.put("platform", getPlatform());
  		if (getPriority() != null && !(getPriority().equals("")))
  			bugMap.put("priority", getPriority());
  		if (getSeverity() != null && !(getSeverity().equals("")))
  			bugMap.put("severity", getSeverity());
  		if (getStatus() != null && !(getStatus().equals("")))
  			bugMap.put("status", getStatus());
  		if (getAsignee() != null && !(getAsignee().equals("")))
  			bugMap.put("assigned_to", getAsignee());
  		if (getQa_contact() != null && !(getQa_contact().equals("")))
  			bugMap.put("qa_contact", this.getQa_contact());
		if (getDeadline() != null)
	    {
			SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy-MM-dd");
         // parse the date into another format
			bugMap.put("deadline", sdfDestination.format(getDeadline()));  // YYYY-MM-DD.
	    }

  		if (getCc() != null && !(getCc().equals("")))
  			bugMap.put("cc", new ArrayList().add(this.getCc()));

  	    // create bug
  	    Object createResult = rpcClient.execute("Bug.update", new Object[]{bugMap});
  	    // result is (should be) a vector.
  	    logger.info(createResult.toString());
  	    logger.info(createResult.getClass().toString());
/*  	    if (createResult instanceof HashMap)
  	    {
  	    	HashMap hM = (HashMap) createResult;
  	    	bugID = (Integer) hM.get("id");
  	    }
  	    else
  	    {
  	    	bugID = 101;
  	    }
*/
  	  }
        catch (MalformedURLException mURLE)
        {
        	logger.info("MalformedURLException " + mURLE.getStackTrace().toString());
       	throw new ConnectorException(mURLE.getMessage());
        }
        catch (XmlRpcException xRE)
        {
       	logger.info("What " + xRE.getClass().toString());
       	logger.info("And " + xRE.getMessage());
       	logger.info("XmlRpcException " + xRE.getStackTrace().toString());
       	throw new ConnectorException(xRE.getMessage());
        }
        catch (Throwable thex)
        {
       	logger.info("What " + thex.getClass().toString());
       	logger.info("And " + thex.getMessage());
       	logger.info("Throwable " + thex.getStackTrace().toString());
       	throw new ConnectorException(thex.getMessage());
        }	
  		//WARNING : Set the output of the connector execution. If outputs are not set, connector fails
  		setBugID("" + getBugid());
  	
	
		//WARNING : Set the output of the connector execution. If outputs are not set, connector fails
		//setBugID(bugID);
	
	 }

	@Override
	public void connect() throws ConnectorException{
		//[Optional] Open a connection to remote server
	
	}

	@Override
	public void disconnect() throws ConnectorException{
		//[Optional] Close connection to remote server
	
	}

}
