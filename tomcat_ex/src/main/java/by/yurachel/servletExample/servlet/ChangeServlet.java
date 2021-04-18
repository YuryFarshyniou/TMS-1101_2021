package by.yurachel.servletExample.servlet;

import by.yurachel.servletExample.entity.Phone;
import by.yurachel.servletExample.repository.PhoneRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/change")
public class ChangeServlet extends HttpServlet {

    private PhoneRepository pr = PhoneRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/change.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Phone pe = new Phone(req.getParameter("name"), Double.parseDouble(req.getParameter("price")), req.getParameter("processor"));
        String phoneName = req.getParameter("oldName");
        boolean phoneExists = false;
        int index = 0;
        for (Phone phone : pr.getPhones()) {
            if (phone.getName().equalsIgnoreCase(phoneName)) {
                phoneExists = true;
                index = pr.getPhones().indexOf(phone);
                break;
            }
        }
        if (phoneExists) {
            pr.getPhones().set(index, pe);
        }

        resp.sendRedirect("catalog");
    }
}
