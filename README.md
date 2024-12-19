**Hướng dẫn cài đặt chương trình.**
1.      Tải source code về từ git hoặc sử dụng câu lệnh git clone.
       $ git clone https://github.com/AnhhDEV/hotel_management.git
2.	 Sử dụng XAMPP để kết nối tới MySQL.
  - Sau khi cài đặt, mở  XAMPP Control Panel và nhấn nút "Start" cho 	MySQL.
  - Đảm bảo MySQL chạy trên cổng mặc định `3306`.
3.Sử dụng Intellij IDEA để import project. 
4.	 Sử dụng SQL Workbench hoặc HeidiSQL để kết nối tới cơ sở dữ liệu.
- Kết nối tới MySQL bằng các thông tin sau:
     + Host: localhost
         + Port: 3306
         + Username: root
         + Password: 	
- Tạo một database mới có tên “qlks” và import file .sql trong project.
	(Đường dẫn file .sql: /src/main/resources/schema.sql)
5.     Mở file application.properties để thay đổi url, username, password nếu cần. (/src/main/resources/application.properties)

6. Cài đặt Maven và chạy code.
7. Mở trình duyệt bất kỳ và truy cập URL: localhost:8080 để vào trang login.
   -  Tài khoản admin:  
       + Username: admin
       + Password: admin123    
* Yêu cầu: JDK 21 trở lên.
**Library sử dụng**
  Spring Web, Spring Data JDBC, Thymeleaf.

