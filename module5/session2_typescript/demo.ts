let x:number = 100;
if(x<50){
    console.log("x is less than 50")
} else{
    console.log("x is NOT less than 50");
}
const user = {
    name: 'Bob',
    age: 55
};
for (const key in user) {
    // @ts-ignore
    console.log(`${key}: ${user[key]}`);
}

const employee = {
    name: 'Hoang Kim Van Chuong',
    address: 'Quang Tri',
    age: 32,
    occupation: "Java DEV"
};

for (const key in employee){
    // @ts-ignore
    console.log(`${key}: ${employee[key]}`);
}

const categories: Array<String> = ['Phone', 'Toy', 'Car', 'Cooker'];
console.log(categories);
console.log(categories.join(" - "));
categories.forEach((str) =>
  console.log(str.trim())
);

const arr:Array<number>=[10,20,30,40];
arr.forEach((num) => console.log(num));
const nums:number[]=[2,3,4,5,9,7];
nums.forEach((num)=>console.log(num));

// convert from this array to other array
const otherArr = nums.map(num => 2*num);
console.log(otherArr.join("/"));

// filter elements of the array 'categories'
const otherCate = categories.filter(str => str.length >= 4);
console.log(otherCate);
const otherNums = nums.filter(num => num >= 4);
console.log(otherNums);


// function
function square(num: number) : number {
    return num*num;
}
console.log("area of square 12x12 is " + square(12));

// function expression
const squareFE = function(num: number): number{
    return num*num;
};
console.log(squareFE(9));

//high-order function
function add(a:number): Function {
    return function (b:number): number {
        return a + b;
    }
}

const addWith5 = add(5);
console.log(addWith5(3));
console.log(addWith5(12));
