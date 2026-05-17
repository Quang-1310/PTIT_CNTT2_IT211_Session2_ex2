package ra.edu.ptit_cntt2_it211_session2_ex2.service;

import ra.edu.ptit_cntt2_it211_session2_ex2.model.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();
    Customer insertCustomer(Customer customer);
    Customer updateCustomer(Long id, Customer customer);
    Customer getCustomerByid(Long id);
}
