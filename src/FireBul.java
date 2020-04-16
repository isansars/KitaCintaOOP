public class FireBul extends Bullet{
    // Turunan Bullet dengan speed = 2000, damage = 30, dan bulletType = "o" .

    public FireBul(int position, GridField grid, EntityArray<Bullet> arr){
        super("o", 30, 3000, position, grid, arr);

        //grid.editGrid(this.bulletType, this.position);
        grid.addFireBul(position);
        //arr.add(this.position, this);
    }
}