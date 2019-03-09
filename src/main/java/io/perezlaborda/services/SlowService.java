package io.perezlaborda.services;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class SlowService {

    //private static final int N = 3000000;
    //real slow = 90000000;
    private final BigInteger a = BigInteger.valueOf(Long.MAX_VALUE).multiply(BigInteger.valueOf(Long.MAX_VALUE));
    private final BigInteger b = BigInteger.valueOf(Long.MAX_VALUE).multiply(BigInteger.valueOf(Long.MAX_VALUE));

    public void loopIterator(int loopCount) {
        for(int i = 0; i < loopCount; i++){
            BigInteger c = a.multiply(b).multiply(BigInteger.valueOf(i));
        }
    }

}
