package ru.mobydrake.servlets;

import ru.mobydrake.entities.Product;
import ru.mobydrake.repository.ProductRepository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class CardController implements Serializable {

    private List<Product> cardList;

    @PostConstruct
    public void init() {
        cardList = new ArrayList<>();
    }

    public String addInCard(Product product) {
        cardList.add(product);
        return "catalog.xhtml";
    }


    public List<Product> getCardList() {
        return cardList;
    }
}
