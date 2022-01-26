void file_out3() {
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
void file_in3() {
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
