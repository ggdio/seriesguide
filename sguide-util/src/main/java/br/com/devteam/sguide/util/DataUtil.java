/**
 * This document is a part of the source code and related artifacts
 * for Unilims, a restricted laboratorial system.
 *
 * http://www.unicorp.com.br
 *
 * Copyright © 2014 Unicorp Informática Industrial - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package br.com.devteam.sguide.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.activation.DataHandler;

/**
 * Utility for data information
 * @author Guilherme Dio
 *
 */
public class DataUtil {

	/**
	 * 
	 * @param handler
	 * @return
	 * @throws IOException
	 */
	public static byte[] convertDataHandler(DataHandler handler) throws IOException {
	    ByteArrayOutputStream output = new ByteArrayOutputStream();
	    handler.writeTo(output);
	    return output.toByteArray();
	}
	
}
