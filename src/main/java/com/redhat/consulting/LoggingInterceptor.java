package com.redhat.consulting;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.activemq.artemis.api.core.ActiveMQException;
import org.apache.activemq.artemis.api.core.Interceptor;
import org.apache.activemq.artemis.api.core.Message;
import org.apache.activemq.artemis.core.protocol.core.Packet;
import org.apache.activemq.artemis.core.protocol.core.impl.wireformat.SessionSendMessage;
import org.apache.activemq.artemis.core.protocol.core.impl.wireformat.SessionReceiveMessage;
import org.apache.activemq.artemis.reader.TextMessageUtil;
import org.apache.activemq.artemis.spi.core.protocol.RemotingConnection;
import org.jboss.logging.Logger;
import org.apache.activemq.artemis.core.protocol.core.impl.wireformat.MessagePacket;
public class LoggingInterceptor implements Interceptor {

	private static final Logger log = Logger.getLogger(LoggingInterceptor.class);	
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
		
	public boolean intercept(Packet packet, RemotingConnection connection) throws ActiveMQException {
		
		
		if (packet instanceof MessagePacket) {
			
	         MessagePacket realPacket = (MessagePacket) packet;
	         Message msg = realPacket.getMessage();
	         
	         String logMessage = String.format("ENTRADA: {\"message-id\":\"%d\", \"correlation-id\":\"%d\", \"timestamp\":\"%s\", \"payload\":\"%s\"}"
	        		 							, msg.getMessageID()
	        		 							, msg.getStringProperty("JMSCorrelationID")
	        		 							, DATE_FORMAT.format(new Date(msg.getTimestamp()))
	        		 							,  TextMessageUtil.readBodyText( msg.getBodyBuffer())
	        		 							);
	         log.info( logMessage );
	      }
		
		
		return true;
	}

}