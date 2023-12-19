# Roguelike-project
サンプル要望が多かったので作っていたら興が乗ったので、私の勉強がてら見様見真似で作ってみました。

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

### コンパイル
javac -d bin src/main/java/game/*.java src/main/java/game/equipments/*.java src/main/java/game/monsters/*.java

### 実行方法
java -cp bin game.Game
