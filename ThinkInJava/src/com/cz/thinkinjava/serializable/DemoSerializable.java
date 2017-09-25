package com.cz.thinkinjava.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DemoSerializable implements Serializable{

	private static final long serialVersionUID = -4565910310124697371L;
	
	private String code ;
	
	private String name ;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	@Override
	public String toString() {
		return "DemoSerializable [code=" + code + ", name=" + name + "]";
	}
	
	
	
}
