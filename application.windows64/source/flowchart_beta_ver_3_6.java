import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import controlP5.*; 
import java.io.File; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.io.BufferedWriter; 
import java.io.FileNotFoundException; 
import java.util.Arrays; 
import java.util.Iterator; 
import java.awt.datatransfer.Clipboard; 
import java.awt.datatransfer.Transferable; 
import java.awt.datatransfer.StringSelection; 
import java.awt.Toolkit; 
import controlP5.*; 
import java.util.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class flowchart_beta_ver_3_6 extends PApplet {



//インポート関係













//IP5関連1


ControlP5 cp5;

String textValue = "";

//グローバル変数の宣言
ArrayList<AbstractBlock> blocklist;
ArrayList<AbstractBlock> fixedblocklist;

AbstractBlock selectedBlock;
AbstractBlock Textfiled;

int selectx;
int selecty;

int colornumber=1;
int colornumber2=1;
int colornumber3=1;
int colornumber4=1;
int colornumber5=1;

int get_x;
int get_y;
int first;

int state;

int size[] = new int[2];
int state2;

Runtime r;

PImage img1, img2, img3, img4, img5, img6, img7, img8, img9, img10;

int cnt, cnt2;

String program, program2;

Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
StringSelection data = new StringSelection(program);

int lang;

int delete;
int hensu_state;
int out_state;

int delete_state;

int time;

//セットアップ関数
public void setup() {
  surface.setResizable(true);
  //画面サイズ変更
  
  surface.setLocation(-3, 0);
  //フォント指定
  textFont(createFont("Meiryo", 50));

  img1 = loadImage("ゴミ箱.png");
  img2 = loadImage("ゴミ箱2.png");
  img3 = loadImage("c.jpg");
  img4 = loadImage("c2.jpg");
  img5 = loadImage("コピー.png");
  img6 = loadImage("コピー２.png");
  img7 = loadImage("java.png");
  img8 = loadImage("java2.png");
  img9 = loadImage("変換.png");
  img10 = loadImage("変換2.png");

  cnt = 0;
  cnt2 = 0;

  size[0] = 20;
  size[1] = 10;
  state2=0;

  //IP5関連1
  cp5 = new ControlP5(this);

  get_x=0;
  get_y=0;
  first=0;

  state=0;

  program = "";
  program2 = "";

  lang = 0;

  delete= 0;

  hensu_state=0;

  out_state=0;

  delete_state=0;

  time = 0;

  fixedblocklist = new ArrayList<AbstractBlock>();
  blocklist = new ArrayList<AbstractBlock>();

  ////左側のブロックを生成
  fixedblocklist.add(new PushButton("", 1400, 740) );
  fixedblocklist.add(new PushButton2("", 825, 740) );
  fixedblocklist.add(new PushButton3("", 1300, 740) );
  fixedblocklist.add(new PushButton4("", 1500, 740) );
  fixedblocklist.add(new PushButton5("", 25, 750) );
  //fixedblocklist.add(new Block1("はじめ", 200, 50));
  fixedblocklist.add(new Block2("変数宣言", 50, 50));
  fixedblocklist.add(new Block3("代入", 50, 150));
  fixedblocklist.add(new Block4("条件分岐", 50, 250));
  fixedblocklist.add(new Block5("出力", 50, 350));
  fixedblocklist.add(new Block6("ループ", 50, 450));
  //fixedblocklist.add(new Block6_("forループ", 50, 550));
  fixedblocklist.add(new Block7("ループ終了", 50, 550));
  //fixedblocklist.add(new Block8("おわり", 50, 650));
  fixedblocklist.add(new Block9("線", 50, 600));

  //ファイルを読み込み
  final String FILE_NAME = "save.txt";
  String lineData[] = null;
  //テキストファイルを読む
  lineData = loadStrings( FILE_NAME );
  if ( lineData == null ) {
    //読み込み失敗
    println( FILE_NAME + " 読み込み失敗" );
    exit();
  }

  try {
    BufferedReader reader = createReader(FILE_NAME);
    String str, name;
    while ((str=reader.readLine())!=null) {
      String []data=str.split(",", 0);
      int x=Integer.parseInt(data[0]);
      int y=Integer.parseInt(data[1]);
      int blockID = Integer.parseInt(data[2]);
      name=data[3];

      switch(blockID) {
      case 1:
        blocklist.add(new Block11(name, x, y));
        cnt++;
        break;
      case 2:
        blocklist.add(new Block12_int(name, x, y));
        break;
      case 22:
        blocklist.add(new Block12_String(name, x, y));
        break;
      case 222:
        blocklist.add(new Block12_double(name, x, y));
        break;
      case 3:
        blocklist.add(new Block13(name, x, y));
        break;
      case 4:
        blocklist.add(new Block14(name, x, y));
        break;
      case 5:
        blocklist.add(new Block15(name, x, y));
        break;
      case 6:
        blocklist.add(new Block6_for(name, x, y));
        break;
      case 66:
        blocklist.add(new Block6_while(name, x, y));
        break;
      case 7:
        blocklist.add(new Block17(name, x, y));
        break;
      case 8:
        blocklist.add(new Block18(name, x, y));
        cnt2++;
        break;
      case 9:
        blocklist.add(new Block19("", x, y));
        break;
      case 11:
        blocklist.add(new Block21(name, x, y));
        break;
      case 12:
        blocklist.add(new Block22(name, x, y));
        break;
      case 13:
        blocklist.add(new Block23(name, x, y));
        break;
      case 14:
        blocklist.add(new Block24(name, x, y));
        break;
      case 15:
        blocklist.add(new Block25(name, x, y));
        break;
      case 16:
        blocklist.add(new Block26(name, x, y));
        break;
      case 17:
        blocklist.add(new Block27(name, x, y));
        break;
      case 18:
        blocklist.add(new Block28(name, x, y));
        break;
      case 19:
        blocklist.add(new Block29(name, x, y));
        break;
      }
    } 
    if (cnt==0) {
      blocklist.add(new Block11("はじめ", 400, 50));
    }
    if (cnt2==0) {
      blocklist.add(new Block18("おわり", 400, 730));
    }
  }
  catch(IOException e) {
    println( FILE_NAME + " 読み込み失敗" );
    exit();
  }
  catch(NumberFormatException e) {
    println( FILE_NAME + " データ破損！！！！！！" );
  }

  file_out3();
  file_in3();
  file_out6();
  file_in6();
}

public void draw() {
  background(0xfffffaf0);
  //strokeJoin(ROUND);
  stroke(0);
  //fill(0);
  rect(25, 25, 325, 700, 10);
  if (delete<=0) {
    //rect(25, 25, 175, 700, 10);
    line(195, 25, 195, 725);
  } else {
    //line(180,65,200,65);
    //line(180,65,200,115);
    //line(180,65,200,165);

    switch(delete_state) {
    case 1:
      line(25, 100, 195, 100);
      line(195, 100, 195, 200);
      line(195, 200, 350, 200);
      //delete_state=0;
      break;
    case 2:
      line(25, 500, 195, 500);
      line(195, 500, 195, 550);
      line(195, 550, 350, 550);
      line(25, 425, 195, 425);
      line(195, 425, 195, 375);
      line(195, 375, 350, 375);
      //delete_state=0;
      break;
    }
    //line();
    //line();
    //smooth(2);
    //beginShape() ;
    //vertex(25, 25);
    //vertex(350, 25);
    //vertex(350, 200);
    //vertex(200, 200);
    //vertex(200, 800);
    //vertex(25, 800);
    //vertex(25, 25);
  }
  rect(375, 25, 525, 775, 10);
  rect(925, 25, 650, 775, 10);
  stroke(243, 156, 18);

  textAlign(LEFT);
  text(program, 950, 50);
  //System.out.println(program);

  for (AbstractBlock block : blocklist) {
    block.display();
  }
  for (AbstractBlock block : fixedblocklist) {
    block.display();
  }

  if (colornumber2==1) {
    image(img1, 825, 740);
  } else {
    image(img2, 825, 740);
  }
  if (colornumber3==1) {
    image(img5, 1300, 740);
  } else {
    image(img6, 1300, 740);
  }
  if (lang==0) {
    image(img3, 1500, 740);
  }
  if (lang==1) {
    image(img7, 1500, 740);
  } 
  if (colornumber5==1) {
    image(img9, 1400, 740);
  } else {
    image(img10, 1400, 740);
  }


  Iterator it = fixedblocklist.iterator();
  while (it.hasNext()) {
    AbstractBlock value = (AbstractBlock)it.next();
    if (delete<=0) {
      if (value instanceof Block12_inttmp ||
        value instanceof Block12_Stringtmp ||
        value instanceof Block12_doubletmp ||
        value instanceof Block6_fortmp ||
        value instanceof Block6_whiletmp ) {
        it.remove();
      }
    }
    if (delete_state==1) {
      if (value instanceof Block6_fortmp ||
        value instanceof Block6_whiletmp ) {
        it.remove();
      }
    }
    if (delete_state==2) {
      if (value instanceof Block12_inttmp ||
        value instanceof Block12_Stringtmp ||
        value instanceof Block12_doubletmp) {
        it.remove();
      }
    }
  }
  textSize(15);
  text("図形ボックス", 70, 15);
  text("作成エリア", 410, 15);
  text("プログラム文", 970, 15);
  textSize(22);
  text("ヘルプ\n", 110, 787);
  textSize(15);
  text("※AdobeReader必須", 110, 790);


  if ((mouseX>=825&&mouseX<=880)&(mouseY>=740&&mouseY<=790)) {
    time++;
    if (time>=25) {
      textSize(15);
      text("図形を全削除", 850, 720);
    }
  } else if ((mouseX>=1300&&mouseX<=1355)&(mouseY>=740&&mouseY<=790)) {
    time++;
    if (time>=25) {
      textSize(15);
      text("クリップボードにコピー", 1325, 720);
    }
  } else if ((mouseX>=1400&&mouseX<=1455)&(mouseY>=740&&mouseY<=790)) {
    time++;
    if (time>=25) {
      textSize(15);
      text("メモ帳に保存", 1425, 720);
    }
  } else if ((mouseX>=1500&&mouseX<=1555)&(mouseY>=740&&mouseY<=790)) {
    time++;
    if (time>=25) {
      textSize(15);
      if(lang==0){
        text("C言語に変換", 1525, 720);
      }else{
        text("java言語に変換", 1520, 720);
      }
    }
  } else {
    time=0;
  }
}

public void mousePressed() {
  switch (mouseButton) {
  case LEFT:
    out_state=0;
    hensu_state=0;

    get_x=mouseX;
    get_y=mouseY;
    first=0;
    for (AbstractBlock block : fixedblocklist) {
      if (block.isPressed5()) {
        if (block instanceof Block9) {
          selectedBlock = new Block19("null", 50, 615);
          blocklist.add(selectedBlock);
          break;
        }
      }
      if (block.isPressed4()) {
        if (block instanceof PushButton) {
          System.out.println("変換ボタン押されたよ");
          colornumber5=0;
          if (lang == 1) {
            file_out();
            file_in();
            r = Runtime.getRuntime();
            try {
              r.exec("notepad data/henkan.txt");
            }
            catch(IOException e) {
              print(e);
            }
          } else if (lang == 0) {
            file_out4();
            file_in4();
            r = Runtime.getRuntime();
            try {
              r.exec("notepad data/henkan.txt");
            }
            catch(IOException e) {
              print(e);
            }
          }
          break;
        }
        if (block instanceof PushButton2) {
          System.out.println("削除ボタン押されたよ");
          colornumber2=0;
          //check=1;

          for ( int i=0; i<=100; i++ ) {
            Iterator it = blocklist.iterator();
            while (it.hasNext()) {
              AbstractBlock value = (AbstractBlock)it.next();
              if (value instanceof Block11 ||
                value instanceof Block12_int ||
                value instanceof Block12_String ||
                value instanceof Block12_double ||
                value instanceof Block13 ||
                value instanceof Block14 ||
                value instanceof Block15 ||
                value instanceof Block6_for ||
                value instanceof Block6_while ||
                value instanceof Block17 ||
                value instanceof Block18 ||
                value instanceof Block19 ||
                value instanceof Block21 ||
                value instanceof Block22 ||
                value instanceof Block23 ||
                value instanceof Block24 ||
                value instanceof Block25 ||
                value instanceof Block26 ||
                value instanceof Block27 ||
                value instanceof Block28 ||
                value instanceof Block29  ) {
                it.remove();
                cp5.remove("input1");
                break;
              }
            }
          }
          blocklist.add(new Block11("はじめ", 400, 50));
          blocklist.add(new Block18("おわり", 400, 730));
          program = "";
          program2 = "";
          if (lang == 1) {
            file_out2();
            file_in2();
            file_out5();
            file_in5();
          } else if (lang == 0) {
            file_out3();
            file_in3();
            file_out6();
            file_in6();
          }
          break;
        }
        if (block instanceof PushButton3) {
          data = new StringSelection(program2);
          clipboard.setContents(data, data);
          colornumber3=0;
        }
        if (block instanceof PushButton4) {
          program = "";
          program2 = "";
          if (lang == 1) {
            file_out3();
            file_in3();
            file_out6();
            file_in6();
            lang = 0;
          } else if (lang == 0) {
            file_out2();
            file_in2();
            file_out5();
            file_in5();
            lang = 1;
          }
        }
      }
      if (block.isPressed6()) {
        if (block instanceof PushButton5) {
          System.out.println("押されたああああああああああ");
          r = Runtime.getRuntime();
          try {
            r.exec("C:/Program Files (x86)/Adobe/Acrobat Reader DC/Reader/AcroRd32.exe data/readme.pdf");
          }
          catch(IOException e) {
            print(e);
          }
        }
      }
      if (block.isPressed()) {

        //if (block instanceof Block1) {
        //  selectedBlock = new Block11("はじめ", 50, 50);
        //  blocklist.add(selectedBlock);
        //  first=1;
        //  break;
        //}

        if (block instanceof Block2) {
          fixedblocklist.add(new Block12_inttmp("整数型", 213, 50) );
          fixedblocklist.add(new Block12_Stringtmp("文字列型", 213, 100) );
          fixedblocklist.add(new Block12_doubletmp("小数型", 213, 150) );
          //blocklist.add(new Block12_inttmp("整数型", 200, 50));
          //blocklist.add(new Block12_Stringtmp("文字列型", 200, 100));
          //blocklist.add(new Block12_doubletmp("小数型", 200, 150));

          delete_state=1;
          first=1;
          delete= 2;
          break;
        }
        if (block instanceof Block12_inttmp) {
          System.out.print("追加1");
          selectedBlock = new Block12_int("null", 200, 50);
          blocklist.add(selectedBlock);
          first=1;
          hensu_state=1;
          break;
        }
        if (block instanceof Block12_Stringtmp) {
          System.out.print("追加2");
          selectedBlock = new Block12_String("null", 200, 100);
          blocklist.add(selectedBlock);
          first=1;
          hensu_state=2;
          break;
        }
        if (block instanceof Block12_doubletmp) {
          System.out.print("追加3");
          selectedBlock = new Block12_double("null", 200, 150);
          blocklist.add(selectedBlock);
          first=1;
          hensu_state=3;
          break;
        }

        if (block instanceof Block3) {
          selectedBlock = new Block13("null", 50, 150);
          blocklist.add(selectedBlock);
          first=1;
          break;
        }
        if (block instanceof Block5) {
          selectedBlock = new Block15("null", 50, 350);
          blocklist.add(selectedBlock);
          first=1;
          out_state=0;
          break;
        }
        if (block instanceof Block6) {
          fixedblocklist.add(new Block6_fortmp("for", 213, 400) );
          fixedblocklist.add(new Block6_whiletmp("while", 213, 500) );
          delete_state=2;
          first=1;
          delete= 2;
          break;
        }
        if (block instanceof Block6_fortmp) {
          //System.out.print("追加1");
          selectedBlock = new Block6_for("null", 200, 400);
          blocklist.add(selectedBlock);
          first=1;
          hensu_state=4;
          break;
        }
        if (block instanceof Block6_whiletmp) {
          //System.out.print("追加1");
          selectedBlock = new Block6_while("null", 200, 500);
          blocklist.add(selectedBlock);
          first=1;
          hensu_state=5;
          break;
        }
        if (block instanceof Block7) {
          selectedBlock = new Block17("ループ終了", 50, 550);
          blocklist.add(selectedBlock);
          first=1;
          break;
        }
        //if (block instanceof Block8) {
        //  selectedBlock = new Block18("おわり", 50, 800);
        //  blocklist.add(selectedBlock);
        //  first=1;
        //  break;
        //}
      }
      if (block.isPressed2()) {
        //if (block instanceof Block9) {
        //  selectedBlock = new Block19("null", 50, 7000);
        //  blocklist.add(selectedBlock);
        //  break;
        //}
      }
      if (block.isPressed3()) {
        if (block instanceof Block4) {
          selectedBlock = new Block14("null", 50, 250);
          blocklist.add(selectedBlock);
          first=1;
          break;
        }
      }
    }
    for (AbstractBlock block : blocklist) {
      if (block.isPressed()) {
        //if (block instanceof Block12_inttmp) {
        //  System.out.print("追加1");
        //  selectedBlock = new Block12_int("null", 200, 50);
        //  blocklist.add(selectedBlock);
        //  first=1;
        //  hensu_state=1;
        //  break;
        //}
        //if (block instanceof Block12_Stringtmp) {
        //  System.out.print("追加2");
        //  selectedBlock = new Block12_String("null", 200, 100);
        //  blocklist.add(selectedBlock);
        //  first=1;
        //  hensu_state=2;
        //  break;
        //}
        //if (block instanceof Block12_doubletmp) {
        //  System.out.print("追加3");
        //  selectedBlock = new Block12_double("null", 200, 150);
        //  blocklist.add(selectedBlock);
        //  first=1;
        //  hensu_state=3;
        //  break;
        //}
        if (block instanceof Block11 ||
          block instanceof Block13 ||
          block instanceof Block17 ||
          block instanceof Block18 ||
          block instanceof Block21 ||
          block instanceof Block22 ||
          block instanceof Block23 ||
          block instanceof Block26 ||
          block instanceof Block27 ||
          block instanceof Block28  ) {
          selectedBlock=block;
          Textfiled=block;
          break;
        }
        if ( block instanceof Block12_int ) {
          selectedBlock=block;
          hensu_state=1;
          Textfiled=block;
          break;
        }
        if ( block instanceof Block12_String ) {
          selectedBlock=block;
          hensu_state=2;
          Textfiled=block;
          break;
        }
        if ( block instanceof Block12_double ) {
          selectedBlock=block;
          hensu_state=3;
          Textfiled=block;
          break;
        }
        if ( block instanceof Block6_for ) {
          selectedBlock=block;
          hensu_state=4;
          Textfiled=block;
          break;
        }
        if ( block instanceof Block6_while ) {
          selectedBlock=block;
          hensu_state=5;
          Textfiled=block;
          break;
        }
        if (block instanceof Block15 || block instanceof Block25  ) {
          selectedBlock=block;
          out_state=1;
          Textfiled=block;
          break;
        }
      }
      if (block.isPressed2()) {
        if ( block instanceof Block19 ||
          block instanceof Block29 ) {
          selectedBlock=block;
          Textfiled=block;
          break;
        }
      }
      if (block.isPressed3()) {
        if ( block instanceof Block14 ||
          block instanceof Block24 ) {
          selectedBlock=block;
          Textfiled=block;
          break;
        }
      }
    }  
    break;
  case RIGHT:
    Iterator it = blocklist.iterator();
    while (it.hasNext())
    {
      AbstractBlock value = (AbstractBlock)it.next();

      if (value instanceof Block12_int ||
        value instanceof Block12_String ||
        value instanceof Block12_double ||
        value instanceof Block13 ||
        value instanceof Block15 ||
        value instanceof Block6_for ||
        value instanceof Block6_while ||
        value instanceof Block17 ||
        value instanceof Block22 ||
        value instanceof Block23 ||
        value instanceof Block25 ||
        value instanceof Block26 ||
        value instanceof Block27  ) {
        if (value.isPressed()) {
          it.remove();
          cp5.remove("input1");
          break;
        }
      }
      if ( value instanceof Block19 ||
        value instanceof Block29 ) {
        if (value.isPressed2()) {

          it.remove();
          cp5.remove("input1");
          break;
        }
      }
      if ( value instanceof Block14 ||
        value instanceof Block24 ) {
        if (value.isPressed3()) {

          it.remove();
          cp5.remove("input1");
          break;
        }
      }
    }
    program = "";
    program2 = "";
    if (lang == 1) {
      file_out2();
      file_in2();
      file_out5();
      file_in5();
    } else if (lang == 0) {
      file_out3();
      file_in3();
      file_out6();
      file_in6();
    }
    break;
  }
  delete--;
}


//テキストボックス
public void input1(String theText) {
  if (Textfiled!=null) {
    cp5.remove("input1");
    state=0;
    if (theText.equals("")) {
    } else {
      //if (theText.length()>=8) {
      //  state2=1;
      Textfiled.name=theText;
      if (out_state==1) {
        out_state=0;
        Textfiled.name=Textfiled.name+("を出力");
      }
      switch(hensu_state) {
      case 1:
        hensu_state=0;
        Textfiled.name=Textfiled.name+("(整数型)");
        break;
      case 2:
        hensu_state=0;
        Textfiled.name=Textfiled.name+("(文字列型)");
        break;
      case 3:
        hensu_state=0;
        Textfiled.name=Textfiled.name+("(小数型)");
        break;
      case 4:
        hensu_state=0;
        Textfiled.name=Textfiled.name+("");
        break;
      case 5:
        hensu_state=0;
        Textfiled.name=Textfiled.name+("");
        break;
      }
      //} else {
      //  state2=0;
      //  Textfiled.name=theText;
      //}
    }
    program = "";
    program2 = "";
    if (lang == 1) {
      file_out2();
      file_in2();
      file_out5();
      file_in5();
    } else if (lang == 0) {
      file_out3();
      file_in3();
      file_out6();
      file_in6();
    }
  }
}

public void mouseClicked(MouseEvent evt) {
  //if (evt.getCount() == 3) {
  //  int i=0;
  //  for (AbstractBlock block : blocklist) {
  //    if (block.isPressed()) {
  //      if (block instanceof Block16) {
  //        System.exit(0);
  //        break;
  //      }
  //    }
  //  }
  //}
  if (evt.getCount() == 2) {
    int i=0;
    for (AbstractBlock block : blocklist) {
      if (block.isPressed()) {
        cp5.remove("input1");
        //if (block instanceof Block11) {
        //  blocklist.set(i, new Block21(block.name, block.x, block.y));
        //  break;
        //}
        if (block instanceof Block13) {
          blocklist.set(i, new Block23(block.name, block.x, block.y));
          break;
        }

        if (block instanceof Block15) {
          blocklist.set(i, new Block25(block.name, block.x, block.y));
          break;
        }
        //if (block instanceof Block16) {
        //  blocklist.set(i, new Block26(block.name, block.x, block.y));
        //  break;
        //}
        if (block instanceof Block17) {
          blocklist.set(i, new Block27(block.name, block.x, block.y));
          break;
        }
        if (block instanceof Block18) {
          blocklist.set(i, new Block28(block.name, block.x, block.y));
          break;
        }

        if (block instanceof Block21) {
          blocklist.set(i, new Block11(block.name, block.x, block.y));
          break;
        }
        if (block instanceof Block23) {
          blocklist.set(i, new Block13(block.name, block.x, block.y));
          break;
        }

        if (block instanceof Block25) {
          blocklist.set(i, new Block15(block.name, block.x, block.y));
          break;
        }
        //if (block instanceof Block26) {
        //  blocklist.set(i, new Block16(block.name, block.x, block.y));
        //  break;
        //}
        if (block instanceof Block27) {
          blocklist.set(i, new Block17(block.name, block.x, block.y));
          break;
        }
        if (block instanceof Block28) {
          blocklist.set(i, new Block18(block.name, block.x, block.y));
          break;
        }
      }
      if (block.isPressed2()) {
        if (block instanceof Block19) {
          blocklist.set(i, new Block29("曲げた", block.x, block.y));
          break;
        }
        if (block instanceof Block29) {
          blocklist.set(i, new Block19("null", block.x, block.y));
          break;
        }
      }
      i++;
    }
    program = "";
    program2 = "";
    if (lang == 1) {
      file_out2();
      file_in2();
      file_out5();
      file_in5();
    } else if (lang == 0) {
      file_out3();
      file_in3();
      file_out6();
      file_in6();
    }
  }
}

public void mouseDragged() {

  if (selectedBlock != null) {
    selectedBlock.move(mouseX - pmouseX, mouseY - pmouseY);
  }
}
public void mouseReleased() {
  if (selectedBlock != null) {
    for (AbstractBlock block : blocklist) {
      if (selectedBlock instanceof Block12_int ||
        selectedBlock instanceof Block12_String ||
        selectedBlock instanceof Block12_double ||
        selectedBlock instanceof Block13 ||
        selectedBlock instanceof Block14 ||
        selectedBlock instanceof Block15 ||
        selectedBlock instanceof Block6_for ||
        selectedBlock instanceof Block6_while ||
        selectedBlock instanceof Block22 ||
        selectedBlock instanceof Block23 ||
        selectedBlock instanceof Block25 ||
        selectedBlock instanceof Block26) {
        if (state==1||first==1||get_x==mouseX&&get_y==mouseY) {
          System.out.print("テキストボックス追加");
          cp5.addTextfield("input1")
            .setPosition(selectedBlock.x-10, selectedBlock.y)
            .setSize(150, 35)
            .setFont(createFont("Meiryo", 15))
            .setFocus(true)
            .setColor(color(255, 255, 255))
            ;
          state=1;
        }
        selectx=selectedBlock.x-10;
        selecty=selectedBlock.y;
      }

      if (selectedBlock != block &&  block.canConnect(selectedBlock)) {
        //複数ブロックの移動の時のために、指定した座標に移動させるのではなく
        //必ず移動量を指定して移動させるようにする。
        int addX = block.x - selectedBlock.x;
        int addY = (block.y + block.h) - selectedBlock.y;
        selectedBlock.move(addX, addY+40);
      }
      if (block instanceof Block14) {
        if (selectedBlock != block &&  block.canConnect2(selectedBlock)) {
          //複数ブロックの移動の時のために、指定した座標に移動させるのではなく
          //必ず移動量を指定して移動させるようにする。
          int addX = (block.x +block.w)- selectedBlock.x;
          int addY = (block.y +block.h)- selectedBlock.y;
          selectedBlock.move(addX+30, addY+40);
        }
      }
      //if (block.x < 150 || block.x > 700 || block.y < 0 || block.y > 800) {
      if (block.x < 250 || block.x > 900 || block.y < 0 || block.y > 800) {
        Iterator it = blocklist.iterator();
        while (it.hasNext()) {
          AbstractBlock value = (AbstractBlock)it.next();
          //System.out.print("通ったよ");
          if (value instanceof Block12_int ||
            value instanceof Block12_String ||
            value instanceof Block12_double ||
            value instanceof Block13 ||
            value instanceof Block15 ||
            value instanceof Block6_for ||
            value instanceof Block6_while ||
            value instanceof Block17 ||
            value instanceof Block22 ||
            value instanceof Block23 ||
            value instanceof Block25 ||
            value instanceof Block26 ||
            value instanceof Block27  ) {
            if (value.isPressed()) {
              //System.out.print("通ったよ!!!!");
              it.remove();
              cp5.remove("input1");
              program = "";
              program2 = "";
              if (lang == 1) {
                file_out2();
                file_in2();
                file_out5();
                file_in5();
              } else if (lang == 0) {
                file_out3();
                file_in3();
                file_out6();
                file_in6();
              }
              break;
            }
          } else if (value instanceof Block11 ) {
            if (value.isPressed()) {
              it.remove();
              blocklist.add(new Block11("はじめ", 400, 50));
              program = "";
              program2 = "";
              if (lang == 1) {
                file_out2();
                file_in2();
                file_out5();
                file_in5();
              } else if (lang == 0) {
                file_out3();
                file_in3();
                file_out6();
                file_in6();
              }
              break;
            }
          } else if (value instanceof Block18) {
            if (value.isPressed()) {
              it.remove();
              blocklist.add(new Block18("おわり", 400, 730));
              program = "";
              program2 = "";
              if (lang == 1) {
                file_out2();
                file_in2();
                file_out5();
                file_in5();
              } else if (lang == 0) {
                file_out3();
                file_in3();
                file_out6();
                file_in6();
              }
              break;
            }
          }
          if ( value instanceof Block19 ||
            value instanceof Block29 ) {
            if (value.isPressed2()) {

              it.remove();
              cp5.remove("input1");
              program = "";
              program2 = "";
              if (lang == 1) {
                file_out2();
                file_in2();
                file_out5();
                file_in5();
              } else if (lang == 0) {
                file_out3();
                file_in3();
                file_out6();
                file_in6();
              }
              break;
            }
          }
          if ( value instanceof Block14 ||
            value instanceof Block24 ) {
            if (value.isPressed3()) {

              it.remove();
              cp5.remove("input1");
              program = "";
              program2 = "";
              if (lang == 1) {
                file_out2();
                file_in2();
                file_out5();
                file_in5();
              } else if (lang == 0) {
                file_out3();
                file_in3();
                file_out6();
                file_in6();
              }
              break;
            }
          }
        }
        break;
      } else {
        program = "";
        program2 = "";
        if (lang == 1) {
          file_out2();
          file_in2();
          file_out5();
          file_in5();
        } else if (lang == 0) {
          file_out3();
          file_in3();
          file_out6();
          file_in6();
        }
      }
    }
  }
  colornumber=1;
  colornumber2=1;
  colornumber3=1;
  colornumber4=1;
  colornumber5=1;
  selectedBlock = null;   //ドラッグ終了のため選択されたブロックは必ずnullに
}

public void dispose() {

  String savefile = "data/save.txt";
  PrintWriter writer= createWriter(savefile);
  for (AbstractBlock block : blocklist) {
    if (block instanceof Block11) {
      writer.println(block.x +","+block.y+","+1+","+block.name);
    }
    if (block instanceof Block12_int) {
      writer.println(block.x +","+block.y+","+2+","+block.name);
    }
    if (block instanceof Block12_String) {
      writer.println(block.x +","+block.y+","+22+","+block.name);
    }
    if (block instanceof Block12_double) {
      writer.println(block.x +","+block.y+","+222+","+block.name);
    }
    if (block instanceof Block13) {
      writer.println(block.x+ ","+block.y+","+3+","+block.name);
    }
    if (block instanceof Block14) {
      writer.println(block.x +","+block.y+","+4+","+block.name);
    }
    if (block instanceof Block15) {
      writer.println(block.x +","+block.y+","+5+","+block.name);
    }
    if (block instanceof Block6_for) {
      writer.println(block.x +","+block.y+","+6+","+block.name);
    }
    if (block instanceof Block6_while) {
      writer.println(block.x +","+block.y+","+66+","+block.name);
    }
    if (block instanceof Block17) {
      writer.println(block.x +","+block.y+","+7+","+block.name);
    }
    if (block instanceof Block18) {
      writer.println(block.x +","+block.y+","+8+","+block.name);
    }
    if (block instanceof Block19) {
      writer.println(block.x +","+block.y+","+9+","+"null");
    }
    if (block instanceof Block21) {
      writer.println(block.x +","+block.y+","+11+","+block.name);
    }
    if (block instanceof Block22) {
      writer.println(block.x +","+block.y+","+12+","+block.name);
    }
    if (block instanceof Block23) {
      writer.println(block.x +","+block.y+","+13+","+block.name);
    }
    if (block instanceof Block24) {
      writer.println(block.x +","+block.y+","+14+","+block.name);
    }
    if (block instanceof Block25) {
      writer.println(block.x +","+block.y+","+15+","+block.name);
    }
    if (block instanceof Block26) {  
      writer.println(block.x +","+block.y+","+16+","+block.name);
    }
    if (block instanceof Block27) {
      writer.println(block.x +","+block.y+","+17+","+block.name);
    }
    if (block instanceof Block28) {
      writer.println(block.x +","+block.y+","+18+","+block.name);
    }
    if (block instanceof Block29) {
      writer.println(block.x +","+block.y+","+19+","+block.name);
    }
  }
  writer.close();
}
abstract class AbstractBlock {

  public String name;
  public int x, y, w, h;

  protected AbstractBlock(String name, int x, int y) {
    this.name = name;
    this.x = x;
    this.y = y;
    w = 120; 
    h = 30;
  }

  abstract public void display();
  public void move(int addX, int addY) {
    x += addX;
    y += addY;
  }

  public boolean isPressed() {
    return x <= mouseX && mouseX <= x + w &&
      y <= mouseY && mouseY <= y + h;
  }
  public boolean isPressed2() {
    return x+40 <= mouseX && mouseX <= x +80 &&
      y <= mouseY && mouseY <= y + h + 80;
  }
  public boolean isPressed3() {
    return x-20 <= mouseX && mouseX <= x + w +20 &&
      y -30<= mouseY && mouseY <= y + h +30;
  }
  public boolean isPressed4() {
    return x <= mouseX && mouseX <= x +55 &&
      y <= mouseY && mouseY <= y+55;
  }
  public boolean isPressed5() {
    return x + 40 <= mouseX && mouseX <= x +80 &&
      y + 40 <= mouseY && mouseY <= y+80;
  }
  public boolean isPressed6() {
    return x <= mouseX && mouseX <= x + 175 &&
      y  <= mouseY && mouseY <= y + 50;
  }
  public boolean isReleased() {
    return x > mouseX;
  }
  
  private int margin = 40;    //許容する二つのブロックの距離の差。適宜変更したり、xとy座標でそれぞれ分けるのもありです
  public boolean canConnect(AbstractBlock block) {
    int bx = block.x;
    int by = block.y;
    //abs()は引数の絶対値を返す関数
    //yに関しては相手のブロックの「底」と比較するためにhを足すのを忘れないように
    return abs(x - bx) <= margin && abs(y + h  - by) <= margin;
  }
  private int margin2 = 60;
  public boolean canConnect2(AbstractBlock block) {
    int bx = block.x;
    int by = block.y;
    return abs(x + w - bx) <= margin2 && abs(y - by) <= margin2;
  }
}
//変換ボタン
class PushButton extends AbstractBlock {
  public PushButton(String name, int x, int y) {
    super(name, x, y);
  }
  int[] colorPallet ={color(255, 0, 0), 
    color(255, 100, 100)};

  public void display() {
    fill(colorPallet [colornumber]); 
    rect(x, y, 54, 54);
    noFill();
    strokeWeight(2);

    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class PushButton2 extends AbstractBlock {
  public PushButton2(String name, int x, int y) {
    super(name, x, y);
  }
  int[] colorPallet ={color(255, 0, 0), 
    color(255, 100, 100)};

  public void display() {
    fill(colorPallet [colornumber2]); 
    rect(x, y, 54, 54);   
    noFill();
    strokeWeight(2);


    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class PushButton3 extends AbstractBlock {
  public PushButton3(String name, int x, int y) {
    super(name, x, y);
  }
  int[] colorPallet ={color(255, 0, 0), 
    color(255, 100, 100)};

  public void display() {
    fill(colorPallet [colornumber2]); 
    rect(x, y, 54, 54);   
    noFill();
    strokeWeight(2);


    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class PushButton4 extends AbstractBlock {
  public PushButton4(String name, int x, int y) {
    super(name, x, y);
  }
  int[] colorPallet ={color(255, 0, 0), 
    color(255, 100, 100)};

  public void display() {
    fill(colorPallet [colornumber2]); 
    rect(x, y, 54, 54);   
    noFill();
    strokeWeight(2);


    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class PushButton5 extends AbstractBlock {
  public PushButton5(String name, int x, int y) {
    super(name, x, y);
  }
  int[] colorPallet ={color(255, 100, 100), 
    color(255, 100, 100)};

  public void display() {
    fill(colorPallet [colornumber2]); 
    rect(x, y, 175, 50);   
    noFill();
    strokeWeight(2);


    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

//はじめ
class Block1 extends AbstractBlock {
  public Block1(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    fill(241, 196, 15); 
    rect(x, y, w, h, 15);   
    noFill();
    strokeWeight(2);
    stroke(200, 0, 0);

    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class Block2 extends AbstractBlock {
  public Block2(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    fill(0xffff8205); 
    //rect(x, y, w, h, 0); 
    beginShape() ;
    vertex(x, y);
    vertex(x+120, y);
    vertex(x+130, y+15);
    vertex(x+120, y+30);
    vertex(x, y+30);
    vertex(x-10, y+15);
    vertex(x, y);

    endShape(CLOSE);
    noFill();
    strokeWeight(2);
    stroke(200, 0, 0);


    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}


class Block3 extends AbstractBlock {
  public Block3(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    fill(241, 196, 15); 
    rect(x, y, w, h, 0);   
    noFill();
    strokeWeight(2);

    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class Block4 extends AbstractBlock {
  public Block4(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    beginShape() ;
    fill(241, 196, 15);
    int R;
    for (int i = 0; i < 4; i++) {
      if (i % 2 == 0) {
        R = 40;
      } else {
        R = 80;
      }
      vertex(x+60+R*sin(radians(90*i)), y+15+R*cos(radians(90*i)));
    }
    endShape(CLOSE);
    noFill();
    strokeWeight(2);
    stroke(200, 0, 0);


    fill(0);
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class Block5 extends AbstractBlock {
  public Block5(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    fill(241, 196, 15); 
    beginShape();
    vertex(x+20, y);
    vertex(x+130, y);
    vertex(x+100, y+30);
    vertex(x-10, y+30);
    endShape(CLOSE);
    noFill();
    strokeWeight(2);

    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class Block6 extends AbstractBlock {
  public Block6(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    fill(0xffff8205); 
    beginShape();
    vertex(x+10, y);
    vertex(x+115, y);
    vertex(x+125, y+10);
    vertex(x+125, y+30);
    vertex(x, y+30);
    vertex(x, y+10);
    endShape(CLOSE);
    noFill();
    strokeWeight(2);

    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class Block6_fortmp extends AbstractBlock {
  public Block6_fortmp(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    //fill(241, 196, 15); 
    beginShape();
    vertex(x+10, y);
    vertex(x+115, y);
    vertex(x+125, y+10);
    vertex(x+125, y+30);
    vertex(x, y+30);
    vertex(x, y+10);
    endShape(CLOSE);
    //noFill();
    strokeWeight(2);

    //fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class Block6_whiletmp extends AbstractBlock {
  public Block6_whiletmp(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    //fill(241, 196, 15); 
    beginShape();
    vertex(x+10, y);
    vertex(x+115, y);
    vertex(x+125, y+10);
    vertex(x+125, y+30);
    vertex(x, y+30);
    vertex(x, y+10);
    endShape(CLOSE);
    //noFill();
    strokeWeight(2);

    //fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class Block6_for extends AbstractBlock {
  public Block6_for(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    fill(241, 196, 15); 
    beginShape();
    vertex(x+10, y);
    vertex(x+115, y);
    vertex(x+125, y+10);
    vertex(x+125, y+30);
    vertex(x, y+30);
    vertex(x, y+10);
    endShape(CLOSE);
    noFill();
    strokeWeight(2);
    line(x+60, y+30, x+60, y+80);

    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class Block6_while extends AbstractBlock {
  public Block6_while(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    fill(241, 196, 15); 
    beginShape();
    vertex(x+10, y);
    vertex(x+115, y);
    vertex(x+125, y+10);
    vertex(x+125, y+30);
    vertex(x, y+30);
    vertex(x, y+10);
    endShape(CLOSE);
    noFill();
    strokeWeight(2);
    line(x+60, y+30, x+60, y+80);

    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class Block7 extends AbstractBlock {
  public Block7(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    fill(241, 196, 15); 
    beginShape();
    vertex(x, y);
    vertex(x+125, y);
    vertex(x+125, y+20);
    vertex(x+115, y+30);
    vertex(x+10, y+30);
    vertex(x, y+20);
    endShape(CLOSE);
    noFill();
    strokeWeight(2);

    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class Block8 extends AbstractBlock {
  public Block8(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    fill(241, 196, 15); 
    rect(x, y, w, h, 15); 
    noFill();
    strokeWeight(2);
    stroke(200, 0, 0);

    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class Block9 extends AbstractBlock {
  public Block9(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    fill(241, 196, 15); 
    rect(x+40, y+35, 40, 40);  
    noFill();
    strokeWeight(2);
    stroke(200, 0, 0);
    
    fill(0); 
    textAlign(CENTER, CENTER);
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h +20);
    noFill();
  }
}

class Block11 extends AbstractBlock {
  public Block11(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    fill(241, 196, 15); 
    rect(x, y, w, h, 15);   
    noFill();
    strokeWeight(2);

    line(x+60, y+30, x+60, y+70);

    stroke(200, 0, 0);
    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class Block12_inttmp extends AbstractBlock {
  public Block12_inttmp(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    
    // fill(241, 196, 15); 
    //rect(x, y, w, h, 15);   
    //noFill();
    //strokeWeight(2);
    //stroke(200, 0, 0);

    //fill(0);   
    //textAlign(CENTER, CENTER); 
    //strokeWeight(3);
    //stroke(243, 156, 18);
    //textSize(20);
    //text(name, x + w / 2, y + h / 3);
    
    //fill(241, 196, 15); 
    //rect(x, y, w, h, 0); 
    beginShape() ;
    vertex(x, y);
    vertex(x+120, y);
    vertex(x+130, y+15);
    vertex(x+120, y+30);
    vertex(x, y+30);
    vertex(x-10, y+15);
    vertex(x, y);
    endShape(CLOSE);
    //line(x+60, y+30, x+60, y+80);
    
    //noFill();
    strokeWeight(2);
    stroke(200, 0, 0);


    //fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class Block12_doubletmp extends AbstractBlock {
  public Block12_doubletmp(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {



    //fill(241, 196, 15); 
    //rect(x, y, w, h, 0); 
    beginShape() ;
    vertex(x, y);
    vertex(x+120, y);
    vertex(x+130, y+15);
    vertex(x+120, y+30);
    vertex(x, y+30);
    vertex(x-10, y+15);
    vertex(x, y);
    endShape(CLOSE);
    
    //line(x+60, y+30, x+60, y+80);

    
    //noFill();
    strokeWeight(2);
    stroke(200, 0, 0);


    //fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class Block12_Stringtmp extends AbstractBlock {
  public Block12_Stringtmp(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {



    //fill(241, 196, 15); 
    //rect(x, y, w, h, 0); 
    beginShape() ;
    vertex(x, y);
    vertex(x+120, y);
    vertex(x+130, y+15);
    vertex(x+120, y+30);
    vertex(x, y+30);
    vertex(x-10, y+15);
    vertex(x, y);
    endShape(CLOSE);
    
    //line(x+60, y+30, x+60, y+80);

    
    //noFill();
    strokeWeight(2);
    stroke(200, 0, 0);


    //fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}
class Block12_int extends AbstractBlock {
  public Block12_int(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {



    fill(241, 196, 15); 
    //rect(x, y, w, h, 0); 
    beginShape() ;
    vertex(x, y);
    vertex(x+120, y);
    vertex(x+130, y+15);
    vertex(x+120, y+30);
    vertex(x, y+30);
    vertex(x-10, y+15);
    vertex(x, y);
    strokeWeight(2);
    line(x+60, y+30, x+60, y+70);

    endShape(CLOSE);
    noFill();
    stroke(200, 0, 0);


    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class Block12_double extends AbstractBlock {
  public Block12_double(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {



    fill(241, 196, 15); 
    //rect(x, y, w, h, 0); 
    beginShape() ;
    vertex(x, y);
    vertex(x+120, y);
    vertex(x+130, y+15);
    vertex(x+120, y+30);
    vertex(x, y+30);
    vertex(x-10, y+15);
    vertex(x, y);
    strokeWeight(2);
    line(x+60, y+30, x+60, y+70);

    endShape(CLOSE);
    noFill();
    stroke(200, 0, 0);


    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class Block12_String extends AbstractBlock {
  public Block12_String(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {



    fill(241, 196, 15); 
    //rect(x, y, w, h, 0); 
    beginShape() ;
    vertex(x, y);
    vertex(x+120, y);
    vertex(x+130, y+15);
    vertex(x+120, y+30);
    vertex(x, y+30);
    vertex(x-10, y+15);
    vertex(x, y);
    strokeWeight(2);
    line(x+60, y+30, x+60, y+70);

    endShape(CLOSE);
    noFill();
    stroke(200, 0, 0);


    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class Block13 extends AbstractBlock {
  public Block13(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {

    fill(241, 196, 15); 
    rect(x, y, w, h, 0);   
    noFill();
    strokeWeight(2);
    line(x+60, y+30, x+60, y+70);

    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class Block14 extends AbstractBlock {
  public Block14(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    beginShape() ;
    fill(241, 196, 15);
    int R;
    for (int i = 0; i < 4; i++) {
      if (i % 2 == 0) {
        R = 40;
      } else {
        R = 80;
      }
      vertex(x+60+R*sin(radians(90*i)), y+15+R*cos(radians(90*i)));
    }
    endShape(CLOSE);
    noFill();
    strokeWeight(2);

    line(x+60, y+55, x+60, y+70);
    line(x+140, y+15, x+210, y+15);
    line(x+210, y+15, x+210, y+70);
    stroke(200, 0, 0);
    fill(0);
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
    textSize(10);
    text("YES", x + w /2-20, y + h+30);
    text("NO", x + w + 30, y + h / 3 -8);
  }
}

class Block15 extends AbstractBlock {
  public Block15(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    fill(241, 196, 15); 
    beginShape();
    vertex(x+20, y);
    vertex(x+130, y);
    vertex(x+100, y+30);
    vertex(x-10, y+30);
    endShape(CLOSE);
    noFill();
    strokeWeight(2);
    line(x+60, y+30, x+60, y+70);

    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(size[state2]);
    text(name, x + w / 2, y + h / 3);
  }
}


//class Block16 extends AbstractBlock {
//  public Block16(String name, int x, int y) {
//    super(name, x, y);
//  }
//  public void display() {
//    fill(241, 196, 15); 
//    beginShape();
//    vertex(x+10, y);
//    vertex(x+115, y);
//    vertex(x+125, y+10);
//    vertex(x+125, y+30);
//    vertex(x, y+30);
//    vertex(x, y+10);
//    endShape(CLOSE);
//    noFill();
//    strokeWeight(2);
//    line(x+60, y+30, x+60, y+80);

//    fill(0);   
//    textAlign(CENTER, CENTER); 
//    strokeWeight(3);
//    stroke(243, 156, 18);
//    textSize(20);
//    text(name, x + w / 2, y + h / 3);
//  }
//}

class Block17 extends AbstractBlock {
  public Block17(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    fill(241, 196, 15); 
    beginShape();
    vertex(x, y);
    vertex(x+125, y);
    vertex(x+125, y+20);
    vertex(x+115, y+30);
    vertex(x+10, y+30);
    vertex(x, y+20);
    endShape(CLOSE);
    noFill();
    strokeWeight(2);
    line(x+60, y+30, x+60, y+70);

    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}


class Block18 extends AbstractBlock {
  public Block18(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    fill(241, 196, 15); 
    rect(x, y, w, h, 15); 
    noFill();
    strokeWeight(2);
    stroke(200, 0, 0);

    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class Block19 extends AbstractBlock {
  public Block19(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    noFill();
    strokeWeight(2);
    stroke(243, 156, 18);
    line(x+60, y, x+60, y+70);
  }
}

class Block21 extends AbstractBlock {
  public Block21(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    fill(241, 196, 15); 
    rect(x, y, w, h, 15);   
    noFill();
    strokeWeight(2);

    stroke(243, 156, 18);
    line(x+60, y+30, x+60, y+50);
    line(x+60, y+50, x-90, y+50);
    line(x-90, y+50, x-80, y+45);
    line(x-90, y+50, x-80, y+55);

    stroke(200, 0, 0);
    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}


class Block22 extends AbstractBlock {
  public Block22(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    fill(241, 196, 15); 
    //rect(x, y, w, h, 0); 
    beginShape() ;
    vertex(x, y);
    vertex(x+120, y);
    vertex(x+130, y+15);
    vertex(x+120, y+30);
    vertex(x, y+30);
    vertex(x-10, y+15);
    vertex(x, y);
    strokeWeight(2);
    stroke(243, 156, 18);
    line(x+60, y+30, x+60, y+50);
    line(x+60, y+50, x-90, y+50);
    line(x-90, y+50, x-80, y+45);
    line(x-90, y+50, x-80, y+55);

    endShape(CLOSE);
    noFill();
    stroke(200, 0, 0);


    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class Block23 extends AbstractBlock {
  public Block23(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    fill(241, 196, 15); 
    rect(x, y, w, h, 0);   
    noFill();
    strokeWeight(2);
    stroke(243, 156, 18);
    line(x+60, y+30, x+60, y+50);
    line(x+60, y+50, x-90, y+50);
    line(x-90, y+50, x-80, y+45);
    line(x-90, y+50, x-80, y+55);

    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class Block24 extends AbstractBlock {
  public Block24(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    beginShape() ;
    fill(241, 196, 15);
    int R;
    for (int i = 0; i < 4; i++) {
      if (i % 2 == 0) {
        R = 40;
      } else {
        R = 80;
      }
      vertex(x+60+R*sin(radians(90*i)), y+15+R*cos(radians(90*i)));
    }
    endShape(CLOSE);
    noFill();
    strokeWeight(2);

    line(x+60, y+55, x+60, y+80);
    line(x+140, y+15, x+210, y+15);
    line(x+210, y+15, x+210, y+80);
    line(x-90, y+60, x-80, y+55);
    line(x-90, y+60, x-80, y+65);

    stroke(200, 0, 0);
    fill(0);
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}


class Block25 extends AbstractBlock {
  public Block25(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    fill(241, 196, 15); 
    beginShape();
    vertex(x+20, y);
    vertex(x+130, y);
    vertex(x+100, y+30);
    vertex(x-10, y+30);
    endShape(CLOSE);
    noFill();
    strokeWeight(2);
    stroke(243, 156, 18);
    line(x+60, y+30, x+60, y+50);
    line(x+60, y+50, x-90, y+50);
    line(x-90, y+50, x-80, y+45);
    line(x-90, y+50, x-80, y+55);

    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class Block26 extends AbstractBlock {
  public Block26(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    fill(241, 196, 15); 
    beginShape();
    vertex(x+10, y);
    vertex(x+115, y);
    vertex(x+125, y+10);
    vertex(x+125, y+30);
    vertex(x, y+30);
    vertex(x, y+10);
    endShape(CLOSE);
    noFill();
    strokeWeight(2);
    stroke(243, 156, 18);
    line(x+60, y+30, x+60, y+50);
    line(x+60, y+50, x-90, y+50);
    line(x-90, y+50, x-80, y+45);
    line(x-90, y+50, x-80, y+55);

    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class Block27 extends AbstractBlock {
  public Block27(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    fill(241, 196, 15); 
    beginShape();
    vertex(x, y);
    vertex(x+125, y);
    vertex(x+125, y+20);
    vertex(x+115, y+30);
    vertex(x+10, y+30);
    vertex(x, y+20);
    endShape(CLOSE);
    noFill();
    strokeWeight(2);
    stroke(243, 156, 18);
    line(x+60, y+30, x+60, y+50);
    line(x+60, y+50, x-90, y+50);
    line(x-90, y+50, x-80, y+45);
    line(x-90, y+50, x-80, y+55);

    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class Block28 extends AbstractBlock {
  public Block28(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    fill(241, 196, 15); 
    rect(x, y, w, h, 15); 
    noFill();
    strokeWeight(2);
    stroke(200, 0, 0);

    fill(0);   
    textAlign(CENTER, CENTER); 
    strokeWeight(3);
    stroke(243, 156, 18);
    textSize(20);
    text(name, x + w / 2, y + h / 3);
  }
}

class Block29 extends AbstractBlock {
  public Block29(String name, int x, int y) {
    super(name, x, y);
  }
  public void display() {
    noFill();
    strokeWeight(2);
    stroke(243, 156, 18);
    line(x+60, y, x+60, y+50);
    line(x+60, y+50, x-90, y+50);
    line(x-90, y+50, x-80, y+45);
    line(x-90, y+50, x-80, y+55);
  }
}
public void file_out2() {
  //ファイル出力
  String savefile = "data/tmp2.txt";
  PrintWriter writer= createWriter(savefile);
  for (AbstractBlock block : blocklist) {
    if (block instanceof Block11) {
      writer.println(block.x +","+block.y+","+1+","+block.name);
    }
    if (block instanceof Block12_int) {
      writer.println(block.x +","+block.y+","+2+","+block.name.replace("(整数型)", ""));
    }
    if (block instanceof Block12_String) {
      writer.println(block.x +","+block.y+","+22+","+block.name.replace("(文字列型)", ""));
    }
    if (block instanceof Block12_double) {
      writer.println(block.x +","+block.y+","+222+","+block.name.replace("(小数型)", ""));
    }
    if (block instanceof Block13) {
      writer.println(block.x+ ","+block.y+","+3+","+block.name);
    }
    if (block instanceof Block14) {
      writer.println(block.x +","+block.y+","+4+","+block.name);
    }
    if (block instanceof Block15) {
      writer.println(block.x +","+block.y+","+5+","+block.name.replace("を出力", ""));
    }
    if (block instanceof Block6_for) {
      writer.println(block.x +","+block.y+","+6+","+block.name);
    }
    if (block instanceof Block6_while) {
      writer.println(block.x +","+block.y+","+66+","+block.name);
    }
    if (block instanceof Block17) {
      writer.println(block.x +","+block.y+","+7+","+block.name);
    }
    if (block instanceof Block18) {
      writer.println(block.x +","+block.y+","+8+","+block.name);
    }
    if (block instanceof Block19) {
      writer.println(block.x +","+block.y+","+9+","+"null");
    }
    if (block instanceof Block21) {
      writer.println(block.x +","+block.y+","+11+","+block.name);
    }
    if (block instanceof Block22) {
      writer.println(block.x +","+block.y+","+12+","+block.name);
    }
    if (block instanceof Block23) {
      writer.println(block.x +","+block.y+","+13+","+block.name);
    }
    if (block instanceof Block24) {
      writer.println(block.x +","+block.y+","+14+","+block.name);
    }
    if (block instanceof Block25) {
      writer.println(block.x +","+block.y+","+15+","+block.name.replace("を出力", ""));
    }
    if (block instanceof Block26) {  
      writer.println(block.x +","+block.y+","+16+","+block.name);
    }
    if (block instanceof Block27) {
      writer.println(block.x +","+block.y+","+17+","+block.name);
    }
    if (block instanceof Block28) {
      writer.println(block.x +","+block.y+","+18+","+block.name);
    }
    if (block instanceof Block29) {
      writer.println(block.x +","+block.y+","+19+","+block.name);
    }
  }
  writer.close();
}
public void file_in2() {
  //ファイルを読み込み
  final String FILE_NAME = "tmp2.txt";
  String lineData[] = null;
  //テキストファイルを読む
  lineData = loadStrings( FILE_NAME );
  if ( lineData == null ) {
    //読み込み失敗
    println( FILE_NAME + " 読み込み失敗" );
    exit();
  }

  int x[]=new int[300];
  int y[]=new int[300];
  int blockID[]=new int[300];
  String name[]=new String[300];
  int i=0;
  try {
    BufferedReader reader = createReader(FILE_NAME);
    String str;
    str=reader.readLine();
    String []data=str.split(",", 0);
    x[i]=Integer.parseInt(data[0]);
    y[i]=Integer.parseInt(data[1]);
    blockID[i] = Integer.parseInt(data[2]);
    name[i]=data[3];
    i++;
    int xhandan[] = new int[5];
    xhandan[0]=x[0];
    xhandan[1]=x[0]+150;
    xhandan[2]=x[0]+300;
    xhandan[3]=x[0]+450;
    xhandan[4]=x[0]+600;
    while ((str=reader.readLine())!=null) {
      data=str.split(",", 0);
      if (Integer.parseInt(data[0])==xhandan[0]||
        Integer.parseInt(data[0])==xhandan[1]||
        Integer.parseInt(data[0])==xhandan[2]||
        Integer.parseInt(data[0])==xhandan[3]||
        Integer.parseInt(data[0])==xhandan[4]) {
        x[i]=Integer.parseInt(data[0]);
        y[i]=Integer.parseInt(data[1]);
        blockID[i] = Integer.parseInt(data[2]);
        name[i]=data[3];
        i++;
      }
    }
  }  
  catch(IOException e) {
    println( FILE_NAME + " 読み込み失敗" );
    exit();
  }
  catch(NumberFormatException e) {
    println( FILE_NAME + " データ破損！！！！！！" );
  }

  //ｙ座標でソート
  int l;
  int m, n, a, b;
  m=0; 
  n=0;
  a=0;
  b=0;
  for (l=0; 0!=y[l]; l++) {
  }
  int tmp;
  String tmp2;

  for ( i=0; i<l-1; i++) {
    for (int j=l-1; j>i; j--) {
      if (y[j]<y[j-1]) {
        tmp=x[j];
        x[j]=x[j-1];
        x[j-1]=tmp;

        tmp=y[j];
        y[j]=y[j-1];
        y[j-1]=tmp;

        tmp= blockID[j];
        blockID[j]= blockID[j-1];
        blockID[j-1]=tmp;

        tmp2= name[j];
        name[j]= name[j-1];
        name[j-1]=tmp2;
      }
    }
  }
  //x座標でソート
  for ( i=0; i<l-1; i++) {
    for (int j=l-1; j>i; j--) {
      if (y[j]==y[j-1]) {
        if (x[j]<x[j-1]) {
          tmp=x[j];
          x[j]=x[j-1];
          x[j-1]=tmp;

          tmp=y[j];
          y[j]=y[j-1];
          y[j-1]=tmp;

          tmp= blockID[j];
          blockID[j]= blockID[j-1];
          blockID[j-1]=tmp;

          tmp2= name[j];
          name[j]= name[j-1];
          name[j-1]=tmp2;

          //j=l-1;
        }
      }
    }
  }

  //処理を行う順番にline[]へ格納
  int line[]= new int[500];
  String line_name[]= new String[500];
  int R;
  R = 0;
  int xhandan[] = new int[5];
  xhandan[0]=x[0];
  xhandan[1]=x[0]+150;
  xhandan[2]=x[0]+300;
  xhandan[3]=x[0]+450;
  xhandan[4]=x[0]+600;
  int xsoezi = 0;
  int soezi_save;
  int epoint[]  = new int[100];
  int esoezi = 0;
  int line_box[]  = new int[500];
  int box = 0;
  int save_point = 1;
  int stop = 0;
  for ( i = 0; i <= l; i++) {
    if (xhandan[xsoezi]==x[i]) {
      line[R] = blockID[i];
      if ((blockID[i]==11||
        blockID[i]==12||
        blockID[i]==13||
        blockID[i]==14||
        blockID[i]==15||
        blockID[i]==16||
        blockID[i]==17||
        blockID[i]==18||
        blockID[i]==19)&&
        (blockID[i+1]==11||
        blockID[i+1]==12||
        blockID[i+1]==13||
        blockID[i+1]==14||
        blockID[i+1]==15||
        blockID[i+1]==16||
        blockID[i+1]==17||
        blockID[i+1]==18||
        blockID[i+1]==19)) {
        line[R] = blockID[i]-10;
      }
      //if (line[R]==4) {
      //  System.out.print("ここです");
      //}
      line_name[R] = name[i];
      line_box[R]=box;
      R++;
      if (blockID[i]==4) {
        //System.out.print("ここだあああああ");
        save_point=i;
      }
      if (blockID[i]==1||
        blockID[i]==4||
        blockID[i]==6||
        blockID[i]==66) {
        box = box + 1;
        System.out.print(blockID[i]);
        System.out.println("のおかげでプラスだべ！");
      }
      if (blockID[i]==7||
        blockID[i]==11||
        blockID[i]==12||
        blockID[i]==13||
        blockID[i]==14||
        blockID[i]==15||
        blockID[i]==16||
        blockID[i]==17||
        blockID[i]==18||
        blockID[i]==19) {
        if (blockID[i+1]==11||
          blockID[i+1]==12||
          blockID[i+1]==13||
          blockID[i+1]==14||
          blockID[i+1]==15||
          blockID[i+1]==16||
          blockID[i+1]==17||
          blockID[i+1]==18||
          blockID[i+1]==19) {
          stop++;
        } else {
          box = box - 1;
          System.out.print(blockID[i]);
          System.out.println("のおかげでマイナスだべ！");
          while (stop>0) {
            stop--;
            box--;
          }
        }
      }
      if (y[i]==y[i+1]&&
        blockID[i+1]==11||
        blockID[i+1]==12||
        blockID[i+1]==13||
        blockID[i+1]==14||
        blockID[i+1]==15||
        blockID[i+1]==16||
        blockID[i+1]==17||
        blockID[i+1]==18||
        blockID[i+1]==19) {
        i = save_point;
        System.out.print("添え字プラス");
        epoint[esoezi] = R-1;
        esoezi++;
        xsoezi++;
      }
      if (blockID[i] == 11||
        blockID[i] == 12||
        blockID[i] == 13||
        blockID[i] == 14||
        blockID[i] == 15||
        blockID[i] == 16||
        blockID[i] == 17||
        blockID[i] == 18||
        blockID[i] == 19) {
        System.out.print("添え字マイナス");
        xsoezi--;
        int j=i;
        soezi_save=xsoezi;
        while (soezi_save>=1) {
          if (blockID[j-1]==11||
            blockID[j-1]==12||
            blockID[j-1]==13||
            blockID[j-1]==14||
            blockID[j-1]==15||
            blockID[j-1]==16||
            blockID[j-1]==17||
            blockID[j-1]==18||
            blockID[j-1]==19) {
            xsoezi--;
            System.out.print("添え字マイナスだよ");
            line[R]=999;
            line_name[R]="a";
            line_box[R]=box;
            l++;
            R++;
          }
          soezi_save--;
          j--;
        }
      }
    }
    if (i+1>l&&i!=R) {
      System.out.println(R);
      //R=0;
      while (i!=R) {
        line[R] = 2;
        line_name[R] = "エラー";
        epoint[R]=-1;
        line_box[R] = 0;
        R++;
      }
    }
  }
  //表示
  System.out.println();
  esoezi= 0;
  int box_tmp;
  for (i=0; i<l; i++) {
    if (line_name[i].equals("null")) {
    } else {
      if(line[i]==7){
        line_box[i]--;
      }
      while (line_box[i]>0) {
        program = program +"  ";
        line_box[i]--;
      }
      switch(line[i]) {
      case 1 :
        program = program +("#include <stdio.h>\n\nint main(){\n");
        break;
      case 2 :
        program = program +("int "+line_name[i]+";\n");
        break;
      case 22 :
        program = program +("char "+line_name[i]+";\n");
        break;
      case 222 :
        program = program +("double "+line_name[i]+";\n");
        break;
      case 3 :
        program = program +(line_name[i]+";\n");
        break;
      case 4 :
        program = program +("if("+line_name[i]+"){\n");
        break;
      case 5 :
        program = program +("printf(\"%d,"+line_name[i]+"\");\n");
        break;
      case 66 :
        program = program +("while("+line_name[i]+"){\n");
        break;
      case 6 :
        program = program +("for("+line_name[i]+"){\n");
        break;
      case 7 :
        
        program = program +("}\n");
        break;
      case 8:
        program = program +("return 0;\n}\n");
        break;
      case 12 :
        program = program +(line_name[i]+";\n");
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          program = program +("  ");
          box_tmp--;
        }
        if (line[i+1]==999) {
          program = program +("\t}\n");
        } else {
          program = program +("}\n");
        }
        break;
      case 13 :
        program = program +(line_name[i]+";\n");
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          program = program +("  ");
          box_tmp--;
        }
        if (line[i+1]==999) {
          program = program +("  }\n");
        } else {
          program = program +("}\n");
        }
        break;
      case 15 :
        program = program +("printf(\"%d,"+line_name[i]+"\");\n");
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          program = program +("  ");
          box_tmp--;
        }
        if (line[i+1]==999) {
          program = program +("  }\n");
        } else {
          program = program +("}\n");
        }
        break;
      case 16 :
        program = program +("ループ開始をif文終了地点に入れないでください！\n");
        break;
      case 17 :
        program = program +("}\n");
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          program = program +("  ");
          box_tmp--;
        }
        if (line[i+1]==999) {
          program = program +("  }\n");
        } else {
          program = program +("}\n");
        }
        break;
      case 19 :
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          program = program +("  ");
          box_tmp--;
        }
        if (line[i+1]==999) {
          program = program +("  }\n");
        } else {
          program = program +("}\n");
        }
        break;
      case 999 :
        program = program +("}\n");
        break;
      default:
        break;
      }
      if (epoint[esoezi]==i&&epoint[esoezi]!=0) {
        box_tmp=line_box[i+1];
        while (box_tmp>=2) {
          program = program +("  ");
          box_tmp--;
        }
        program = program +("}else{\n");
        esoezi++;
      }
    }
  }
}
public void file_out3() {
  //ファイル出力
  String savefile = "data/tmp2.txt";
  PrintWriter writer= createWriter(savefile);
  for (AbstractBlock block : blocklist) {
    if (block instanceof Block11) {
      writer.println(block.x +","+block.y+","+1+","+block.name);
    }
    if (block instanceof Block12_int) {
      writer.println(block.x +","+block.y+","+2+","+block.name.replace("(整数型)", ""));
    }
    if (block instanceof Block12_String) {
      writer.println(block.x +","+block.y+","+22+","+block.name.replace("(文字列型)", ""));
    }
    if (block instanceof Block12_double) {
      writer.println(block.x +","+block.y+","+222+","+block.name.replace("(小数型)", ""));
    }
    if (block instanceof Block13) {
      writer.println(block.x+ ","+block.y+","+3+","+block.name);
    }
    if (block instanceof Block14) {
      writer.println(block.x +","+block.y+","+4+","+block.name);
    }
    if (block instanceof Block15) {
      writer.println(block.x +","+block.y+","+5+","+block.name.replace("を出力", ""));
    }
    if (block instanceof Block6_for) {
      writer.println(block.x +","+block.y+","+6+","+block.name);
    }
    if (block instanceof Block6_while) {
      writer.println(block.x +","+block.y+","+66+","+block.name);
    }
    if (block instanceof Block17) {
      writer.println(block.x +","+block.y+","+7+","+block.name);
    }
    if (block instanceof Block18) {
      writer.println(block.x +","+block.y+","+8+","+block.name);
    }
    if (block instanceof Block19) {
      writer.println(block.x +","+block.y+","+9+","+"null");
    }
    if (block instanceof Block21) {
      writer.println(block.x +","+block.y+","+11+","+block.name);
    }
    if (block instanceof Block22) {
      writer.println(block.x +","+block.y+","+12+","+block.name);
    }
    if (block instanceof Block23) {
      writer.println(block.x +","+block.y+","+13+","+block.name);
    }
    if (block instanceof Block24) {
      writer.println(block.x +","+block.y+","+14+","+block.name);
    }
    if (block instanceof Block25) {
      writer.println(block.x +","+block.y+","+15+","+block.name.replace("を出力", ""));
    }
    if (block instanceof Block26) {  
      writer.println(block.x +","+block.y+","+16+","+block.name);
    }
    if (block instanceof Block27) {
      writer.println(block.x +","+block.y+","+17+","+block.name);
    }
    if (block instanceof Block28) {
      writer.println(block.x +","+block.y+","+18+","+block.name);
    }
    if (block instanceof Block29) {
      writer.println(block.x +","+block.y+","+19+","+block.name);
    }
  }
  writer.close();
}
public void file_in3() {
  //ファイルを読み込み
  final String FILE_NAME = "tmp2.txt";
  String lineData[] = null;
  //テキストファイルを読む
  lineData = loadStrings( FILE_NAME );
  if ( lineData == null ) {
    //読み込み失敗
    println( FILE_NAME + " 読み込み失敗" );
    exit();
  }

  int x[]=new int[300];
  int y[]=new int[300];
  int blockID[]=new int[300];
  String name[]=new String[300];
  int i=0;
  try {
    BufferedReader reader = createReader(FILE_NAME);
    String str;
    str=reader.readLine();
    String []data=str.split(",", 0);
    x[i]=Integer.parseInt(data[0]);
    y[i]=Integer.parseInt(data[1]);
    blockID[i] = Integer.parseInt(data[2]);
    name[i]=data[3];
    i++;
    int xhandan[] = new int[5];
    xhandan[0]=x[0];
    xhandan[1]=x[0]+150;
    xhandan[2]=x[0]+300;
    xhandan[3]=x[0]+450;
    xhandan[4]=x[0]+600;
    while ((str=reader.readLine())!=null) {
      data=str.split(",", 0);
      if (Integer.parseInt(data[0])==xhandan[0]||
        Integer.parseInt(data[0])==xhandan[1]||
        Integer.parseInt(data[0])==xhandan[2]||
        Integer.parseInt(data[0])==xhandan[3]||
        Integer.parseInt(data[0])==xhandan[4]) {
        x[i]=Integer.parseInt(data[0]);
        y[i]=Integer.parseInt(data[1]);
        blockID[i] = Integer.parseInt(data[2]);
        name[i]=data[3];
        i++;
      }
    }
  }
  catch(IOException e) {
    println( FILE_NAME + " 読み込み失敗" );
    exit();
  }
  catch(NumberFormatException e) {
    println( FILE_NAME + " データ破損！！！！！！" );
  }

  //ｙ座標でソート
  int l;
  int m, n, a, b;
  m=0; 
  n=0;
  a=0;
  b=0;
  for (l=0; 0!=y[l]; l++) {
  }
  int tmp;
  String tmp2;

  for ( i=0; i<l-1; i++) {
    for (int j=l-1; j>i; j--) {
      if (y[j]<y[j-1]) {
        tmp=x[j];
        x[j]=x[j-1];
        x[j-1]=tmp;

        tmp=y[j];
        y[j]=y[j-1];
        y[j-1]=tmp;

        tmp= blockID[j];
        blockID[j]= blockID[j-1];
        blockID[j-1]=tmp;

        tmp2= name[j];
        name[j]= name[j-1];
        name[j-1]=tmp2;
      }
    }
  }
  //x座標でソート
  for ( i=0; i<l-1; i++) {
    for (int j=l-1; j>i; j--) {
      if (y[j]==y[j-1]) {
        if (x[j]<x[j-1]) {
          tmp=x[j];
          x[j]=x[j-1];
          x[j-1]=tmp;

          tmp=y[j];
          y[j]=y[j-1];
          y[j-1]=tmp;

          tmp= blockID[j];
          blockID[j]= blockID[j-1];
          blockID[j-1]=tmp;

          tmp2= name[j];
          name[j]= name[j-1];
          name[j-1]=tmp2;

          //j=l-1;
        }
      }
    }
  }

  //処理を行う順番にline[]へ格納
  int line[]= new int[500];
  String line_name[]= new String[500];
  int R;
  R = 0;
  int xhandan[] = new int[5];
  xhandan[0]=x[0];
  xhandan[1]=x[0]+150;
  xhandan[2]=x[0]+300;
  xhandan[3]=x[0]+450;
  xhandan[4]=x[0]+600;
  int xsoezi = 0;
  int soezi_save;
  int epoint[]  = new int[100];
  int esoezi = 0;
  int line_box[]  = new int[500];
  int box = 0;
  int save_point = 1;
  for ( i = 0; i <= l; i++) {
    if (xhandan[xsoezi]==x[i]) {
      line[R] = blockID[i];
      if (line[R]==4) {
        System.out.print("ここです");
      }
      line_name[R] = name[i];
      line_box[R]=box;
      R++;
      if (blockID[i]==4) {
        System.out.print("ここだあああああ");
        save_point=i;
      }
      if (blockID[i]==1) {
        box = box + 2;
      }
      if (blockID[i]==8) {
        box = box - 2;
      }
      if (blockID[i]==4||
        blockID[i]==6||
        blockID[i]==66) {
        box = box + 1;
      }
      if (blockID[i]==7||
        blockID[i]==11||
        blockID[i]==12||
        blockID[i]==13||
        blockID[i]==14||
        blockID[i]==15||
        blockID[i]==16||
        blockID[i]==17||
        blockID[i]==18||
        blockID[i]==19) {
        box = box - 1;
      }
      if (y[i]==y[i+1]&&
        blockID[i+1]==11||
        blockID[i+1]==12||
        blockID[i+1]==13||
        blockID[i+1]==14||
        blockID[i+1]==15||
        blockID[i+1]==16||
        blockID[i+1]==17||
        blockID[i+1]==18||
        blockID[i+1]==19) {
        i = save_point;
        System.out.print("添え字プラス");
        epoint[esoezi] = R-1;
        esoezi++;
        xsoezi++;
      }
      if (blockID[i] == 11||
        blockID[i] == 12||
        blockID[i] == 13||
        blockID[i] == 14||
        blockID[i] == 15||
        blockID[i] == 16||
        blockID[i] == 17||
        blockID[i] == 18||
        blockID[i] == 19) {
        System.out.print("添え字マイナス");
        xsoezi--;
        int j=i;
        soezi_save=xsoezi;
        while (soezi_save>=1) {
          if (blockID[j-1]==11||
            blockID[j-1]==12||
            blockID[j-1]==13||
            blockID[j-1]==14||
            blockID[j-1]==15||
            blockID[j-1]==16||
            blockID[j-1]==17||
            blockID[j-1]==18||
            blockID[j-1]==19) {
            xsoezi--;
            System.out.print("添え字マイナスだよ");
          }
          soezi_save--;
          j--;
        }
      }
    }
    if (i+1>l&&i!=R) {
      System.out.println(R);
      //R=0;
      while (i!=R) {
        line[R] = 2;
        line_name[R] = "エラー";
        epoint[R]=-1;
        line_box[R] = 0;
        R++;
      }
    }
  }

  //表示
  esoezi= 0;
  int box_tmp;
  for (i=0; i<l; i++) {
    if (line_name[i].equals("null")) {
    } else {
      if(line[i]==7){
        line_box[i]--;
      }
      if (line[i]!=8) {
        while (line_box[i]>0) {
          program = program +"    ";
          line_box[i]--;
        }
      }
      switch(line[i]) {
      case 1 :
        program = program +("public class クラス名 {\n  public static void main(String args[]) {\n");
        break;
      case 2 :
        program = program +("int "+line_name[i]+";\n");
        break;
      case 22 :
        program = program +("String "+line_name[i]+";\n");
        break;
      case 222 :
        program = program +("double "+line_name[i]+";\n");
        break;
      case 3 :
        program = program +(line_name[i]+";\n");
        break;
      case 4 :
        program = program +("if("+line_name[i]+"){\n");
        break;
      case 5 :
        program = program +("System.out.println("+line_name[i]+");\n");
        break;
      case 66 :
        program = program +("while("+line_name[i]+"){\n");
        break;
      case 6 :
        program = program +("for("+line_name[i]+"){\n");
        break;
      case 7 :
        program = program +("}\n");
        break;
      case 8:
        program = program +("    }\n}");
        break;
      case 12 :
        program = program +(line_name[i]+";\n");
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          program = program +("    ");
          box_tmp--;
        }
        program = program +("}\n");
        break;
      case 13 :
        program = program +(line_name[i]+";\n");
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          program = program +("    ");
          box_tmp--;
        }
        program = program +("}\n");
        break;
      case 15 :
        program = program +("System.out.println("+line_name[i]+");\n");
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          program = program +("    ");
          box_tmp--;
        }
        program = program +("}\n");
        break;
      case 16 :
        program = program +("ループ開始をif文終了地点に入れないでください！\n");
        break;
      case 17 :
        program = program +("}\n");
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          program = program +("    ");
          box_tmp--;
        }
        program = program +("}\n");
        break;
      case 19 :
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          program = program +("    ");
          box_tmp--;
        }
        program = program +("}\n");
        break;
      default:
        break;
      }
      if (epoint[esoezi]==i&&epoint[esoezi]!=0) {
        box_tmp=line_box[i+1];
        while (box_tmp>=2) {
          program = program +("    ");
          box_tmp--;
        }
        program = program +("}else{\n");
        esoezi++;
      }
    }
  }
}
public void file_out5() {
  //ファイル出力
  String savefile = "data/tmp2.txt";
  PrintWriter writer= createWriter(savefile);
  for (AbstractBlock block : blocklist) {
    if (block instanceof Block11) {
      writer.println(block.x +","+block.y+","+1+","+block.name);
    }
    if (block instanceof Block12_int) {
      writer.println(block.x +","+block.y+","+2+","+block.name.replace("(整数型)", ""));
    }
    if (block instanceof Block12_String) {
      writer.println(block.x +","+block.y+","+22+","+block.name.replace("(文字列型)", ""));
    }
    if (block instanceof Block12_double) {
      writer.println(block.x +","+block.y+","+222+","+block.name.replace("(小数型)", ""));
    }
    if (block instanceof Block13) {
      writer.println(block.x+ ","+block.y+","+3+","+block.name);
    }
    if (block instanceof Block14) {
      writer.println(block.x +","+block.y+","+4+","+block.name);
    }
    if (block instanceof Block15) {
      writer.println(block.x +","+block.y+","+5+","+block.name.replace("を出力", ""));
    }
    if (block instanceof Block6_for) {
      writer.println(block.x +","+block.y+","+6+","+block.name);
    }
    if (block instanceof Block6_while) {
      writer.println(block.x +","+block.y+","+66+","+block.name);
    }
    if (block instanceof Block17) {
      writer.println(block.x +","+block.y+","+7+","+block.name);
    }
    if (block instanceof Block18) {
      writer.println(block.x +","+block.y+","+8+","+block.name);
    }
    if (block instanceof Block19) {
      writer.println(block.x +","+block.y+","+9+","+"null");
    }
    if (block instanceof Block21) {
      writer.println(block.x +","+block.y+","+11+","+block.name);
    }
    if (block instanceof Block22) {
      writer.println(block.x +","+block.y+","+12+","+block.name);
    }
    if (block instanceof Block23) {
      writer.println(block.x +","+block.y+","+13+","+block.name);
    }
    if (block instanceof Block24) {
      writer.println(block.x +","+block.y+","+14+","+block.name);
    }
    if (block instanceof Block25) {
      writer.println(block.x +","+block.y+","+15+","+block.name.replace("を出力", ""));
    }
    if (block instanceof Block26) {  
      writer.println(block.x +","+block.y+","+16+","+block.name);
    }
    if (block instanceof Block27) {
      writer.println(block.x +","+block.y+","+17+","+block.name);
    }
    if (block instanceof Block28) {
      writer.println(block.x +","+block.y+","+18+","+block.name);
    }
    if (block instanceof Block29) {
      writer.println(block.x +","+block.y+","+19+","+block.name);
    }
  }
  writer.close();
}
public void file_in5() {
  //ファイルを読み込み
  final String FILE_NAME = "tmp2.txt";
  String lineData[] = null;
  //テキストファイルを読む
  lineData = loadStrings( FILE_NAME );
  if ( lineData == null ) {
    //読み込み失敗
    println( FILE_NAME + " 読み込み失敗" );
    exit();
  }

  int x[]=new int[300];
  int y[]=new int[300];
  int blockID[]=new int[300];
  String name[]=new String[300];
  int i=0;
  try {
    BufferedReader reader = createReader(FILE_NAME);
    String str;
    str=reader.readLine();
    String []data=str.split(",", 0);
    x[i]=Integer.parseInt(data[0]);
    y[i]=Integer.parseInt(data[1]);
    blockID[i] = Integer.parseInt(data[2]);
    name[i]=data[3];
    i++;
    int xhandan[] = new int[5];
    xhandan[0]=x[0];
    xhandan[1]=x[0]+150;
    xhandan[2]=x[0]+300;
    xhandan[3]=x[0]+450;
    xhandan[4]=x[0]+600;
    while ((str=reader.readLine())!=null) {
      data=str.split(",", 0);
      if (Integer.parseInt(data[0])==xhandan[0]||
        Integer.parseInt(data[0])==xhandan[1]||
        Integer.parseInt(data[0])==xhandan[2]||
        Integer.parseInt(data[0])==xhandan[3]||
        Integer.parseInt(data[0])==xhandan[4]) {
        x[i]=Integer.parseInt(data[0]);
        y[i]=Integer.parseInt(data[1]);
        blockID[i] = Integer.parseInt(data[2]);
        name[i]=data[3];
        i++;
      }
    }
  }  
  catch(IOException e) {
    println( FILE_NAME + " 読み込み失敗" );
    exit();
  }
  catch(NumberFormatException e) {
    println( FILE_NAME + " データ破損！！！！！！" );
  }

  //ｙ座標でソート
  int l;
  int m, n, a, b;
  m=0; 
  n=0;
  a=0;
  b=0;
  for (l=0; 0!=y[l]; l++) {
  }
  int tmp;
  String tmp2;

  for ( i=0; i<l-1; i++) {
    for (int j=l-1; j>i; j--) {
      if (y[j]<y[j-1]) {
        tmp=x[j];
        x[j]=x[j-1];
        x[j-1]=tmp;

        tmp=y[j];
        y[j]=y[j-1];
        y[j-1]=tmp;

        tmp= blockID[j];
        blockID[j]= blockID[j-1];
        blockID[j-1]=tmp;

        tmp2= name[j];
        name[j]= name[j-1];
        name[j-1]=tmp2;
      }
    }
  }
  //x座標でソート
  for ( i=0; i<l-1; i++) {
    for (int j=l-1; j>i; j--) {
      if (y[j]==y[j-1]) {
        if (x[j]<x[j-1]) {
          tmp=x[j];
          x[j]=x[j-1];
          x[j-1]=tmp;

          tmp=y[j];
          y[j]=y[j-1];
          y[j-1]=tmp;

          tmp= blockID[j];
          blockID[j]= blockID[j-1];
          blockID[j-1]=tmp;

          tmp2= name[j];
          name[j]= name[j-1];
          name[j-1]=tmp2;

          //j=l-1;
        }
      }
    }
  }

  //処理を行う順番にline[]へ格納
  int line[]= new int[500];
  String line_name[]= new String[500];
  int R;
  R = 0;
  int xhandan[] = new int[5];
  xhandan[0]=x[0];
  xhandan[1]=x[0]+150;
  xhandan[2]=x[0]+300;
  xhandan[3]=x[0]+450;
  xhandan[4]=x[0]+600;
  int xsoezi = 0;
  int soezi_save;
  int epoint[]  = new int[100];
  int esoezi = 0;
  int line_box[]  = new int[500];
  int box = 0;
  int save_point = 1;
  int stop = 0;
  for ( i = 0; i <= l; i++) {
    if (xhandan[xsoezi]==x[i]) {
      line[R] = blockID[i];
      if ((blockID[i]==11||
        blockID[i]==12||
        blockID[i]==13||
        blockID[i]==14||
        blockID[i]==15||
        blockID[i]==16||
        blockID[i]==17||
        blockID[i]==18||
        blockID[i]==19)&&
        (blockID[i+1]==11||
        blockID[i+1]==12||
        blockID[i+1]==13||
        blockID[i+1]==14||
        blockID[i+1]==15||
        blockID[i+1]==16||
        blockID[i+1]==17||
        blockID[i+1]==18||
        blockID[i+1]==19)) {
        line[R] = blockID[i]-10;
      }
      //if (line[R]==4) {
      //  System.out.print("ここです");
      //}
      line_name[R] = name[i];
      line_box[R]=box;
      R++;
      if (blockID[i]==4) {
        //System.out.print("ここだあああああ");
        save_point=i;
      }
      if (blockID[i]==1||
        blockID[i]==4||
        blockID[i]==6||
        blockID[i]==66) {
        box = box + 1;
        System.out.print(blockID[i]);
        System.out.println("のおかげでプラスだべ！");
      }
      if (blockID[i]==7||
        blockID[i]==11||
        blockID[i]==12||
        blockID[i]==13||
        blockID[i]==14||
        blockID[i]==15||
        blockID[i]==16||
        blockID[i]==17||
        blockID[i]==18||
        blockID[i]==19) {
        if (blockID[i+1]==11||
          blockID[i+1]==12||
          blockID[i+1]==13||
          blockID[i+1]==14||
          blockID[i+1]==15||
          blockID[i+1]==16||
          blockID[i+1]==17||
          blockID[i+1]==18||
          blockID[i+1]==19) {
          stop++;
        } else {
          box = box - 1;
          System.out.print(blockID[i]);
          System.out.println("のおかげでマイナスだべ！");
          while (stop>0) {
            stop--;
            box--;
          }
        }
      }
      if (y[i]==y[i+1]&&
        blockID[i+1]==11||
        blockID[i+1]==12||
        blockID[i+1]==13||
        blockID[i+1]==14||
        blockID[i+1]==15||
        blockID[i+1]==16||
        blockID[i+1]==17||
        blockID[i+1]==18||
        blockID[i+1]==19) {
        i = save_point;
        System.out.print("添え字プラス");
        epoint[esoezi] = R-1;
        esoezi++;
        xsoezi++;
      }
      if (blockID[i] == 11||
        blockID[i] == 12||
        blockID[i] == 13||
        blockID[i] == 14||
        blockID[i] == 15||
        blockID[i] == 16||
        blockID[i] == 17||
        blockID[i] == 18||
        blockID[i] == 19) {
        System.out.print("添え字マイナス");
        xsoezi--;
        int j=i;
        soezi_save=xsoezi;
        while (soezi_save>=1) {
          if (blockID[j-1]==11||
            blockID[j-1]==12||
            blockID[j-1]==13||
            blockID[j-1]==14||
            blockID[j-1]==15||
            blockID[j-1]==16||
            blockID[j-1]==17||
            blockID[j-1]==18||
            blockID[j-1]==19) {
            xsoezi--;
            System.out.print("添え字マイナスだよ");
            line[R]=999;
            line_name[R]="a";
            line_box[R]=box;
            l++;
            R++;
          }
          soezi_save--;
          j--;
        }
      }
    }
    if (i+1>l&&i!=R) {
      System.out.println(R);
      //R=0;
      while (i!=R) {
        line[R] = 2;
        line_name[R] = "エラー";
        epoint[R]=-1;
        line_box[R] = 0;
        R++;
      }
    }
  }
  //表示
  System.out.println();
  esoezi= 0;
  int box_tmp;
  for (i=0; i<l; i++) {
    if (line_name[i].equals("null")) {
    } else {
      if(line[i]==7){
        line_box[i]--;
      }
      while (line_box[i]>0) {
        program2 = program2 +"\t";
        line_box[i]--;
      }
      switch(line[i]) {
      case 1 :
        program2 = program2 +("#include <stdio.h>\n\nint main(){\n");
        break;
      case 2 :
        program2 = program2 +("int "+line_name[i]+";\n");
        break;
      case 22 :
        program2 = program2 +("char "+line_name[i]+";\n");
        break;
      case 222 :
        program2 = program2 +("double "+line_name[i]+";\n");
        break;
      case 3 :
        program2 = program2 +(line_name[i]+";\n");
        break;
      case 4 :
        program2 = program2 +("if("+line_name[i]+"){\n");
        break;
      case 5 :
        program2 = program2 +("printf(\"%d,"+line_name[i]+"\");\n");
        break;
      case 66 :
        program2 = program2 +("while("+line_name[i]+"){\n");
        break;
      case 6 :
        program2 = program2 +("for("+line_name[i]+"){\n");
        break;
      case 7 :
        program2 = program2 +("}\n");
        break;
      case 8:
        program2 = program2 +("return 0;\n}\n");
        break;
      case 12 :
        program2 = program2 +(line_name[i]+";\n");
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          program2 = program2 +("\t");
          box_tmp--;
        }
        if (line[i+1]==999) {
          program2 = program2 +("\t}\n");
        } else {
          program2 = program2 +("}\n");
        }
        break;
      case 13 :
        program2 = program2 +(line_name[i]+";\n");
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          program2 = program2 +("\t");
          box_tmp--;
        }
        if (line[i+1]==999) {
          program2 = program2 +("\t}\n");
        } else {
          program2 = program2 +("}\n");
        }
        break;
      case 15 :
        program2 = program2 +("printf(\"%d,"+line_name[i]+"\");\n");
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          program2 = program2 +("\t");
          box_tmp--;
        }
        if (line[i+1]==999) {
          program2 = program2 +("\t}\n");
        } else {
          program2 = program2 +("}\n");
        }
        break;
      case 16 :
        program2 = program2 +("ループ開始をif文終了地点に入れないでください！\n");
        break;
      case 17 :
        program2 = program2 +("}\n");
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          program2 = program2 +("\t");
          box_tmp--;
        }
        if (line[i+1]==999) {
          program2 = program2 +("\t}\n");
        } else {
          program2 = program2 +("}\n");
        }
        break;
      case 19 :
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          program2 = program2 +("\t");
          box_tmp--;
        }
        if (line[i+1]==999) {
          program2 = program2 +("\t}\n");
        } else {
          program2 = program2 +("}\n");
        }
        break;
      case 999 :
        program2 = program2 +("}\n");
        break;
      default:
        break;
      }
      if (epoint[esoezi]==i&&epoint[esoezi]!=0) {
        box_tmp=line_box[i+1];
        while (box_tmp>=2) {
          program2 = program2 +("\t");
          box_tmp--;
        }
        program2 = program2 +("}else{\n");
        esoezi++;
      }
    }
  }
}
public void file_out6() {
  //ファイル出力
  String savefile = "data/tmp2.txt";
  PrintWriter writer= createWriter(savefile);
  for (AbstractBlock block : blocklist) {
    if (block instanceof Block11) {
      writer.println(block.x +","+block.y+","+1+","+block.name);
    }
    if (block instanceof Block12_int) {
      writer.println(block.x +","+block.y+","+2+","+block.name.replace("(整数型)", ""));
    }
    if (block instanceof Block12_String) {
      writer.println(block.x +","+block.y+","+22+","+block.name.replace("(文字列型)", ""));
    }
    if (block instanceof Block12_double) {
      writer.println(block.x +","+block.y+","+222+","+block.name.replace("(小数型)", ""));
    }
    if (block instanceof Block13) {
      writer.println(block.x+ ","+block.y+","+3+","+block.name);
    }
    if (block instanceof Block14) {
      writer.println(block.x +","+block.y+","+4+","+block.name);
    }
    if (block instanceof Block15) {
      writer.println(block.x +","+block.y+","+5+","+block.name.replace("を出力", ""));
    }
    if (block instanceof Block6_for) {
      writer.println(block.x +","+block.y+","+6+","+block.name);
    }
    if (block instanceof Block6_while) {
      writer.println(block.x +","+block.y+","+66+","+block.name);
    }
    if (block instanceof Block17) {
      writer.println(block.x +","+block.y+","+7+","+block.name);
    }
    if (block instanceof Block18) {
      writer.println(block.x +","+block.y+","+8+","+block.name);
    }
    if (block instanceof Block19) {
      writer.println(block.x +","+block.y+","+9+","+"null");
    }
    if (block instanceof Block21) {
      writer.println(block.x +","+block.y+","+11+","+block.name);
    }
    if (block instanceof Block22) {
      writer.println(block.x +","+block.y+","+12+","+block.name);
    }
    if (block instanceof Block23) {
      writer.println(block.x +","+block.y+","+13+","+block.name);
    }
    if (block instanceof Block24) {
      writer.println(block.x +","+block.y+","+14+","+block.name);
    }
    if (block instanceof Block25) {
      writer.println(block.x +","+block.y+","+15+","+block.name.replace("を出力", ""));
    }
    if (block instanceof Block26) {  
      writer.println(block.x +","+block.y+","+16+","+block.name);
    }
    if (block instanceof Block27) {
      writer.println(block.x +","+block.y+","+17+","+block.name);
    }
    if (block instanceof Block28) {
      writer.println(block.x +","+block.y+","+18+","+block.name);
    }
    if (block instanceof Block29) {
      writer.println(block.x +","+block.y+","+19+","+block.name);
    }
  }
  writer.close();
}
public void file_in6() {
  //ファイルを読み込み
  final String FILE_NAME = "tmp2.txt";
  String lineData[] = null;
  //テキストファイルを読む
  lineData = loadStrings( FILE_NAME );
  if ( lineData == null ) {
    //読み込み失敗
    println( FILE_NAME + " 読み込み失敗" );
    exit();
  }

  int x[]=new int[300];
  int y[]=new int[300];
  int blockID[]=new int[300];
  String name[]=new String[300];
  int i=0;
  try {
    BufferedReader reader = createReader(FILE_NAME);
    String str;
    str=reader.readLine();
    String []data=str.split(",", 0);
    x[i]=Integer.parseInt(data[0]);
    y[i]=Integer.parseInt(data[1]);
    blockID[i] = Integer.parseInt(data[2]);
    name[i]=data[3];
    i++;
    int xhandan[] = new int[5];
    xhandan[0]=x[0];
    xhandan[1]=x[0]+150;
    xhandan[2]=x[0]+300;
    xhandan[3]=x[0]+450;
    xhandan[4]=x[0]+600;
    while ((str=reader.readLine())!=null) {
      data=str.split(",", 0);
      if (Integer.parseInt(data[0])==xhandan[0]||
        Integer.parseInt(data[0])==xhandan[1]||
        Integer.parseInt(data[0])==xhandan[2]||
        Integer.parseInt(data[0])==xhandan[3]||
        Integer.parseInt(data[0])==xhandan[4]) {
        x[i]=Integer.parseInt(data[0]);
        y[i]=Integer.parseInt(data[1]);
        blockID[i] = Integer.parseInt(data[2]);
        name[i]=data[3];
        i++;
      }
    }
  }
  catch(IOException e) {
    println( FILE_NAME + " 読み込み失敗" );
    exit();
  }
  catch(NumberFormatException e) {
    println( FILE_NAME + " データ破損！！！！！！" );
  }

  //ｙ座標でソート
  int l;
  int m, n, a, b;
  m=0; 
  n=0;
  a=0;
  b=0;
  for (l=0; 0!=y[l]; l++) {
  }
  int tmp;
  String tmp2;

  for ( i=0; i<l-1; i++) {
    for (int j=l-1; j>i; j--) {
      if (y[j]<y[j-1]) {
        tmp=x[j];
        x[j]=x[j-1];
        x[j-1]=tmp;

        tmp=y[j];
        y[j]=y[j-1];
        y[j-1]=tmp;

        tmp= blockID[j];
        blockID[j]= blockID[j-1];
        blockID[j-1]=tmp;

        tmp2= name[j];
        name[j]= name[j-1];
        name[j-1]=tmp2;
      }
    }
  }
  //x座標でソート
  for ( i=0; i<l-1; i++) {
    for (int j=l-1; j>i; j--) {
      if (y[j]==y[j-1]) {
        if (x[j]<x[j-1]) {
          tmp=x[j];
          x[j]=x[j-1];
          x[j-1]=tmp;

          tmp=y[j];
          y[j]=y[j-1];
          y[j-1]=tmp;

          tmp= blockID[j];
          blockID[j]= blockID[j-1];
          blockID[j-1]=tmp;

          tmp2= name[j];
          name[j]= name[j-1];
          name[j-1]=tmp2;

          //j=l-1;
        }
      }
    }
  }

  //処理を行う順番にline[]へ格納
  int line[]= new int[500];
  String line_name[]= new String[500];
  int R;
  R = 0;
  int xhandan[] = new int[5];
  xhandan[0]=x[0];
  xhandan[1]=x[0]+150;
  xhandan[2]=x[0]+300;
  xhandan[3]=x[0]+450;
  xhandan[4]=x[0]+600;
  int xsoezi = 0;
  int soezi_save;
  int epoint[]  = new int[100];
  int esoezi = 0;
  int line_box[]  = new int[500];
  int box = 0;
  int save_point = 1;
  for ( i = 0; i <= l; i++) {
    if (xhandan[xsoezi]==x[i]) {
      line[R] = blockID[i];
      if (line[R]==4) {
        System.out.print("ここです");
      }
      line_name[R] = name[i];
      line_box[R]=box;
      R++;
      if (blockID[i]==4) {
        System.out.print("ここだあああああ");
        save_point=i;
      }
      if(blockID[i]==1){
        box = box + 2;
      }
      if(blockID[i]==8){
        box = box - 2;
      }
      if (blockID[i]==4||
        blockID[i]==6||
        blockID[i]==66) {
        box = box + 1;
      }
      if (blockID[i]==7||
        blockID[i]==11||
        blockID[i]==12||
        blockID[i]==13||
        blockID[i]==14||
        blockID[i]==15||
        blockID[i]==16||
        blockID[i]==17||
        blockID[i]==18||
        blockID[i]==19) {
        box = box - 1;
      }
      if (y[i]==y[i+1]&&
        blockID[i+1]==11||
        blockID[i+1]==12||
        blockID[i+1]==13||
        blockID[i+1]==14||
        blockID[i+1]==15||
        blockID[i+1]==16||
        blockID[i+1]==17||
        blockID[i+1]==18||
        blockID[i+1]==19) {
        i = save_point;
        System.out.print("添え字プラス");
        epoint[esoezi] = R-1;
        esoezi++;
        xsoezi++;
      }
      if (blockID[i] == 11||
        blockID[i] == 12||
        blockID[i] == 13||
        blockID[i] == 14||
        blockID[i] == 15||
        blockID[i] == 16||
        blockID[i] == 17||
        blockID[i] == 18||
        blockID[i] == 19) {
        System.out.print("添え字マイナス");
        xsoezi--;
        int j=i;
        soezi_save=xsoezi;
        while (soezi_save>=1) {
          if (blockID[j-1]==11||
            blockID[j-1]==12||
            blockID[j-1]==13||
            blockID[j-1]==14||
            blockID[j-1]==15||
            blockID[j-1]==16||
            blockID[j-1]==17||
            blockID[j-1]==18||
            blockID[j-1]==19) {
            xsoezi--;
            System.out.print("添え字マイナスだよ");
          }
          soezi_save--;
          j--;
        }
      }
    }
    if (i+1>l&&i!=R) {
      System.out.println(R);
      //R=0;
      while (i!=R) {
        line[R] = 2;
        line_name[R] = "エラー";
        epoint[R]=-1;
        line_box[R] = 0;
        R++;
      }
    }
  }

  //表示
  esoezi= 0;
  int box_tmp;
  for (i=0; i<l; i++) {
    if (line_name[i].equals("null")) {
    } else {
      if(line[i]==7){
        line_box[i]--;
      }
      if (line[i]!=8) {
        while (line_box[i]>0) {
          program2 = program2 +"\t";
          line_box[i]--;
        }
      }
      switch(line[i]) {
      case 1 :
        program2 = program2 +("public class クラス名 {\n\tpublic static void main(String args[]) {\n");
        break;
      case 2 :
        program2 = program2 +("int "+line_name[i]+";\n");
        break;
      case 22 :
        program2 = program2 +("String "+line_name[i]+";\n");
        break;
      case 222 :
        program2 = program2 +("double "+line_name[i]+";\n");
        break;
      case 3 :
        program2 = program2 +(line_name[i]+";\n");
        break;
      case 4 :
        program2 = program2 +("if("+line_name[i]+"){\n");
        break;
      case 5 :
        program2 = program2 +("System.out.println("+line_name[i]+");\n");
        break;
      case 66 :
        program2 = program2 +("while("+line_name[i]+"){\n");
        break;
      case 6 :
        program2 = program2 +("for("+line_name[i]+"){\n");
        break;
      case 7 :
        program2 = program2 +("}\n");
        break;
      case 8:
        program2 = program2 +("\t}\n}");
        break;
      case 12 :
        program2 = program2 +(line_name[i]+";\n");
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          program2 = program2 +("\t");
          box_tmp--;
        }
        program2 = program2 +("}\n");
        break;
      case 13 :
        program2 = program2 +(line_name[i]+";\n");
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          program2 = program2 +("\t");
          box_tmp--;
        }
        program2 = program2 +("}\n");
        break;
      case 15 :
        program2 = program2 +("System.out.println("+line_name[i]+");\n");
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          program2 = program2 +("\t");
          box_tmp--;
        }
        program2 = program2 +("}\n");
        break;
      case 16 :
        program2 = program2 +("ループ開始をif文終了地点に入れないでください！\n");
        break;
      case 17 :
        program2 = program2 +("}\n");
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          program2 = program2 +("\t");
          box_tmp--;
        }
        program2 = program2 +("}\n");
        break;
      case 19 :
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          program2 = program2 +("\t");
          box_tmp--;
        }
        program2 = program2 +("}\n");
        break;
      default:
        break;
      }
      if (epoint[esoezi]==i&&epoint[esoezi]!=0) {
        box_tmp=line_box[i+1];
        while (box_tmp>=2) {
          program2 = program2 +("\t");
          box_tmp--;
        }
        program2 = program2 +("}else{\n");
        esoezi++;
      }
    }
  }
}
public void file_out() {
  //ファイル出力
  String savefile = "data/tmp.txt";
  PrintWriter writer= createWriter(savefile);
  for (AbstractBlock block : blocklist) {
    if (block instanceof Block11) {
      writer.println(block.x +","+block.y+","+1+","+block.name);
    }
    if (block instanceof Block12_int) {
      writer.println(block.x +","+block.y+","+2+","+block.name.replace("(整数型)", ""));
    }
    if (block instanceof Block12_String) {
      writer.println(block.x +","+block.y+","+22+","+block.name.replace("(文字列型)", ""));
    }
    if (block instanceof Block12_double) {
      writer.println(block.x +","+block.y+","+222+","+block.name.replace("(小数型)", ""));
    }
    if (block instanceof Block13) {
      writer.println(block.x+ ","+block.y+","+3+","+block.name);
    }
    if (block instanceof Block14) {
      writer.println(block.x +","+block.y+","+4+","+block.name);
    }
    if (block instanceof Block15) {
      writer.println(block.x +","+block.y+","+5+","+block.name.replace("を出力", ""));
    }
    if (block instanceof Block6_for) {
      writer.println(block.x +","+block.y+","+6+","+block.name);
    }
    if (block instanceof Block6_while) {
      writer.println(block.x +","+block.y+","+66+","+block.name);
    }
    if (block instanceof Block17) {
      writer.println(block.x +","+block.y+","+7+","+block.name);
    }
    if (block instanceof Block18) {
      writer.println(block.x +","+block.y+","+8+","+block.name);
    }
    if (block instanceof Block19) {
      writer.println(block.x +","+block.y+","+9+","+"null");
    }
    if (block instanceof Block21) {
      writer.println(block.x +","+block.y+","+11+","+block.name);
    }
    if (block instanceof Block22) {
      writer.println(block.x +","+block.y+","+12+","+block.name);
    }
    if (block instanceof Block23) {
      writer.println(block.x +","+block.y+","+13+","+block.name);
    }
    if (block instanceof Block24) {
      writer.println(block.x +","+block.y+","+14+","+block.name);
    }
    if (block instanceof Block25) {
      writer.println(block.x +","+block.y+","+15+","+block.name.replace("を出力", ""));
    }
    if (block instanceof Block26) {  
      writer.println(block.x +","+block.y+","+16+","+block.name);
    }
    if (block instanceof Block27) {
      writer.println(block.x +","+block.y+","+17+","+block.name);
    }
    if (block instanceof Block28) {
      writer.println(block.x +","+block.y+","+18+","+block.name);
    }
    if (block instanceof Block29) {
      writer.println(block.x +","+block.y+","+19+","+block.name);
    }
  }
  writer.close();
}
public void file_in() {
  //ファイルを読み込み
  final String FILE_NAME = "tmp.txt";
  String lineData[] = null;
  //テキストファイルを読む
  lineData = loadStrings( FILE_NAME );
  if ( lineData == null ) {
    //読み込み失敗
    println( FILE_NAME + " 読み込み失敗" );
    exit();
  }

  int x[]=new int[300];
  int y[]=new int[300];
  int blockID[]=new int[300];
  String name[]=new String[300];
  int i=0;
  try {
    BufferedReader reader = createReader(FILE_NAME);
    String str;
    str=reader.readLine();
    String []data=str.split(",", 0);
    x[i]=Integer.parseInt(data[0]);
    y[i]=Integer.parseInt(data[1]);
    blockID[i] = Integer.parseInt(data[2]);
    name[i]=data[3];
    i++;
    int xhandan[] = new int[5];
    xhandan[0]=x[0];
    xhandan[1]=x[0]+150;
    xhandan[2]=x[0]+300;
    xhandan[3]=x[0]+450;
    xhandan[4]=x[0]+600;
    while ((str=reader.readLine())!=null) {
      data=str.split(",", 0);
      if (Integer.parseInt(data[0])==xhandan[0]||
        Integer.parseInt(data[0])==xhandan[1]||
        Integer.parseInt(data[0])==xhandan[2]||
        Integer.parseInt(data[0])==xhandan[3]||
        Integer.parseInt(data[0])==xhandan[4]) {
        x[i]=Integer.parseInt(data[0]);
        y[i]=Integer.parseInt(data[1]);
        blockID[i] = Integer.parseInt(data[2]);
        name[i]=data[3];
        i++;
      }
    }
  }
  catch(IOException e) {
    println( FILE_NAME + " 読み込み失敗" );
    exit();
  }
  catch(NumberFormatException e) {
    println( FILE_NAME + " データ破損！！！！！！" );
  }

  //ｙ座標でソート
  int l;
  int m, n, a, b;
  m=0; 
  n=0;
  a=0;
  b=0;
  for (l=0; 0!=y[l]; l++) {
  }
  int tmp;
  String tmp2;

  for ( i=0; i<l-1; i++) {
    for (int j=l-1; j>i; j--) {
      if (y[j]<y[j-1]) {
        tmp=x[j];
        x[j]=x[j-1];
        x[j-1]=tmp;

        tmp=y[j];
        y[j]=y[j-1];
        y[j-1]=tmp;

        tmp= blockID[j];
        blockID[j]= blockID[j-1];
        blockID[j-1]=tmp;

        tmp2= name[j];
        name[j]= name[j-1];
        name[j-1]=tmp2;
      }
    }
  }

  //x座標でソート
  for ( i=0; i<l-1; i++) {
    for (int j=l-1; j>i; j--) {
      if (y[j]==y[j-1]) {
        if (x[j]<x[j-1]) {
          tmp=x[j];
          x[j]=x[j-1];
          x[j-1]=tmp;

          tmp=y[j];
          y[j]=y[j-1];
          y[j-1]=tmp;

          tmp= blockID[j];
          blockID[j]= blockID[j-1];
          blockID[j-1]=tmp;

          tmp2= name[j];
          name[j]= name[j-1];
          name[j-1]=tmp2;

          //j=l-1;
        }
      }
    }
  }

  String savefile = "data/henkan.txt";
  PrintWriter writer= createWriter(savefile);

  //処理を行う順番にline[]へ格納
  int line[]= new int[500];
  String line_name[]= new String[500];
  int R;
  R = 0;
  int xhandan[] = new int[5];
  xhandan[0]=x[0];
  xhandan[1]=x[0]+150;
  xhandan[2]=x[0]+300;
  xhandan[3]=x[0]+450;
  xhandan[4]=x[0]+600;
  int xsoezi = 0;
  int soezi_save;
  int epoint[]  = new int[100];
  int esoezi = 0;
  int line_box[]  = new int[500];
  int box = 0;
  int save_point = 1;
  int stop = 0;
  for ( i = 0; i <= l; i++) {
    if (xhandan[xsoezi]==x[i]) {
      line[R] = blockID[i];
      if ((blockID[i]==11||
        blockID[i]==12||
        blockID[i]==13||
        blockID[i]==14||
        blockID[i]==15||
        blockID[i]==16||
        blockID[i]==17||
        blockID[i]==18||
        blockID[i]==19)&&
        (blockID[i+1]==11||
        blockID[i+1]==12||
        blockID[i+1]==13||
        blockID[i+1]==14||
        blockID[i+1]==15||
        blockID[i+1]==16||
        blockID[i+1]==17||
        blockID[i+1]==18||
        blockID[i+1]==19)) {
        line[R] = blockID[i]-10;
      }
      //if (line[R]==4) {
      //  System.out.print("ここです");
      //}
      line_name[R] = name[i];
      line_box[R]=box;
      R++;
      if (blockID[i]==4) {
        //System.out.print("ここだあああああ");
        save_point=i;
      }
      if (blockID[i]==1||
        blockID[i]==4||
        blockID[i]==6||
        blockID[i]==66) {
        box = box + 1;
        System.out.print(blockID[i]);
        System.out.println("のおかげでプラスだべ！");
      }
      if (blockID[i]==7||
        blockID[i]==11||
        blockID[i]==12||
        blockID[i]==13||
        blockID[i]==14||
        blockID[i]==15||
        blockID[i]==16||
        blockID[i]==17||
        blockID[i]==18||
        blockID[i]==19) {
        if (blockID[i+1]==11||
          blockID[i+1]==12||
          blockID[i+1]==13||
          blockID[i+1]==14||
          blockID[i+1]==15||
          blockID[i+1]==16||
          blockID[i+1]==17||
          blockID[i+1]==18||
          blockID[i+1]==19) {
          stop++;
        } else {
          box = box - 1;
          System.out.print(blockID[i]);
          System.out.println("のおかげでマイナスだべ！");
          while (stop>0) {
            stop--;
            box--;
          }
        }
      }
      if (y[i]==y[i+1]&&
        blockID[i+1]==11||
        blockID[i+1]==12||
        blockID[i+1]==13||
        blockID[i+1]==14||
        blockID[i+1]==15||
        blockID[i+1]==16||
        blockID[i+1]==17||
        blockID[i+1]==18||
        blockID[i+1]==19) {
        i = save_point;
        System.out.print("添え字プラス");
        epoint[esoezi] = R-1;
        esoezi++;
        xsoezi++;
      }
      if (blockID[i] == 11||
        blockID[i] == 12||
        blockID[i] == 13||
        blockID[i] == 14||
        blockID[i] == 15||
        blockID[i] == 16||
        blockID[i] == 17||
        blockID[i] == 18||
        blockID[i] == 19) {
        System.out.print("添え字マイナス");
        xsoezi--;
        int j=i;
        soezi_save=xsoezi;
        while (soezi_save>=1) {
          if (blockID[j-1]==11||
            blockID[j-1]==12||
            blockID[j-1]==13||
            blockID[j-1]==14||
            blockID[j-1]==15||
            blockID[j-1]==16||
            blockID[j-1]==17||
            blockID[j-1]==18||
            blockID[j-1]==19) {
            xsoezi--;
            System.out.print("添え字マイナスだよ");
            line[R]=999;
            line_name[R]="a";
            line_box[R]=box;
            l++;
            R++;
          }
          soezi_save--;
          j--;
        }
      }
    }
    if (i+1>l&&i!=R) {
      System.out.println(R);
      //R=0;
      while (i!=R) {
        line[R] = 2;
        line_name[R] = "エラー";
        epoint[R]=-1;
        line_box[R] = 0;
        R++;
      }
    }
  }

  //表示
  esoezi= 0;
  int box_tmp;
  for (i=0; i<l; i++) {
    if (line_name[i].equals("null")) {
    } else {
      if(line[i]==7){
        line_box[i]--;
      }
      while (line_box[i]>0) {
        writer.print("\t");
        line_box[i]--;
      }
      switch(line[i]) {
      case 1 :
        writer.println("#include <stdio.h>\n\nint main(){");
        break;
      case 2 :
        writer.println("int "+line_name[i]+";");
        break;
      case 22 :
        writer.println("char "+line_name[i]+";");
        break;
      case 222 :
        writer.println("double "+line_name[i]+";");
        break;
      case 3 :
        writer.println(line_name[i]+";");
        break;
      case 4 :
        writer.println("if("+line_name[i]+"){");
        break;
      case 5 :
        writer.println("printf(\"%d,"+line_name[i]+"\");");
        break;
      case 66 :
        writer.println("while("+line_name[i]+"){");
        break;
      case 6 :
        writer.println("for("+line_name[i]+"){");
        break;
      case 7 :
        writer.println("}");
        break;
      case 8:
        writer.println("return 0;\n}");
        break;
      case 12 :
        writer.println(line_name[i]+";");
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          writer.print("\t");
          box_tmp--;
        }
        if (line[i+1]==999) {
          writer.println("\t}");
        } else {
          writer.println("}");
        }
        break;
      case 13 :
        writer.println(line_name[i]+";");
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          writer.print("\t");
          box_tmp--;
        }
        if (line[i+1]==999) {
          writer.println("\t}");
        } else {
          writer.println("}");
        }
        break;
      case 15 :
        writer.println("printf(\"%d,"+line_name[i]+"\");");
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          writer.print("\t");
          box_tmp--;
        }
        if (line[i+1]==999) {
          writer.println("\t}");
        } else {
          writer.println("}");
        }
        break;
      case 16 :
        writer.println("ループ開始をif文終了地点に入れないでください！");
        break;
      case 17 :
        writer.println("}");
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          writer.print("\t");
          box_tmp--;
        }
        if (line[i+1]==999) {
          writer.println("\t}");
        } else {
          writer.println("}");
        }
        break;
      case 19 :
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          writer.print("\t");
          box_tmp--;
        }
        if (line[i+1]==999) {
          writer.println("\t}");
        } else {
          writer.println("}");
        }
        break;
      case 999 :
        writer.println("}");
        break;
      default:
        break;
      }
      if (epoint[esoezi]==i&&epoint[esoezi]!=0) {
        box_tmp=line_box[i+1];
        while (box_tmp>=2) {
          writer.print("\t");
          box_tmp--;
        }
        writer.println("}else{");
        esoezi++;
      }
    }
  }

  writer.close();
}
public void file_out4() {
  //ファイル出力
  String savefile = "data/tmp.txt";
  PrintWriter writer= createWriter(savefile);
  for (AbstractBlock block : blocklist) {
    if (block instanceof Block11) {
      writer.println(block.x +","+block.y+","+1+","+block.name);
    }
    if (block instanceof Block12_int) {
      writer.println(block.x +","+block.y+","+2+","+block.name.replace("(整数型)", ""));
    }
    if (block instanceof Block12_String) {
      writer.println(block.x +","+block.y+","+22+","+block.name.replace("(文字列型)", ""));
    }
    if (block instanceof Block12_double) {
      writer.println(block.x +","+block.y+","+222+","+block.name.replace("(小数型)", ""));
    }
    if (block instanceof Block13) {
      writer.println(block.x+ ","+block.y+","+3+","+block.name);
    }
    if (block instanceof Block14) {
      writer.println(block.x +","+block.y+","+4+","+block.name);
    }
    if (block instanceof Block15) {
      writer.println(block.x +","+block.y+","+5+","+block.name.replace("を出力", ""));
    }
    if (block instanceof Block6_for) {
      writer.println(block.x +","+block.y+","+6+","+block.name);
    }
    if (block instanceof Block6_while) {
      writer.println(block.x +","+block.y+","+66+","+block.name);
    }
    if (block instanceof Block17) {
      writer.println(block.x +","+block.y+","+7+","+block.name);
    }
    if (block instanceof Block18) {
      writer.println(block.x +","+block.y+","+8+","+block.name);
    }
    if (block instanceof Block19) {
      writer.println(block.x +","+block.y+","+9+","+"null");
    }
    if (block instanceof Block21) {
      writer.println(block.x +","+block.y+","+11+","+block.name);
    }
    if (block instanceof Block22) {
      writer.println(block.x +","+block.y+","+12+","+block.name);
    }
    if (block instanceof Block23) {
      writer.println(block.x +","+block.y+","+13+","+block.name);
    }
    if (block instanceof Block24) {
      writer.println(block.x +","+block.y+","+14+","+block.name);
    }
    if (block instanceof Block25) {
      writer.println(block.x +","+block.y+","+15+","+block.name.replace("を出力", ""));
    }
    if (block instanceof Block26) {  
      writer.println(block.x +","+block.y+","+16+","+block.name);
    }
    if (block instanceof Block27) {
      writer.println(block.x +","+block.y+","+17+","+block.name);
    }
    if (block instanceof Block28) {
      writer.println(block.x +","+block.y+","+18+","+block.name);
    }
    if (block instanceof Block29) {
      writer.println(block.x +","+block.y+","+19+","+block.name);
    }
  }
  writer.close();
}
public void file_in4() {
  //ファイルを読み込み
  final String FILE_NAME = "tmp.txt";
  String lineData[] = null;
  //テキストファイルを読む
  lineData = loadStrings( FILE_NAME );
  if ( lineData == null ) {
    //読み込み失敗
    println( FILE_NAME + " 読み込み失敗" );
    exit();
  }

  int x[]=new int[300];
  int y[]=new int[300];
  int blockID[]=new int[300];
  String name[]=new String[300];
  int i=0;
  try {
    BufferedReader reader = createReader(FILE_NAME);
    String str;
    str=reader.readLine();
    String []data=str.split(",", 0);
    x[i]=Integer.parseInt(data[0]);
    y[i]=Integer.parseInt(data[1]);
    blockID[i] = Integer.parseInt(data[2]);
    name[i]=data[3];
    i++;
    int xhandan[] = new int[5];
    xhandan[0]=x[0];
    xhandan[1]=x[0]+150;
    xhandan[2]=x[0]+300;
    xhandan[3]=x[0]+450;
    xhandan[4]=x[0]+600;
    while ((str=reader.readLine())!=null) {
      data=str.split(",", 0);
      if (Integer.parseInt(data[0])==xhandan[0]||
        Integer.parseInt(data[0])==xhandan[1]||
        Integer.parseInt(data[0])==xhandan[2]||
        Integer.parseInt(data[0])==xhandan[3]||
        Integer.parseInt(data[0])==xhandan[4]) {
        x[i]=Integer.parseInt(data[0]);
        y[i]=Integer.parseInt(data[1]);
        blockID[i] = Integer.parseInt(data[2]);
        name[i]=data[3];
        i++;
      }
    }
  }  
  catch(IOException e) {
    println( FILE_NAME + " 読み込み失敗" );
    exit();
  }
  catch(NumberFormatException e) {
    println( FILE_NAME + " データ破損！！！！！！" );
  }

  //ｙ座標でソート
  int l;
  int m, n, a, b;
  m=0; 
  n=0;
  a=0;
  b=0;
  for (l=0; 0!=y[l]; l++) {
  }
  int tmp;
  String tmp2;

  for ( i=0; i<l-1; i++) {
    for (int j=l-1; j>i; j--) {
      if (y[j]<y[j-1]) {
        tmp=x[j];
        x[j]=x[j-1];
        x[j-1]=tmp;

        tmp=y[j];
        y[j]=y[j-1];
        y[j-1]=tmp;

        tmp= blockID[j];
        blockID[j]= blockID[j-1];
        blockID[j-1]=tmp;

        tmp2= name[j];
        name[j]= name[j-1];
        name[j-1]=tmp2;
      }
    }
  }
  //x座標でソート
  for ( i=0; i<l-1; i++) {
    for (int j=l-1; j>i; j--) {
      if (y[j]==y[j-1]) {
        if (x[j]<x[j-1]) {
          tmp=x[j];
          x[j]=x[j-1];
          x[j-1]=tmp;

          tmp=y[j];
          y[j]=y[j-1];
          y[j-1]=tmp;

          tmp= blockID[j];
          blockID[j]= blockID[j-1];
          blockID[j-1]=tmp;

          tmp2= name[j];
          name[j]= name[j-1];
          name[j-1]=tmp2;

          //j=l-1;
        }
      }
    }
  }

  String savefile = "data/henkan.txt";
  PrintWriter writer= createWriter(savefile);

  //処理を行う順番にline[]へ格納
  int line[]= new int[500];
  String line_name[]= new String[500];
  int R;
  R = 0;
  int xhandan[] = new int[5];
  xhandan[0]=x[0];
  xhandan[1]=x[0]+150;
  xhandan[2]=x[0]+300;
  xhandan[3]=x[0]+450;
  xhandan[4]=x[0]+600;
  int xsoezi = 0;
  int soezi_save;
  int epoint[]  = new int[100];
  int esoezi = 0;
  int line_box[]  = new int[500];
  int box = 0;
  int save_point = 1;
  for ( i = 0; i <= l; i++) {
    if (xhandan[xsoezi]==x[i]) {
      line[R] = blockID[i];
      if (line[R]==4) {
        System.out.print("ここです");
      }
      line_name[R] = name[i];
      line_box[R]=box;
      R++;
      if (blockID[i]==4) {
        System.out.print("ここだあああああ");
        save_point=i;
      }
      if (blockID[i]==1) {
        box = box + 2;
      }
      if (blockID[i]==8) {
        box = box - 2;
      }
      if (blockID[i]==4||
        blockID[i]==6||
        blockID[i]==66) {
        box = box + 1;
      }
      if (blockID[i]==7||
        blockID[i]==11||
        blockID[i]==12||
        blockID[i]==13||
        blockID[i]==14||
        blockID[i]==15||
        blockID[i]==16||
        blockID[i]==17||
        blockID[i]==18||
        blockID[i]==19) {
        box = box - 1;
      }
      if (y[i]==y[i+1]&&
        blockID[i+1]==11||
        blockID[i+1]==12||
        blockID[i+1]==13||
        blockID[i+1]==14||
        blockID[i+1]==15||
        blockID[i+1]==16||
        blockID[i+1]==17||
        blockID[i+1]==18||
        blockID[i+1]==19) {
        i = save_point;
        System.out.print("添え字プラス");
        epoint[esoezi] = R-1;
        esoezi++;
        xsoezi++;
      }
      if (blockID[i] == 11||
        blockID[i] == 12||
        blockID[i] == 13||
        blockID[i] == 14||
        blockID[i] == 15||
        blockID[i] == 16||
        blockID[i] == 17||
        blockID[i] == 18||
        blockID[i] == 19) {
        System.out.print("添え字マイナス");
        xsoezi--;
        int j=i;
        soezi_save=xsoezi;
        while (soezi_save>=1) {
          if (blockID[j-1]==11||
            blockID[j-1]==12||
            blockID[j-1]==13||
            blockID[j-1]==14||
            blockID[j-1]==15||
            blockID[j-1]==16||
            blockID[j-1]==17||
            blockID[j-1]==18||
            blockID[j-1]==19) {
            xsoezi--;
            System.out.print("添え字マイナスだよ");
          }
          soezi_save--;
          j--;
        }
      }
    }
    if (i+1>l&&i!=R) {
      System.out.println(R);
      //R=0;
      while (i!=R) {
        line[R] = 2;
        line_name[R] = "エラー";
        epoint[R]=-1;
        line_box[R] = 0;
        R++;
      }
    }
  }

  //表示
  esoezi= 0;
  int box_tmp;
  for (i=0; i<l; i++) {
    if (line_name[i].equals("null")) {
    } else {
      if(line[i]==7){
        line_box[i]--;
      }
      if (line[i]!=8) {
        while (line_box[i]>0) {
          writer.print("\t");
          line_box[i]--;
        }
      }
      switch(line[i]) {
      case 1 :
        writer.println("public class クラス名 {\n\tpublic static void main(String args[]) {");
        break;
      case 2 :
        writer.println("int "+line_name[i]+";");
        break;
      case 22 :
        writer.println("String "+line_name[i]+";");
        break;
      case 222 :
        writer.println("double "+line_name[i]+";");
        break;
      case 3 :
        writer.println(line_name[i]+";");
        break;
      case 4 :
        writer.println("if("+line_name[i]+"){");
        break;
      case 5 :
        writer.println("System.out.println("+line_name[i]+");");
        break;
      case 66 :
        writer.println("while("+line_name[i]+"){");
        break;
      case 6 :
        writer.println("for("+line_name[i]+"){");
        break;
      case 7 :
        writer.println("}");
        break;
      case 8:
        writer.println("\t}\n}");
        break;
      case 12 :
        writer.println(line_name[i]+";");
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          writer.print("\t");
          box_tmp--;
        }
        writer.println("}");
        break;
      case 13 :
        writer.println(line_name[i]+";");
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          writer.print("\t");
          box_tmp--;
        }
        writer.println("}");
        break;
      case 15 :
        writer.println("System.out.println("+line_name[i]+");");
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          writer.print("\t");
          box_tmp--;
        }
        writer.println("}");
        break;
      case 16 :
        writer.println("ループ開始をif文終了地点に入れないでください！");
        break;
      case 17 :
        writer.println("}");
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          writer.print("\t");
          box_tmp--;
        }
        writer.println("}");
        break;
      case 19 :
        box_tmp=line_box[i+1];
        while (box_tmp>0) {
          writer.print("\t");
          box_tmp--;
        }
        writer.println("}");
        break;
      case 999 :
        writer.println("}");
        break;
      default:
        break;
      }
      if (epoint[esoezi]==i&&epoint[esoezi]!=0) {
        box_tmp=line_box[i+1];
        while (box_tmp>=2) {
          writer.print("\t");
          box_tmp--;
        }
        writer.println("}else{");
        esoezi++;
      }
    }
  }

  writer.close();
}
  public void settings() {  size(1600, 850); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "flowchart_beta_ver_3_6" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
