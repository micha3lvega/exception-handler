package co.com.soft.technology.exception.handler.handler;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import brave.Tracer;
import co.com.soft.technology.exception.handler.dto.Response;
import co.com.soft.technology.exception.handler.exception.BadRequestException;

@ControllerAdvice
public class BadRequestExceptionHandler {

	@Autowired
	private Tracer tracer;

	@ExceptionHandler
	public ResponseEntity<Response> exceptionHandler(BadRequestException ex) {

		Response response = new Response();

		response.setDate(new Date());
		response.setMessage(ex.getMessage());
		response.setResponseCode(HttpStatus.BAD_REQUEST);
		response.setTransactionId(tracer.currentSpan().context().traceIdString());

		// Agregar error
		if ((ex.getCause() != null) && (ex.getCause().getLocalizedMessage() != null)) {
			response.setMessage(ex.getCause().getLocalizedMessage());
		}else {
			response.setMessage(ex.getMessage());
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

	}
}
