package service;

import entity.Category;
import entity.OrderrItem;

import java.util.List;

public interface OrderrItemService {

    List<OrderrItem> getAll();

    OrderrItem save(OrderrItem orderrItem);

    OrderrItem update(OrderrItem orderrItem);

    void delete(Integer id);
}
