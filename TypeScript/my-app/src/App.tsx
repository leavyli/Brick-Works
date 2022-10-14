import React from "react";
import logo from "./logo.svg";
import "./App.css";
import {ShoppingList, Hello} from "./ShoppingList";
import { NameForm } from "./NameForm";



function App() {
  return (
    <div className="App">
      <Hello who="Jhon" />
      <ShoppingList name="five star" />
      <NameForm />
    </div>
  );
}

export default App;
