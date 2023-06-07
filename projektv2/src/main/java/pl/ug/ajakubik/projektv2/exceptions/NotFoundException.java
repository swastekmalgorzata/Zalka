package pl.ug.ajakubik.projektv2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Object not found in database!")
public class NotFoundException extends RuntimeException{
}
