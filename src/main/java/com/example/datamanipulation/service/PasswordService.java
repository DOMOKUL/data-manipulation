package com.example.datamanipulation.service;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface PasswordService {

     String encode(String enc) throws NoSuchPaddingException, NoSuchAlgorithmException, Exception;
     String decode(String dec) throws InvalidKeySpecException, Exception;



}

