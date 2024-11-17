package com.example.utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@PrepareForTest({})
@PowerMockIgnore("javax.management.*")
@RunWith(PowerMockRunner.class)
public class AESUtilTest {
    @Mock
    KeyGenerator keyGenerator;
    @Mock
    SecureRandom secureRandom;
    @Mock
    Cipher cipher;
    @InjectMocks
    AESUtil aESUtil;

    /**
     * iFlyCodeTestGenerate#63f5a73bc9f841df8376e6598e51d1d8
     * 以下代码由iFlyCode生成
     * 测试加密方法在正常情况下的执行，输入正常的字符串内容，期望返回正确的加密后的16进制字符串。
     * 输入：无
     * 输出：	48656C6C6F20576F726C64
     */
    @Test
    public void testEncryptHappyPath() throws Exception {
        /**
         * hex.length() == 1 : false
         */
        when(keyGenerator.generateKey()).thenReturn(new SecretKeySpec(new byte[]{(byte) 0}, 0, 0, "algorithm"));
        when(keyGenerator.getInstance(anyString())).thenReturn(KeyGenerator.getInstance("algorithm"));
        doNothing().when(keyGenerator).init(anyInt(), any(SecureRandom.class));
        doNothing().when(secureRandom).setSeed(any(byte[].class));
        when(secureRandom.getInstance(anyString())).thenReturn(new SecureRandom());
        doNothing().when(cipher).init(anyInt(), any(Key.class));
        when(cipher.getInstance(anyString())).thenReturn(Cipher.getInstance("transformation"));
        when(cipher.doFinal(any(byte[].class))).thenReturn(new byte[]{(byte) 0});
        /* 调用被测方法 */
        String result = aESUtil.encrypt();
        verify(keyGenerator).init(anyInt(), any(SecureRandom.class));
        verify(secureRandom).setSeed(any(byte[].class));
        verify(cipher).init(anyInt(), any(Key.class));
        Assert.assertEquals("测试加密方法在正常情况下的执行，输入正常的字符串内容，期望返回正确的加密后的16进制字符串。", "48656C6C6F20576F726C64", result);
    }//*************iFlyCodeTestGenerate#63f5a73bc9f841df8376e6598e51d1d8*************//

    /**
     * iFlyCodeTestGenerate#1138c627f3d4476f8cf1bce39aee0cae
     * 以下代码由iFlyCode生成
     * 测试加密方法在输入为空字符串的情况下的执行，期望返回空字符串的加密结果。
     * 输入：无
     * 输出：无
     */
    @Test
    public void testEncryptEmptyContent() throws Exception {
        /**
         * hex.length() == 1 : false
         */
        when(keyGenerator.generateKey()).thenReturn(new SecretKeySpec(new byte[]{(byte) 0}, 0, 0, "algorithm"));
        when(keyGenerator.getInstance(anyString())).thenReturn(KeyGenerator.getInstance("algorithm"));
        doNothing().when(keyGenerator).init(anyInt(), any(SecureRandom.class));
        doNothing().when(secureRandom).setSeed(any(byte[].class));
        when(secureRandom.getInstance(anyString())).thenReturn(new SecureRandom());
        doNothing().when(cipher).init(anyInt(), any(Key.class));
        when(cipher.getInstance(anyString())).thenReturn(Cipher.getInstance("transformation"));
        when(cipher.doFinal(any(byte[].class))).thenReturn(new byte[]{(byte) 0});
        /* 调用被测方法 */
        String result = aESUtil.encrypt();
        verify(keyGenerator).init(anyInt(), any(SecureRandom.class));
        verify(secureRandom).setSeed(any(byte[].class));
        verify(cipher).init(anyInt(), any(Key.class));
        Assert.assertEquals("测试加密方法在输入为空字符串的情况下的执行，期望返回空字符串的加密结果。", null, result);
    }//*************iFlyCodeTestGenerate#1138c627f3d4476f8cf1bce39aee0cae*************//

    /**
     * iFlyCodeTestGenerate#5dbec397cb5d480392f0361b1b24922a
     * 以下代码由iFlyCode生成
     * 测试加密方法在输入包含特殊字符的情况下的执行，期望返回正确处理特殊字符的加密结果。
     * 输入：无
     * 输出：	2648656C6C6F2026576F726C64
     */
    @Test
    public void testEncryptWithSpecialCharacters() throws Exception {
        /**
         * hex.length() == 1 : false
         */
        when(keyGenerator.generateKey()).thenReturn(new SecretKeySpec(new byte[]{(byte) 0}, 0, 0, "algorithm"));
        when(keyGenerator.getInstance(anyString())).thenReturn(KeyGenerator.getInstance("algorithm"));
        doNothing().when(keyGenerator).init(anyInt(), any(SecureRandom.class));
        doNothing().when(secureRandom).setSeed(any(byte[].class));
        when(secureRandom.getInstance(anyString())).thenReturn(new SecureRandom());
        doNothing().when(cipher).init(anyInt(), any(Key.class));
        when(cipher.getInstance(anyString())).thenReturn(Cipher.getInstance("transformation"));
        when(cipher.doFinal(any(byte[].class))).thenReturn(new byte[]{(byte) 0});
        /* 调用被测方法 */
        String result = aESUtil.encrypt();
        verify(keyGenerator).init(anyInt(), any(SecureRandom.class));
        verify(secureRandom).setSeed(any(byte[].class));
        verify(cipher).init(anyInt(), any(Key.class));
        Assert.assertEquals("测试加密方法在输入包含特殊字符的情况下的执行，期望返回正确处理特殊字符的加密结果。", "2648656C6C6F2026576F726C64", result);
    }//*************iFlyCodeTestGenerate#5dbec397cb5d480392f0361b1b24922a*************//

    /**
     * iFlyCodeTestGenerate#86d35d0ea00c4567a6ede17220b9dda5
     * 以下代码由iFlyCode生成
     * 测试加密方法在输入为null的情况下的执行，期望抛出NullPointerException异常。
     * 输入：无
     * 输出：无
     */
    @Test
    public void testEncryptWithNullContent() throws Exception {
        /**
         * hex.length() == 1 : false
         */
        when(keyGenerator.generateKey()).thenReturn(new SecretKeySpec(new byte[]{(byte) 0}, 0, 0, "algorithm"));
        when(keyGenerator.getInstance(anyString())).thenReturn(KeyGenerator.getInstance("algorithm"));
        doNothing().when(keyGenerator).init(anyInt(), any(SecureRandom.class));
        doNothing().when(secureRandom).setSeed(any(byte[].class));
        when(secureRandom.getInstance(anyString())).thenReturn(new SecureRandom());
        doNothing().when(cipher).init(anyInt(), any(Key.class));
        when(cipher.getInstance(anyString())).thenReturn(Cipher.getInstance("transformation"));
        when(cipher.doFinal(any(byte[].class))).thenReturn(new byte[]{(byte) 0});
        /* 调用被测方法 */
        String result = aESUtil.encrypt();
        verify(keyGenerator).init(anyInt(), any(SecureRandom.class));
        verify(secureRandom).setSeed(any(byte[].class));
        verify(cipher).init(anyInt(), any(Key.class));
        Assert.assertEquals("测试加密方法在输入为null的情况下的执行，期望抛出NullPointerException异常。", null, result);
    }//*************iFlyCodeTestGenerate#86d35d0ea00c4567a6ede17220b9dda5*************//

    /**
     * iFlyCodeTestGenerate#63f5a73bc9f841df8376e6598e51d1d8
     * 以下代码由iFlyCode生成
     * 测试加密方法在正常情况下的执行，输入正常的字符串内容，期望返回正确的加密后的16进制字符串。
     * 输入：无
     * 输出：	48656C6C6F20576F726C64
     */
    @Test
    public void testEncryptHappyPath1() throws Exception {
        /**
         * hex.length() == 1 : false
         */
        when(keyGenerator.generateKey()).thenReturn(new SecretKeySpec(new byte[]{(byte) 0}, 0, 0, "algorithm"));
        when(keyGenerator.getInstance(anyString())).thenReturn(KeyGenerator.getInstance("algorithm"));
        doNothing().when(keyGenerator).init(anyInt(), any(SecureRandom.class));
        doNothing().when(secureRandom).setSeed(any(byte[].class));
        when(secureRandom.getInstance(anyString())).thenReturn(new SecureRandom());
        doNothing().when(cipher).init(anyInt(), any(Key.class));
        when(cipher.getInstance(anyString())).thenReturn(Cipher.getInstance("transformation"));
        when(cipher.doFinal(any(byte[].class))).thenReturn(new byte[]{(byte) 0});
        /* 调用被测方法 */
        String result = aESUtil.encrypt();
        verify(keyGenerator).init(anyInt(), any(SecureRandom.class));
        verify(secureRandom).setSeed(any(byte[].class));
        verify(cipher).init(anyInt(), any(Key.class));
        Assert.assertEquals("测试加密方法在正常情况下的执行，输入正常的字符串内容，期望返回正确的加密后的16进制字符串。", "48656C6C6F20576F726C64", result);
    }//*************iFlyCodeTestGenerate#63f5a73bc9f841df8376e6598e51d1d8*************//

    /**
     * iFlyCodeTestGenerate#1138c627f3d4476f8cf1bce39aee0cae
     * 以下代码由iFlyCode生成
     * 测试加密方法在输入为空字符串的情况下的执行，期望返回空字符串的加密结果。
     * 输入：无
     * 输出：无
     */
    @Test
    public void testEncryptEmptyContent1() throws Exception {
        /**
         * hex.length() == 1 : false
         */
        when(keyGenerator.generateKey()).thenReturn(new SecretKeySpec(new byte[]{(byte) 0}, 0, 0, "algorithm"));
        when(keyGenerator.getInstance(anyString())).thenReturn(KeyGenerator.getInstance("algorithm"));
        doNothing().when(keyGenerator).init(anyInt(), any(SecureRandom.class));
        doNothing().when(secureRandom).setSeed(any(byte[].class));
        when(secureRandom.getInstance(anyString())).thenReturn(new SecureRandom());
        doNothing().when(cipher).init(anyInt(), any(Key.class));
        when(cipher.getInstance(anyString())).thenReturn(Cipher.getInstance("transformation"));
        when(cipher.doFinal(any(byte[].class))).thenReturn(new byte[]{(byte) 0});
        /* 调用被测方法 */
        String result = aESUtil.encrypt();
        verify(keyGenerator).init(anyInt(), any(SecureRandom.class));
        verify(secureRandom).setSeed(any(byte[].class));
        verify(cipher).init(anyInt(), any(Key.class));
        Assert.assertEquals("测试加密方法在输入为空字符串的情况下的执行，期望返回空字符串的加密结果。", null, result);
    }//*************iFlyCodeTestGenerate#1138c627f3d4476f8cf1bce39aee0cae*************//

    /**
     * iFlyCodeTestGenerate#5dbec397cb5d480392f0361b1b24922a
     * 以下代码由iFlyCode生成
     * 测试加密方法在输入包含特殊字符的情况下的执行，期望返回正确处理特殊字符的加密结果。
     * 输入：无
     * 输出：	2648656C6C6F2026576F726C64
     */
    @Test
    public void testEncryptWithSpecialCharacters1() throws Exception {
        /**
         * hex.length() == 1 : false
         */
        when(keyGenerator.generateKey()).thenReturn(new SecretKeySpec(new byte[]{(byte) 0}, 0, 0, "algorithm"));
        when(keyGenerator.getInstance(anyString())).thenReturn(KeyGenerator.getInstance("algorithm"));
        doNothing().when(keyGenerator).init(anyInt(), any(SecureRandom.class));
        doNothing().when(secureRandom).setSeed(any(byte[].class));
        when(secureRandom.getInstance(anyString())).thenReturn(new SecureRandom());
        doNothing().when(cipher).init(anyInt(), any(Key.class));
        when(cipher.getInstance(anyString())).thenReturn(Cipher.getInstance("transformation"));
        when(cipher.doFinal(any(byte[].class))).thenReturn(new byte[]{(byte) 0});
        /* 调用被测方法 */
        String result = aESUtil.encrypt();
        verify(keyGenerator).init(anyInt(), any(SecureRandom.class));
        verify(secureRandom).setSeed(any(byte[].class));
        verify(cipher).init(anyInt(), any(Key.class));
        Assert.assertEquals("测试加密方法在输入包含特殊字符的情况下的执行，期望返回正确处理特殊字符的加密结果。", "2648656C6C6F2026576F726C64", result);
    }//*************iFlyCodeTestGenerate#5dbec397cb5d480392f0361b1b24922a*************//

    /**
     * iFlyCodeTestGenerate#86d35d0ea00c4567a6ede17220b9dda5
     * 以下代码由iFlyCode生成
     * 测试加密方法在输入为null的情况下的执行，期望抛出NullPointerException异常。
     * 输入：无
     * 输出：无
     */
    @Test
    public void testEncryptWithNullContent1() throws Exception {
        /**
         * hex.length() == 1 : false
         */
        when(keyGenerator.generateKey()).thenReturn(new SecretKeySpec(new byte[]{(byte) 0}, 0, 0, "algorithm"));
        when(keyGenerator.getInstance(anyString())).thenReturn(KeyGenerator.getInstance("algorithm"));
        doNothing().when(keyGenerator).init(anyInt(), any(SecureRandom.class));
        doNothing().when(secureRandom).setSeed(any(byte[].class));
        when(secureRandom.getInstance(anyString())).thenReturn(new SecureRandom());
        doNothing().when(cipher).init(anyInt(), any(Key.class));
        when(cipher.getInstance(anyString())).thenReturn(Cipher.getInstance("transformation"));
        when(cipher.doFinal(any(byte[].class))).thenReturn(new byte[]{(byte) 0});
        /* 调用被测方法 */
        String result = aESUtil.encrypt();
        verify(keyGenerator).init(anyInt(), any(SecureRandom.class));
        verify(secureRandom).setSeed(any(byte[].class));
        verify(cipher).init(anyInt(), any(Key.class));
        Assert.assertEquals("测试加密方法在输入为null的情况下的执行，期望抛出NullPointerException异常。", null, result);
    }//*************iFlyCodeTestGenerate#86d35d0ea00c4567a6ede17220b9dda5*************//
}