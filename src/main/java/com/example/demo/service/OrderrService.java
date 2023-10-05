package service;

import entity.Orderr;
import entity.OrderrItem;

import java.util.List;

public interface OrderrService {

    List<Orderr> getAll();

    Orderr save(Orderr orderr);

    Orderr update(Orderr orderr);

    void delete(Integer id);
}
