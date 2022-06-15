export type Product = {
  id: number;
  name: string;
  category: string;
  description: string;
  price: number;
};

export class OrderLine {
  constructor(public product: Product, public quantity: number) {}

  get total(): number {
    return this.product.price * this.quantity;
  }
}

export class Order {
  private lines = new Map<number, OrderLine>();
  constructor(public initialList?: OrderLine[]) {
    if (initialList)
      initialList.forEach((ol) => this.lines.set(ol.product.id, ol));
  }

  addProduct(product: Product, quantity: number): void {
    if (this.lines.has(product.id)) {
      this.lines.get(product.id)!.quantity += quantity;
    } else {
      this.lines.set(product.id, new OrderLine(product, quantity));
    }
  }

  removeProduct(id: number): void {
    this.lines.delete(id);
  }

  get orderLines(): OrderLine[] {
    return Array.from(this.lines.values());
  }

  get productCount(): number {
    return Array.from(this.lines.values()).reduce(
      (acc, ol) => acc + ol.quantity,
      0
    );
  }

  get total(): number {
    return Array.from(this.lines.values()).reduce(
      (total, ol) => total + ol.total,
      0
    );
  }
}
