public class FireBul extends Bullet{
    // turunan Bullet dengan speed = 2, damage = 3, dan bulletType = "o" .

    public FireBul(int position, GridField grid, EntityArray<Bullet> arr){
        super("o", 30, 2, position, grid, arr);

        grid.editGrid(this.bulletType, this.position);
        arr.add(this.position, this);
    }
}