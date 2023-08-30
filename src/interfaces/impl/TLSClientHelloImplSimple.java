package interfaces.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import interfaces.ITLSClientHello;

/**
 * @author David Zakrevskyy
 * 
 *         Description: simple interface for base TLS functions.
 * 
 */
public class TLSClientHelloImplSimple implements ITLSClientHello {

    private static final Logger logger = LogManager.getLogger(TLSClientHelloImplSimple.class);

    public TLSClientHelloImplSimple() {
        if (logger.isDebugEnabled()) {
            logger.debug(String.format("Created %s", this.getClass().getName()));
        }
    }

    @Override
    public byte[] generateRecordHeader() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateRecordHeader'");
    }

    @Override
    public byte[] generateHandshakeHeader() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateHandshakeHeader'");
    }

    @Override
    public byte[] generateClientVersion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateClientVersion'");
    }

    @Override
    public byte[] generateClientRandom() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateClientRandom'");
    }

    @Override
    public byte[] generateSessionID() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateSessionID'");
    }

    @Override
    public byte[] generateCipherSuits() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateCipherSuits'");
    }

    @Override
    public byte[] generateCompressionsMethods() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateCompressionsMethods'");
    }

    @Override
    public byte[] generateExtensionLength() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateExtensionLength'");
    }

    
}
