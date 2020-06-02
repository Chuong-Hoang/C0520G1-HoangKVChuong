// Khai báo 2 biến kích thước nhập vào của hình cn
let inputWidth;
let inputHeight;
// Nhập vào giá trị của hai biến vừa khai báo
inputWidth = prompt("Enter the width");
inputHeight = prompt("Enter the height");
/* Sử dụng hàm parseInt() để
    chuyển kiểu dữ liệu từ
    chuỗi sang số nguyên.
 */
let width = parseInt(inputWidth);
let height = parseInt(inputHeight);
// Tính diện tích hình chữ nhật và hiển thị ra màn hình
let area = width * height;
document.write("The width is " + width + "<br/>");
document.write("The height is " + height + "<br/>");
document.write("The area is: " + area);