package com.nit.experiment.common.util;

import com.nit.experiment.entity.User;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import org.apache.commons.lang.*;
import org.apache.commons.lang.StringUtils;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 江建平 on 2017/7/27.
 */
public class ExcelUtil {

    public static List<User> readMember(InputStream in) throws Exception{
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        List<User> list = new LinkedList<User>();
        WorkbookSettings setting=new WorkbookSettings();
        setting.setEncoding("utf-8");
        //获取Excel文件对象
        Workbook rwb = Workbook.getWorkbook(in, setting);
        //获取文件的指定工作表 默认的第一个
        Sheet sheet = rwb.getSheet(0);
        for(int i=1; i<sheet.getRows(); i++){
            //创建一个数组 用来存储每一列的值
            User user = new User();
            user.setUserName(sheet.getCell(0, i).getContents());
            user.setSex(sheet.getCell(1, i).getContents());
            user.setStuNo(sheet.getCell(2, i).getContents());
            user.setClassName(sheet.getCell(3, i).getContents());
            user.setPhone(sheet.getCell(4, i).getContents());
            user.setEmail(sheet.getCell(5, i).getContents());
            user.setQq(sheet.getCell(6, i).getContents());
            String time = sheet.getCell(7, i).getContents();
            if(StringUtils.isNotBlank(time)){
                user.setCreateTime(df.parse(time));
            }else{
                user.setCreateTime(null);
            }
            user.setUserType(sheet.getCell(8, i).getContents());
            //把刚获取的列存入list
            list.add(user);
        }
        return list;
    }
}
