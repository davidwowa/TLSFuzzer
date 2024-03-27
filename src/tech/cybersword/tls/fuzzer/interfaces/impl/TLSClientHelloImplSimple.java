package tech.cybersword.tls.fuzzer.interfaces.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import tech.cybersword.tls.fuzzer.generator.TLS13TestValidDataGenerator;
import tech.cybersword.tls.fuzzer.interfaces.ITLSClientHello;
import tech.cybersword.tls.fuzzer.util.ArrayUtils;
import tech.cybersword.tls.fuzzer.util.LoggerUtil;

/**
 * @author David Zakrevskyy
 * 
 *         Description: simple interface for base TLS functions.
 * 
 */
public class TLSClientHelloImplSimple implements ITLSClientHello {

    private static final Logger logger = LoggerUtil.getLogger(TLSClientHelloImplSimple.class.getName());
    private TLS13TestValidDataGenerator generator;

    public TLSClientHelloImplSimple() {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("Created %s", this.getClass().getName()));
        }
        generator = TLS13TestValidDataGenerator.getInstance();
    }

    @Override
    public byte[] generateRecordHeader() {
        return generator.createTLSRecordHeader0();
    }

    @Override
    public byte[] generateHandshakeHeader() {
        return generator.createTestHandshakeHeader1();
    }

    @Override
    public byte[] generateClientVersion() {
        return generator.createTestClientVersion2();
    }

    @Override
    public byte[] generateClientRandom() {
        return generator.createTestClientRandom3();
    }

    @Override
    public byte[] generateSessionID() {
        return generator.createTestSessionID4();
    }

    @Override
    public byte[] generateCipherSuits() {
        return generator.createTestCipherSuites5();
    }

    @Override
    public byte[] generateCompressionsMethods() {
        return generator.createTestCompressionMethods6();
    }

    public static void main(String[] args) {
        TLSClientHelloImplSimple tls = new TLSClientHelloImplSimple();

        ArrayUtils bytesConverter = new ArrayUtils();

        String test = "badabum";

        String result = bytesConverter.bytesToHexadecimal(test.getBytes());

        System.out.println(result);
        // 16 03 01 00 f8
    }
}
