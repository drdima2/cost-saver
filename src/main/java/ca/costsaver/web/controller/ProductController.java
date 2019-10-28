package ca.costsaver.web.controller;

import ca.costsaver.entity.Product;
import ca.costsaver.repository.InMemoryProductRepository;
import ca.costsaver.repository.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ProductController extends HttpServlet {


    ProductRepository repository = new InMemoryProductRepository();




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action==null ? "":action){
            case "delete":
                repository.delete(Integer.parseInt(req.getParameter("id")));
                break;
            case "edit":
                req.setAttribute("product",repository.get(Integer.parseInt(req.getParameter("id"))));
                req.getRequestDispatcher("/WEB-INF/JSP/edit-product.jsp").forward(req,resp);
                break;


        }
        req.setAttribute("productList",repository.getAll());
        req.getRequestDispatcher("/WEB-INF/JSP/index.jsp").forward(req,resp);


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String barCode = req.getParameter("barCode");
        String productName = req.getParameter("productName");
        String id = req.getParameter("id");

        System.out.println(id);
        System.out.println(barCode);
        System.out.println(productName);

        Product product = new Product(id.isEmpty()?null:Integer.valueOf(id),barCode,productName);

        repository.save(product);

        req.setAttribute("productList",repository.getAll());
        req.getRequestDispatcher("/WEB-INF/JSP/index.jsp").forward(req,resp);

    }
}
