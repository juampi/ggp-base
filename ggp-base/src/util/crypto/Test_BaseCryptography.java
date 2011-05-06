package util.crypto;

import util.crypto.BaseCryptography.EncodedKeyPair;
import junit.framework.TestCase;

/**
 * Unit tests for the HttpReader/HttpWriter pair, which are the way that
 * game players and game servers communicate. Please update these tests
 * as needed when bugs are discovered, to prevent regressions. 
 * 
 * @author Sam
 */
public class Test_BaseCryptography extends TestCase {
    public void testSimpleCryptography() throws Exception {
        // Not an ideal unit test because generating the key takes a while,
        // but it's useful to have test coverage at all so we'll make due.
        EncodedKeyPair theKeys = BaseCryptography.generateKeys();
        String theSK = theKeys.thePrivateKey;
        String thePK = theKeys.thePublicKey;
        
        String theData = "Hello world!";
        String theSignature = BaseCryptography.signData(theSK, theData);        
        assertTrue(BaseCryptography.verifySignature(thePK, theSignature, theData));
    }
    
}