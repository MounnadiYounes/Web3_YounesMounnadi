package ui.controller;

import domain.model.Person;
import util.Checker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Dashboard extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Checker.isUserLoggedIn(request);
        Person p = Checker.getUserInSession(request);
        System.out.println(p.getRegister());
        System.out.println(p.getLastLogin());
        System.out.println(p.getUserid());
        System.out.println(p.getEmail());
        System.out.println(p.getFirstName());
        System.out.println(p.getLastName());
        System.out.println(p.getRole());
        request.setAttribute("user", p);

        return "dashboard.jsp";
    }
}
