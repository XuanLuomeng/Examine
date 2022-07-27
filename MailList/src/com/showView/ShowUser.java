package com.showView;

import com.UserOperation.Change;
import com.UserOperation.Delete;
import com.function.SearchOrSee;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Iterator;

import static com.company.Main.userMap;

public class ShowUser extends Application {
    // 接收查看的组名
    private String groupName = new String();
    public void gN(String gN){
        this.groupName = gN;
    }

    final ImageView background6 = new ImageView("com/image/背景6.jpg");//背景
    @Override
    public void start(Stage sU){
        background6.setFitHeight(720);//设置通讯录主页背景图大小
        background6.setPreserveRatio(true);//保持缩放比例

        //列面板
        VBox VBO = new VBox(10);
        VBO.setAlignment(Pos.TOP_CENTER);

        //用迭代器完成用户列表的展示
        Iterator it = userMap.keySet().iterator();//获取所有键
        int i = 0;
        Label []Label = new Label[20];
        Button []Butt0 = new Button[20];
        Button []Butt1 = new Button[20];
        Button []Butt2 = new Button[20];
        while(it.hasNext()){
            String xv = (String) it.next();
            //若组名与查找组名相同，则展示用户
            if(userMap.get(xv).getGroup().equals(groupName)) {
                Label labe = new Label(xv);
                labe.setStyle("-fx-font-size: 16;-fx-font-weight: BOLD");//设置字体
                Label[i] = labe;
                Button butt0 = new Button("修改");
                Button butt1 = new Button("查看");
                Button butt2 = new Button("删除");
                Butt0[i] = butt0;
                Butt1[i] = butt1;
                Butt2[i] = butt2;
                HBox HBo = new HBox(40);//设置间距
                HBo.setAlignment(Pos.CENTER);
                HBo.getChildren().addAll(Label[i], Butt0[i], Butt1[i], Butt2[i]);
                VBO.getChildren().add(HBo);
                //修改按钮
                Butt0[i].setOnAction(new EventHandler<ActionEvent>() {
                    Stage sa = new Stage();
                    @Override
                    public void handle(ActionEvent event) {
                        Change ch = new Change();
                        ch.key(xv);
                        sU.close();
                        ch.start(sa);
                    }
                });
                //查看按钮
                Butt1[i].setOnAction(new EventHandler<ActionEvent>() {
                    Stage ss = new Stage();
                    @Override
                    public void handle(ActionEvent event) {
                        SearchOrSee se = new SearchOrSee();
                        se.receive(xv);
                        se.start(ss);
                    }
                });
                //删除按钮
                Butt2[i].setOnAction(new EventHandler<ActionEvent>() {
                    Stage so = new Stage();
                    @Override
                    public void handle(ActionEvent event) {
                        Delete de = new Delete();
                        de.N(xv);
                        sU.close();
                        de.start(so);
                    }
                });
                i++;
            }
        }

        StackPane S = new StackPane(background6,VBO);
        Scene scene = new Scene(S,360,720);
        sU.setTitle(groupName);
        sU.setScene(scene);
        sU.show();
    }
}
