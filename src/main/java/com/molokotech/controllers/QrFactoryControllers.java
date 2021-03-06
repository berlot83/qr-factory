package com.molokotech.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.google.zxing.WriterException;
import com.molokotech.model.QR;
import com.molokotech.service.QrService;
import com.molokotech.utilities.QRCodeGenerator;
import com.molokotech.utilities.TokenCreator;

@RestController
@ComponentScan("com.molokotech.service")
public class QrFactoryControllers {

	@Autowired
	QrService qrService;
	
	@GetMapping("/qr-simple")
	public String qrSimple(String root) throws WriterException, IOException {
		byte[] image = QRCodeGenerator.generateQRCodeImageToByte(root, 300, 300);
		String strBase64 = QRCodeGenerator.toBase64(image);
		return strBase64;
	}

	@GetMapping("/qr-factory")
	public List<QR> qrFactory(@RequestParam("quantity") int quantity, @RequestParam("root") String root) throws InterruptedException, WriterException, IOException {
		List<QR> list = new ArrayList<>();
		List<QR> total = qrService.findAllQR();
		
		if(total.size() < 1000) {
			if(quantity != 0 && root != null) {
				for (int i = 0; i < quantity; i++) {
					QR qr = new QR();
					Thread hilo = new Thread() {
						{
							qr.setShortId(TokenCreator.createSpecialId());
							byte[] image = QRCodeGenerator.generateQRCodeImageToByte(root + qr.getShortId(), 300, 300);
							qr.setStrBase64(QRCodeGenerator.toBase64(image));		
							qrService.createQR(qr);
						}
					};
					hilo.run();
					Thread.sleep(500);
					
					System.out.println("size:" + list.size());
					list.add(qr);
				}
			}
		}else {
			System.out.println("La cantidad total de Códigos QR en DB se ha excedido, no puede seguir creando, comuníquese con info@molokotech.com");
		}
		return list;
	}

}
