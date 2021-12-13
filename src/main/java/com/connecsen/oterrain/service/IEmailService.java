package com.connecsen.oterrain.service;

import javax.mail.MessagingException;

import com.connecsen.oterrain.domaine.Login;
import com.connecsen.oterrain.domaine.MailSend;
import com.connecsen.oterrain.domaine.Reservation;

public interface IEmailService {
public boolean sendContactEmail(MailSend mail);
public boolean sendMailUpdatePassword(Login login,String resetPasswordId) throws MessagingException;
public boolean confirmedMessageAccountCreatedSuccess(Login login) throws MessagingException;
public boolean confirmedMessageReservationPaidSuccess(Reservation reservation) throws MessagingException;

}
