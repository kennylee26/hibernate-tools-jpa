package org.hibernate.tool.hbm2x;

import java.io.File;
import java.util.Map;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2x.pojo.POJOClass;

/**
 * @author kennylee
 *
 */
public class DAOInterfaceExporter extends POJOExporter {

    private static final String DAO_DAOHOME_FTL = "dao/inter_dao.ftl";

    private String sessionFactoryName = "SessionFactory";

    public DAOInterfaceExporter() {
    }
    
    public DAOInterfaceExporter(Configuration cfg, File outputdir) {
        super(cfg, outputdir);        
    }
    
    public DAOInterfaceExporter(Configuration cfg, File outputdir, boolean isOverride,boolean isTk) {
    	super(cfg, outputdir, isOverride, isTk);        
    }

    protected void init() {
    	super.init();
    	setTemplateName(DAO_DAOHOME_FTL);
    	//XXX modify by kennylee, add dao folder.
    	setFilePattern("{package-name}/dao/{class-name}DAO.java");    	    	
    }
    
    protected void exportComponent(Map additionalContext, POJOClass element) {
    	// noop - we dont want components
    }

	public String getSessionFactoryName() {
		return sessionFactoryName;
	}

	public void setSessionFactoryName(String sessionFactoryName) {
		this.sessionFactoryName = sessionFactoryName;
	}

	protected void setupContext() {
		getProperties().put("sessionFactoryName", getSessionFactoryName());
		super.setupContext();		
	}
	
	public String getName() {
		return "hbm2dao";
	}

	
}
