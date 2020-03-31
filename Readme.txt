Program berisikan permainan simpel menyerupai Game plants vs zombies yang dilakukan secara bergiliran dengan paradigma pemrograman berorientasi objek menggunakan bahasa java.

Objective permainan:
-Mempertahankan taman yang ada di layar dari serangan zombie yang dimodelkan dengan "ZA"/"ZB", dengan membeli tanaman yang dapat menyerang zombie tersebut yang dimodelkan dengan "PA"/"PB" menggunakan Sunpoints yang didapat per giliran(25 Sunpoints)

Kondisi gameover:
-Zombie sampai di lane paling kiri
-Giliran mencapai giliran ke-50

Spesifikasi karakter:
PA : Harga: 25 Sunpoints, Health: 50, AttFreq: 4, Bullettype: Normal
PB : Harga: 50 Sunpoints, Health: 60, AttFreq: 3, Bullettype: Fire

ZA : Health: 50, Damage: 10, Speed: 2
ZB : Health: 80, Damage: 20, Speed: 1

Normal Bullet: Model: "->", Damage: 20, Speed: 1
Fire Bullet  : Model: "o", Damage: 30, Speed: 2

Petunjuk inisialisasi program:
-Download semua file
-Compile semua file yang ber-ekstensi .java dengan command pada cmd "javac Bullet.java GridField.java FireBul.java NormalBul.java GameDemo.java Plant.java PlantA.java PlantB.java Zombie.java ZombieA.java ZombieB.java Player.java" dan pastikan cmd telah di direktori file file tersebut
-Run DemoGame dengan command "java DemoGame"

Petunjuk permainan:
-BUY : untuk menampilkan menu beli tanaman
-SKIP : untuk skip giliran yang sekarang