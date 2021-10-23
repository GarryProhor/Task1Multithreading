package byitClass;

public class Consumer {
    private String name;
    private int purchased;

    public Consumer(String name) {
        this.name = name;
        purchased = 0;
    }

    public int getPurchased() {
        return purchased;
    }

    public void getWarehouse(){
        if(Warehouse.warehouse >=2){
            purchased += 2;
            Warehouse.warehouse -= 2;
            System.out.println(name + " взял со склада 2 товара.");
        }else if(Warehouse.warehouse == 1){
            purchased +=1;
            Warehouse.warehouse -=1;
            System.out.println(name + " взял со склада 1 товар.");
        }else{
            System.out.println("Склад пустой, " + name + " не смог ничего взять.");
        }

    }

}
