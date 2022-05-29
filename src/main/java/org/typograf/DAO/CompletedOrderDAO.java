package org.typograf.DAO;

import org.typograf.entity.CompletedOrder;

import java.util.List;

public interface CompletedOrderDAO {
    CompletedOrder getSingleCompletedOrder(Integer id_CompletedOrder);
    CompletedOrder getSingleCompletedOrder(Integer id_clientRequest, Integer id_employee);
    List<CompletedOrder> getAllCompletedOrder();
}
