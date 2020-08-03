package james_case_study;

public class Request {
    //Action: lưu giữ thông tin action, ví dụ: lookup/define/drop
    private String action;

    //Params: lưu giữ tham số cần thiết khác để thực hiện action
    private String[] params;

    //Keyword: lưu giữ mục từ (nếu có).
    private String[] keyword;


}



/*
[HD] Để đạt được mục tiêu học tập, phiên bản hoàn thiện của chương trình phải đáp ứng những ràng buộc sau đây:
(+) Toàn bộ action của người dùng phải được tổng hợp thành một object (gọi là request) trước khi tìm cách đọc hiểu.
(+) request có các thuộc tính sau:
# Action: lưu giữ thông tin action, ví dụ: lookup/define/drop
# Params: lưu giữ tham số cần thiết khác để thực hiện action
# Keyword: lưu giữ mục từ (nếu có).

 --> Ví dụ hoàn chỉnh một object request:
{
  action: 'define',
  params: ['-v', 'a positive factor', 'một nhân tố tích cực']
  keyword: 'positive'
}

(+) Tách riêng lớp nhận/hiểu request (gọi là controller) và (các) lớp chức năng (gọi là service).
(+) Không được sử dụng dữ liệu nguyên thủy mà không bao gói trong đối tượng. Tất cả các dữ liệu như từ,
    định nghĩa, mẫu câu, … đều phải được lưu chứa thành object (gọi là entities).
(+) Lợi dụng kiểu dữ liệu Map để thực hiện lookup.
(+) Lợi dụng kiểu dữ liệu LinkedList để lưu giữ các entities, nhằm tiện cho việc thêm sửa xóa mục từ mà
    vẫn giữ được thứ tự bảng chữ cái.
(+) Sử dụng mẫu thiết kế Factory hay Abstract Factory để tạo mới entities.
(+) Sử dụng mẫu thiết kế Singleton cho service.
(+) Phải có kiểm thử cho service, sử dụng JUnit.
(+) Tìm cách tái cấu trúc để controller không cần câu lệnh rẽ nhánh để hiểu action (Sử dụng cấu trúc dữ liệu Map).

*/

