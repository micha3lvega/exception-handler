package co.com.soft.technology.exception.handler.handler;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import brave.Tracer;
import co.com.soft.technology.exception.handler.dto.Response;

@ControllerAdvice
public class GlobalExceptionHandler {

	@Autowired
	private Tracer tracer;

	@ExceptionHandler
	public ResponseEntity<Response> handlerException(MissingRequestHeaderException ex) {

		Response error = new Response();

		error.setDate(new Date());
		error.setMessage(String.format("Header requerido no especificado, por favor verificar: %s", ex.getMessage()));
		error.setResponseCode(HttpStatus.BAD_REQUEST);
		error.setTransactionId(tracer.currentSpan().context().traceIdString());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler
	public ResponseEntity<Response> handlerException(MissingServletRequestParameterException ex) {

		Response error = new Response();

		error.setDate(new Date());
		error.setMessage(
				String.format("Parámetro requerido no especificado, por favor verificar: %s", ex.getMessage()));
		error.setResponseCode(HttpStatus.BAD_REQUEST);
		error.setTransactionId(tracer.currentSpan().context().traceIdString());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler
	public ResponseEntity<Response> handlerException(MethodArgumentNotValidException ex) {

		Response error = new Response();

		error.setDate(new Date());
		error.setMessage(String.format("Cuerpo de la petición con formato incorrecto, por favor verificar: %s",
				ex.getMessage()));
		error.setResponseCode(HttpStatus.BAD_REQUEST);
		error.setTransactionId(tracer.currentSpan().context().traceIdString());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler
	public ResponseEntity<Response> handlerException(MethodArgumentTypeMismatchException ex) {

		Response error = new Response();

		error.setDate(new Date());
		error.setMessage(String.format("Parámetro con formato incorrecto, por favor verificar: %s", ex.getMessage()));
		error.setResponseCode(HttpStatus.BAD_REQUEST);
		error.setTransactionId(tracer.currentSpan().context().traceIdString());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

	}

	@ExceptionHandler
	public ResponseEntity<Response> handlerException(HttpMessageNotReadableException ex) {

		Response error = new Response();

		error.setDate(new Date());
		error.setMessage(String.format("Cuerpo de la petición con formato incorrecto, por favor verificar: %s",
				ex.getMessage()));
		error.setResponseCode(HttpStatus.BAD_REQUEST);
		error.setTransactionId(tracer.currentSpan().context().traceIdString());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

	}

	@ExceptionHandler
	public ResponseEntity<Response> exceptionHandler(Exception ex) {

		Response error = new Response();

		if (ex != null) {
			if ((ex.getCause() != null) && (ex.getCause().getMessage() != null)) {
				error.setMessage(ex.getCause().getMessage());
			} else {
				error.setMessage(ex.getMessage());
			}
		}

		error.setDate(new Date());
		error.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR);
		error.setTransactionId(tracer.currentSpan().context().traceIdString());

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);

	}

}
