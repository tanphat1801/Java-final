# Java-final

# Cách chạy trên IntelliJ

- mở xampp
- dô src/main/java/com/example/ecommerce -> run hàm main đó

# Cấu trúc file

- thư mục controllers: các hàm đều return String (là tên của file html để render), gọi các hàm từ service
- thư mục services: như bên nodejs
- thư mục repository: mặc định sẽ có get all, get by id, delete by id, nếu cần thêm hàm update thì qua bên file userrepo để lấy template
- thư mục models: định nghĩa các model
- thư mục html nằm ở src/main/resouces/templates

- cách thêm data vào model: https://loda.me/articles/jpahuong-dan-manytomany, https://loda.me/articles/jpahuong-dan-onetomany-va-manytoone
- tạo validator cho model: https://loda.me/articles/jpahuong-dan-tu-tao-validator-e-kiem-tra-model-entity
