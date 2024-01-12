package com.sarikaya.CooPomodoro;

import com.sarikaya.CooPomodoro.core.WebConfig;
import com.sarikaya.CooPomodoro.core.utils.exceptions.BusinessException;
import com.sarikaya.CooPomodoro.core.utils.exceptions.ProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@SpringBootApplication
@RestControllerAdvice
@Import(WebConfig.class)
public class CooPomodoroApplication {

	public static void main(String[] args) {
		SpringApplication.run(CooPomodoroApplication.class, args);
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		return problemDetails;
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(methodArgumentNotValidException.getMessage());
		return problemDetails;
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
