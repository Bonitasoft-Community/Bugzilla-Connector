package org.bonitasoft.connector;

import org.bonitasoft.engine.connector.AbstractConnector;
import org.bonitasoft.engine.connector.ConnectorValidationException;

public abstract class AbstractBosBugzillaUpdateBugImpl extends
		AbstractConnector {

	protected final static String URL_INPUT_PARAMETER = "url";
	protected final static String UID_INPUT_PARAMETER = "uid";
	protected final static String PWD_INPUT_PARAMETER = "pwd";
	protected final static String BUGID_INPUT_PARAMETER = "bugid";
	protected final static String PRODUCT_INPUT_PARAMETER = "product";
	protected final static String COMPONENT_INPUT_PARAMETER = "component";
	protected final static String SUMMARY_INPUT_PARAMETER = "summary";
	protected final static String DESCRIPTION_INPUT_PARAMETER = "description";
	protected final static String VERSION_INPUT_PARAMETER = "version";
	protected final static String OP_SYS_INPUT_PARAMETER = "op_sys";
	protected final static String PLATFORM_INPUT_PARAMETER = "platform";
	protected final static String PRIORITY_INPUT_PARAMETER = "priority";
	protected final static String SEVERITY_INPUT_PARAMETER = "severity";
	protected final static String STATUS_INPUT_PARAMETER = "status";
	protected final static String ASIGNEE_INPUT_PARAMETER = "asignee";
	protected final static String QA_CONTACT_INPUT_PARAMETER = "qa_contact";
	protected final static String CC_INPUT_PARAMETER = "cc";
	protected final static String CATEGORY_INPUT_PARAMETER = "category";
	protected final static String DEADLINE_INPUT_PARAMETER = "deadline";
	protected final static String EXPVENDOR_INPUT_PARAMETER = "expVendor";
	protected final String BUGID_OUTPUT_PARAMETER = "bugID";

	protected final java.lang.String getUrl() {
		return (java.lang.String) getInputParameter(URL_INPUT_PARAMETER);
	}

	protected final java.lang.String getUid() {
		return (java.lang.String) getInputParameter(UID_INPUT_PARAMETER);
	}

	protected final java.lang.String getPwd() {
		return (java.lang.String) getInputParameter(PWD_INPUT_PARAMETER);
	}

	protected final java.lang.String getBugid() {
		return (java.lang.String) getInputParameter(BUGID_INPUT_PARAMETER);
	}

	protected final java.lang.String getProduct() {
		return (java.lang.String) getInputParameter(PRODUCT_INPUT_PARAMETER);
	}

	protected final java.lang.String getComponent() {
		return (java.lang.String) getInputParameter(COMPONENT_INPUT_PARAMETER);
	}

	protected final java.lang.String getSummary() {
		return (java.lang.String) getInputParameter(SUMMARY_INPUT_PARAMETER);
	}

	protected final java.lang.String getDescription() {
		return (java.lang.String) getInputParameter(DESCRIPTION_INPUT_PARAMETER);
	}

	protected final java.lang.String getVersion() {
		return (java.lang.String) getInputParameter(VERSION_INPUT_PARAMETER);
	}

	protected final java.lang.String getOp_sys() {
		return (java.lang.String) getInputParameter(OP_SYS_INPUT_PARAMETER);
	}

	protected final java.lang.String getPlatform() {
		return (java.lang.String) getInputParameter(PLATFORM_INPUT_PARAMETER);
	}

	protected final java.lang.String getPriority() {
		return (java.lang.String) getInputParameter(PRIORITY_INPUT_PARAMETER);
	}

	protected final java.lang.String getSeverity() {
		return (java.lang.String) getInputParameter(SEVERITY_INPUT_PARAMETER);
	}

	protected final java.lang.String getStatus() {
		return (java.lang.String) getInputParameter(STATUS_INPUT_PARAMETER);
	}

	protected final java.lang.String getAsignee() {
		return (java.lang.String) getInputParameter(ASIGNEE_INPUT_PARAMETER);
	}

	protected final java.lang.String getQa_contact() {
		return (java.lang.String) getInputParameter(QA_CONTACT_INPUT_PARAMETER);
	}

	protected final java.lang.String getCc() {
		return (java.lang.String) getInputParameter(CC_INPUT_PARAMETER);
	}

	protected final java.lang.String getCategory() {
		return (java.lang.String) getInputParameter(CATEGORY_INPUT_PARAMETER);
	}

	protected final java.util.Date getDeadline() {
		return (java.util.Date) getInputParameter(DEADLINE_INPUT_PARAMETER);
	}

	protected final java.lang.String getExpVendor() {
		return (java.lang.String) getInputParameter(EXPVENDOR_INPUT_PARAMETER);
	}

	protected final void setBugID(java.lang.String bugID) {
		setOutputParameter(BUGID_OUTPUT_PARAMETER, bugID);
	}

	@Override
	public void validateInputParameters() throws ConnectorValidationException {
		try {
			getUrl();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("url type is invalid");
		}
		try {
			getUid();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("uid type is invalid");
		}
		try {
			getPwd();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("pwd type is invalid");
		}
		try {
			getBugid();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("bugid type is invalid");
		}
		try {
			getProduct();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("product type is invalid");
		}
		try {
			getComponent();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("component type is invalid");
		}
		try {
			getSummary();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("summary type is invalid");
		}
		try {
			getDescription();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException(
					"description type is invalid");
		}
		try {
			getVersion();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("version type is invalid");
		}
		try {
			getOp_sys();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("op_sys type is invalid");
		}
		try {
			getPlatform();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("platform type is invalid");
		}
		try {
			getPriority();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("priority type is invalid");
		}
		try {
			getSeverity();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("severity type is invalid");
		}
		try {
			getStatus();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("status type is invalid");
		}
		try {
			getAsignee();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("asignee type is invalid");
		}
		try {
			getQa_contact();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("qa_contact type is invalid");
		}
		try {
			getCc();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("cc type is invalid");
		}
		try {
			getCategory();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("category type is invalid");
		}
		try {
			getDeadline();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("deadline type is invalid");
		}
		try {
			getExpVendor();
		} catch (ClassCastException cce) {
			throw new ConnectorValidationException("expVendor type is invalid");
		}

	}

}
