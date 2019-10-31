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

public class StoreController extends HttpServlet {

    StoreRepository storeRepository = new InMemoryStoreRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action == null ? "all" : action) {
            case "delete":
                storeRepository.delete(Integer.parseInt(req.getParameter("storeId")));
                break;
//            case "edit":
//                req.setAttribute("product", storeRepository.get(Integer.parseInt(req.getParameter("storeId"))));
//                req.getRequestDispatcher("/WEB-INF/JSP/edit-product.jsp").forward(req, resp);
//                break;


        }
        req.setAttribute("storeList", storeRepository.getAll());
        req.getRequestDispatcher("/WEB-INF/JSP/stores.jsp").forward(req, resp);


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String storeId = req.getParameter("storeId");
        String storeName = req.getParameter("storeName");

        System.out.println("store ID: " + storeId);
        System.out.println("store name: " + storeName);

        if (!"".equals(storeName)) {
            Store store = new Store(storeId.isEmpty() ? null : Integer.valueOf(storeId), storeName);
            storeRepository.save(store);
        }


        req.setAttribute("storeList", storeRepository.getAll());
        req.getRequestDispatcher("/WEB-INF/JSP/stores.jsp").forward(req, resp);

    }
}
