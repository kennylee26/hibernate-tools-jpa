<#-- kennylee fixed meta value 2013-06-15 -->
<#if metaattributable.getMetaAttributes()?exists>
<#list metaattributable.getMetaAttributes().keySet() as key>
 <#list metaattributable.getMetaAttributes().get(key).values as value>
  <meta attribute="${key}" inherit="false"><![CDATA[${value}]]></meta>
 </#list>
</#list>
</#if>