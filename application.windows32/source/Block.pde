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
  void move(int addX, int addY) {
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
  color[] colorPallet ={color(255, 0, 0), 
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
  color[] colorPallet ={color(255, 0, 0), 
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
  color[] colorPallet ={color(255, 0, 0), 
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
  color[] colorPallet ={color(255, 0, 0), 
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
  color[] colorPallet ={color(255, 100, 100), 
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
    fill(#ff8205); 
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
    fill(#ff8205); 
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
