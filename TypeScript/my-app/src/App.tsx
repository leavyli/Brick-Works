import React from "react";
import logo from "./logo.svg";
import "./App.css";
import { ShoppingList, Hello } from "./ShoppingList";
import { NameForm } from "./NameForm";
import { PostInfo } from "./BasicContext/PostInfo";
import { ContextApp } from "./BasicContext/ContextApp";

function App() {
  return (
    <div className="App">
      <Hello who="Jhon" />
      <ShoppingList name="five star" />
      <NameForm messageFunc={() => alert("yoho")} />
      <ContextApp />
    </div>
  );
}

export default App;
