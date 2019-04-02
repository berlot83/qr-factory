package com.molokotech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.molokotech.model.QR;
import com.molokotech.repository.QrRepository;

@Service
public class QrService {
	
	@Autowired
	QrRepository qrRepository;
	

	public QR createQR(QR qr) {
		return qrRepository.save(qr);
	}
	
	public List<QR> findAllQR(List<QR> list){
		return list;
	}
	
}
