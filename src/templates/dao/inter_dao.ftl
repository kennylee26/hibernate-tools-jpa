package ${pojo.getPackageName()}.dao;
<#-- // Generated ${date} by Hibernate Tools ${version} -->
<#assign classbody>
<#assign lowDeclarationName = pojo.importType(pojo.getLowDeclarationName())>
<#assign declarationName = pojo.importType(pojo.getDeclarationName())>

import cn.com.timekey.commons.dao.BaseDAO;

import ${pojo.getPackageName()}.po.${declarationName};

/**
 * DAO interface object for domain model class ${declarationName}.
 * @see ${pojo.getPackageName()}.po.${declarationName}
 * @author Hibernate Tools, kennylee
 */
public interface ${declarationName}DAO extends BaseDAO<${declarationName}, String>{

	//property constants
<#foreach property in pojo.getAllPropertiesIterator()>
	public static final String ${pojo.generateConstantName(property.name)} = "${property.name}";
</#foreach>

}
</#assign>

${pojo.generateImports()}
${classbody}
