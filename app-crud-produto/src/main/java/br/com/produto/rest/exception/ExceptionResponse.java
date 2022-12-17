package br.com.produto.rest.exception;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private LocalDate date;
	private String message;
	private String detail;

	public ExceptionResponse() {
		// TODO Auto-generated constructor stub
	}

	public ExceptionResponse(LocalDate date, String message, String detail) {
		this.date = date;
		this.message = message;
		this.detail = detail;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, detail, message);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExceptionResponse other = (ExceptionResponse) obj;
		return Objects.equals(date, other.date) && Objects.equals(detail, other.detail)
				&& Objects.equals(message, other.message);
	}

}
