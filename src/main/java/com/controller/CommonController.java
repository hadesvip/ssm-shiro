package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by wangyong on 2016/7/15.
 */
@Controller
public class CommonController {


    //获取验证码
    @RequestMapping(method = RequestMethod.GET, value = "/userWebGetCode")
    @ResponseBody
    public void getCode(HttpServletRequest request,
                        HttpServletResponse response) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String code = drawImg(output);
        //ShiroUtil.setAttribute(Constant.SESSION_SECURITY_CODE, code);
        try {
            ServletOutputStream out = response.getOutputStream();
            output.writeTo(out);
        } catch (IOException e) {
            //do nothing
        }
    }

    private String drawImg(ByteArrayOutputStream output) {
        //final int verifyCodeLength = 10;
        final int verifyCodeLength = 4;
        String code = getVerifyCode(verifyCodeLength);
        //int width = 125;
        int width = 70;
        int height = 25;
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        Font font = new Font("Times New Roman", Font.PLAIN, 20);
        Graphics2D g = bi.createGraphics();
        g.setFont(font);
        g.setColor(new Color(66, 2, 82));
        g.setBackground(new Color(226, 226, 240));
        g.clearRect(0, 0, width, height);
        FontRenderContext context = g.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(code, context);
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = bounds.getY();
        double baseY = y - ascent;
        g.drawString(code, (int) x, (int) baseY);
        g.dispose();
        try {
            ImageIO.write(bi, "jpg", output);
        } catch (IOException e) {
            //do nothing
        }
        return code;
    }


    //获得验证码字符串
    private String getVerifyCode(int verifyCodeLength) {
        //final String s = "Aa-Bb0=Cc+Dd1~Ee;Ff2@GgHh3#Jj:Kk4$Ll[Mm5%Nn]Pp6^Rr{Ss7&Tt}Uu8*Vv<Ww9(Xx>Yy?Zz)";
        final String s = "ab1cd2ef3gh4jk5mn6op7qr8st9uv0wxyz";
        final int seedLength = s.length();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < verifyCodeLength; i++) {
            stringBuffer.append(s.charAt((int) (Math.random() * seedLength)));
        }
        return stringBuffer.toString();
    }
}
