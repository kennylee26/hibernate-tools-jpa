package org.hibernate.tool.hbm2x.pojo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.mapping.Property;

/**
 * Wrapper class over PersistentClass used in hbm2java and hbm2doc tool
 * @author max
 * @author <a href="mailto:abhayani@jboss.org">Amit Bhayani</a>
 *
 */
public interface POJOClass extends ImportContext {

	/** 
	 * Returns "package packagename;" where packagename is either the declared packagename,
	 * or the one provide via meta attribute "generated-class".
	 * 
	 * Returns "// default package" if no package declarition available.
	 *  
	 * @param cm
	 * @param tool TODO
	 * @return
	 */
	public String getPackageDeclaration();
	
	public String getClassModifiers();

	public String getQualifiedDeclarationName();
	
	/**
	 * Returns the javadoc associated with the class.
	 * 
	 * @param fallback the default text if nothing else is found
	 * @param indent how many spaces should be added
	 * @return
	 */
	public String getClassJavaDoc(String fallback, int indent);
	
	/**
	 * 
	 * @return declaration type "interface" or "class"
	 */
	public String getDeclarationType();
	
	/**
	 * @return unqualified classname for this class (can be changed by meta attribute "generated-class")
	 */
	public String getDeclarationName();
	
	public String getImplementsDeclaration();
	public String getImplements();
	
	public String getExtendsDeclaration();
	public String getExtends();
	
	public String generateEquals(String thisName, String otherName, boolean useGenerics);
	
	public boolean isComponent();
	
	public String getExtraClassCode();
		
	public boolean needsEqualsHashCode();
	
	public boolean hasIdentifierProperty();
	
	public String generateAnnColumnAnnotation(Property property);
	public String generateAnnIdGenerator();
	public String generateAnnTableUniqueConstraint();
	public String generateBasicAnnotation(Property property);
	public Iterator getAllPropertiesIterator();

	public String getPackageName();
	public String getShortName();

	public Iterator getToStringPropertiesIterator();
	public Iterator getEqualsHashCodePropertiesIterator();
	
	public boolean needsToString();
	
	public String getFieldJavaDoc(Property property, int indent);
	
	/**
	 * <p>扩展原有的 getFieldJavaDoc(Property property, int indent);方法，支持不添加*号前缀</p>
	 * @author kennylee
	 * 
	 * @param property 属性
	 * @param indent 分割数
	 * @param isNeedPrefix 是否自动添加*号前缀。
	 * @return
	 */
	public String getFieldJavaDoc(Property property, int indent,boolean isNeedPrefix);
	/**
	 * <p>检查在扩展代码中是否定义了SerialVersionUID</p>
	 * @author kennylee
	 * @return
	 */
	public boolean hasSerialVersionUID();
	
	/**
	 * 生成首字母小写的名字
	 * @author kennylee
	 * @return
	 */
	public String getLowDeclarationName();
	
	/**
	 * <p>获取去掉Tk头字母的类名</p>
	 * @author kennylee
	 * @return
	 */
	public String getFriendlyClassName();
	
	/**
	 * 生成基本的包名
	 * @author kennylee
	 * @return
	 */
	//public String getBaseDeclarationName();
	
	public String getFieldDescription(Property property);

	public Object getDecoratedObject();

	public boolean isInterface();
	
	public boolean isSubclass();

	public List getPropertiesForFullConstructor();
	public List getPropertyClosureForFullConstructor();
	public List getPropertyClosureForSuperclassFullConstructor();
	
	public boolean needsMinimalConstructor();
	public boolean needsFullConstructor();
	public List getPropertiesForMinimalConstructor();
	public List getPropertyClosureForMinimalConstructor();
	public List getPropertyClosureForSuperclassMinimalConstructor();
	
	public POJOClass getSuperClass();
	
	public String getJavaTypeName(Property p, boolean useGenerics);
	public String getFieldInitialization(Property p, boolean useGenerics);
	
	public Property getIdentifierProperty();
	
	public boolean hasVersionProperty();
	public Property getVersionProperty();
		
}
