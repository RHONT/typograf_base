package org.typograf.functionPack;

import com.fasterxml.jackson.annotation.JsonRawValue;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.typograf.Services.DataBaseTypographService;
import org.typograf.entity.ClientRequest;

// просто хранит ключ от объекта ClientRequest (Наверное можно удалить уже lock)
public class ClientOrder {

    private Integer id;
    private boolean lock;

    public ClientOrder() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {

        this.id = id;
        lock=true;
    }

    public boolean isLock() {
        return lock;
    }
    public void setLock(boolean lock) {
        this.lock = lock;
    }
}
