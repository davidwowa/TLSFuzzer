package tech.cybersword.tls.fuzzer.interfaces;

import java.io.Serializable;

/**
 * @author David Zakrevskyy
 * 
 * Description: simple interface for base TLS functions.
 * 
 */
public interface ITLSClientHello extends Serializable {
    byte[] generateRecordHeader();
    byte[] generateHandshakeHeader();
    byte[] generateClientVersion();
    byte[] generateClientRandom();
    byte[] generateSessionID();
    byte[] generateCipherSuits();
    byte[] generateCompressionsMethods();
}