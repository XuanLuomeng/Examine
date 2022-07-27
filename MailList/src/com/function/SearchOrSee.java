package com.function;

import com.user.User;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static com.company.Main.userMap;

public class SearchOrSee extends Application {
    //背景
    final ImageView background4 = new ImageView("com/image/背景4.jpg");
    //标签
    final Label Name1 = new Label();
    final Label Number1 = new Label();
    final Label Mail1 = new Label();
    final Label Group1 = new Label();
    final Label bug1 = new Label("查无此人哟！");//当无法搜索出相关人员时弹出信息
    //接收搜索的姓名
    private String Receive = new String();
    //接收主页搜索框的内容
    public void receive (String tf){
        this.Receive = tf;
    }
    @Override
    public void start(Stage St){
        background4.setFitHeight(200);//设置通讯录主页背景图大小
        background4.setPreserveRatio(true);//保持缩放比例

        VBox VB = new VBox(15);//设置行面板并规定节点间距
        VB.setAlignment(Pos.CENTER);//设置列面板中对齐
        String title = new String();

        if(!userMap.containsKey(Receive)){
            //设置字体
            bug1.setStyle("-fx-font-size: 50;-fx-font-weight: BOLD");
            //将节点传给列面板
            VB.getChildren().add(bug1);
            title = "查无此人";
        }
        else{
            User user = userMap.get(Receive);
            title = user.getName();//获取主题信息
            //设置标签信息
            Name1.setText("姓名:"+user.getName());
            Number1.setText("号码:"+user.getNumber());
            Mail1.setText("邮箱:"+user.getMail());
            Group1.setText("组别:"+user.getGroup());
            //设置字体
            Name1.setStyle("-fx-font-size: 20;-fx-font-weight: BOLD");
            Number1.setStyle("-fx-font-size: 20;-fx-font-weight: BOLD");
            Mail1.setStyle("-fx-font-size: 20;-fx-font-weight: BOLD");
            Group1.setStyle("-fx-font-size: 20;-fx-font-weight: BOLD");
            //将标签传给列面板
            VB.getChildren().addAll(Name1,Number1,Mail1,Group1);
        }
        StackPane aPane = new StackPane(background4,VB);//将背景和行面板加入栈面板
        Scene scene = new Scene(aPane,384,200);
        St.setResizable(false);//锁定舞台大小
        St.setTitle(title);
        St.setScene(scene);
        St.show();
    }
}
