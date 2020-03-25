public class NormalBul extends Bullet{
    // turunan Bullet dengan speed = 1, damage = 2, dan bulletType = "-" .

    public NormalBul(int plantPosition, GridField grid, ArrayList<Bullet> arr){
        super("-", 2, 1, plantPosition, grid, arr);
    }
}