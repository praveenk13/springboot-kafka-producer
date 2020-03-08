package com.ford.ierp.cims.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
 
@AllArgsConstructor
@Builder
@Data
public class IERPMessage {
	private String uniqueId;
	private String systemName;
	private String interfaceName;
	private String author;
	private String payload;
	private String eventType;
	private String errorCode;
	private String shortDesc;
	private String description;

	@Override
	public String toString() {
		return "IERPMessage [uniqueId=" + uniqueId + ", systemName=" + systemName + ", interfaceName=" + interfaceName
				+ ", author=" + author + ", payload=" + payload + ", eventType=" + eventType + ", errorCode="
				+ errorCode + ", shortDesc=" + shortDesc + ", description=" + description + "]";
	}	
}
