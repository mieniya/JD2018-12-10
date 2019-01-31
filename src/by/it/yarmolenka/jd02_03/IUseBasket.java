package by.it.yarmolenka.jd02_03;


interface IUseBasket {
    void takeBasket();                                    //взял корзину
    void putGoodsToBasket(Goods goods, int listSize);     //положил выбранный товар в корзину (goods - список товаров магазина)
}
