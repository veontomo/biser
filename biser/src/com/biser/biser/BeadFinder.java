package com.biser.biser;

import java.io.File;

public class BeadFinder {
	/**
	 * Path to the file with bead stand color
	 */
	private String _beadStand = "";
	
	/**
	 * _beadStand setter
	 * @param file
	 */
	public void setBeadStand(String file){
		if (this._isValidFile(file)) {
			this._beadStand = file;
		}
	}
	
	private boolean _isValidFile(String fileName){
		File f = new File(fileName);
		return (f.exists() && !f.isDirectory());

	} 
	
	public String getBeadStand(){
		return this._beadStand;
	}

	/**
	 * Path to the file with sorted bead colors
	 */
	private String _beadStandOrdered = "";
	
	public BeadFinder(){
		this._beadStand = "";
	}
	
	public String locate(String color){
		return color.concat(color);
	}
}
