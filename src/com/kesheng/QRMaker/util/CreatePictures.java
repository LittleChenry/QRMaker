package com.kesheng.QRMaker.util;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;

public class CreatePictures {
	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0xFFFFFFFF;
	private long maxbt;
	private long maxbx;
	private int width;
	private int height;
	private String fixedtext;
	private String pagepath;
	private Font font;
	private String fileroot;
	private int btnum;
	private int bxnum;
	private String pre12id;
	
	public CreatePictures(){}
	
	public CreatePictures(long maxbt, long maxbx, int width, int height, String fixedtext, String pagepath, Font font,
			String fileroot, int btnum, int bxnum,String pre12id) {
		super();
		this.maxbt = maxbt;
		this.maxbx = maxbx;
		this.width = width;
		this.height = height;
		this.fixedtext = fixedtext;
		this.pagepath = pagepath;
		this.font = font;
		this.fileroot = fileroot;
		this.btnum = btnum;
		this.bxnum = bxnum;
		this.pre12id = pre12id;
	}

	public void QRPicture(BufferedImage fixedtextimg,int numheight,HashMap<EncodeHintType, String> hints) throws Exception{
		
		String format = "png";
		int count = btnum;
		while(count>0){
			long idnum = count+maxbt;
			String id = String.format("%012d", idnum);
			String url = "http://" + pagepath+"?="+pre12id+id;
	        BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height, hints);
	        BufferedImage qrcode = toBufferedImage(bitMatrix);
	        BufferedImage QRPicture = mergeImage(qrcode,fixedtextimg);
	        Graphics g = QRPicture.getGraphics();
	        int sigleheight = numheight+1;
	        g.setColor(Color.BLACK);
			g.setFont(font);
			g.drawString(pre12id, 500, 2*sigleheight+48);
			g.drawString(id, 500, 3*sigleheight+48);
			File productimg = new File( fileroot + File.separator +"product" + File.separator + id + "." + format);
	        if(!productimg.exists()){
	        	productimg.mkdirs();
	        }
	        ImageIO.write(QRPicture, "png", productimg);
	        count--;
		}
		count = bxnum;
		while(count>0){
			long idnum = count+maxbx;
			String id = String.format("%012d", idnum);
			String url = pagepath+"?="+pre12id+id;
	        
	        BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height, hints);
	        BufferedImage qrcode = toBufferedImage(bitMatrix);
	        
	        BufferedImage QRPicture = mergeImage(qrcode,fixedtextimg);
	        Graphics g = QRPicture.getGraphics();
	        int sigleheight = numheight+1;
	        g.setColor(Color.BLACK);
			g.setFont(font);
			g.drawString(pre12id, 500, 2*sigleheight+48);
			g.drawString(id, 500, 3*sigleheight+48);
	        File boximg = new File(fileroot + File.separator +"box" + File.separator + id + "." + format);
	        if(!boximg.exists()){
	        	boximg.mkdirs();
	        }
	        ImageIO.write(QRPicture, "png", boximg);
	        count--;
		}
        
        System.out.println("SUCCESS！");
	}
	
	
	public BufferedImage fixedtextImg(int maxwidth,int numheight) throws Exception{
		int picwidth = maxwidth+55;
		int sigleheight = numheight+1;
		BufferedImage image = new BufferedImage(picwidth,height,BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();
		
		int up = height/3;
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, picwidth, height);
		g.setColor(Color.BLACK);
		g.setFont(font);
		
		g.drawString("产品编号：", 0, sigleheight+48);
		
		char[] textchar = fixedtext.toCharArray();

		int count = 0;
		int lines = 1;
		int index = 0;
		while(count < textchar.length){
			for(int i=count;i<=textchar.length;i++){
				
				Rectangle2D singleline= font.getStringBounds(textchar, index, i, new FontRenderContext(AffineTransform.getScaleInstance(1, 1),false,false));
				int linewidth = (int)Math.round(singleline.getWidth());
				if(linewidth>=maxwidth){
					g.drawChars(textchar, index, count-index, 0, up+sigleheight*(lines++)+48);
					index = count;
					break;
				}else{
					count = i;
				}
			}
		}
		g.drawChars(textchar, index, count-index, 0, up+sigleheight*(lines++)+48);
		
		return image;
	}
	
	public BufferedImage mergeImage(BufferedImage img1, BufferedImage img2) throws IOException { 
        int w1 = img1.getWidth(); 
        int h1 = img1.getHeight(); 
        int w2 = img2.getWidth(); 
        int h2 = img2.getHeight(); 

        // 从图片中读取RGB 
        int[] ImageArrayOne = new int[w1 * h1]; 
        ImageArrayOne = img1.getRGB(0, 0, w1, h1, ImageArrayOne, 0, w1); // 逐行扫描图像中各个像素的RGB到数组中 
        int[] ImageArrayTwo = new int[w2 * h2]; 
        ImageArrayTwo = img2.getRGB(0, 0, w2, h2, ImageArrayTwo, 0, w2); 

        // 生成新图片 
        BufferedImage DestImage = null; 
        DestImage = new BufferedImage(w1+w2, h1, BufferedImage.TYPE_INT_RGB); 
        DestImage.setRGB(0, 0, w1, h1, ImageArrayOne, 0, w1); // 设置上半部分或左半部分的RGB 
        DestImage.setRGB(w1, 0, w2, h2, ImageArrayTwo, 0, w2); 
        return DestImage; 
    } 
	

	public BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
			}
		}
		return image;
	}
	
	public void ImgToPDF(String sourceFilePath,String PDFFilePath){
		try {
			File sourceFile = new File(sourceFilePath);
			File[] sourceFiles = sourceFile.listFiles();
			FileOutputStream fos = new FileOutputStream(PDFFilePath);
			Document doc = new Document(null, 0, 0, 0, 0);
			doc.setPageSize(new Rectangle(PageSize.A4.rotate()));
			PdfWriter.getInstance(doc, fos);
			int count = 0;
			doc.open();
			for(int k=0;k<=(Math.ceil(sourceFiles.length/25));k++){
				if(count>=sourceFiles.length)
					break;
				doc.newPage();
				for(int i=0;i<5;i++){
					if(count>=sourceFiles.length)
						break;
					for(int j=0;j<5;j++){
						if(count>=sourceFiles.length)
							break;
						Image image = Image.getInstance(sourceFiles[25*k+5*i+j].toString());
						image.setAbsolutePosition(160*i+25,110*j+25); 
						image.scalePercent(20);
						doc.add(image);
						count++;
					}
				}
			}
			doc.close();
			System.out.println("SUCCESS!");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BadElementException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
