//generic class EntityArray.java

public class EntityArray<T> {
    //kelas untuk array dengan elemen entittas
    //entitas dapat berupa zombie, plant, atau bullet yang sedang ada di instansiasinya

    //atribut
    private Object[] t; //T adalah entitas: zombie, plant, atau bullet.
    private static int count; //berisi informasi jumlah entitas di dalam array

    //konstruktor
    public EntityArray() {
        int i;
        t = new Object[60];
        for (i = 0; i <= 59; i ++) {
            this.t[i] = null;
        }
        count = 0;
    }
    //method
    //menambah entitas T ke elemen ke-i
    public void add(int i, T t) {
        this.t[i] = t;
        count += 1;
    }
    
    //menghapus entitas yg menempati elemen ke-i
    public void delete(int i) {
        if (t[i] != null) {
            t[i] = null;
            count -= 1;
        }
    }

    //getter count
    public static int getCount() {
        return count;
    }

    //getter entitas pada elemen ke-i
    public T getEntity(int i) {
        if (t[i] != null) {
            @SuppressWarnings("unchecked")
            T temp = (T)t[i];
            return temp;
        }
        else {
            return null;
        }
    }
}