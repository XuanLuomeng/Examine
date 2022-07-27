package com.function;

import com.InformationModification.ModifyGroupName;
import com.company.Main;
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
import java.util.HashSet;
import java.util.Iterator;

import static com.company.Main.snackList;

public class DeleteGroup extends Application {
    // 接收删除的组名
    private String groupName = new String();
    public void GN(String gN){
        this.groupName = gN;
    }
    //主页背景
    final ImageView background3 = new ImageView("com/image/背景3.jpg");
    //标签
    final Label la = new Label("是否确认要删除此组名?");
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
         * 事件(确认添加组别)
         * */
        confirm1.setOnAction(e->{
            HashSet Sn = new HashSet(snackList);
            snackList.clear();//先清空原本集合中的元素
            Iterator ite = Sn.iterator();
            while(ite.hasNext()){
                String io = (String)ite.next();
                if(io!=groupName)//要删除的组名与集合中的不一样，则重新将值传回原集合
                    snackList.add(io);
            }
            ModifyGroupName mo = new ModifyGroupName();//将原本组别里的人员重新设定为必有组别”朋友“
            mo.AllModifyGroupName(groupName,"朋友");
            Stage t = new Stage();//处理完后重新打开主窗口
            Main tl = new Main();
            tl.start(t);
            St.close();//关闭窗口
        });
        /*
         * 事件(取消，重新打开主窗口)
         * */
        cancel.setOnAction(e->{
            Stage t1 = new Stage();//重新打开主窗口
            Main t2 = new Main();
            t2.start(t1);
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
        St.setTitle("确认是否删除组别");
        St.setScene(scene);
        St.show();
    }
}
