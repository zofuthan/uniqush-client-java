/*
 * Copyright 2013 Nan Deng
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.uniqush.client;

import java.security.interfaces.RSAPublicKey;

/**
 * The implementation should provide credential information like
 * the public key of the server, the token for some user.
 * 
 * Since uniqush client library will not try to store credential
 * information, app developers should find their own why to implement
 * this interface securely.
 * 
 * @author monnand
 */
public interface CredentialProvider {
	/**
	 * @param service
	 * @param username
	 * @return The token for the given user.
	 */
	String getToken(String service, String username);
	
	/**
	 * @param host
	 * @param port
	 * @return The RSA public key for the server.
	 */
	RSAPublicKey getPublicKey(String host, int port);
}
