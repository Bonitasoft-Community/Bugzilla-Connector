/**
 * 
 */
package com.bos.bugzilla;

import org.bonitasoft.engine.connector.ConnectorException;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;

import java.util.logging.Logger;

/**
 *The connector execution will follow the steps
 * 1 - setInputParameters() --> the connector receives input parameters values
 * 2 - validateInputParameters() --> the connector can validate input parameters values
 * 3 - connect() --> the connector can establish a connection to a remote server (if necessary)
 * 4 - executeBusinessLogic() --> execute the connector
 * 5 - getOutputParameters() --> output are retrieved from connector
 * 6 - disconnect() --> the connector can close connection to remote server (if any)
 */
public class BosBugzillaCreateBugImpl extends AbstractBosBugzillaCreateBugImpl {


    Logger logger = Logger.getLogger("org.bonitasoft");

    @Override
	protected void executeBusinessLogic() throws ConnectorException{

	  int bugID = 0;
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
	    logger.info("Map Created=" + bugMap.size());

		bugMap.put("product", getProduct());
		bugMap.put("component", getComponent());
		bugMap.put("summary", getSummary());
		bugMap.put("description",getDescription());
		bugMap.put("version", getVersion());
		bugMap.put("op_sys", getOp_sys());
		bugMap.put("platform", getPlatform());
		bugMap.put("priority", getPriority());
		bugMap.put("severity", getSeverity());
		bugMap.put("status", getStatus());
		bugMap.put("assigned_to", getAsignee());
		if (getDeadline() != null)
	    {
			SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy-MM-dd");
         // parse the date into another format
			bugMap.put("deadline", sdfDestination.format(getDeadline()));  // YYYY-MM-DD.
	    }

//		bugMap.put("qa_contact", this.getQa_contact());
	    logger.info("Map Almost populated=" + bugMap.size());
//		bugMap.put("cc", new ArrayList().add(this.getCc()));
	    logger.info("Map populated (cc)=" + bugMap.size());

	    // create bug
	    Object createResult = rpcClient.execute("Bug.create", new Object[]{bugMap});
	    // result is (should be) a vector.
	    logger.info("clientExecuted=" + bugMap.size());
	    logger.info(createResult.toString());
	    logger.info(createResult.getClass().toString());
	    if (createResult instanceof HashMap)
	    {
	    	HashMap hM = (HashMap) createResult;
	    	bugID = (Integer) hM.get("id");
	    }
	    else
	    {
	    	bugID = 101;
	    }
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
		setBugID("" + bugID);
	
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
