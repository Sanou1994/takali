package com.connecsen.oterrain.domaine;

public class UpdateTransactionObjet {
private long id;
private String status;
public UpdateTransactionObjet() {
	super();
}
public UpdateTransactionObjet(long id, String status) {
	super();
	this.id = id;
	this.status = status;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}


}
