var place = "Delhi";
var leng = 12;
var boole = true;
var time = 1;
var company = "BMW";
console.log("Place: ", place);
console.log("Length: ", leng);
console.log("boolean: ", boole);
console.log("Time: ", time);
console.log("Company: ", company);
function greet(name) {
    console.log("Hello " + name);
}
greet("Syed");
var fact = function (n) {
    var res = 1;
    for (var i = 2; i <= n; i++) {
        res = res * i;
    }
    return res;
};
console.log(fact(5));
function getGrade(marks) {
    console.log(marks);
    if (marks > 90) {
        console.log("A");
    }
    else if (marks > 74 && marks < 90) {
        console.log("B");
    }
    else if (marks > 49 && marks < 90) {
        console.log("C");
    }
    else {
        console.log("F");
    }
}
getGrade(94);
