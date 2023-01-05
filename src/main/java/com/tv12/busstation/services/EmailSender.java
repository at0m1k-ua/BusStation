package com.tv12.busstation.services;

public interface EmailSender {
    void sendHtml(String text, String toEmail);
}
