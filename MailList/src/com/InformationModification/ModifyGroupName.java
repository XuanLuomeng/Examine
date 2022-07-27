package com.InformationModification;
import com.user.User;
import java.util.Iterator;

import static com.company.Main.userMap;

/*
* 修改用户组别信息(当修改组名或者删除组别时，调用此方法修改用户组别信息)
* */
public class ModifyGroupName {
    public void AllModifyGroupName(String Old,String New){
        Iterator it = userMap.keySet().iterator();
        while(it.hasNext()){
            String xv = (String)it.next();
            User user = userMap.get(xv);
            if(user.getGroup()==Old){
                user.setGroup(New);
                userMap.put(user.getName(),user);
            }
        }
    }
}
