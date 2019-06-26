package com.company;

import java.util.ArrayList;
import java.util.List;

public class OrderController {

    UserController userController;
    List<Order> ordersList;

    final float MIN_DISTANCE_BETWEEN_MARKET = 30.0f;

    public OrderController(UserController userController) {
        this.userController = userController;

        ordersList = new ArrayList<Order>();
    }


    public List<Market> getMarketsClose(Client pCliente)
    {
        List<Market> marketsList = new ArrayList<Market>();

        for (User u :userController.getUsersList()) {
            if(u instanceof Market){
                if (((Market) u).getDirectionMarket().getCoords().Distance(pCliente.getDirection().getCoords()) < MIN_DISTANCE_BETWEEN_MARKET)
                {
                    marketsList.add((Market) u);
                }
            }
        }

        return marketsList;
    }
}
