package com.project.orderMgmt.Configuration;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response {

	Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
