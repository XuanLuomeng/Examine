package com.UserOperation;

import com.user.User;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import static com.company.Main.*;
import static com.company.Main.number;

public class Change extends Application {
    private String Key = "冰墩墩";
    public void key(String Key){
        this.Key = Key;
    }
    final ImageView background2 = new ImageView("com/image/背景2.jpg");//主页背景
    //标签
    final Label Name = new Label("姓名：");
    final Label Number = new Label("号码：");
    final Label Mail = new Label("邮箱：");
    final Label Group = new Label("组别：");
    final Label bug = new Label();//当添加用户时姓名或号码为空时弹出标签警告
    //输入框与选择框
    final TextField Na = new TextField();//输入姓名
    final TextField Nu = new TextField();//输入号码
    final TextField Ma = new TextField();//输入邮箱
    final ComboBox Gru = new ComboBox();//选择组别
    //是否确认添加按钮
    final Button confirm = new Button("确认");//确认按钮
    final Button cancel = new Button("取消");//取消按钮
    @Override
    public void start(Stage St){
        /*
         *设置按钮，标签等外观属性
         */
        background2.setFitHeight(720);//设置背景图大小
        background2.setPreserveRatio(true);//保持背景图缩放比例
        //提示信息
        Na.setText(userMap.get(Key).getName());
        Nu.setText(userMap.get(Key).getNumber());
        Ma.setText(userMap.get(Key).getMail());
        //文本框透明化
        Na.setStyle("-fx-background-color: rgba(255,255,255,0.4)");
        Nu.setStyle("-fx-background-color: rgba(255,255,255,0.4)");
        Ma.setStyle("-fx-background-color: rgba(255,255,255,0.4)");
        //字体设置
        Name.setStyle("-fx-font-size: 18;-fx-font-weight: BOLD");//标签
        Number.setStyle("-fx-font-size: 18;-fx-font-weight: BOLD");//标签
        Mail.setStyle("-fx-font-size: 18;-fx-font-weight: BOLD");//标签
        Group.setStyle("-fx-font-size: 18;-fx-font-weight: BOLD");//标签
        confirm.setStyle("-fx-font-size: 18;-fx-font-weight: BOLD");//按钮
        cancel.setStyle("-fx-font-size: 18;-fx-font-weight: BOLD");//按钮
        //下拉框设置
        ObservableList<String> obList = FXCollections.observableArrayList(snackList);
        Gru.setItems(obList); // 设置下拉框的数据来源
        Gru.setValue(userMap.get(Key).getGroup());//设置初始选中值

        /*
         * 事件(取消按钮，关闭窗口)
         * */
        cancel.setOnAction(e->{
            St.close();
        });
        /*
         * 事件(确认，将有关信息存入映射接口)
         * */
        confirm.setOnAction(e->{
            if(userMap.containsKey(Na.getText())){//不能重复姓名
                bug.setStyle("-fx-font-size: 18;-fx-font-weight: BOLD;-fx-text-fill: red");
                bug.setText("该姓名已存在哟！");
                bug.setAlignment(Pos.CENTER);
            }
            else {
                if (!"".equals(Na.getText()) && !"".equals(Nu.getText())) {
                    User user = new User(Na.getText(), Nu.getText(), Ma.getText(), (String) Gru.getValue());//设置个变量收集文本框内容
                    //设置个人信息
                    users[number] = user;//将变量内容传给方法组（防止空指针）
                    //将个人信息放入集合中
                    userMap.remove(Key);
                    userMap.put(users[number].getName(), users[number]);//将数据传给映射接口方便其他操作的查找以及删除功能
                    //组中人数加一
                    number++;
                    St.close();
                } else {
                    bug.setStyle("-fx-font-size: 18;-fx-font-weight: BOLD;-fx-text-fill: red");
                    bug.setText("姓名和号码均不能为空哦！");
                    bug.setAlignment(Pos.CENTER);
                }
            }
        });

        /*
         * 面板排版
         * */
        GridPane Gr = new GridPane();
        Gr.add(Name,0,0);
        Gr.add(Na,1,0);
        Gr.add(Number,0,1);
        Gr.add(Nu,1,1);
        Gr.add(Mail,0,2);
        Gr.add(Ma,1,2);
        Gr.add(Group,0,3);
        Gr.add(Gru,1,3);
        Gr.add(cancel,1,4);
        Gr.add(confirm,0,4);
        Gr.add(bug,0,5,2,1);
        Gr.setAlignment(Pos.CENTER);
        Gr.setHgap(5);
        Gr.setVgap(20);
        StackPane kPane = new StackPane(background2,Gr);
        kPane.setAlignment(Pos.CENTER);
        Scene scene = new Scene(kPane,360,720);//设置窗口大小
        St.setScene(scene);
        St.setResizable(false);//锁定舞台大小//锁定新窗口大小
        St.setTitle("联系人信息输入");
        St.show();
    }
}
