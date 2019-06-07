package com.cjl.client;

import com.cjl.model.AnotherPerson;
import com.cjl.model.Person;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.ibatis.sqlmap.client.SqlMapSession;
import org.apache.ibatis.io.Resources;

import java.io.Reader;
import java.sql.SQLException;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
        //主配置文件　　一张表对应的配置文件

        String resource = "SqlMapConfig.xml";
        SqlMapClient client = null;
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            client = SqlMapClientBuilder.buildSqlMapClient(reader);
            client.startTransaction();

            Person person = new Person();
            person.setName("cjl");
            person.setGender(1);
            person.setId(new Random().nextInt(100000));


            /**
             * 第一个参数　　sqlMapConfigxml中的　ｉｄ
             * 第二个参数　　参入的数据
             */
            Object object = client.insert("insertPerson",person);
            System.out.println("insertPerson Test.main "+object);


            //查询

//            for (Object o:client.queryForList("getAllPersons",null)){
//                System.out.println("getAllPersons2 Test.main "+o);
//            }


            //xml

            System.out.println("getAllPersons2 Test.main "+client.queryForList("getAllPersons3",null));



//            Object o = client.queryForObject("getPerson1",11754);
//            System.out.println("getPerson1 Test.main "+o);

            AnotherPerson anotherPerson = (AnotherPerson) client.queryForObject("getPerson2",11754);
            System.out.println("anotherPerson Test.main "+anotherPerson);


            System.out.println("insertPerson2 Test.main"+            client.insert("insertPerson2",person));


//            client.delete("deletePerson",11754);

            Person newPerson = new Person();
            newPerson.setId(1);
            newPerson.setName("test");
            newPerson.setGender(2);
            client.update("updatePerson",newPerson);


            client.commitTransaction();


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(null != client){
                    client.endTransaction();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
