package org.hibernate.tool.ant;

import org.hibernate.tool.hbm2x.DAOInterfaceExporter;
import org.hibernate.tool.hbm2x.Exporter;

/**
 * @author kennylee
 * @see Hbm2DAOExporterTask
 */
public class Hbm2DAOInterfaceExporterTask extends Hbm2JavaExporterTask {

	public Hbm2DAOInterfaceExporterTask(HibernateToolTask parent) {
		super(parent);
	}
	
	protected Exporter configureExporter(Exporter exp) {
		DAOInterfaceExporter exporter = (DAOInterfaceExporter)exp;
		super.configureExporter(exp);
		return exporter;
	}
	
	protected Exporter createExporter() {
		//XXX modify by kennylee, support override and tk confing
		return new DAOInterfaceExporter(parent.getConfiguration(), parent.getDestDir(), parent.isOverride(), parent.isTk()) ;
	}

	public String getName() {
		return "hbm2dao (Generates a set of DAOs)";
	}

}
