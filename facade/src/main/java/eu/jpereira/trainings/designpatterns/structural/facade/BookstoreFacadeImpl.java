package eu.jpereira.trainings.designpatterns.structural.facade;

import eu.jpereira.trainings.designpatterns.structural.facade.model.Book;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Customer;
import eu.jpereira.trainings.designpatterns.structural.facade.model.DispatchReceipt;
import eu.jpereira.trainings.designpatterns.structural.facade.model.Order;
import eu.jpereira.trainings.designpatterns.structural.facade.service.*;

public class BookstoreFacadeImpl implements BookstoreFacade {
    private BookDBService bookDBService;
    private CustomerDBService customerDBService;
    private OrderingService orderingService;
    private WharehouseService wharehouseService;
    private CustomerNotificationService customerNotificationService;

    public void setBookDBService(BookDBService bookDBService) {
        this.bookDBService = bookDBService;
    }

    public void setCustomerDBService(CustomerDBService customerDBService) {
        this.customerDBService = customerDBService;
    }

    public void setOrderingService(OrderingService orderingService) {
        this.orderingService = orderingService;
    }

    public void setWharehouseService(WharehouseService wharehouseService) {
        this.wharehouseService = wharehouseService;
    }

    public void setCustomerNotificationService(CustomerNotificationService customerNotificationService) {
        this.customerNotificationService = customerNotificationService;
    }

    @Override
    public void placeOrder(String customerId, String isbn) {

        Book bookByISBN = bookDBService.findBookByISBN(isbn);
        Customer customerById = customerDBService.findCustomerById(customerId);
        Order order = orderingService.createOrder(customerById, bookByISBN);
        DispatchReceipt dispatch = wharehouseService.dispatch(order);

        customerNotificationService.notifyClient(dispatch);
    }


}
