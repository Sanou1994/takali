package com.connecsen.oterrain.domaine;

public class UpdateTransactionObjet {
private long id;
private boolean status;
public UpdateTransactionObjet() {
	super();
}
public UpdateTransactionObjet(long id, boolean status) {
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
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}


}
