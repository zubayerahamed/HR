package com.kit.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zubayer Ahamed
 * @since Aug 24, 2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

	public boolean status;
	public String message;
}
