package org.hibernate.tool.ant;

import org.hibernate.tool.hbm2x.DAOExporter;
import org.hibernate.tool.hbm2x.Exporter;

/**
 * @author Dennis Byrne
 */
public class Hbm2DAOExporterTask extends Hbm2JavaExporterTask {

	public Hbm2DAOExporterTask(HibernateToolTask parent) {
		super(parent);
	}
	
	protected Exporter configureExporter(Exporter exp) {
		DAOExporter exporter = (DAOExporter)exp;
		super.configureExporter(exp);
		return exporter;
	}
	
	protected Exporter createExporter() {
		//XXX modify by kennylee, support override and tk confing
		return new DAOExporter(parent.getConfiguration(), parent.getDestDir(), parent.isOverride(), parent.isTk()) ;
	}

	public String getName() {
		return "hbm2dao (Generates a set of DAOImpls)";
	}

}
