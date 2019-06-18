package demo.controller;

import com.googlecode.objectify.ObjectifyService;
import demo.entity.Account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class HelloController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account account = new Account();
        account.setId(Calendar.getInstance().getTimeInMillis());
        account.setUsername(req.getParameter("username"));
        account.setPassword(req.getParameter("password"));
        account.setSalt("1102");
        account.setStatus(1);
        ofy().save().entity(account).now();
        resp.getWriter().println("Hello Controller");
    }
}
