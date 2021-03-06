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

import static org.junit.Assert.*;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Arrays;

import javax.crypto.NoSuchPaddingException;

import org.junit.Test;

public class KeySetTest {

	@Test
	public void testKeySet() {
		byte[] k = {119,-72,44,103,89,-33,-10,45,51,24,-107,-57,-110,63,-104,-46,-118,40,-69,-86,114,31,33,-90,4,118,83,125,-7,16,-65,111,79,-89,61,61,102,68,-101,-40,99,-15,-24,-42,-125,35,115,-89,59,-24,11,-40,-74,89,66,-31,107,-17,-40,125,99,-101,-12,116,-7,102,-115,39,-101,-67,84,-29,-120,-31,-24,-24,-84,10,-79,-74,-21,105,50,0,70,-93,16,116,46,-9,60,14,60,-101,10,-127,-126,63,-97,-24,-67,-71,-109,74,46,27,-79,80,121,48,-105,-67,-24,22,21,81,38,84,-27,-9,-38,-15,-117,10,-31,-51,-19,-52,-25,-47,0,104,-15,98,-100,120,-113,57,8,-72,79,-46,-93,53,-72,13,-49,-102,43,-111,-91,-20,41,64,-92,19,6,-32,109,-66,23,108,-107,-91,-86,-126,-5,54,0,80,-78,79,-110,27,-102,-27,-70,19,126,-72,88,112,-101,-117,-123,-21,111,-38,37,-50,-1,2,-23,-33,-87,35,110,-124,-53,-86,37,41,60,84,122,57,-3,-86,-67,-109,126,-78,-68,-77,-61,91,46,7,36,-102,-96,-80,77,-116,5,-44,-11,119,-53,-20,-123,126,68,-17,-70,76,-69,-118,57,-27,101,-51,108,-12,-97,77,25,-68,94,-93,-8,-113,-34,115,-103,-123};
		byte[] nonce = {93,62,6,-83,-126,-11,41,-55,-43,58,-118,28,-31,64,8,32,-68,-111,108,7,63,70,85,18,-20,86,51,-102,-121,55,-40,-36};
		byte[] serverEncrKey={63,-80,-86,56,79,97,78,21,16,-51,87,-124,21,48,-67,-13,-115,-29,11,-26,-60,-97,24,-58,100,49,-48,45,7,-31,-27,84};
		byte[] serverAuthKey={119,-37,-126,106,-88,-122,-114,-94,-99,-69,12,-25,51,70,-83,5,-3,-126,113,19,-88,-45,-38,83,119,-11,82,-5,-83,53,119,-123};
		byte[] clientEncrKey={11,-115,-18,-94,79,16,-77,11,30,70,-35,-110,88,100,-91,120,8,76,-104,15,-61,0,76,-41,-64,46,64,62,-33,116,58,49};
		byte[] clientAuthKey={-122,116,-47,93,-78,72,78,95,-48,-103,14,-8,112,89,122,29,-18,118,-11,25,-49,-40,113,0,-47,-110,-58,8,62,-7,-104,-7};
		KeySet ks = null;
		try {
			ks = new KeySet(k, nonce);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
			fail("invalid key");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			fail("no such algorithm");
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
			fail("no such provider");
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
			fail("no such padding");
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
			fail("bad iv");
		}
		
		if (!Arrays.equals(serverEncrKey, ks.serverEncrKey)) {
			fail("key error");
		}
		if (!Arrays.equals(serverAuthKey, ks.serverAuthKey)) {
			fail("key error");
		}
		if (!Arrays.equals(clientEncrKey, ks.clientEncrKey)) {
			fail("key error");
		}
		if (!Arrays.equals(clientAuthKey, ks.clientAuthKey)) {
			fail("key error");
		}
	}

}
