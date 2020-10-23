var x = 100;
if (x < 50) {
    console.log("x is less than 50");
}
else {
    console.log("x is NOT less than 50");
}
var user = {
    name: 'Bob',
    age: 55
};
for (var key in user) {
    console.log(key + ": " + user[key]);
}
var employee = {
    name: 'Hoang Kim Van Chuong',
    address: 'Quang Tri',
    age: 32,
    occupation: "Java DEV"
};
for (var key in employee) {
    console.log(key + ": " + employee[key]);
}
var categories = ['Phone', 'Toy', 'Car', 'Cooker'];
console.log(categories);
console.log(categories.join(" - "));
categories.forEach(function (str) {
    return console.log(str.trim());
});
var arr = [10, 20, 30, 40];
arr.forEach(function (num) { return console.log(num); });
var nums = [2, 3, 4, 5, 9, 7];
nums.forEach(function (num) { return console.log(num); });
var otherArr = nums.map(function (num) { return 2 * num; });
console.log(otherArr.join("/"));
var otherCate = categories.filter(function (str) { return str.length >= 4; });
console.log(otherCate);
var otherNums = nums.filter(function (num) { return num >= 4; });
console.log(otherNums);
function square(num) {
    return num * num;
}
console.log("area of square 12x12 is " + square(12));
var squareFE = function (num) {
    return num * num;
};
console.log(squareFE(9));
function add(a) {
    return function (b) {
        return a + b;
    };
}
var addWith5 = add(5);
console.log(addWith5(3));
console.log(addWith5(12));
