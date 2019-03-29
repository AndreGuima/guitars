/**
 * 
 */
package com.adpguima.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author andre
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class GuitarNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GuitarNotFoundException(String msg) {
		super(msg);
	}

}
