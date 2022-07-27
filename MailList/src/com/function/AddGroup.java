package com.function;

import com.company.Main;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static com.company.Main.snackList;

public class AddGroup extends Application {
    //主页背景
    final ImageView background3 = new ImageView("com/image/背景3.jpg");
    //标签
    final Label GroupName = new Label("新组名:");
    final Label bug1 = new Label();//当新组别的框为空时弹出警告
    //文本框
    final TextField GN = new TextField();
    //确认与取消按钮
    final Button confirm1 = new Button("确认");
    final Button cancel = new Button("取消");
    @Override
    public void start(Stage primaryStage){
        /*
         *设置按钮，标签等外观属性
         */
        //背景设置
        background3.setFitHeight(400);//设置背景图大小
        background3.setPreserveRatio(true);//保持背景图缩放比例
        //提示信息
        GN.setPromptText("输入新组别名");
        //文本框透明化
        GN.setStyle("-fx-background-color: rgba(255,255,255,0.9)");
        //字体设置
        GroupName.setStyle("-fx-font-size: 18;-fx-font-weight: BOLD");//标签
        confirm1.setStyle("-fx-font-size: 18;-fx-font-weight: BOLD");//确认按钮
        cancel.setStyle("-fx-font-size: 18;-fx-font-weight: BOLD");//取消按钮

        /*
        * 事件(确认添加组别)
        * */
        confirm1.setOnAction(e->{
            if(snackList.contains(GN.getText())){//不允许重复组名添加
                bug1.setStyle("-fx-font-size: 18;-fx-font-weight: BOLD;-fx-text-fill: red");
                bug1.setText("该组名已存在哟！");
                bug1.setAlignment(Pos.CENTER);
            }
            else {
                if (!"".equals(GN.getText())) {
                    snackList.add(GN.getText());//将新组名添加到接口集合
                    Stage t1 = new Stage();
                    Main t2 = new Main();
                    t2.start(t1);
                    primaryStage.close();//关闭窗口
                } else {
                    bug1.setStyle("-fx-font-size: 18;-fx-font-weight: BOLD;-fx-text-fill: red");
                    bug1.setText("新组名不能为空哟！");
                    bug1.setAlignment(Pos.CENTER);
                }
            }
        });

        /*
        * 事件(取消，重新打开主窗口)
        * */
        cancel.setOnAction(e->{
            Stage t1 = new Stage();
            Main t2 = new Main();
            t2.start(t1);
            primaryStage.close();
        });

        /*
        * 面板排版
        * */
        HBox HB1 = new HBox(5);
        HB1.setAlignment(Pos.CENTER);//设置居中对齐
        HB1.getChildren().addAll(GroupName,GN);
        HBox HB2 = new HBox(30);
        HB2.setAlignment(Pos.CENTER);//设置居中对齐
        HB2.getChildren().addAll(confirm1,cancel);
        VBox VB = new VBox(20);
        VB.setAlignment(Pos.CENTER);
        VB.getChildren().addAll(HB1,HB2,bug1);
        StackPane SP = new StackPane(background3,VB);
        Scene scene = new Scene(SP,400,370);
        primaryStage.setTitle("添加组别");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);//锁定舞台大小//锁定新窗口大小
        primaryStage.show();
    }
}