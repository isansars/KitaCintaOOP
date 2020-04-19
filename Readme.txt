Program berisikan permainan simpel menyerupai Game plants vs zombies yang dilakukan secara bergiliran dengan paradigma pemrograman berorientasi objek menggunakan bahasa java.

Objective permainan:
-Mempertahankan taman yang ada di layar dari serangan zombie yang dimodelkan dengan "ZA"/"ZB", dengan membeli tanaman yang dapat menyerang zombie tersebut yang dimodelkan dengan "PA"/"PB" menggunakan Sunpoints yang didapat per giliran(25 Sunpoints) dan juga dapat diambil dengan cara menekan sunpoints yang muncul secara acak pada lane yang ada.

Kondisi gameover:
-Zombie sampai di lane paling kiri

Spesifikasi karakter:
PA : Harga: 25 Sunpoints, Health: 50, AttFreq: 8000(thread), Bullettype: Normal
PB : Harga: 50 Sunpoints, Health: 60, AttFreq: 6000(thread), Bullettype: Fire

ZA : Health: 50, Damage: 10, Speed: 5000(thread)
ZB : Health: 80, Damage: 20, Speed: 6000(thread)

Normal Bullet: Model: "->", Damage: 20, Speed: 5000(thread)
Fire Bullet  : Model: "o", Damage: 30, Speed: 3000(thread)

Petunjuk inisialisasi program:
-Download semua file

-Compile semua file yang ber-ekstensi .java dengan command pada cmd "javac Bullet.java GridField.java FireBul.java NormalBul.java GameDemo.java Plant.java PlantA.java PlantB.java Zombie.java ZombieA.java ZombieB.java Player.java EntityArray.java SunPoint.java SpaceFullException.java" dan pastikan cmd telah di direktori file file tersebut

-Run DemoGame dengan command "java DemoGame"

Petunjuk permainan:
-Terdapat menu untuk buy tanaman dan jika sunpoints memenuhi, tanaman akan bisa langusng diletakkan ke dalam lane yang tersedia
