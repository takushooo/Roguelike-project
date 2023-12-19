# 橘大学情報工学科オブジェクト指向プログラミング: 最終課題サンプル

サンプル要望が多かったので作っていたら興が乗ったので、勉強がてら見様見真似で作ってみました。

/src/test/にはteamsでも配布している、本来の最終課題サンプルコードが置いてあります。
満点を目指せるように頑張ってみてください。

確保した準備時間の都合上今年はここまで。
毎年講義のタイミングで合わせてアップデートしていくと面白いかもしれないと思いました。

[last update: Dec.19 2023]

## 課題要件
プログラム要件を形式的にでも満たしていることが最終課題満点の条件です。
各要点の達成具合によって加点こそすれど、減点することはありません。

流石にレポートサンプルは書いてませんので、ご了承ください。
やったことを書いてくれれば結構です。

出来なかったのであれば出来なかったなりに書けるレポートがあります。
「どこまで出来て、どこからが出来てないのか」を正確に言語化できることは、javaが書けることなんかよりも重要なオブジェクト指向のスキルです。
全てのプログラムの要件を満たせなかった場合にも、何らかの形で動くプログラムとそれなりのレポートが提出されていれば悪いようにはしません。

頑張ってみてね。

### プログラムの要件
1. 必ずオブジェクト指向を反映したコーディングであること．
2. 言語はJavaを使って，クラス・インターフェース・継承の全てを必ずプログラム中に含むこと
3. ソースは1つでもよいが，複数のクラスがあること．
4. 多様性を生かした処理があること
5. getter/setterを利用したフィールドアクセスを用いていること

### レポートの要件
+ フォーマット:
    + A4 2段組、2ページ以上、フォントサイズは10ptか10.5pt
    + 名前、学籍番号、適切な章立て、タイトルなどを加える
1. 作ったプログラムのコンセプト
    + なぜこれを作ろうと思ったか、着眼点、オブジェクト指向らしさとの兼ね合い
2. プログラムの流れと仕様
    + 何ができるプログラムなのか？
    + 定義したクラスやメソッドは何をしているのか？
    + 箇条書きでクラスの関係性など全体の大筋がわかるものでよい
3. どのあたりにオブジェクト指向を取り入れたか？
    + コーディングにあたって気を付けたもの、実装で工夫した箇所など
4. 講義の振り返り（感想、今後の抱負など）

## Roguelike-project
ここからは本レポジトリの説明。

授業資料がゲームベースなので、(たぶん)流行りのローグライクっぽいゲームを作ってみました。

### 遊び方
+ 各waveではプレイヤーのステータスがランダムに設定される
+ プレイヤーは攻撃するか防御するかを選びながら、魔物を倒していく
+ 10連勝したらゲームクリア，プレイヤーのHPが0になるとゲームオーバー
+ ゲームオーバーの場合，HP/攻撃力/防御力のいずれか1つを引き継いで次のwaveへ

## ディレクトリ構造
ゲーム開発経験があるわけではないので実際のところは知らないのですが、ChatGPT君的にはこういう構造が良いとのことです。
PCゲーム等をやっている人は、インストールフォルダにリソースファイルがどのように配置されているか見てみると面白いかもしれないです。
以下コピペ。
```
ProjectRoot/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── game/
│   │   │   │   ├── Game.java
│   │   │   │   ├── Player.java
│   │   │   │   ├── Character.java
│   │   │   │   ├── equipment/
│   │   │   │   │   └── Equipment.java
│   │   │   │   └── monsters/
│   │   │   │       ├── Monster.java
│   │   │   │       ├── Goblin.java
│   │   │   │       ├── Orc.java
│   │   │   │       └── Dragon.java
│   │   └── resources/
│   │       └── ... (リソースファイルなど)
│   └── test/
│       ├── java/
│       └── resources/
│
├── bin/ (コンパイルされたクラスファイル)
├── lib/ (依存ライブラリ)
└── README.md

```
+ src/main/java/ はすべてのJavaソースコードを含むディレクトリです。
+ game はあなたのゲームのメインパッケージです。
+ equipment や monsters のように、関連するクラスはサブパッケージに分類します。
+ src/main/resources/ はリソースファイル（画像、設定ファイルなど）を格納する場所です。
+ src/test/ はユニットテスト用のソースコードを含むディレクトリです。
+ bin/ はコンパイルされたクラスファイルを置くディレクトリです。
+ lib/ はプロジェクトで利用する外部ライブラリを格納するディレクトリです。

とのこと。

今回はテキストベースなのでリソースファイルなどはありません。

## 実行方法
覚えていられないので`compile.sh`と`run.sh`を用意しています。
```
./complie.sh
./run.sh
```

### コンパイル
javac -d bin src/main/java/game/*.java src/main/java/game/equipments/*.java src/main/java/game/monsters/*.java

### 実行方法
java -cp bin game.Game

## 拡張に向けたメモ
+ 装備品要素増やしたい
+ MP放置なので攻撃方法を複数パターン用意する