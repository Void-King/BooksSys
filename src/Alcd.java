
import java.io.*;
import java.text.Collator;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;




//主界面
public class Alcd extends Application{
	@Override
	public void start(Stage x) {
		GridPane book = new GridPane();
		GridPane bookt = new GridPane();
		GridPane bookb = new GridPane();
		GridPane bookbe = new GridPane();
		ScrollPane bookcon = new ScrollPane();
		
		Label sh = new Label("书号");
		Label sm = new Label("书名");
		Label zzm = new Label("作者名");
		Label jg = new Label("价格");
		Label gmrq = new Label("购买日期");
		sh.setMinWidth(100);
		sm.setMinWidth(150);
		zzm.setMinWidth(100);
		jg.setMinWidth(100);
		gmrq.setMinWidth(100);
		bookcon.setMinHeight(600);
		
		bookt.add(sh, 0, 0);
		bookt.add(sm, 1, 0);
		bookt.add(zzm, 2, 0);
		bookt.add(jg, 3, 0);
		bookt.add(gmrq, 4, 0);
		
		
		
		
		Button bt1 = new Button("查找");
		Button bt2 = new Button("插入");
		Button bt3 = new Button("删除");
		Button bt4 = new Button("更新");
		Button bt5 = new Button("排序");
		Button bt6 = new Button("刷新");
		Button bt7 = new Button("号");
		Button bt8 = new Button("名");
		bt1.setMinSize(75, 50);
		bt2.setMinSize(75, 50);
		bt3.setMinSize(75, 50);
		bt4.setMinSize(75, 50);
		bt5.setMinSize(75, 50);
		bt6.setMinSize(75, 50);
		bt7.setMinSize(20, 20);
		bt8.setMinSize(20, 20);
		
		bt1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				bookLookCk();
			}
		});
		
		bt2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				bookIn();
			}
		});
		
		bt3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e1) {
				bookOut();
			}
		});
		
		bt4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e1) {
				bookUp();
			}
		});
		
		bt5.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				GridPane bookcontext = new GridPane();
				
				try {
					Vector<book> books = new Vector<>();
					File fe = new File("Books.txt");
					Scanner in = new Scanner(fe);
					while(in.hasNextLine()) {
						String A = in.nextLine();
						String B = in.nextLine();
						String C = in.nextLine();
						String D = in.nextLine();
						String E = in.nextLine();
						
						books.add(new book(A,B,C,D,E));
					}
					book[] bookst= new book[books.size()];
					
					for (int it = 0; it < books.size(); it++) {
						bookst[it] = books.get(it);
					}
					chinaSort(bookst,0);
					for (int it = 0; it < bookst.length; it++) {
						Label temp1 = new Label(bookst[it].sh);
						Label temp2 = new Label(bookst[it].sm);
						Label temp3 = new Label(bookst[it].zzm);
						Label temp4 = new Label(bookst[it].jg);
						Label temp5 = new Label(bookst[it].gmrq);
						temp1.setMinWidth(100);
						temp2.setMinWidth(150);
						temp3.setMinWidth(100);
						temp4.setMinWidth(100);
						temp5.setMinWidth(80);
						bookcontext.add(temp1, 0, it);
						bookcontext.add(temp2, 1, it);
						bookcontext.add(temp3, 2, it);
						bookcontext.add(temp4, 3, it);
						bookcontext.add(temp5, 4, it);
					}
					in.close();
				}
				catch(Exception e1) {
					
				}
				bookcontext.setPadding(new Insets(5,10,5,10));
				bookcon.setContent(bookcontext);
				bookcon.layout();
			}
		});
		
		bt6.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				GridPane bookcontext = new GridPane();
				int i = 0;
				try {
					File fe = new File("Books.txt");
					Scanner in = new Scanner(fe);
					while(in.hasNextLine()) {
						Label temp1 = new Label(in.nextLine());
						Label temp2 = new Label(in.nextLine());
						Label temp3 = new Label(in.nextLine());
						Label temp4 = new Label(in.nextLine());
						Label temp5 = new Label(in.nextLine());
						temp1.setMinWidth(100);
						temp2.setMinWidth(150);
						temp3.setMinWidth(100);
						temp4.setMinWidth(100);
						temp5.setMinWidth(80);
						bookcontext.add(temp1, 0, i);
						bookcontext.add(temp2, 1, i);
						bookcontext.add(temp3, 2, i);
						bookcontext.add(temp4, 3, i);
						bookcontext.add(temp5, 4, i);
						i++;
					}
					in.close();
				}
				catch(Exception e1) {
					
				}
				bookcontext.setPadding(new Insets(5,10,5,10));
				bookcon.setContent(bookcontext);
				bookcon.layout();
			}
		});
		
		
		bt7.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				GridPane bookcontext = new GridPane();
				
				try {
					Vector<book> books = new Vector<>();
					File fe = new File("Books.txt");
					Scanner in = new Scanner(fe);
					while(in.hasNextLine()) {
						String A = in.nextLine();
						String B = in.nextLine();
						String C = in.nextLine();
						String D = in.nextLine();
						String E = in.nextLine();
						
						books.add(new book(A,B,C,D,E));
					}
					book[] bookst= new book[books.size()];
					
					for (int it = 0; it < books.size(); it++) {
						bookst[it] = books.get(it);
					}
					chinaSort(bookst,1);
					for (int it = 0; it < bookst.length; it++) {
						Label temp1 = new Label(bookst[it].sh);
						Label temp2 = new Label(bookst[it].sm);
						Label temp3 = new Label(bookst[it].zzm);
						Label temp4 = new Label(bookst[it].jg);
						Label temp5 = new Label(bookst[it].gmrq);
						temp1.setMinWidth(100);
						temp2.setMinWidth(150);
						temp3.setMinWidth(100);
						temp4.setMinWidth(100);
						temp5.setMinWidth(80);
						bookcontext.add(temp1, 0, it);
						bookcontext.add(temp2, 1, it);
						bookcontext.add(temp3, 2, it);
						bookcontext.add(temp4, 3, it);
						bookcontext.add(temp5, 4, it);
					}
					in.close();
					
				}
				catch(Exception e1) {
					
				}
				bookcontext.setPadding(new Insets(5,10,5,10));
				bookcon.setContent(bookcontext);
				bookcon.layout();
			}
		});
		
		bt8.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				GridPane bookcontext = new GridPane();
				
				try {
					Vector<book> books = new Vector<>();
					File fe = new File("Books.txt");
					Scanner in = new Scanner(fe);
					while(in.hasNextLine()) {
						String A = in.nextLine();
						String B = in.nextLine();
						String C = in.nextLine();
						String D = in.nextLine();
						String E = in.nextLine();
						
						books.add(new book(A,B,C,D,E));
					}
					book[] bookst= new book[books.size()];
					
					for (int it = 0; it < books.size(); it++) {
						bookst[it] = books.get(it);
					}
					chinaSort(bookst,2);
					for (int it = 0; it < bookst.length; it++) {
						Label temp1 = new Label(bookst[it].sh);
						Label temp2 = new Label(bookst[it].sm);
						Label temp3 = new Label(bookst[it].zzm);
						Label temp4 = new Label(bookst[it].jg);
						Label temp5 = new Label(bookst[it].gmrq);
						temp1.setMinWidth(100);
						temp2.setMinWidth(150);
						temp3.setMinWidth(100);
						temp4.setMinWidth(100);
						temp5.setMinWidth(80);
						bookcontext.add(temp1, 0, it);
						bookcontext.add(temp2, 1, it);
						bookcontext.add(temp3, 2, it);
						bookcontext.add(temp4, 3, it);
						bookcontext.add(temp5, 4, it);
					}
					in.close();
					
				}
				catch(Exception e1) {
					
				}
				bookcontext.setPadding(new Insets(5,10,5,10));
				bookcon.setContent(bookcontext);
				bookcon.layout();
			}
		});
		
		bookb.add(bt6, 0, 0);
		bookb.add(bt1, 1, 0);
		bookb.add(bt2, 2, 0);
		bookb.add(bt3, 3, 0);
		bookb.add(bt4, 4, 0);
		bookb.add(bt5, 5, 0);
		bookbe.add(bt7, 0, 0);
		bookbe.add(bt8, 0, 1);
		bookb.add(bookbe, 6, 0);
		
		
		//bookb.setPadding(new Insets(0,0,10,0));
		bookb.setHgap(10);
		bookb.setAlignment(Pos.CENTER);
		bookbe.setAlignment(Pos.CENTER);
		bookbe.setVgap(5);
		
		bookt.setPadding(new Insets(0,10,0,10));
		
		//bookcon.getStyleClass().add("edge-to-edge");
		
		
		
		book.add(bookt, 0, 0);
		book.add(bookcon, 0, 1);
		book.add(bookb, 0, 2);
		book.setVgap(10);
		
		
		book.setPadding(new Insets(10,5,10,5));
		
		Scene books = new Scene(book,580,705);
		x.setScene(books);
		x.setTitle("Books");
		x.getIcons().add(new Image("ico.png"));
		x.show();
	}
	
	//查看选择界面
	public void bookLookCk() {
		Stage x = new Stage();
		GridPane bookin = new GridPane();
		Button bt = new Button("查找");
		bt.setMinSize(120, 30);
		TextField sm = new TextField();
		sm.setMinSize(160, 30);
		sm.setMaxSize(160, 30);
		TextField zzm = new TextField();
		zzm.setMinSize(160, 30);
		zzm.setMaxSize(160, 30);
		
		bt.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e) {
				String s2 = sm.getText();
				String s3 = zzm.getText();
				int excheck = 0;
				try {
					File f = new File("Books.txt");
					Scanner in = new Scanner(f);
					while (in.hasNextLine()) {
						String A = in.nextLine();
						String B = in.nextLine();
						String C = in.nextLine();
						String D = in.nextLine();
						String E = in.nextLine();
						if (s2.equals(B) || s3.equals(C)){
							bookLookRe(s2,s3);
							excheck = 1;
							x.close();
							break;
						}
						
					}
					in.close();
				}
				catch(Exception e1) {
					
				}
				if (excheck == 0) {
					alertForm("书目不存在!");
				}
			}
			
			
			
		});
		
		Label sm1 = new Label("书名");
		sm1.setFont(new Font(15));
		Label zzm1 = new Label("作者名");
		zzm1.setFont(new Font(15));
		
		bookin.add(sm1, 0, 1);
		bookin.add(zzm1, 0, 2);
		bookin.add(sm, 1, 1);
		bookin.add(zzm, 1, 2);
		bookin.add(bt, 1, 5);
		
		
		bookin.setHgap(10);
		bookin.setVgap(10);
		bookin.setAlignment(Pos.CENTER);
		Scene xs = new Scene(bookin,250,200);
		
		x.setScene(xs);
		x.setTitle("BooksLook");
		x.getIcons().add(new Image("ico.png"));
		x.show();
	}
	
	//查看结果界面
	public void bookLookRe(String s2, String s3) {
		Stage x = new Stage();
		GridPane book = new GridPane();
		GridPane bookt = new GridPane();
		GridPane bookcontext = new GridPane();
		ScrollPane bookcon = new ScrollPane();
		
		Label sh = new Label("书号");
		Label sm = new Label("书名");
		Label zzm = new Label("作者名");
		Label jg = new Label("价格");
		Label gmrq = new Label("购买日期");
		sh.setMinWidth(100);
		sm.setMinWidth(150);
		zzm.setMinWidth(100);
		jg.setMinWidth(100);
		gmrq.setMinWidth(100);
		bookcon.setMinHeight(400);
		
		bookt.add(sh, 0, 0);
		bookt.add(sm, 1, 0);
		bookt.add(zzm, 2, 0);
		bookt.add(jg, 3, 0);
		bookt.add(gmrq, 4, 0);
		File f = new File("Books.txt");
		File ft = new File("BooksTemp.ini");
		try {
			Scanner in = new Scanner(f);
			int i = 0;
			while (in.hasNextLine()) {
				String A = in.nextLine();
				String B = in.nextLine();
				String C = in.nextLine();
				String D = in.nextLine();
				String E = in.nextLine();
				if (s2.equals(B) || s3.equals(C)){
					Label temp1 = new Label(A);
					Label temp2 = new Label(B);
					Label temp3 = new Label(C);
					Label temp4 = new Label(D);
					Label temp5 = new Label(E);
					temp1.setMinWidth(100);
					temp2.setMinWidth(150);
					temp3.setMinWidth(100);
					temp4.setMinWidth(100);
					temp5.setMinWidth(80);
					bookcontext.add(temp1, 0, i);
					bookcontext.add(temp2, 1, i);
					bookcontext.add(temp3, 2, i);
					bookcontext.add(temp4, 3, i);
					bookcontext.add(temp5, 4, i);
					i++;
				}
				
			}
			in.close();
			
		}
		catch (Exception e1) {
			
		}
		bookt.setPadding(new Insets(0,10,0,10));
		bookcon.getStyleClass().add("edge-to-edge");
		bookcontext.setPadding(new Insets(5,10,5,10));
		bookcon.setContent(bookcontext);	
		book.add(bookt, 0, 0);
		book.add(bookcon, 0, 1);
		book.setVgap(10);
		book.setPadding(new Insets(10,5,10,5));
		Scene books = new Scene(book,580,450);
		x.setScene(books);
		x.setTitle("Books");
		x.getIcons().add(new Image("ico.png"));
		x.show();
	}
	
	//插入界面
	public void bookIn() {
		Stage x = new Stage();
		GridPane bookin = new GridPane();
		Button bt = new Button("增加");
		bt.setMinSize(120, 30);
		TextField sh = new TextField();
		sh.setMinSize(160, 30);
		sh.setMaxSize(160, 30);
		TextField sm = new TextField();
		sm.setMinSize(160, 30);
		sm.setMaxSize(160, 30);
		TextField zzm = new TextField();
		zzm.setMinSize(160, 30);
		zzm.setMaxSize(160, 30);
		TextField jg = new TextField();
		jg.setMinSize(160, 30);
		jg.setMaxSize(160, 30);
		TextField gmrq = new TextField();
		gmrq.setMinSize(160, 30);
		gmrq.setMaxSize(160, 30);
		bt.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e) {
				String s1 = sh.getText();
				String s2 = sm.getText();
				String s3 = zzm.getText();
				String s4 = jg.getText();
				String s5 = gmrq.getText();
				int excheck = 0;
				try {
					File f = new File("Books.txt");
					Scanner in = new Scanner(f);
					while (in.hasNextLine()) {
						String A = in.nextLine();
						String B = in.nextLine();
						String C = in.nextLine();
						String D = in.nextLine();
						String E = in.nextLine();
						if (s1.equals(A)){
							alertForm("书目已存在!");
							excheck = 1;
							x.close();
						}
						
					}
					in.close();
				}
				catch(Exception e1) {
					
				}
				if (excheck == 0) {
					addbook(s1,s2,s3,s4,s5);
					x.close();
				}
			}
			
			
			
		});
		
		Label sh1 = new Label("书号");
		sh1.setFont(new Font(15));
		Label sm1 = new Label("书名");
		sm1.setFont(new Font(15));
		Label zzm1 = new Label("作者名");
		zzm1.setFont(new Font(15));
		Label jg1 = new Label("价格");
		jg1.setFont(new Font(15));
		Label gmrq1 = new Label("购买日期");
		gmrq1.setFont(new Font(15));
		
		bookin.add(sh1, 0, 0);
		bookin.add(sm1, 0, 1);
		bookin.add(zzm1, 0, 2);
		bookin.add(jg1, 0, 3);
		bookin.add(gmrq1, 0, 4);
		bookin.add(sh, 1, 0);
		bookin.add(sm, 1, 1);
		bookin.add(zzm, 1, 2);
		bookin.add(jg, 1, 3);
		bookin.add(gmrq, 1, 4);
		bookin.add(bt, 1, 5);
		
		
		bookin.setHgap(10);
		bookin.setVgap(10);
		bookin.setAlignment(Pos.CENTER);
		Scene xs = new Scene(bookin,250,300);
		
		x.setScene(xs);
		x.setTitle("BooksIn");
		x.getIcons().add(new Image("ico.png"));
		x.show();
	}
	
	//插入函数
	public void addbook(String s1,String s2,String s3,String s4,String s5) {
		File f = new File("Books.txt");
		File ft = new File("BooksTemp.ini");
		try {
			Scanner in1 = new Scanner(f);
			PrintWriter out1 = new PrintWriter(ft);
			while (in1.hasNextLine()) {
				String A = in1.nextLine();
				String B = in1.nextLine();
				String C = in1.nextLine();
				String D = in1.nextLine();
				String E = in1.nextLine();
				out1.write(A + "\n");
				out1.write(B + "\n");
				out1.write(C + "\n");
				out1.write(D + "\n");
				out1.write(E + "\n");
			}
			in1.close();
			out1.close();
			
			Scanner in2 = new Scanner(ft);
			PrintWriter out2 = new PrintWriter(f);
			out2.write(s1 + "\n");
			out2.write(s2 + "\n");
			out2.write(s3 + "\n");
			out2.write(s4 + "\n");
			out2.write(s5 + "\n");
			while (in2.hasNextLine()) {
				String A = in2.nextLine();
				String B = in2.nextLine();
				String C = in2.nextLine();
				String D = in2.nextLine();
				String E = in2.nextLine();
				out2.write(A + "\n");
				out2.write(B + "\n");
				out2.write(C + "\n");
				out2.write(D + "\n");
				out2.write(E + "\n");
				
			}
			in2.close();
			out2.close();
			alertForm("增加成功！");
		}
		catch (Exception e1) {
			
		}
	}
	
	
	//删除界面
	public void bookOut() {
		Stage x = new Stage();
		GridPane bookin = new GridPane();
		Button bt = new Button("删除");
		bt.setMinSize(120, 30);
		TextField sh = new TextField();
		sh.setMinSize(160, 30);
		sh.setMaxSize(160, 30);
		bt.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e) {
				String s1 = sh.getText();
				int excheck = 0;
				try {
					File f = new File("Books.txt");
					Scanner in = new Scanner(f);
					while (in.hasNextLine()) {
						String A = in.nextLine();
						String B = in.nextLine();
						String C = in.nextLine();
						String D = in.nextLine();
						String E = in.nextLine();
						if (s1.equals(A)){
							excheck = 1;
							x.close();
						}
						
					}
					in.close();
				}
				catch(Exception e1) {	
					
				}
				if (excheck == 0) {
					alertForm("书目不存在!");
				}
				
				if (excheck == 1) {
					delbook(s1);
					x.close();
				}
			}
				
				
				
		});
			
		Label sh1 = new Label("书号");
		sh1.setFont(new Font(15));
		
		bookin.add(sh1, 0, 0);
		bookin.add(sh, 1, 0);
		bookin.add(bt, 1, 2);
		
			
		bookin.setHgap(10);
		bookin.setVgap(10);
		bookin.setAlignment(Pos.CENTER);
		Scene xs = new Scene(bookin,250,150);
			
		x.setScene(xs);
		x.setTitle("BooksOut");
		x.getIcons().add(new Image("ico.png"));
		x.show();
	}
		
	//删除函数
	public void delbook(String s1) {
		File f = new File("Books.txt");
		File ft = new File("BooksTemp.ini");
		try {
			Scanner in1 = new Scanner(f);
			PrintWriter out1 = new PrintWriter(ft);
			while (in1.hasNextLine()) {
				String A = in1.nextLine();
				String B = in1.nextLine();
				String C = in1.nextLine();
				String D = in1.nextLine();
				String E = in1.nextLine();
				if (s1.equals(A)) continue;
				out1.write(A + "\n");
				out1.write(B + "\n");
				out1.write(C + "\n");
				out1.write(D + "\n");
				out1.write(E + "\n");
			}
			in1.close();
			out1.close();
			
			Scanner in2 = new Scanner(ft);
			PrintWriter out2 = new PrintWriter(f);
			while (in2.hasNextLine()) {
				String A = in2.nextLine();
				String B = in2.nextLine();
				String C = in2.nextLine();
				String D = in2.nextLine();
				String E = in2.nextLine();
				out2.write(A + "\n");
				out2.write(B + "\n");
				out2.write(C + "\n");
				out2.write(D + "\n");
				out2.write(E + "\n");
				
			}
			in2.close();
			out2.close();
			alertForm("删除成功！");
		}
		catch (Exception e1) {
			
		}
	}
	
	//更新界面
	public void bookUp() {
		Stage x = new Stage();
		GridPane bookin = new GridPane();
		Button bt = new Button("更新");
		bt.setMinSize(120, 30);
		TextField sh = new TextField();
		sh.setMinSize(160, 30);
		sh.setMaxSize(160, 30);
		TextField sm = new TextField();
		sm.setMinSize(160, 30);
		sm.setMaxSize(160, 30);
		TextField zzm = new TextField();
		zzm.setMinSize(160, 30);
		zzm.setMaxSize(160, 30);
		TextField jg = new TextField();
		jg.setMinSize(160, 30);
		jg.setMaxSize(160, 30);
		TextField gmrq = new TextField();
		gmrq.setMinSize(160, 30);
		gmrq.setMaxSize(160, 30);
		bt.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e) {
				String s1 = sh.getText();
				String s2 = sm.getText();
				String s3 = zzm.getText();
				String s4 = jg.getText();
				String s5 = gmrq.getText();
				int excheck = 0;
				try {
					File f = new File("Books.txt");
					Scanner in = new Scanner(f);
					while (in.hasNextLine()) {
						String A = in.nextLine();
						String B = in.nextLine();
						String C = in.nextLine();
						String D = in.nextLine();
						String E = in.nextLine();
						if (s1.equals(A)){
							excheck = 1;
							x.close();
						}
						
					}
					in.close();
				}
				catch(Exception e1) {
					
				}
				if (excheck == 0) {
					alertForm("书目不存在!");
				}
				
				if (excheck == 1) {
					upbook(s1,s2,s3,s4,s5);
					
					x.close();
				}
			}
			
			
			
		});
		
		Label sh1 = new Label("书号");
		sh1.setFont(new Font(15));
		Label sm1 = new Label("书名");
		sm1.setFont(new Font(15));
		Label zzm1 = new Label("作者名");
		zzm1.setFont(new Font(15));
		Label jg1 = new Label("价格");
		jg1.setFont(new Font(15));
		Label gmrq1 = new Label("购买日期");
		gmrq1.setFont(new Font(15));
		
		bookin.add(sh1, 0, 0);
		bookin.add(sm1, 0, 1);
		bookin.add(zzm1, 0, 2);
		bookin.add(jg1, 0, 3);
		bookin.add(gmrq1, 0, 4);
		bookin.add(sh, 1, 0);
		bookin.add(sm, 1, 1);
		bookin.add(zzm, 1, 2);
		bookin.add(jg, 1, 3);
		bookin.add(gmrq, 1, 4);
		bookin.add(bt, 1, 5);
		
		
		bookin.setHgap(10);
		bookin.setVgap(10);
		bookin.setAlignment(Pos.CENTER);
		Scene xs = new Scene(bookin,250,300);
		
		x.setScene(xs);
		x.setTitle("BooksUp");
		x.getIcons().add(new Image("ico.png"));
		x.show();
	}
	
	//更新函数
	public void upbook(String s1,String s2,String s3,String s4,String s5) {
		File f = new File("Books.txt");
		File ft = new File("BooksTemp.ini");
		try {
			Scanner in1 = new Scanner(f);
			PrintWriter out1 = new PrintWriter(ft);
			while (in1.hasNextLine()) {
				String A = in1.nextLine();
				String B = in1.nextLine();
				String C = in1.nextLine();
				String D = in1.nextLine();
				String E = in1.nextLine();
				if (s1.equals(A)) continue;
				out1.write(A + "\n");
				out1.write(B + "\n");
				out1.write(C + "\n");
				out1.write(D + "\n");
				out1.write(E + "\n");
			}
			in1.close();
			out1.close();
			
			Scanner in2 = new Scanner(ft);
			PrintWriter out2 = new PrintWriter(f);
			out2.write(s1 + "\n");
			out2.write(s2 + "\n");
			out2.write(s3 + "\n");
			out2.write(s4 + "\n");
			out2.write(s5 + "\n");
			while (in2.hasNextLine()) {
				String A = in2.nextLine();
				String B = in2.nextLine();
				String C = in2.nextLine();
				String D = in2.nextLine();
				String E = in2.nextLine();
				out2.write(A + "\n");
				out2.write(B + "\n");
				out2.write(C + "\n");
				out2.write(D + "\n");
				out2.write(E + "\n");
				
			}
			in2.close();
			out2.close();
			alertForm("更新成功！");
		}
		catch (Exception e1) {
			
		}
	}
	
	//弹窗函数
	public void alertForm(String s) {
		Stage y1 = new Stage();
		Button bty1 = new Button(s);
		bty1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				y1.close();
			}
			
		});
		
		Scene ys = new Scene(bty1,240,100);
		y1.getIcons().add(new Image("ico.png"));
		y1.setScene(ys);
		y1.show();
	}
	
	
	//中文排序
	public void chinaSort(book[] a, int x){
		Comparator chinas = Collator.getInstance(java.util.Locale.CHINA);
		for (int i = a.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				switch(x) {
					case 0:
						if (chinas.compare(a[j].zzm,a[j+1].zzm) == 1) {
							book btemp = a[j];
							a[j] = a[j+1];
							a[j+1] = btemp;
						}
						break;
					case 1:
						if (chinas.compare(a[j].sh,a[j+1].sh) == 1) {
							book btemp = a[j];
							a[j] = a[j+1];
							a[j+1] = btemp;
						}
						break;
					case 2:
						if (chinas.compare(a[j].sm,a[j+1].sm) == 1) {
							book btemp = a[j];
							a[j] = a[j+1];
							a[j+1] = btemp;
						}
						break;
					default:break;
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}

class book{
	String sh;
	String sm;
	String zzm;
	String jg;
	String gmrq;
	
	public book(String sh, String sm, String zzm, String jg, String gmrq) {
		this.sh = sh;
		this.sm = sm;
		this.zzm = zzm;
		this.jg = jg;
		this.gmrq = gmrq;
	}
}

