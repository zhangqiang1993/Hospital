/**
 * 
 */
package com.renji.model;

/**
 * @author zhang
 *
 */
public class CommonDict {
	private int id;
	
	private String text;
	
	private String xh;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	@Override
	public String toString() {
		return "CommonDict [id=" + id + ", text=" + text + ", xh=" + xh + "]";
	}
}
