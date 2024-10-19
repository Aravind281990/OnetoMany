package com.example.OneToManyMappingGlobal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="Author id doesn't exist")
public class InvalidAuthorIdException extends Exception{

		
	
}
