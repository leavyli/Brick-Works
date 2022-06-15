import { AbstractDataSource } from "./data/abstractDataSource";
import { Order, Product } from "./data/entities";
import { createElement } from "./tools/jsxFactory";
import { ProductList } from "./productList";



export class HtmlDisplay {
    private containerElem: HTMLElement;
    private selectedCategory: string | undefined;
    props: {
        dataSource: AbstractDataSource

    };
    constructor() {
        this.containerElem = document.createElement("div");
    }

    async getContent(): Promise<HTMLElement> {
        await this.updateContent();
        return this.containerElem;
    }

    async updateContent() {
        let products = await this.props.dataSource.getProducts();
        let categories = await this.props.dataSource.getCategories();

        let content = <div>
            <ProductList products={products} categories={categories}
                selectedCategory={this.selectedCategory}
                addToOrderCallback={this.addToOrder}
                filterCallback={this.selectCategory} />
        </div>
        this.containerElem.appendChild(content);
    }

    addToOrder = (product: Product, quantity: number) => {
        this.props.dataSource.order.addProduct(product, quantity);
        this.updateContent();
    }

    selectCategory = (selected: string) => {
        this.selectedCategory = selected === "ALL" ? undefined : selected;;
        this.updateContent();
    }

    // getElementText(): string {
    //     return `${this.props.products.length} Products, `
    //         + `Order total: $${this.props.order.total}`;
    // }
}