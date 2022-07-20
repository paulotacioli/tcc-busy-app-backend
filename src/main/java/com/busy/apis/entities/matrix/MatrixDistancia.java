package com.busy.apis.entities.matrix;

import java.util.Arrays;

public class MatrixDistancia {
	
	private String matrixId;
	private MatrixDistanciaTempo matrix;

	
	public MatrixDistancia() {
		
	}
	
	public MatrixDistancia(String matrixId, MatrixDistanciaTempo matrix
			//String[] regionDefinition
			) {
		super();
		this.matrixId = matrixId;
		this.matrix = matrix;
		//this.regionDefinition = regionDefinition;
	}
	public String getMatrixId() {
		return matrixId;
	}
	public void setMatrixId(String matrixId) {
		this.matrixId = matrixId;
	}
	public MatrixDistanciaTempo getMatrix() {
		return matrix;
	}
	public void setMatrix(MatrixDistanciaTempo matrix) {
		this.matrix = matrix;
	}
//	public String[] getRegionDefinition() {
//		return regionDefinition;
//	}
//	public void setRegionDefinition(String[] regionDefinition) {
//		this.regionDefinition = regionDefinition;
//	}

	@Override
	public String toString() {
		return "MatrixDistancia [matrixId=" + matrixId + ", matrix=" + matrix + 
				", regionDefinition="
				//+ Arrays.toString(regionDefinition) 
				+ "]";
	}
	
	
	
	
}
