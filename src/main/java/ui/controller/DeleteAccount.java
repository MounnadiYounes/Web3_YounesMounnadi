package ui.controller;

import domain.model.Person;
import domain.model.Role;
import util.Checker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteAccount extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Checker.isUserLoggedIn(request);

        if (request.getParameter("yes") == null) return "Controller?command=Home";

        String userId = request.getParameter("userId");
        contactTracingService.deleteAccount(userId);
        request.setAttribute("success", "The account and all its content has been deleted successfully.");

        Person person = (Person) request.getSession().getAttribute("user");
        if (person.getRole() == Role.ADMIN) {
            return "Controller?command=UsersOverview";
        } else {
            Checker.logout(request);
            return "Controller?command=Home";
        }
    }
}