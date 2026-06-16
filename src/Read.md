thuc thể 
Book :
id
title 
author
price
status (AVALIBLE, BORROWED)
is_deleted
Các API cần thực hiện 
- Quản lý sách 
- Api thêm mới Book(validate)
- Api lấy danh sách Book
- Api cập nhât thông tin sách tất cả thông tin
- Api cập nhật thông tin sách một phần thông tin 
- Api xóa sách (soft delete , hoặc Hard delete)
- Truy vấn nâng cao 
- Api tìm kiếm sách theo tên (title hoặc author) kết hợp phân trang  , tích hợp vào Api lấy danh sách đã được đề cập ở trên 
- Yêu cầu áp dụng AOp để thiệt lập cơ chế kiểm soát log cụ the hệ thống phải tự động log ra consolog thông tin về 
method Name và mỗi khi có luồng dữ liệu gọi vào các chức năng thêm mới hoặc cập nhật của book
- Validation 
- yêu cầu bắt buộc áp dụng cơ chế Validation dữ liệu đầu vào cho các api
- Book : các trường hợp title và author không được để trống tường price phải có giá trị lớn hơn 0
- Exception Handling 
- Xây dưng cơ chế 