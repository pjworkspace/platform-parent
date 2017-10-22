package com.framework.rabbitmq.util;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class KryoUtil {
    private static Logger logger = LoggerFactory.getLogger(KryoUtil.class);

    public final static Kryo kryo = new Kryo();

    static {
        kryo.setRegistrationRequired(false);
        kryo.setMaxDepth(20);
    }

    public synchronized static byte[] serailToByte(Object obj) {
        ByteArrayOutputStream out = null;
        Output output = null;
        try {
            out = new ByteArrayOutputStream();
            output = new Output(out);
            kryo.writeClassAndObject(output, obj);
            output.flush();
            return out.toByteArray();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (null != output) {
                output.close();
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
        return null;
    }

    public synchronized static Object deserialToObj(byte[] bytes) {
        Input input = null;
        ByteArrayInputStream bais = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            input = new Input(bais);
            return kryo.readClassAndObject(input);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (null != input) {
                input.close();
            }
            if (null != bais) {
                try {
                    bais.close();
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String string = "abc1231";
        byte[] bytes = serailToByte(string);
        System.out.println(deserialToObj(bytes));
    }
}
