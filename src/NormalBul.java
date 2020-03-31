public class NormalBul extends Bullet{
    // Turunan Bullet dengan damage = 20, speed = 1, dan bulletType = "->" .

    public NormalBul(int position, GridField grid, EntityArray<Bullet> arr){
        super("->", 20, 1, position, grid, arr);

        grid.editGrid(this.bulletType, this.position);
        arr.add(this.position, this);
    }
}