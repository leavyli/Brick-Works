import React from "react";
import logo from "./logo.svg";
import "./App.css";
import { ShoppingList, Hello } from "./ShoppingList";
import { NameForm } from "./NameForm";
import { ContextApp, PostInfo } from "./BasicContext/ContextApp";
import {ChildComponent, ParentComponent } from "./BasicContext/Test";

const AppTest = ()=> <ParentComponent Comp={ChildComponent} />

function App() {
  return (
    <div className="App">
      <Hello who="Jhon" />
      <ShoppingList name="five star" />
      <NameForm messageFunc={() => alert("yoho")} />
      <ContextApp Comp={PostInfo} />

      <AppTest />
    </div>
  );
}

export default App;
