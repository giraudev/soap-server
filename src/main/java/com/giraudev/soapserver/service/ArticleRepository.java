package com.giraudev.soapserver.service;

import com.giraudev.soapserver.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    Article findByArticleId(Long articleId);
    List<Article> findByTitleAndCategory(String title, String category);

}
