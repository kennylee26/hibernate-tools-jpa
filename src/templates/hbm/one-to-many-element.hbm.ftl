<one-to-many class="${c2h.getClassName(elementValue.getAssociatedClass())}"
	<#if !elementValue.getAssociatedClass().getClassName().equals(elementValue.getReferencedEntityName())> 
		entity-name="${elementValue.getReferencedEntityName()}"
	</#if>/>
