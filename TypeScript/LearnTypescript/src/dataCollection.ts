import { Person, Product } from "./dataTypes";

// type dataType = Person | Product;

export class DataCollection<dataType extends { name: string }> {
  private items: dataType[] = [];

  constructor(items: dataType[]) {
    this.items = items;
  }

  add(newItem: dataType) {
    this.items.push(newItem);
  }

  getNames(): string[] {
    return this.items.map((item) => item.name);
  }

  getItem(index: number): dataType | undefined {
    return this.items[index];
  }
}
