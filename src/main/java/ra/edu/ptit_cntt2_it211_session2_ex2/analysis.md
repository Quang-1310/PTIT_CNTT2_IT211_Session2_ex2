So sánh HTTP POST và HTTP PUT
Mục đích chính:
HTTP POST: Tạo mới một tài nguyên dưới dạng một tập con của một danh sách.
HTTP PUT:  Cập nhật một tài nguyên đã biết rõ danh tính, hoặc tạo mới nếu chưa tồn tại.

Xác định URI:
HTTP POST: Client không biết trước ID của tài nguyên. Server tự sinh ID.
HTTP PUT:  Client đã biết rõ ID của tài nguyên cần thao tác.

Tính Idempotent:
HTTP POST: KHÔNG mang tính Idempotent.
HTTP PUT:  CÓ mang tính Idempotent.

Tại sao việc sử dụng POST cho cả tạo mới và cập nhật trong trường hợp được cung cấp ở trên lại dễ dẫn đến lỗi dữ liệu trùng lặp?
Nếu Client gửi lên một Request có kèm ID (Ví dụ: id: 99) nhằm mục đích cập nhật thông tin. Tuy nhiên, vì một lý do nào đó (do gõ nhầm ID, dữ liệu trên DB đã bị User khác xóa trước đó, hoặc sai lệch bộ nhớ), hệ thống không tìm thấy khách hàng này trong danh sách (isPresent() == false).

Thay vì ném ra một lỗi 404 Not Found thích đáng để báo cho Client biết dữ liệu đầu vào bị sai, đoạn code trên lại tự ý thực hiện lệnh customers.add(customer). Điều này vô tình đưa một thực thể có ID tự chế (không đồng bộ với bộ đếm nextId) vào hệ thống, phá vỡ cấu trúc toàn vẹn dữ liệu và dẫn đến xung đột, trùng lặp ID hoặc thông tin ở các lượt tạo mới tiếp theo.