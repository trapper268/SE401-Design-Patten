package Behavioral.Observer;

import java.util.ArrayList;
import java.util.List;

interface Subscriber {
    void update(String status);
}

class Customer implements Subscriber {
    private String name;
    private String orderStatus;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(String status) {
        this.orderStatus = status;
        displayStatus();
    }

    public void displayStatus() {
        System.out.println("Khách hàng " + name + ": Trạng thái đơn hàng hiện tại là \"" + orderStatus + "\"");
    }
}

interface Publisher {
    void registerCustomer(Subscriber customer);
    void removeCustomer(Subscriber customer);
    void notifyCustomers();
}

class Order implements Publisher {
    private String status;
    private List<Subscriber> customers = new ArrayList<>();

    @Override
    public void registerCustomer(Subscriber customer) {
        customers.add(customer);
    }

    @Override
    public void removeCustomer(Subscriber customer) {
        customers.remove(customer);
    }

    @Override
    public void notifyCustomers() {
        for (Subscriber customer : customers) {
            customer.update(status);
        }
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
        System.out.println("\nCập nhật trạng thái đơn hàng: " + newStatus);
        notifyCustomers();
    }
}


public class Observer {
    public static void main(String[] args) {
        Order order = new Order();

        Customer customer = new Customer("Huy");

        order.registerCustomer(customer);

        order.updateStatus("Đang chuẩn bị");
        order.updateStatus("Đã sẵn sàng để giao");
        order.updateStatus("Đang giao hàng");
        order.updateStatus("Hoàn tất");
    }
}
