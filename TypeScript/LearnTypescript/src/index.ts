import { DataCollection } from "./dataCollection";
import { Person, Product } from "./dataTypes";

let people = [
  new Person("John", "New York"),
  new Person("Jane", "New York"),
  new Person("Bob", "Paris"),
];

let products = [new Product("iPhone", 1000), new Product("MacBook", 2000)];
let peopleData = new DataCollection(people);

console.log(`Names: ${peopleData.getNames().join(", ")}`);

let firstPerson = peopleData.getItem(0);
if (firstPerson instanceof Person) {
  console.log(`First person is ${firstPerson.name}, ${firstPerson.city}`);
}

let myObject = {
  greeting: "Hi there!",

  writeMessage() {
    return (message: string) => console.log(`${this.greeting}: ${message}`);
  },
};

let greeting = "hello";

// let myfunction = myObject.writeMessage.bind(myObject)();
let myfunction = myObject.writeMessage();
myfunction("Oh It is rain day!");

interface IPerson {
  [key: string]: string;
}

class ProductGroup {
  constructor(...initialProducts: [string, Product][]) {
    initialProducts.map((p) => (this[p[0]] = p[1]));
  }
  [key: string]: Product;
}

let group = new ProductGroup(["iPhone", new Product("iPhone", 1000)]);
group.hat = new Product("Hat", 100);
Object.keys(group).forEach((key) => {
  console.log(`key:${key} ${group[key]?.name} costs ${group[key]?.price}`);
});

let person: IPerson = {};
person.name = "John";
person.city = "New York";
console.log(`${person.name} lives in ${person.city}`);

let map = new Map<string, number>();
map.set("John", 1);
map.set("Jane", 2);
map.forEach((value, key) => console.log(`${key} ${value}`));
