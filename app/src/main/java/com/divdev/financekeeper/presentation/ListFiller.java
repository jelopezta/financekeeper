package com.divdev.financekeeper.presentation;

import com.divdev.financekeeper.core.persistence.model.FinanceNode;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author jlopez
 */
public class ListFiller {
    public static void llenarListaNodos(List<FinanceNode> listaNodos) {
        FinanceNode nodo = new FinanceNode();
        nodo.setName("Patito1");
        nodo.setDescription("Description of node patito 1");
        nodo.setBalance(new BigDecimal(3_000_000));

        FinanceNode nodo2 = new FinanceNode();
        nodo2.setName("    Patito2");
        nodo2.setDescription("Description of node patito 2");
        nodo2.setBalance(new BigDecimal(1_500_000));

        FinanceNode nodo3 = new FinanceNode();
        nodo3.setName("    Patito3");
        nodo3.setDescription("Description of node patito 3");
        nodo3.setBalance(new BigDecimal(1_500_000));

        FinanceNode nodo4 = new FinanceNode();
        nodo4.setName("        Patito4");
        nodo4.setDescription("Description of node patito 4");
        nodo4.setBalance(new BigDecimal(1_500_000));

        FinanceNode nodo5 = new FinanceNode();
        nodo5.setName("        Patito5");
        nodo5.setDescription("Description of node patito 5");
        nodo5.setBalance(new BigDecimal(50_000));

        FinanceNode nodo6 = new FinanceNode();
        nodo6.setName("    Patito6");
        nodo6.setDescription("Description of node patito 6");
        nodo6.setBalance(new BigDecimal(700_000));

        FinanceNode nodo7 = new FinanceNode();
        nodo7.setName("    Patito7");
        nodo7.setDescription("Description of node patito 7");
        nodo7.setBalance(new BigDecimal(900_000));

        FinanceNode nodo8 = new FinanceNode();
        nodo8.setName("Patito800000000000000000000000");
        nodo8.setDescription("Description of node patito 8");
        nodo8.setBalance(new BigDecimal(1_000_500_000));

        FinanceNode nodo9 = new FinanceNode();
        nodo9.setName("    Patito900000000000000000000000");
        nodo9.setDescription("Description of node patito 9");
        nodo9.setBalance(new BigDecimal(500_000));

        listaNodos.add(nodo);
        listaNodos.add(nodo2);
        listaNodos.add(nodo3);
        listaNodos.add(nodo4);
        listaNodos.add(nodo5);
        listaNodos.add(nodo6);
        listaNodos.add(nodo7);
        listaNodos.add(nodo8);
        listaNodos.add(nodo9);
    }
}
