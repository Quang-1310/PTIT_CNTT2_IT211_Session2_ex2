package ra.edu.ptit_cntt2_it211_session2_ex2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.edu.ptit_cntt2_it211_session2_ex2.model.dto.response.ApiDataResponse;
import ra.edu.ptit_cntt2_it211_session2_ex2.model.entity.Customer;
import ra.edu.ptit_cntt2_it211_session2_ex2.service.CustomerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerRepository {
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<ApiDataResponse<List<Customer>>> getAllCustomer(){
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Lấy danh sách khách hàng thành công",
                customerService.getAllCustomer(),
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiDataResponse<Customer>> insertCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Thêm khách hàng thành công",
                customerService.insertCustomer(customer),
                HttpStatus.CREATED
        ), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Customer>> updateCustomer(@RequestBody Customer customer, @PathVariable Long id){
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Cập nhật khách hàng thành công",
                customerService.updateCustomer(id, customer),
                HttpStatus.OK
        ), HttpStatus.OK);
    }
}
