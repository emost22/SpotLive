package com.ssafy.spotlive.db.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Video{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long videoId = null;

    String videoTitle;
    String videoDescription;
    String mode;
    @CreationTimestamp
    LocalDateTime startTime;
    LocalDateTime endTime;
    String thumbnailUrl;
    String videoUrl;
    Boolean isLive;
    Long hit;
    String sessionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountEmail")
    User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "showInfoId")
    ShowInfo showInfo;

    @OneToMany(mappedBy = "video", cascade = CascadeType.ALL)
    List<UserVideo> userVideoList = new ArrayList<>();
}