package co.com.soft.technology.exception.handler.handler;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import brave.Tracer;
import co.com.soft.technology.exception.handler.dto.Response;
import co.com.soft.technology.exception.handler.exception.BusinessException;

@ControllerAdvice
public class BusinessExceptionHandler {

	@Autowired
	private Tracer tracer;

	@ExceptionHandler
	public ResponseEntity<Response> handlerException(BusinessException ex) {

		Response response = new Response();

		response.setDate(new Date());
		response.setMessage(ex.getMessage());
		response.setResponseCode(HttpStatus.PRECONDITION_FAILED);
		response.setTransactionId(tracer.currentSpan().context().traceIdString());

		// Agregar error
		if ((ex.getCause() != null) && (ex.getCause().getLocalizedMessage() != null)) {
			response.setMessage(ex.getCause().getLocalizedMessage());
		}else if ((ex.getMessage() != null) && !ex.getMessage().isBlank()) {
			response.setMessage(ex.getMessage());
		}else{
			response.setMessage("Error al validar una regla de negocio");
		}

		return new ResponseEntity<>(response, HttpStatus.PRECONDITION_FAILED);

	}

}
