package ui.controller;

import domain.service.ContactTracingService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RequestHandler {
    protected ContactTracingService contactTracingService;

    public abstract String handleRequest(HttpServletRequest request, HttpServletResponse response);

    public void setModel(ContactTracingService contactTracingService) {
        this.contactTracingService = contactTracingService;
    }

    public ContactTracingService getService() {
        return contactTracingService;
    }
}