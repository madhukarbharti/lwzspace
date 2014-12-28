package org.lwz.space.model;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by 权 on 2014/10/5.
 */

@Entity
@Table(name = "t_person")
public class Person {
    private int id;
    private String name;
    private Date birthDay;
    private Genger genger;
    private String info ;//大文本，默认情况下，String在Mysql中对应的为Varchar类型 255长度，当这个长度超过255时用@Lob
    private byte[] file;//使用@Lob，对于大文件信息使用延迟加载策略
    private String imageInfo;//使用@Transient, 该属性将不会出现在表字段中


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "personName", nullable = false, length = 10)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Temporal(TemporalType.DATE)
    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 5)
    public Genger getGenger() {
        return genger;
    }

    public void setGenger(Genger genger) {
        this.genger = genger;
    }

    @Lob
    public String getInfo() {
        return info;
    }

    @Lob
    @Basic(fetch = FetchType.LAZY)
    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    @Transient
    public String getImageInfo() {
        return imageInfo;
    }

    public void setImageInfo(String imageInfo) {
        this.imageInfo = imageInfo;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Person() {
    }

    public Person(String name) {

        this.name = name;
    }

    public Person(String name, Genger genger) {
        this.name = name;
        this.genger = genger;
    }

    public Person(String name, Date birthDay, Genger genger) {
        this.name = name;
        this.birthDay = birthDay;
        this.genger = genger;
    }

    @Override
    public String toString() {
        return this.name + ":" +this.genger;
    }
}
