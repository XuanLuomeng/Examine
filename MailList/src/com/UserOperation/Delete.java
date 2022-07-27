package com.UserOperation;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static com.company.Main.userMap;

public class Delete extends Application {
    // 接收删除的组名
    private String Name = new String();
    public void N(String gN){
        this.Name = gN;
    }
    //主页背景
    final ImageView background3 = new ImageView("com/image/背景3.jpg");
    //标签
    final Label la = new Label("是否确认要此用户?");
    //确认与取消按钮
    final Button confirm1 = new Button("确认");
    final Button cancel = new Button("取消");
    @Override
    public void start(Stage St){
        //背景设置
        background3.setFitHeight(400);//设置背景图大小
        background3.setPreserveRatio(true);//保持背景图缩放比例

        //字体设置
        la.setStyle("-fx-font-size: 18;-fx-font-weight: BOLD;-fx-text-fill: RED");//设置标签
        confirm1.setStyle("-fx-font-size: 18;-fx-font-weight: BOLD");//确认按钮
        cancel.setStyle("-fx-font-size: 18;-fx-font-weight: BOLD");//取消按钮

        /*
         * 事件(确认删除用户)
         * */
        confirm1.setOnAction(e->{
            userMap.remove(Name);
            St.close();//关闭窗口
        });
        /*
         * 事件(取消，重新打开主窗口)
         * */
        cancel.setOnAction(e->{
            St.close();
        });

        /*
         * 面板排版
         * */
        HBox HB2 = new HBox(30);
        HB2.setAlignment(Pos.CENTER);//设置居中对齐
        HB2.getChildren().addAll(confirm1,cancel);
        VBox VB = new VBox(20);
        VB.setAlignment(Pos.CENTER);
        VB.getChildren().addAll(la,HB2);
        StackPane SP = new StackPane(background3,VB);
        Scene scene = new Scene(SP,400,370);
        St.setTitle("确认是否删除用户");
        St.setScene(scene);
        St.show();
    }
}
