package com.wiseweb.ntc.comment.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import org.hibernate.id.IntegralDataTypeHolder;

/**
 * 生成图片验证码工具类
 * @author ntc
 *
 */
public class ValidateCodeUtil {
	/*生成仅为数字的验证码*/
	public static final Integer TYPE_NUM_ONLY = 0;
	/*生成仅为字母的验证码*/
	public static final Integer TYPE_LETTER_ONLY = 1;
	/*生成数字、字母组合的验证码*/
	public static final Integer TYPE_ALL_MAXED = 2;
	
	/**
	 * 生成验证码字符
	 * @param type
	 * @param length
	 * @param exCharts
	 * @return
	 */
	public static String generateTextCode(Integer type,Integer length,String exCharts) {
		if(length == null || length.intValue() < 1) return "6666";
		StringBuilder code = new StringBuilder("");
		Random random = new Random();//创建一个随机数
		switch (type) {
		case 0:
			while(length-- > 0) {
				int num = random.nextInt(10);
				code.append(num);
			}
			break;
		case 1:
			while(length-- > 0) {
				int num = random.nextInt(123);
				char c = (char) num;
				if(((num >= 65 && num <= 90) || num >= 97) && (exCharts == null || exCharts.indexOf(c) == -1)) {
					code.append(c);
				}
			}
			break;
		default:
			while(length-- > 0) {
				int num = random.nextInt(123);
				char c = (char) num;
				if(((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || num >= 97) 
						&& (exCharts == null || exCharts.indexOf(c) == -1)) {
					code.append(c);
				}
			}
			break;
		}
		return code.toString();
	}
	
	/**
	 * 根据验证码字符生成图片
	 * @param code
	 * @param width
	 * @param height
	 * @param line
	 * @param heightRandom
	 * @param backgroundColor
	 * @param fontColor
	 * @param lineColor
	 * @return
	 */
	public static BufferedImage generateImageCode(String code,int width,int height,int line,
			Boolean heightRandom,Color backgroundColor,Color fontColor,Color lineColor) {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//获取画笔
		Graphics graphics = image.getGraphics();
		//1.画背景图
		graphics.setColor(backgroundColor == null ? getRandomColor() : backgroundColor);//设置画笔颜色
		graphics.fillRect(0, 0, width, height);
		//2.画干扰线
		Random random = new Random();
		if(line > 0) {
			int x1=0,x2=width,y1=0,y2=0;
			while(line-- > 0) {
				graphics.setColor(lineColor == null ? getRandomColor() : lineColor);
				y1 = random.nextInt(height);//干扰线起始高度0到图片高度之间
				y2 = random.nextInt(height);//干扰线结束高度0到图片高度之间
				graphics.drawLine(x1, y1, x2, y2);
			}
		}
		//3.写入验证码字符
		int fontSize = (int) (height*0.8);//字体高度为整体高度的80%
		int fx = height-fontSize;//字体距x轴方向距离,初始值
		int fy = fontSize;//字体距y轴方向距离,初始值
		graphics.setFont(new Font("Default", Font.PLAIN, fontSize));
		for(int i=0;i<code.length();i++) {
			fy = (int) (heightRandom ? (Math.random()*0.3+0.6)*height : fy);//写入的每个字符高度是否随机
			graphics.setColor(fontColor == null ? getRandomColor() : fontColor);
			graphics.drawString(code.charAt(i)+"", fx, fy);
			fx += fontSize*0.9;
		}
		graphics.dispose();
		return image;
	}

	/**
	 * 随机获取一种颜色
	 * @return
	 */
	private static Color getRandomColor() {
		Random random = new Random();
		Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
		return color;
	}
}
