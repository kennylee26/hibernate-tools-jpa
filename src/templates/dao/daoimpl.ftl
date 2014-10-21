package ${pojo.getPackageName()}.dao.impl;
<#-- // Generated ${date} by Hibernate Tools ${version}-->
import cn.com.timekey.commons.dao.AbstractBaseDAO;
import org.springframework.stereotype.Repository;
<#assign classbody>
<#assign lowDeclarationName = pojo.importType(pojo.getLowDeclarationName())>
<#assign declarationName = pojo.importType(pojo.getDeclarationName())>

import ${pojo.getPackageName()}.po.${declarationName};
import ${pojo.getPackageName()}.dao.${declarationName}DAO;
/**
 * DAO object for domain model class ${declarationName}.
 * @see ${pojo.getPackageName()}.po.${declarationName}
 * @author Hibernate Tools, kennylee
 */
<#if ejb3>
@${pojo.importType("javax.ejb.Stateless")}
</#if>
@Repository("${lowDeclarationName}DAO")
public class ${declarationName}DAOImpl extends AbstractBaseDAO<${declarationName}, String> implements ${declarationName}DAO{

	/**
	 * @param ctx org.springframework.context.ApplicationContext
	 * @return
	 */
	public static ${declarationName}DAO getFromApplicationContext(
			${pojo.importType("org.springframework.context.ApplicationContext")} ctx) {
		return (${declarationName}DAO) ctx.getBean("${lowDeclarationName}DAO");
	}

<#if ejb3>
    @${pojo.importType("javax.persistence.PersistenceContext")} private ${pojo.importType("javax.persistence.EntityManager")} entityManager;

    public void persist(${declarationName} transientInstance) {
        log.debug("persisting ${declarationName} instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void remove(${declarationName} persistentInstance) {
        log.debug("removing ${declarationName} instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }

    public ${declarationName} merge(${declarationName} detachedInstance) {
        log.debug("merging ${declarationName} instance");
        try {
            ${declarationName} result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

<#if clazz.identifierProperty?has_content>
    public ${declarationName} findById( ${pojo.getJavaTypeName(clazz.identifierProperty, jdk5)} id) {
        log.debug("getting ${declarationName} instance with id: " + id);
        try {
            ${declarationName} instance = entityManager.find(${pojo.getDeclarationName()}.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
</#if>
<#else>



</#if>
}
</#assign>

${pojo.generateImports()}
${classbody}
