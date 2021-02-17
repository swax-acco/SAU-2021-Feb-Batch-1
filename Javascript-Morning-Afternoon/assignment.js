// 1 array methods
console.log("question 1")
a = [1,2,3,4];
b = [5,6,7,8];
console.log("a = ",a," b = ", b);
// concat method
var c = a.concat(b);
console.log("a concat b, c = ",c);

var checkGreaterthan = function(n){
    // every method
    return c.every((num) => { return num > n});
}
console.log("check all num in c greater than 5 using every method = ",checkGreaterthan(5));
console.log("check all num in c greater than 0 = ",checkGreaterthan(0));

// filter method
d = c.filter((num) => { return num > 5});
console.log("nums in c greater than 5 using filter = ",d);

// forEach method
console.log("printing num+2 of c using forEach method");
c.forEach(num => { return console.log(num + 2);});


console.log("index of 3 in c = ", c.indexOf(3));
console.log("index of 10 in c = ", c.indexOf(10));

// join method
e = c.join();
console.log("converting c to string using join = ", e);


c.push(3);
c.push(3);
// lastIndexOf method
console.log("c = ", c);
console.log("last index of 3 in c", c.lastIndexOf(3));

// map method
f = c.map(num => {return num + 2});
console.log("creating f whose elements are = c[elements] + 2 using map method ", f);

// pop method
console.log("c = ",c);
c.pop();
c.pop();
console.log("After pop, c = ",c);

// 2 slide 52
console.log("question 2");
var add = (function() {
    var counter = 0;
    return function() { return ++counter;}
})();
add();
add();
console.log(add());
console.log("The value of counter is incrementing with every call and not resetting back to 1 as every function in js remembers all the variables in it's scope.");
console.log("Everytime add is called it creates a new copy add with incremented counter value.\n");

// 3 regex function
function testRegEx(string){
    re1 = /^lion/i;
    re2 = /cat$/i;
    re3 = /ab+c/i;
    if(re1.test(string) || re2.test(string)){
        return true;
    }
    if(match = re3.exec(string)){
        console.log(match.index + " to " + (+match.index + +match[0].length));
        return true;
    }
    return false;
}
console.log("question 3")
console.log(testRegEx("lion is not lion"));
console.log(testRegEx("lion is a cat"));
console.log(testRegEx("that is a cat"));
console.log(testRegEx("awdaec abbbbbbc awfnbbce"));

// 4
console.log("question 4")
function question4(arr){
    arr = arr.sort();
    arr = arr.map((num) => { return num * 10;})
    return arr.filter((num) => {return !(num%3)}); 
}
console.log("array = ", [5,4,7,9,1,2,6,8]);
console.log("array after q4 = ", question4([5,4,7,9,1,2,6,8]));

// 5
console.log("question 5")
console.log("== in JavaScript is used for comparing two variables, but it ignores the datatype of variable. The == checks for equality only after doing necessary conversations. whereas");
console.log("=== is used for comparing two variables, but this operator also checks datatype and compares two values. If two variable values are not similar, then === will not perform any conversion and will return false.");
//some examples to understand it better
console.log(1 === "1");//prints false
console.log(true == "1");//prints false
console.log(true == "1" == 1) //prints true



