package com.example.demo.enums;

public enum RoleTypeEnum {
	
	SUPERADMIN("SuperAdmin"),
	COMPLIANCE_MANAGER("Compliance Manager"), 
	EXEC("exec"), 
	INTERNAL_AUDITORS("Internal Auditors");
	
	private String value;
	
	RoleTypeEnum(String value) {
		this.value=value;
	}
	
	public String getValue() {
		return value;
	}
	
}
