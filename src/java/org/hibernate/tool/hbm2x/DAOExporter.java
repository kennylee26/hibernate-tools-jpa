package org.hibernate.tool.hbm2x;

import java.io.File;
import java.util.Map;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2x.pojo.POJOClass;

public class DAOExporter extends POJOExporter {

    private static final String DAO_DAOHOME_FTL = "dao/daoimpl.ftl";

    private String sessionFactoryName = "SessionFactory";

    public DAOExporter() {
    }
    
    public DAOExporter(Configuration cfg, File outputdir) {
        super(cfg, outputdir);        
    }

    public DAOExporter(Configuration cfg, File destDir,
			boolean override, boolean tk) {
        super(cfg, destDir, override, tk);        
	}

	protected void init() {
    	super.init();
    	setTemplateName(DAO_DAOHOME_FTL);
    	//XXX modify by kennylee, add dao/impl folder
    	setFilePattern("{package-name}/dao/impl/{class-name}DAOImpl.java");    	    	
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
