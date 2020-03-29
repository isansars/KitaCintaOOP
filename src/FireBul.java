public class FireBul extends Bullet{
    // turunan Bullet dengan speed = 2, damage = 3, dan bulletType = "o" .

    public FireBul(int plantPosition, GridField grid, EntityArray<Bullet> arr){
        super("o", 3, 2, plantPosition, grid, arr);
    }
}