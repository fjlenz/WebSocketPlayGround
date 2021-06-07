package com.fj.websocketplayground.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Message {

  Logger logger = LoggerFactory.getLogger("jsonConsoleAppender");
	
  private String name;

  public Message() {
  }

  public Message(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}