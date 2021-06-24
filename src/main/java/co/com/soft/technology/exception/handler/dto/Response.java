package co.com.soft.technology.exception.handler.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response implements Serializable {

	private static final long serialVersionUID = -5304017116611044468L;

	private Date date;
	private String message;
	private String transactionId;
	private HttpStatus responseCode;


}
