package com.auefly.sb06doc.pojo;

import lombok.Data;

@Data
public class Post {
    private long pid;
    private int userId;
    private String title;
    private String cover;
    private String description;
    private String publishTime;
    private String lastUpdateTime;
    private long view;
    private String content;
    private int status;
}
