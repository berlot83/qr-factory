package com.molokotech.utilities;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.EnumMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeGenerator{

	/* Create a QR-Code white byte[] results */
	public static byte[] generateQRCodeImageToByte(String text, int width, int height)
			throws WriterException, IOException {
		
		/* Border size */
		Map<EncodeHintType, Object> hints = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		hints.put(EncodeHintType.MARGIN, 1); /* default = 4 */
		/* Border size */
		
		
		/* ZXing Matrix formatter */ 
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);
		
		
		/* Manage the bytes for an output in this case byte[] */ 
		ByteArrayOutputStream imageOut = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix, "PNG", imageOut);
		byte[] imageData = imageOut.toByteArray(); 
		return imageData;
	}

	public static String toBase64(byte[] imageData) {
		/* Conevert byte[] to Base64 encode in a simple line, need to return an String to insert DB data */
		String i = Base64.getEncoder().encodeToString(imageData);
		return i;
	}
	
	public static void main(String[] args) throws WriterException, IOException {
	/* For console test porpuse only */
		
		String lorem="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
		
		byte[] qr = QRCodeGenerator.generateQRCodeImageToByte(lorem+lorem+lorem+lorem+lorem, 500, 500);
		String str64 = Base64.getEncoder().encodeToString(qr);
		System.out.println(str64);
	}

}