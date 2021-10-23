package byitClass;

public class Production {
    private String name;
    private int produce;

    public Production(String name) {
        this.name = name;
        produce=0;
    }

    public int getProduce() {
        return produce;
    }
    public void setWarehouse(){
        if(Warehouse.warehouse!=5){
            if(5-Warehouse.warehouse<=3){
                Warehouse.warehouse+=3;
                produce+=3;
                System.out.println(name + " произвел 3 товара и добавил на склад");
            }else {
                Warehouse.warehouse = 5 - Warehouse.warehouse;
                produce = 5 - Warehouse.warehouse;
                System.out.println(name + " произвел " + produce + " товара и добавил на склад");
            }
        } else {
            System.out.println(name + " попытался добавить товар на склад. Склад переполнен.");
        }
    }
}
