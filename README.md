# Library-Management-demo

## 1. Giới thiệu

**Library Management** là chương trình quản lý thư viện được xây dựng bằng Java, kết hợp lập trình hướng đối tượng (OOP) và cơ sở dữ liệu SQL Server.

Demo mô phỏng các chức năng quản lý thông tin sách, cho phép người dùng thao tác với dữ liệu thông qua giao diện đồ họa Swing. Dữ liệu được lưu trữ trong SQL Server và được truy xuất thông qua JDBC.

**Mục tiêu:**
- Vận dụng kiến thức lập trình hướng đối tượng trong Java.
- Kết nối Java với SQL Server thông qua JDBC.
- Xây dựng giao diện quản lý dữ liệu bằng Java Swing.
- Thực hiện các thao tác CRUD trên cơ sở dữ liệu.

## 2. Công nghệ sử dụng

| Công nghệ | Vai trò |
|---|---|
| Java | Ngôn ngữ lập trình chính |
| Java Swing | Xây dựng giao diện đồ họa |
| JDBC | Kết nối và trao đổi dữ liệu giữa Java và SQL Server |
| SQL Server | Quản lý và lưu trữ dữ liệu |
| Maven | Quản lý thư viện và dependency |
| GitHub | Quản lý mã nguồn dự án |

## 3. Cấu trúc dự án

| File | Chức năng |
|---|---|
| `Book.java` | Xây dựng lớp Book, đại diện cho một quyển sách. Quản lý các thuộc tính như mã sách, tên sách, tác giả, nhà xuất bản, năm xuất bản và số lượng. |
| `BookDAO.java` | Thực hiện các thao tác truy vấn và xử lý dữ liệu sách trong SQL Server. Chứa các phương thức lấy danh sách, thêm, sửa và xóa sách. |
| `BookManagementUI.java` | Xây dựng giao diện quản lý thư viện bằng Java Swing. Hiển thị danh sách sách bằng JTable và cung cấp các nút thao tác. |
| `DBConnection.java` | Quản lý kết nối giữa ứng dụng Java và cơ sở dữ liệu SQL Server thông qua JDBC. |
| `DigitalLibrary.java` | File Java liên quan đến chương trình DigitalLibrary. |
| `Mavenproject1.java` | File Java được tạo trong project Maven. |
| `digitallibrary.sql` | Chứa các câu lệnh SQL phục vụ khởi tạo cơ sở dữ liệu và bảng dữ liệu. |
| `README.md` | Tài liệu giới thiệu, hướng dẫn và mô tả dự án. |

## 4. Các chức năng chính

### 4.1. Hiển thị danh sách sách (Read)
- Truy xuất danh sách sách từ SQL Server.
- Hiển thị thông tin sách trên JTable.
- Tự động tải lại dữ liệu sau khi thực hiện thao tác.

### 4.2. Thêm sách (Create)
- Nhập thông tin sách thông qua hộp thoại.
- Kiểm tra và chuyển đổi dữ liệu đầu vào.
- Lưu thông tin sách vào SQL Server.

### 4.3. Sửa thông tin sách (Update)
- Chọn sách cần chỉnh sửa trên bảng dữ liệu.
- Cập nhật thông tin sách.
- Lưu thay đổi vào SQL Server.

### 4.4. Xóa sách (Delete)
- Chọn sách cần xóa.
- Hiển thị hộp thoại xác nhận.
- Xóa bản ghi tương ứng trong SQL Server.

## 5. Kiến trúc và cách tổ chức chương trình

Dự án được tổ chức theo hướng phân chia trách nhiệm giữa các thành phần:

- **Model:** Lớp `Book` đại diện cho đối tượng sách và các thuộc tính liên quan.
- **DAO (Data Access Object):** Lớp `BookDAO` chịu trách nhiệm truy vấn và thao tác dữ liệu.
- **Database Connection:** Lớp `DBConnection` quản lý kết nối SQL Server.
- **GUI:** Lớp `BookManagementUI` đảm nhiệm giao diện và tiếp nhận thao tác từ người dùng.

Luồng xử lý cơ bản:

`User → BookManagementUI → BookDAO → DBConnection → SQL Server`

Cách tổ chức này giúp tách biệt giao diện, xử lý dữ liệu và kết nối cơ sở dữ liệu, thuận tiện cho việc bảo trì và mở rộng chương trình.

## 6. Hướng dẫn cài đặt và chạy chương trình

**Yêu cầu:**
- JDK tương thích với cấu hình Maven của dự án.
- Apache Maven.
- Microsoft SQL Server.
- SQL Server Management Studio (SSMS).
- NetBeans IDE hoặc IDE hỗ trợ Maven.

**Các bước thực hiện:**

1. Clone repository:

   ```bash
   git clone <repository-url>
   ```

2. Mở project bằng NetBeans hoặc IDE hỗ trợ Maven.

3. Mở SQL Server Management Studio và chạy file `digitallibrary.sql` để khởi tạo cơ sở dữ liệu.

4. Kiểm tra thông tin kết nối trong `DBConnection.java`, bao gồm tên máy chủ, cổng, tên database và phương thức xác thực.

5. Kiểm tra dependency JDBC trong file `pom.xml`.

6. Build và chạy chương trình từ IDE.

## 7. Tác giả

Dự án được thực hiện nhằm phục vụ chuyên đề **Lập trình hướng đối tượng kết hợp cơ sở dữ liệu (OOP + Database)** của lớp D24CQCN01-N.
Các Thành viên nhóm thực hiện:
1. Công Huyền Tôn Nữ Gia Hân
2. Võ Lê Tô Tố
3. Vũ Thanh Phượng Nhi
4. Phạm Ngọc Hồng Loan
5. Nguyễn Thảo Ly
