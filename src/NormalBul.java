public class NormalBul extends Bullet{
    // Turunan Bullet dengan damage = 20, speed = 4000, dan bulletType = "->" .

    public NormalBul(int position, GridField grid, EntityArray<Bullet> arr){
        super("->", 20, 5000, position, grid, arr);

        grid.addNormalBul(position);
        arr.add(this.position, this);
    }
}