package br.com.bb.cotacaodolar.exception;

public class DocumentException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DocumentException(String message) {
		super(message);
	}

	public DocumentException(Throwable cause) {
		super(cause);
	}
}
