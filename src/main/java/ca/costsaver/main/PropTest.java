package ca.costsaver.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

public class PropTest {


    public static void main(String[] args) throws IOException, URISyntaxException {

        PropTest propTest = new PropTest();

        Properties properties = new Properties();
        properties.load((propTest.getClass().getClassLoader().getResourceAsStream("application.properties")));

        URI dbUrl = new URI(System.getenv("DATABASE_URL"));


        System.out.println(dbUrl.getHost());
        System.out.println(dbUrl.getPort());
        System.out.println(dbUrl.getPath());

        System.out.println(dbUrl.getUserInfo());
        System.out.println(dbUrl.getUserInfo().split(":")[0]);
        System.out.println(dbUrl.getUserInfo().split(":")[1]);


    }

}
