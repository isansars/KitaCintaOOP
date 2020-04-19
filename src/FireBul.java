public class FireBul extends Bullet{
    // Turunan Bullet dengan speed = 3000, damage = 30, dan bulletType = "o" .

    public FireBul(int position, GridField grid, EntityArray<Bullet> arr){
        super("o", 30, 3000, position, grid, arr);

        grid.addFireBul(position);
        arr.add(this.position, this);
    }
}