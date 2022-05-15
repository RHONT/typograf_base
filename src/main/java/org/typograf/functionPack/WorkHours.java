package org.typograf.functionPack;

public enum WorkHours {

        SHIELD(1, 200),
        POITIO_OF_HEALTH(2, 100),
        MOLOTOV(3, 150);

        private int numb_for_tovar;
        private int coast;

        market(int buf_number, int buf_coast) {

            this.numb_for_tovar = buf_number;
            this.coast = buf_coast;

}
