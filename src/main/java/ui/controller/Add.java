package ui.controller;

import domain.db.DbException;
import domain.model.Person;
import domain.model.Role;
import util.Checker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class Add extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        List<String> errors = new ArrayList<>();

        Person person = new Person();
        setPersonUserid(person, request, errors);
        setPersonFirstName(person, request, errors);
        setPersonLastName(person, request, errors);
        setPersonEmail(person, request, errors);
        setPersonPassword(person, request, errors);
        setPersonRole(person, request, errors);

        if (errors.size() == 0) {
            try {
                contactTracingService.getPersonService().add(person);

                Checker.loginUser(request, person, contactTracingService);

                request.setAttribute("success", "Your account has been registered successfully.");
                return "Controller?command=ContactsOverview";
            } catch (DbException e) {
                errors.add(e.getMessage());
            }
        }

        request.setAttribute("errors", errors);
        return "Controller?command=Register";
    }

    private void setPersonUserid(Person person, HttpServletRequest request, List<String> errors) {
        String userId = request.getParameter("userId").trim();
        try {
            person.setUserid(userId);
            request.setAttribute("userIdPrevious", userId);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    private void setPersonFirstName(Person person, HttpServletRequest request, List<String> errors) {
        String firstName = request.getParameter("firstName").trim();
        try {
            person.setFirstName(firstName);
            request.setAttribute("firstNamePrevious", firstName);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    private void setPersonLastName(Person person, HttpServletRequest request, List<String> errors) {
        String lastName = request.getParameter("lastName").trim();
        try {
            person.setLastName(lastName);
            request.setAttribute("lastNamePrevious", lastName);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    private void setPersonEmail(Person person, HttpServletRequest request, List<String> errors) {
        String email = request.getParameter("email").trim();
        try {
            person.setEmail(email);
            request.setAttribute("emailPrevious", email);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    private void setPersonPassword(Person person, HttpServletRequest request, List<String> errors) {
        String password = request.getParameter("password").trim();
        try {
            person.setPasswordHashed(password);
            request.setAttribute("passwordPrevious", password);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    private void setPersonRole(Person person, HttpServletRequest request, List<String> errors) {
        try {
            person.setRole(Role.USER);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }
}
