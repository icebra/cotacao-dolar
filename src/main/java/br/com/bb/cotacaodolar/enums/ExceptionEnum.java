package br.com.bb.cotacaodolar.enums;

public enum ExceptionEnum {
	// 1 a 100 excecoes padrao da api
	EXCEPTION							(  2, "error.server"			),
	ACCESS_DENIED_EXCEPTION 			(  3, "error.accessdenied"		),
	UNAUTHORIZED_EXCEPTION				(  4, "error.unauthorized"		),
	ITEM_NOT_FOUND_EXCEPTION			(  5, "error.notfound"			),
	API_EXCEPTION						(  7, "error.api"				),
	DUPLICATED_EXCEPTION				(  8, "error.duplicated"		),
	MANDATORY_FIELD_EXCEPTION			(  9, "error.mandatoryfield"	),
	ERRO_VALIDATION						( 10, "error.validation"		),
	
	// exceções especificas da api
	;
	
	private final Integer code;
	private final String messageKey;
	
	private ExceptionEnum(final Integer code, final String messageKey) {
		this.code = code;
		this.messageKey = messageKey;
	}
	public Integer getCode() {
		return code;
	}
	public String getMessageKey() {
		return messageKey;
	}
}
