package com.molokotech.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("QR")
public class QR {

	@Id
	private ObjectId objectId;
	private String shortId;
	private String strBase64;

	public ObjectId getObjectId() {
		return objectId;
	}

	public void setObjectId(ObjectId objectId) {
		this.objectId = objectId;
	}

	public String getShortId() {
		return shortId;
	}

	public void setShortId(String shortId) {
		this.shortId = shortId;
	}

	public String getStrBase64() {
		return strBase64;
	}

	public void setStrBase64(String strBase64) {
		this.strBase64 = strBase64;
	}

}
