package com.company;
import com.function.AddUser;
import com.function.AddGroup;
import com.function.SearchOrSee;
import com.function.ChangeGroup;
import com.function.DeleteGroup;
import com.showView.ShowUser;
import com.showView.ShowUsers;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import com.user.User;
import java.util.*;

public class Main extends Application {
    /*
    * 各类节点
    * */
    final ImageView background1 = new ImageView("com/image/背景1.jpg");//主页背景
    final ImageView ADD = new ImageView("com/image/添加.png");//添加按钮
    final TextField tf = new TextField();//搜索人员框
    final Button search = new Button("搜索");//搜索按钮
    final Button ADD0 = new Button();//添加人员按钮
    final Button addGroup = new Button("添加组别");//添加组别按钮
    /*
    * 用户数据
    * */
    public static Map<String, User> userMap = new HashMap<>();//用户集合
    public static User[]users = new User[100];//定义用户组
    public static int number = 1;//用户组内的数量
    public static HashSet<String> snackList = new HashSet<>();//组别名
    /*
    *用户初始化
    * */
    static{
        User user = new User("冰墩墩","15112900139","1253745284@qq.com","朋友");
        users[0] = user;
        //将个人信息放入集合中
        userMap.put(users[0].getName(),users[0]);
    }

    @Override
    /*
    主页设计
    * */
    public void start(Stage stage) {
        /*
         * 组名：所有人（必有且不可删除，只允许查看）
         * */
        snackList.add("朋友");//该组名必有且不可删除
        Label allMan = new Label("所有人");
        allMan.setStyle("-fx-font-size: 18;-fx-font-weight: BOLD");//设置字体
        Button see0 = new Button("查看");
        see0.setStyle("-fx-font-size: 18;-fx-font-weight: BOLD");//设置字体
        FlowPane group0 = new FlowPane(Orientation.HORIZONTAL,200,20);//设置水平布局
        group0.setAlignment(Pos.CENTER);//设置居中对齐
        group0.getChildren().addAll(allMan,see0);//将标签与查看按钮放入面板中

        /*
        * 主页必要元素设计
        * */
        background1.setFitHeight(720);//设置通讯录主页背景图大小
        background1.setPreserveRatio(true);//保持缩放比例

        ADD0.setGraphic(ADD);
        ADD.setFitHeight(28);//设置添加按钮大小
        ADD.setPreserveRatio(true);//保持缩放比例

        tf.setPromptText("输入搜索人名");//设置提示文本
        tf.setStyle("-fx-background-color: rgba(255,255,255,0.4)");//设置文本框接近透明

        HBox hb = new HBox(26);//设置行面板各个节点的间距
        search.setStyle("-fx-font-size: 16;-fx-font-weight: BOLD");//设置字体
        hb.getChildren().addAll(ADD0,tf,search);//将添加按钮，搜索框，搜索放入行面板

        VBox vb = new VBox(15);//设置行面板并规定节点间距
        vb.setAlignment(Pos.TOP_CENTER);//设置列面板中上对齐
        vb.getChildren().addAll(hb,addGroup,group0);//将搜索和添加功能的行面板与各小组面板添加至列面板

        Iterator it = snackList.iterator();//创建哈希集合snackList的迭代器it
        //创建遍历需要使用到的标签组与按钮组(防止空指针异常)
        int i = 0;
        Label []Label = new Label[20];
        Button []Butt0 = new Button[20];
        Button []Butt1 = new Button[20];
        Button []Butt2 = new Button[20];
        while(it.hasNext()){//判断哈希集合中的元素
            String xv = (String)it.next();
            Label label = new Label(xv);
            label.setStyle("-fx-font-size: 16;-fx-font-weight: BOLD");//设置字体
            Label[i] = label;
            Button butt0 = new Button("修改");
            Button butt1 = new Button("查看");
            Button butt2 = new Button("删除");
            Butt0[i] = butt0;
            Butt1[i] = butt1;
            Butt2[i] = butt2;
            HBox HBo = new HBox(40);//设置间距
            HBo.setAlignment(Pos.CENTER);
            if("朋友".equals(xv)){//保证朋友这个组名不可被修改与删除
                HBo.getChildren().addAll(Label[i], Butt1[i]);
            }
            else
                HBo.getChildren().addAll(Label[i], Butt0[i], Butt1[i], Butt2[i]);
            vb.getChildren().add(HBo);

            //修改按钮
            Butt0[i].setOnAction(new EventHandler<ActionEvent>() {
                public Stage s11 = new Stage();
                @Override
                public void handle(ActionEvent event) {
                    ChangeGroup s12 = new ChangeGroup();
                    s12.GN(xv);
                    stage.close();//关闭主窗口
                    s12.start(s11);
                }
            });

            //查看按钮
            Butt1[i].setOnAction(new EventHandler<ActionEvent>() {
                public Stage s9 = new Stage();
                @Override
                public void handle(ActionEvent event) {
                    ShowUser s10 = new ShowUser();
                    s10.gN(xv);//将查看的组名传给新舞台
                    s10.start(s9);
                }
            });

            //删除按钮
            Butt2[i].setOnAction(new EventHandler<ActionEvent>() {
                public Stage s = new Stage();
                @Override
                public void handle(ActionEvent event) {
                    DeleteGroup st = new DeleteGroup();
                    st.GN(xv);
                    stage.close();//关闭主窗口
                    st.start(s);
                }
            });
            i++;
        }

        StackPane bPane = new StackPane(background1,vb);//将背景和行面板加入栈面板
        bPane.setAlignment(Pos.TOP_CENTER);//设置栈面板上中对齐

        /*
        * 事件(添加通讯录)
        * */
        HAND hi = new HAND();
        ADD0.setOnAction(hi);

        /*
        * 事件(添加组别)在此定义是为了方便关闭主窗口，完成新窗口操作后再重新打开实现窗口刷新
        * */
        addGroup.setOnAction(new EventHandler<ActionEvent>() {
            public Stage s3 = new Stage();
            @Override
            public void handle(ActionEvent event) {
                AddGroup s4 = new AddGroup();
                s4.start(s3);
                stage.close();
            }
        });

        /*
        * 事件(搜索)
        * */
        SearchEvent Se = new SearchEvent();
        search.setOnAction(Se);

        /*
        * 事件(所有人的查看功能)
        * */
        See se = new See();
        see0.setOnAction(se);

        /*
        *场景
        * */
        Scene scene = new Scene(bPane,360,720);

        /*
        * 舞台
        * */
        stage.setResizable(false);//锁定舞台大小
        stage.setTitle("个人通讯录");
        stage.setScene(scene);
        stage.show();
    }

    /*
    *添加新人员的事件处理
    * */
    public class HAND implements EventHandler<ActionEvent>{
        public Stage s2 = new Stage();
        @Override
        public void handle(ActionEvent e) {
            AddUser s1 = new AddUser();
            s1.start(s2);
        }
    }
    /*
    * 搜索的事件处理
    * */
    public class SearchEvent implements EventHandler<ActionEvent>{
        public Stage s5 = new Stage();
        @Override
        public void handle(ActionEvent e){
            SearchOrSee s6 = new SearchOrSee();
            s6.receive(tf.getText());//将搜索框内容传至Search
            s6.start(s5);
        }
    }
    /*
    *所有人的查看功能
    * */
    public class See implements EventHandler<ActionEvent>{
        public Stage s7 = new Stage();
        @Override
        public void handle(ActionEvent e){
            ShowUsers s8 = new ShowUsers();
            s8.start(s7);
        }
    }
}
