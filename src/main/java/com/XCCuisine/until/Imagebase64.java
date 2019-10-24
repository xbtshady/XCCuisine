package com.XCCuisine.until;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * base64和BufferedImage互转工具类
 *
 * @author xuwang
 * Created on 2019/010/17 14:16.
 */
public class Imagebase64 {
    static BASE64Encoder encoder = new sun.misc.BASE64Encoder();
    static BASE64Decoder decoder = new sun.misc.BASE64Decoder();


    public static String getImageBinary(BufferedImage bi,String suffix) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, suffix, baos);
            byte[] bytes = baos.toByteArray();
            return encoder.encodeBuffer(bytes).trim().replaceAll("\n", "").replaceAll("\r", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static BufferedImage base64StringToImage(String base64String) {
        BufferedImage result = null;
        try {
            byte[] bytes1 = decoder.decodeBuffer(base64String);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
            result = ImageIO.read(bais);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

