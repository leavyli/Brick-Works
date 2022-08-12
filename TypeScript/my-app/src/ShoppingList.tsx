import React from "react";

export const Hello = ({ who }: { who: string }) => <p>Hello, {who}</p>;

export class ShoppingList extends React.Component<{ name: string }> {
  render() {
    return (
      <div className="shopping-list">
        <h1>Shopping List for {this.props.name}</h1>
        <ul>
          <li>Instagram</li>
          <li>WhatsApp</li>
          <li>Oculus</li>
        </ul>
      </div>
    );
  }
}
