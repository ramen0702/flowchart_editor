import controlP5.*;

//インポート関係
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

//IP5関連1
import controlP5.*;
import java.util.*;
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
void setup() {
  surface.setResizable(true);
  //画面サイズ変更
  size(1600, 850);
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

void draw() {
  background(#fffaf0);
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

void mousePressed() {
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

void mouseClicked(MouseEvent evt) {
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

void mouseDragged() {

  if (selectedBlock != null) {
    selectedBlock.move(mouseX - pmouseX, mouseY - pmouseY);
  }
}
void mouseReleased() {
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

void dispose() {

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
