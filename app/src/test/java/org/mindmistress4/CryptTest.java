package org.mindmistress4;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.crypto.spec.SecretKeySpec;


import filesReadAndWrite.CryptUtil;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
//import static org.junit.Assert.assertThat;

public class CryptTest {
	@Test
	public void testEnAndDecrypt() {
		SecretKeySpec key = CryptUtil.getKey();
		if(key == null) fail("Schluessel erzeugen fehlgeschlagen");
		
		String inhalt = "10101111001101012"; 
		String verschluesselt = CryptUtil.encryptText(inhalt, key);

		assertThat(inhalt, is(not(equalTo(verschluesselt))));

		String entschluesselt = CryptUtil.decryptText(verschluesselt, key);
		
		assertThat(inhalt, is(equalTo(entschluesselt)));
	}

}
