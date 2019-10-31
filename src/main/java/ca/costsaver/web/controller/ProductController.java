package ca.costsaver.web.controller;

import ca.costsaver.entity.Product;
import ca.costsaver.entity.Store;
import ca.costsaver.repository.InMemoryProductRepository;
import ca.costsaver.repository.InMemoryStoreRepository;
import ca.costsaver.repository.ProductRepository;
import ca.costsaver.repository.StoreRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductController extends HttpServlet {


    ProductRepository productRepository = new InMemoryProductRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action == null ? "all" : action) {
            case "delete":
                productRepository.delete(Integer.parseInt(req.getParameter("id")));
                break;
            case "edit":
                req.setAttribute("product", productRepository.get(Integer.parseInt(req.getParameter("id"))));
                req.getRequestDispatcher("/WEB-INF/JSP/edit-product.jsp").forward(req, resp);
                break;
            case "stores":
                req.getRequestDispatcher("/WEB-INF/JSP/stores.jsp").forward(req, resp);
                break;

        }
        req.setAttribute("productList", productRepository.getAll());
        req.getRequestDispatcher("/WEB-INF/JSP/index.jsp").forward(req, resp);


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

        if (!"".equals(barCode) && !"".equals(productName)) {
            Product product = new Product(id.isEmpty() ? null : Integer.valueOf(id), barCode, productName);
            productRepository.save(product);
        }


        req.setAttribute("productList", productRepository.getAll());
        req.getRequestDispatcher("/WEB-INF/JSP/index.jsp").forward(req, resp);

    }
}
