//Variable declaration
//let/const variableName:datatype = value;
var message = "Hello TS";
console.log(message);
// we are not going to use the upper one compiler automatically understand it
var msg = "TRYING";
console.log(msg);
// when trying to store number in msg it gives error
// msg = 1 
var bool = true;
console.log(bool);
// Same here if we try to store any other data type in bool it also give error
function calculateDiscountedPrice(price, discount) {
    if (discount < 0 || discount > 100) {
        throw new Error("Discount must be in between 0 and 100");
    }
    return price - (price * discount) / 100;
}
var finalPrice = calculateDiscountedPrice(2000, 20);
console.log("Final Price:", finalPrice);
//  Optional parameter 
//  age?:number it will display unknown when not given any value
// Country:string="India" this is default but we can change it
function welcome(name, age, country) {
    if (country === void 0) { country = "India"; }
    return "".concat(name, " is ").concat(age !== null && age !== void 0 ? age : "unknown", " years old from ").concat(country);
}
console.log(welcome("Ali", 21)); // Ali is 21 years old from India
console.log(welcome(1)); //Abhay is unknown years old from India
console.log(welcome("Yasir", 26, "Dubai")); //Yasir is 22 years old from Dubai
