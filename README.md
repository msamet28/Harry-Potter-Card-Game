TR| Kotlin ile yazılan bu proje Harry Potter temalı klasik bir kart eşleştirme oyunudur. Oyuna giriş yapmak için kullanıcı profili oluşturmak gerekmektedir. Oluşturulan yeni profillerin id, kullanıcı adı, e-posta, şifreleri Firebase Realtime Database'de kaydedilmektedir. Kartların arka yüzündeki karakterin adı, fotoğrafı(Base64 formunda), puanı, hangi evden olduğu da Firebase Cloud Firestore'da saklanmaktadır. Oyun 3 adet zorluk seviyesine sahiptir(2x2 , 4x4 , 6x6) ve her zorluk seviyesi ister tek kişilik ister 2 kişilik oynanabilmektedir. Tek kişilik oyunun süresi 45 saniye iken 2 kişilik oyunun süresi 60 saniyedir.

Tek kişilik oyunun puanlama sistemi şu şekildedir;
o Oyun süresi 45 saniyedir. Oyunda her kartın bir puanı ve ait olduğu bir ev bulunmaktadır. Oyun skoru her hamle sonrasında ekranda anlık olarak gösterilecektir.
o Örn- Harry Potter (Puan :10 , Ev: Gryffindor)
o Oyuncu doğru bir eşleştirme yaparsa (2*kartın puanı * evin katsayısı) * (kalan süre / 10) kadar puan kazanır.
o Yanlış bir eşleştirme durumunda iki kart aynı evden ise (kartların toplam puanı / evin katsayısı) * (geçen süre / 10) kadar puan kaybeder.
o Yanlış bir eşleştirme durumunda iki kart farklı evden ise (kartların puan ortalaması * Ev_1_katsayı * Ev_2_katsayı ) * (geçen süre / 10) kadar puan kaybeder
o Ev katsayıları
▪ Gryffindor : 2
▪ Slytherin : 2
▪ Hufflepuff : 1
▪ Ravenclaw : 1

2 kişilik oyunun puanlama sistemi şu şekildedir;
o Oyun süresi 60 saniyedir. Oyunda her kartın bir puanı ve ait olduğu bir ev bulunmaktadır. Her oyuncu sırayla seçim yapar. Doğru bir eşleştirme yapan oyuncu tekrar oynama hakkına sahiptir. Oyun skoru her hamle sonrasında ekranda anlık olarak gösterilecektir.
o Örn - Harry Potter (Puan :10 , Ev: Gryffindor)
o Oyuncu doğru bir eşleştirme yaparsa (2*kartın puanı * evin katsayısı) kadar puan kazanır.
o Yanlış bir eşleştirme durumunda iki kart aynı evden ise (kartların toplam puanı / evin katsayısı) kadar puan kaybeder.
o Yanlış bir eşleştirme durumunda iki kart farklı evden ise (kartların puan ortalaması * Ev_1_katsayı * Ev_2_katsayı ) kadar puan kaybeder.
o Ev katsayıları
▪ Gryffindor : 2
▪ Slytherin : 2
▪ Hufflepuff : 1
▪ Ravenclaw : 1
 
Not: Kartların bireysel puanları "photo9"da belirtilmiştir.

-----------------------------------------------------------------------------------------------------------------------------------------

EN| This project, written in Kotlin, is a classic card matching game with a Harry Potter theme. To start the game, users need to create a profile. The newly created profiles, including ID, username, email, and password, are stored in Firebase Realtime Database. The information about the characters on the back of the cards, such as their name, photo (in Base64 format), score, and house affiliation, is stored in Firebase Cloud Firestore. The game has three difficulty levels (2x2, 4x4, 6x6), and each level can be played either in single-player or two-player mode. The single-player game has a time limit of 45 seconds, while the two-player game has a time limit of 60 seconds.

The scoring system for the single-player game is as follows;
o The game lasts for 45 seconds. Each card has a score and belongs to a house. The game score will be displayed on the screen in real-time after each move.
o Example: Harry Potter (Score: 10, House: Gryffindor)
o If the player makes a correct match, they earn points equal to (2 * card score * house coefficient) * (remaining time / 10).
o If the player makes an incorrect match and both cards belong to the same house, they lose points equal to (total score of the cards / house coefficient) * (elapsed time / 10).
o If the player makes an incorrect match and the two cards belong to different houses, they lose points equal to (average score of the cards * House_1_coefficient * House_2_coefficient) * (elapsed time / 10).
o House coeffi cients
▪ Gryffindor : 2
▪ Slytherin : 2
▪ Hufflepuff : 1
▪ Ravenclaw : 1

The scoring system for the two-player game is as follows;
o The game lasts for 60 seconds. Each card has a score and belongs to a house. Each player takes turns making a selection. If a player makes a correct match, they earn points and get another turn to play. The game score is displayed on the screen after each move in real-time.
o Example: Harry Potter (Score: 10, House: Gryffindor)
o If a player makes a correct match, they earn points equal to (2 * card score * house coefficient).
o If a player makes an incorrect match and both cards belong to the same house, they lose points equal to (total score of the cards / house coefficient).
o If a player makes an incorrect match and the two cards belong to different houses, they lose points equal to (average score of the cards * House_1_coefficient * House_2_coefficient).
o House coefficients:
▪ Gryffindor : 2
▪ Slytherin : 2
▪ Hufflepuff : 1
▪ Ravenclaw : 1

Note: The individual scores of the cards are indicated in "photo9".

