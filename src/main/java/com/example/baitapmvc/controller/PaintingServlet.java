package com.example.baitapmvc.controller;

import com.example.baitapmvc.model.Painting;
import com.example.baitapmvc.service.PaintingService;
import com.example.baitapmvc.service.PaintingServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "PaintingServlet", urlPatterns = "/paintings")
public class PaintingServlet extends HttpServlet {
    private PaintingService paintingService = new PaintingServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                viewCustomer(request, response);
                break;
            default:
                listPaintings(request, response);
                break;
        }
    }

    private void listPaintings(HttpServletRequest request, HttpServletResponse response) {
        List<Painting> paintings = this.paintingService.findAll();
        request.setAttribute("painting", paintings);

        RequestDispatcher dispatcher = request.getRequestDispatcher("painting/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Painting painting = this.paintingService.findById(id);
        RequestDispatcher dispatcher;
        if(painting == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("painting", painting);
            dispatcher = request.getRequestDispatcher("painting/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Painting painting = this.paintingService.findById(id);
        RequestDispatcher dispatcher;
        if (painting == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("painting", painting);
            dispatcher = request.getRequestDispatcher("painting/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Painting painting = this.paintingService.findById(id);
        RequestDispatcher dispatcher;
        if (painting == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("painting", painting);
            dispatcher = request.getRequestDispatcher("painting/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("painting/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createPainting(request, response);
                break;
            case "edit":
                updatePainting(request, response);
                break;
            case "delete":
                deletePainting(request, response);
                break;
            default:
                break;
        }
    }

    private void deletePainting(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Painting painting = this.paintingService.findById(id);
        RequestDispatcher dispatcher;
        if (painting == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            this.paintingService.remove(id);
            try {
                response.sendRedirect("/paintings");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updatePainting(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String paintCode = request.getParameter("paintCode");
        String name = request.getParameter("name");
        double height = Double.parseDouble(request.getParameter("height"));
        double width = Double.parseDouble(request.getParameter("width"));
        String material = request.getParameter("material");
        String status = request.getParameter("status");
        double price = Double.parseDouble(request.getParameter("price"));

        Painting painting = this.paintingService.findById(id);
        RequestDispatcher dispatcher;
        if (painting == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            painting.setPaintCode(paintCode);
            painting.setName(name);
            painting.setHeight(height);
            painting.setWidth(width);
            painting.setMaterial(material);
            painting.setStatus(status);
            painting.setPrice(price);
            this.paintingService.update(id, painting);
            request.setAttribute("painting", painting);
            request.setAttribute("message", "painting information was updated");
            dispatcher = request.getRequestDispatcher("painting/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createPainting(HttpServletRequest request, HttpServletResponse response) {
        int id = (int) (Math.random() * 1000);
        String paintCode = request.getParameter("paintCode");
        String name = request.getParameter("name");
        double height = Double.parseDouble(request.getParameter("height"));
        double width = Double.parseDouble(request.getParameter("width"));
        String material = request.getParameter("material");
        String status = request.getParameter("status");
        double price = Double.parseDouble(request.getParameter("price"));

        Painting painting = new Painting(id, paintCode, name, height, width, material, status, price);
        this.paintingService.create(painting);
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        request.setAttribute("message", "New painting was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}