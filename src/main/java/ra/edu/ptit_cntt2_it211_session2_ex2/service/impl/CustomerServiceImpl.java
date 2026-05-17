package ra.edu.ptit_cntt2_it211_session2_ex2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.edu.ptit_cntt2_it211_session2_ex2.model.entity.Customer;
import ra.edu.ptit_cntt2_it211_session2_ex2.repository.CustomerRepository;
import ra.edu.ptit_cntt2_it211_session2_ex2.service.CustomerService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer insertCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        customerRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Không tồn tại khách hàng"));
        customer.setCustomerId(id);
        customerRepository.save(customer);
        return null;
    }

    @Override
    public Customer getCustomerByid(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Không tồn tại khách hàng"));
    }
}
