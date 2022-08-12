import React from "react";
import logo from "./logo.svg";
import "./App.css";
import {ShoppingList, Hello} from "./ShoppingList";



function App() {
  return (
    <div className="App">
      <Hello who="Jhon" />
      <ShoppingList name="five star" />
    </div>
  );
}

export default App;
