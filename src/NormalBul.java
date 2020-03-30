public class NormalBul extends Bullet{
    // turunan Bullet dengan speed = 1, damage = 2, dan bulletType = "-" .

    public NormalBul(int position, GridField grid, EntityArray<Bullet> arr){
        super("->", 40, 1, position, grid, arr);

        grid.editGrid(this.bulletType, this.position);
        arr.add(this.position, this);
    }
}