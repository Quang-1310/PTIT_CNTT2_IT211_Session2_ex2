package ra.edu.ptit_cntt2_it211_session2_ex2.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiDataResponse<T> {
    private boolean success;
    private String message;
    private T data;
    private HttpStatus httpStatus;
}
