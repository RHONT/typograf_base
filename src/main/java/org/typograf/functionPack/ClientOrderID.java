package org.typograf.functionPack;

// просто хранит ключ от объекта ClientRequest (Наверное можно удалить уже lock)

public class ClientOrderID {

    private Integer id;

    public ClientOrderID() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
