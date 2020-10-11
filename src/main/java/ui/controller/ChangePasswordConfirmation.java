package ui.controller;

import domain.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangePasswordConfirmation extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        String newPasswordConfirmation = request.getParameter("newPasswordConfirmation");
        String error = null;

        Person p = (Person) request.getSession().getAttribute("user");

        if (p.isCorrectPassword(currentPassword)) {

            if (newPassword.equals(newPasswordConfirmation)) {
                request.setAttribute("newPassword", newPassword);
                request.setAttribute("newPasswordConfirmation", newPasswordConfirmation);
                return "changePasswordConfirmation.jsp";
            } else {
                error = "New password and new password confirmation don't match";
            }
        } else {
            error = "Wrong password";
        }

        request.setAttribute("error", error);
        return "Controller?command=ChangePasswordForm";
    }
}
