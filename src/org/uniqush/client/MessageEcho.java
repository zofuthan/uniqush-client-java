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

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;

class MessageEcho implements MessageHandler {
	private MessageCenter center;
	
	public MessageEcho(MessageCenter center) {
		this.center = center;
	}

	private void printMessage(Message msg) {
		Map<String, String> header = msg.getHeader();
		Iterator<Entry<String,String>> iter = header.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, String> entry = iter.next();
			System.out.printf("[%s=%s]", entry.getKey(), entry.getValue());
		}
	}

	@Override
	public void onMessageFromServer(String id, Message msg) {
		System.out.printf("Message Received from server with id %s: ", id);
		printMessage(msg);
		System.out.println();
		try {
			this.center.sendMessageToServer(msg);
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ShortBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onMessageFromUser(String service, String username, String id,
			Message msg) {
		System.out.printf("Message Received from %s:%s with id %s:", service, username, id);
		printMessage(msg);
		System.out.println();
	}

	@Override
	public void onMessageDigestFromServer(int size, String id,
			Map<String, String> parameters) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMessageDigestFromUser(String service, String username,
			int size, String id, Map<String, String> parameters) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCloseStart() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClosed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onError(Exception e) {
		e.printStackTrace();
	}

}
