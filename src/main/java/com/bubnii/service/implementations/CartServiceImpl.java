package com.bubnii.service.implementations;

import com.bubnii.model.Person;
import com.bubnii.model.Product;
import com.bubnii.service.interfaces.CartService;
import com.bubnii.service.interfaces.PersonService;
import com.bubnii.service.interfaces.ProductService;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

@Service
public class CartServiceImpl implements CartService {

    private static final String PASSWORD = "567tyu567tyua";

    private final ProductService productService;
    private final PersonService personService;

    public CartServiceImpl(ProductService productService, PersonService personService) {
        this.productService = productService;
        this.personService = personService;
    }

    @Override
    public void prepareOrderAndSendEmail(final HttpSession session, final String email) {

        final int userId = (int) session.getAttribute("userId");
        final Properties properties = new Properties();

        try {
            properties.load(CartServiceImpl.class.getClassLoader().getResourceAsStream("mail.properties"));
            Session mailSession = Session.getDefaultInstance(properties);
            MimeMessage message = prepareMessage(email, userId, mailSession);

            Transport tr = mailSession.getTransport();
            tr.connect(null, PASSWORD);
            tr.sendMessage(message, message.getAllRecipients());
            tr.close();
            productService.clearCart(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private MimeMessage prepareMessage(final String email, final int userId, final Session mailSession) throws MessagingException {
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("bubniyo@gmail.com"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        message.setSubject("Дякуємо за замовлення!");
        message.setText(createProductInfoMessage(userId));
        return message;
    }

    private int getTotalPrice(final int userId) {
        final Person person = personService.get(userId);
        final List<Product> productList = person.getProductList();

        return productList.stream().mapToInt(Product::getPrice).sum();
    }

    private String createProductInfoMessage(final int userId) {
        final Person person = personService.get(userId);
        final List<Product> productList = person.getProductList();

        StringBuilder orderMessage = new StringBuilder();

        orderMessage
                .append("№ замовлення: ")
                .append(randomizeNumberOfOrder())
                .append("\n")
                .append("Дата замовлення: ")
                .append(new Date())
                .append("\n")
                .append("Реквізити оплати: 5375 4141 0550 2925\n");

        final List<String> productsInfo = new LinkedList<>();
        for (int i = 0; i < productList.size(); i++) {
            productsInfo.add(i, "Назва: " + productList.get(i).getName() + " | " + "Модель: "
                    + productList.get(i).getModel() + " | " + "Ціна: " + productList.get(i).getPrice());
        }

        for (int i = 0; i < productList.size(); i++) {
            orderMessage.append(productsInfo.get(i)).append("\n");
        }

        orderMessage
                .append("Загальна сума до оплати: ")
                .append(getTotalPrice(userId))
                .append(" грн.");

        return String.valueOf(orderMessage);
    }

    private long randomizeNumberOfOrder() {
        return (long) (10000 + Math.random() * 10000);
    }
}
