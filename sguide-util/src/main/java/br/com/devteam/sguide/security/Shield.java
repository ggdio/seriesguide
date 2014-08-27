package br.com.devteam.sguide.security;

import static br.com.devteam.sguide.util.ObjectUtil.*;
import static br.com.devteam.sguide.util.StringUtil.*;

/**
 * Class for method protecting
 * Act as a shield preventing invalid arguments
 * @author Guilherme Dio
 *
 */
public abstract class Shield {

	/**
	 * Prevent {@link NullPointerException}
	 * @param obj - The object to be checked
	 * @param e - The exception to be thrown
	 * @throws T - The type of the exception
	 */
	public static <T extends Throwable> void preventNPE(T e, Object...obj) throws T{
		if(isNull(obj))
			throw e;
	}
	
	/**
	 * Prevent {@link NullPointerException}
	 * @param obj - The object to be checked
	 * @param e - The exception to be thrown
	 * @throws T - The type of the exception
	 */
	public static <T extends Throwable> void preventBlank(T e, String...str) throws T{
		if(!hasText(str))
			throw e;
	}
	
}
