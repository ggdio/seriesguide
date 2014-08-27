/**
 * This document is a part of the source code and related artifacts
 * for Unilims, a restricted laboratorial system.
 *
 * http://www.unicorp.com.br
 *
 * Copyright © 2014 Unicorp Informática Industrial - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package br.com.devteam.sguide.mail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Component used to store mail that must be sent by {@link MailNotificationJob}
 * @author Guilherme Dio
 *
 */
public class Mailing {

	private SmtpAccount sender;
	private List<Message> messages = new ArrayList<>();
	
	public SmtpAccount getSender() {
		return sender;
	}
	
	public void setSender(SmtpAccount sender) {
		this.sender = sender;
	}
	
	public List<Message> getMessages() {
		return Collections.unmodifiableList(messages);
	}
	
	public void addMessage(Message message){
		if(message != null)
			this.messages.add(message);
	}
	
	public void addMessages(List<Message> messages){
		for(Message message : messages)
			addMessage(message);
	}
	
	public void addMessages(Message...messages){
		addMessages(Arrays.asList(messages));
	}
	
	public boolean hasPendency(){
		return messages.size() > 0;
	}
	
	public void clear(){
		this.messages.clear();
	}
	
	public int size(){
		return messages.size();
	}
	
}
