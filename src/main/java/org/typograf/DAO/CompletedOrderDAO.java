package org.typograf.DAO;

import org.typograf.entity.CompletedOrder;

import java.util.List;

public interface CompletedOrderDAO {
    CompletedOrder getSingleCompletedOrder(Integer id_CompletedOrder);
    List<CompletedOrder> getAllCompletedOrder();
}
