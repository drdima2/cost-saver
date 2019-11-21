package ca.costsaver.web.controller;

import ca.costsaver.entity.Product;
import ca.costsaver.service.ProductService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
@RequestMapping("/product")
public class ProductController  {


    private static final Logger log = getLogger(ProductController.class);


    @Autowired
    ProductService productService;


//    @Override
//    public void init() throws ServletException {
//        super.init();
//        //ProductRepository repository = new ProductRepositoryImplInMemory();
//        ProductRepository repository= ServiceManager.getInstance(getServletContext()).getProductRepository();
//        productService = new ProductServiceImpl(repository);
//        log.info("Servlet ProductController has been initialized");
//
//    }

    @GetMapping(value = "/all")
    public void listAllProducts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        log.debug("action={}", action);


        switch (action == null ? "" : action) {
            case "delete":
                productService.delete(Integer.parseInt(req.getParameter("id")));
                resp.sendRedirect("/");
                break;
            case "edit":
                req.setAttribute("product", productService.get(Integer.parseInt(req.getParameter("id"))));
                req.getRequestDispatcher("/WEB-INF/JSP/edit-product.jsp").forward(req, resp);
                break;
            default:
                req.setAttribute("productList", productService.getAll());
                req.getRequestDispatcher("/WEB-INF/JSP/index.jsp").forward(req, resp);

        }


    }



    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String barCode = req.getParameter("barCode");
        String productName = req.getParameter("productName");
        String id = req.getParameter("id");

        log.debug("incoming paramaters id={} barCode={} productName={}", id, barCode, productName);


        Product product = new Product(id.isEmpty() ? null : Integer.valueOf(id), barCode, productName);

        productService.save(product);

        //req.setAttribute("productList", repository.getAll());
        //req.getRequestDispatcher("/WEB-INF/JSP/index.jsp").forward(req, resp);
        resp.sendRedirect("/");

    }
}
