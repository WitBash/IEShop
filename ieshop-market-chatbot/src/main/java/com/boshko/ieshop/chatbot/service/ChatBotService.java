package com.boshko.ieshop.chatbot.service;

public interface ChatBotService {

    String getBotName();

    String askBot(String request);
}
