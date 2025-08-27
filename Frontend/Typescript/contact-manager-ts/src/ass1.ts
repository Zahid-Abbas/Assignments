let place:string= "Delhi";
var leng:number= 12;
const boole:boolean= true;
let time:any= 1;
const company = "BMW";

console.log("Place: ",place);
console.log("Length: ",leng);
console.log("boolean: ",boole);
console.log("Time: ",time);
console.log("Company: ",company);


function greet(name:string){
    console.log("Hello " + name);
}
greet("Syed");

const fact = (n:number):number =>{
    let res=1;
    for(let i=2;i<=n;i++){
        res= res*i;
    } 
    return res;
};

console.log(fact(5));


function getGrade(marks:number){
    console.log(marks);
    
    if(marks>90){
        console.log("A");
    }
    else if(marks>74 && marks<90){
        console.log("B");
    }
    else if(marks>49 && marks<90){
        console.log("C");
    }
    else{
        console.log("F");
    }
}

getGrade(94);




