package com.giraudev.soapserver.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ARTICLES")
public class Article{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ARTICLE_ID")
    private Long articleId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CATEGORY")
    private String category;



}
